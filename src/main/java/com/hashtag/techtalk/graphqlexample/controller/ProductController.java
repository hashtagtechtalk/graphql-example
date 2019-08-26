package com.hashtag.techtalk.graphqlexample.controller;

import com.hashtag.techtalk.graphqlexample.service.ProductGraphQLService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("rest/products")
@RestController
public class ProductController
{
    @Autowired
    private ProductGraphQLService productGraphQLService;

    @PostMapping
    public ResponseEntity getAllProducts(@RequestBody String query){
        ExecutionResult result=productGraphQLService.graphQL().execute(query);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @GetMapping("/test")
    public String workingTest(){
        return "Working";
    }
}
