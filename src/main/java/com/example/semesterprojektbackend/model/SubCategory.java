package com.example.semesterprojektbackend.model;

public class SubCategory {
    private int subCategoryId;
    private String subCategory;

    public SubCategory() {
    }

    public SubCategory(int subCategoryId, String subCategory) {
        this.subCategoryId = subCategoryId;
        this.subCategory = subCategory;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }
}
