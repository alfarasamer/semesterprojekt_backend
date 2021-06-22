package com.example.semesterprojektbackend.model;

public class Category extends SubCategory{
    private String categoryName;
    private int numberOfProducts;

    public Category(String subCategory,String categoryName,int numberOfProducts) {
        super(subCategory);
        this.categoryName=categoryName;
        this.numberOfProducts=numberOfProducts;
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(String categoryName, int numberOfProducts) {
        this.categoryName = categoryName;
        this.numberOfProducts = numberOfProducts;
    }

    public String getCategoryName() {
        return categoryName;
    }


    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }
}
