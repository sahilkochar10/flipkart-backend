package com.onlineshopping.flipkart.service;

import com.onlineshopping.flipkart.exceptions.ProductAlreadyExistsException;
import com.onlineshopping.flipkart.exceptions.ProductNotFoundException;
import com.onlineshopping.flipkart.repository.ProductRepository;
import com.onlineshopping.flipkart.vo.Products;
import com.onlineshopping.flipkart.exceptions.SupplierNotFoundException;
import com.onlineshopping.flipkart.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //Create Injectable singleton object of service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SupplierRepository suppliersRepository;

    public List<com.onlineshopping.flipkart.entity.Products> getProducts() {
        return productRepository.findAll();
    }

    @Transactional(rollbackFor = {SupplierNotFoundException.class, ProductAlreadyExistsException.class})
    public void saveProducts(List<Products> products) throws ProductAlreadyExistsException, SupplierNotFoundException {
        for (Products product : products) {
            if (productRepository.findById(product.getProductID()).isPresent()) {
                throw new ProductAlreadyExistsException(product.getProductID());
            }
            productRepository.save(getEntity(product));
        }
    }
        // add transactionmanager
    public com.onlineshopping.flipkart.entity.Products getProductByPid(Integer pid) throws ProductNotFoundException {
        return productRepository.findById(pid).orElseThrow(() -> new ProductNotFoundException(pid));
    }

    public void updateProducts(List<com.onlineshopping.flipkart.vo.Products> products) throws ProductNotFoundException, SupplierNotFoundException {
        for (Products p : products) {
            if (productRepository.findById(p.getProductID()).isEmpty()) {
                throw new ProductNotFoundException(p.getProductID());
            }
            productRepository.save(getEntity(p));
        }
    }

    public com.onlineshopping.flipkart.entity.Products getEntity(Products product) {
        return com.onlineshopping.flipkart.entity.Products.builder()
                .productName(product.getProductName())
                .productID(product.getProductID())
                .price(product.getPrice())
                .productImage(product.getProductImage())
                .supplier(suppliersRepository.findById(product.getSupplierID()).orElseThrow(()-> new SupplierNotFoundException(product.getSupplierID())))
                .unit(product.getUnit()).build();
    }

    public void  deleteProductById(Integer pid) {
        productRepository.delete(productRepository.findById(pid).orElseThrow(() -> new ProductNotFoundException(pid)));

    }
    }
