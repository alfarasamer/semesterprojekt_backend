package com.example.semesterprojektbackend.model;

public class Category extends SubCategory {
    private int categoryId;
    private String categoryName;

    public Category(int subCategoryId, String subCategory, int categoryId, String categoryName) {
        super(subCategoryId, subCategory);
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }


    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
