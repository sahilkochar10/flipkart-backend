package com.onlineshopping.flipkart.controller;

import com.onlineshopping.flipkart.exceptions.ProductAlreadyExistsException;
import com.onlineshopping.flipkart.exceptions.ProductNotFoundException;
import com.onlineshopping.flipkart.exceptions.SupplierNotFoundException;
import com.onlineshopping.flipkart.service.ProductService;
import com.onlineshopping.flipkart.util.ValidList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    ResponseEntity<List<com.onlineshopping.flipkart.entity.Products>> getProducts() {
        return ResponseEntity.ok(productService.getProducts()) ;
    }

    @GetMapping("/{pid}")
    ResponseEntity<com.onlineshopping.flipkart.entity.Products> getProductByPid(@PathVariable Integer pid) throws ProductNotFoundException {
        return ResponseEntity.ok(productService.getProductByPid(pid));
    }

    @PostMapping
    ResponseEntity<String> saveProducts(@RequestBody @Valid ValidList<com.onlineshopping.flipkart.vo.Products> products) throws ProductAlreadyExistsException, SupplierNotFoundException {
        productService.saveProducts(products);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<String> updateProducts(@RequestBody @Valid List<com.onlineshopping.flipkart.vo.Products> products) throws ProductNotFoundException, SupplierNotFoundException {
        productService.updateProducts(products);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/{pid}")
    ResponseEntity<com.onlineshopping.flipkart.entity.Products> deleteProductByPid(@PathVariable Integer pid) throws ProductNotFoundException {
        productService.deleteProductById(pid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
        //No exceptions to be written in controller