package com.moraxweb.psql.controller;

import com.moraxweb.psql.model.Product;
import com.moraxweb.psql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @PostMapping("/products/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/products/{id}/remove")
    public ResponseEntity<Product> removeProduct(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.removeProduct(id), HttpStatus.OK);
    }

    @GetMapping("/products/{id}/detail")
    public ResponseEntity<Product> productDetail(@PathVariable("id") Long id){
        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
    }
}
