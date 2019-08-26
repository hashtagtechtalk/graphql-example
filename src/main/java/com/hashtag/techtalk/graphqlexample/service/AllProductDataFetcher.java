package com.hashtag.techtalk.graphqlexample.service;

import com.hashtag.techtalk.graphqlexample.model.Product;
import com.hashtag.techtalk.graphqlexample.repository.ProductRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllProductDataFetcher implements DataFetcher<List<Product>> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return productRepository.findAll();
    }
}
