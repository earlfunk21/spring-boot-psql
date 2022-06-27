package com.moraxweb.psql.repo;

import com.moraxweb.psql.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findProductsByTagsId(Long tagId);
}
