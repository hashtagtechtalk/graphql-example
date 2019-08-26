package com.hashtag.techtalk.graphqlexample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


@NoArgsConstructor
@Table
@Setter
@Getter
@Entity
public class Product {
    @Id
    private String productId;
    private String productName;
    private String productBrand;
    private float productPrice;
    private int productDiscount;
    private String[] totalContainerBatchNumbers;

    public Product(String productId, String productName, String productBrand, float productPrice, int productDiscount, String[] totalContainerBatchNumbers) {
        this.productId = productId;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productPrice = productPrice;
        this.productDiscount = productDiscount;
        this.totalContainerBatchNumbers = totalContainerBatchNumbers;
    }
}
