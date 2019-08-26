package com.hashtag.techtalk.graphqlexample.service;

import com.hashtag.techtalk.graphqlexample.model.Product;
import com.hashtag.techtalk.graphqlexample.repository.ProductRepository;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ProductGraphQLService {

    @Value("classpath:products.graphql")
    private Resource resource;

    private GraphQL graphQL;

    @Autowired
    private AllProductDataFetcher allProductDataFetcher;

    @Autowired
    private ProductRepository productRepository;

    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;
    private Product product5;
    private List<Product> productsList;

    private void initializeProducts() {
        String[] productBatchList = {"batch 1"};

        product1 = new Product("1", "product1", "Brand1", Float.valueOf("1.01"), 10, productBatchList);
        product2 = new Product("2", "product2", "Brand2", Float.valueOf("2.01"), 20, productBatchList);
        product3 = new Product("3", "product3", "Brand3", Float.valueOf("3.01"), 30, productBatchList);
        product4 = new Product("4", "product4", "Brand4", Float.valueOf("4.01"), 40, productBatchList);
        product5 = new Product("5", "product5", "Brand4", Float.valueOf("5.01"), 50, productBatchList);
        productsList = new ArrayList<>();
        productsList.add(product1);
        productsList.add(product2);
        productsList.add(product3);
        productsList.add(product4);
        productsList.add(product5);


    }

    @Autowired
    private ProductDataFetcher productDataFetcher;

    @PostConstruct
    private void loadSchema() throws IOException {
        //Loading Temporary Data
        initializeProducts();
        loadAllInHSQL();
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();

    }


    private void loadAllInHSQL() {
        productRepository.saveAll(productsList);
    }



    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring().type("Query", typeWiring ->
                typeWiring.dataFetcher("allProducts", allProductDataFetcher)
                        .dataFetcher("product", productDataFetcher)

        ).build();
    }

    public GraphQL graphQL() {
        return graphQL;
    }
}
