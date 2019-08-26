package com.hashtag.techtalk.graphqlexample.service;

import com.hashtag.techtalk.graphqlexample.model.Product;
import com.hashtag.techtalk.graphqlexample.repository.ProductRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDataFetcher implements DataFetcher<Product> {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product get(DataFetchingEnvironment dataFetchingEnvironment) {
       String productId = dataFetchingEnvironment.getArgument("id");
        return productRepository.getOne(productId);
    }
}
