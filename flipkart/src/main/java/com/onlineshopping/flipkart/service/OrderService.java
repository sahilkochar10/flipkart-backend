package com.onlineshopping.flipkart.service;

import com.onlineshopping.flipkart.entity.Customers;
import com.onlineshopping.flipkart.entity.OrderDetails;
import com.onlineshopping.flipkart.entity.Shippers;
import com.onlineshopping.flipkart.exceptions.CustomerNotFoundException;
import com.onlineshopping.flipkart.exceptions.ProductNotFoundException;
import com.onlineshopping.flipkart.exceptions.ShipperNotFoundException;
import com.onlineshopping.flipkart.repository.CustomerRepository;
import com.onlineshopping.flipkart.repository.OrderRepository;
import com.onlineshopping.flipkart.entity.Orders;
import com.onlineshopping.flipkart.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ShipperRepository shipperRepository;
    public ResponseEntity<List<Orders>> getOrders() {
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }

//    public void saveOrders(com.onlineshopping.flipkart.vo.Orders order) throws ParseException, CustomerNotFoundException, ShipperNotFoundException {
//        System.out.println(order.getCustomerID());
//        Orders order1 = convertToOrders(order);
//        if(customerRepository.findById(order.getCustomerID()).isEmpty())
//            throw new CustomerNotFoundException(order.getCustomerID());
//        if(shipperRepository.findById(order.getShipperID()).isEmpty())
//            throw new ShipperNotFoundException(order.getShipperID());
//        orderRepository.save(order1);
//    }
//
//    static Orders convertToOrders(com.onlineshopping.flipkart.vo.Orders orderVo) throws ParseException {
//        Orders order = new Orders();
//        order.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(orderVo.getDate()));
//        Customers customers = new Customers();
//        customers.setCustomerID(orderVo.getCustomerID());
//        order.setCustomer(customers);
//        Shippers shippers = new Shippers();
//        shippers.setShipperID(orderVo.getShipperID());
//        order.setShipper(shippers);
//        List<OrderDetails> orderDetails = new ArrayList<>(); // Generics
//        for(com.onlineshopping.flipkart.vo.OrderDetails orderDetailsVo : orderVo.getOrderDetails()){ //for-each
//            orderDetails.add(OrderDetailService.convertToOrderDetail(orderDetailsVo));
//        }
//        order.setOrderDetails(orderDetails);
//        return order;
//    }
public void saveOrders(com.onlineshopping.flipkart.vo.Orders order) throws ParseException, CustomerNotFoundException, ShipperNotFoundException, ProductNotFoundException {
    Orders order1 = convertToOrders(order);
    if(customerRepository.findById(order.getCustomerID()).isEmpty())
        throw new CustomerNotFoundException(order.getCustomerID());
    if(shipperRepository.findById(order.getShipperID()).isEmpty())
        throw new ShipperNotFoundException(order.getShipperID());
    order1.setOrderID(100);
    orderRepository.save(order1);
}

    static Orders convertToOrders(com.onlineshopping.flipkart.vo.Orders orderVo) throws ParseException, ProductNotFoundException {
        Orders order = new Orders();
        order.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(orderVo.getDate()));
        Customers customers = new Customers();
        customers.setCustomerID(orderVo.getCustomerID());
        order.setCustomer(customers);
        Shippers shippers = new Shippers();
        shippers.setShipperID(orderVo.getShipperID());
        order.setShipper(shippers);
        List<OrderDetails> orderDetails = new ArrayList<>(); // Generics
        for(com.onlineshopping.flipkart.vo.OrderDetails orderDetailsVo : orderVo.getOrderDetails()){ //for-each
            orderDetails.add(OrderDetailService.convertToOrderDetail(orderDetailsVo));
        }
        order.setOrderDetails(orderDetails);
        return order;
    }
}
