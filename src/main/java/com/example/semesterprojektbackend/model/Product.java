// Done

package com.example.semesterprojektbackend.model;

public class Product {
    private int itemNumber;
    private String productDescription;
    private String productLongDescription;
    private String size;
    private int category;
    private int subCategory;
    private boolean status;
    private double price;

    public Product(int itemNumber, String productDescription,String productLongDescription, String size, int category, int subCategory, boolean status, double price) {
        this.itemNumber = itemNumber;
        this.productDescription = productDescription;
        this.productLongDescription=productLongDescription;
        this.size = size;
        this.category = category;
        this.subCategory = subCategory;
        this.status = status;
        this.price = price;
    }


    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(int subCategory) {
        this.subCategory = subCategory;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductLongDescription() {
        return productLongDescription;
    }

    public void setProductLongDescription(String productLongDescription) {
        this.productLongDescription = productLongDescription;
    }
}
