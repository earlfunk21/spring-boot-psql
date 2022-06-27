package com.moraxweb.psql.service;

import com.moraxweb.psql.model.Product;
import com.moraxweb.psql.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getProducts(){
        return productRepo.findAll();
    }

    public List<Product> getProductByTagsId(Long tagsId){
        return productRepo.findProductsByTagsId(tagsId);
    }

    public Product addProduct(Product product){
        return productRepo.save(product);
    }

    public Product removeProduct(Long id){
        Product product = this.getProduct(id);
        productRepo.deleteById(id);
        return product;
    }

    public Product getProduct(Long id){
        return productRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException("Not found Product with id = " + id)
                );
    }

}
