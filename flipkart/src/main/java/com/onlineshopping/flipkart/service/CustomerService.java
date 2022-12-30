package com.onlineshopping.flipkart.service;

import com.onlineshopping.flipkart.exceptions.CustomerAlreadyExistsException;
import com.onlineshopping.flipkart.exceptions.CustomerNotFoundException;
import com.onlineshopping.flipkart.entity.Customers;
import com.onlineshopping.flipkart.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customers> getCustomers() {
        return customerRepository.findAll();
    }

    public void saveCustomer(List<com.onlineshopping.flipkart.vo.Customers> customers) throws CustomerAlreadyExistsException {
        for (com.onlineshopping.flipkart.vo.Customers customer : customers) {
            if (customerRepository.findById(customer.getCustomerID()).isPresent()) {
                throw new CustomerAlreadyExistsException(customer.getCustomerID());
            }
            customerRepository.save(getEntity(customer));
        }
    }

    public void updateCustomer(List<com.onlineshopping.flipkart.vo.Customers> customers) throws CustomerNotFoundException {
        for (com.onlineshopping.flipkart.vo.Customers customer : customers) {
            if (customerRepository.findById(customer.getCustomerID()).isEmpty()) {
                throw new CustomerNotFoundException(customer.getCustomerID());
            }
            customerRepository.save(getEntity(customer));
        }
    }

    public Customers getEntity(com.onlineshopping.flipkart.vo.Customers customer){
        return Customers.builder()
                .customerName(customer.getCustomerName())
                .customerID(customer.getCustomerID())
                .address(customer.getAddress())
                .postalCode(customer.getPostalCode())
                .city(customer.getCity())
                .country(customer.getCountry()).build();
    }

}