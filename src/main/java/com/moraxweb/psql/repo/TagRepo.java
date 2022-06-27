package com.moraxweb.psql.repo;

import com.moraxweb.psql.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepo extends JpaRepository<Tag, Long> {
    List<Tag> findTagByProductsId(Long productsId);
}
