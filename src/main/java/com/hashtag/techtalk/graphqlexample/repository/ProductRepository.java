package com.hashtag.techtalk.graphqlexample.repository;

import com.hashtag.techtalk.graphqlexample.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
