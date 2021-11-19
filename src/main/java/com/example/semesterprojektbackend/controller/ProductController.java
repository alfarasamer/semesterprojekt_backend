package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.Product;
import com.example.semesterprojektbackend.service.ProductService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")

    public String getProducts(Model model){
        List<Product> productList = productService.getProducts();
        model.addAttribute("products",productList);
        return "product";
    }
    /*public ArrayList<Product> getProducts() {

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(123, "T-shirt","T-Shirt long description", "L", 1, 2, true, 99.5));
        products.add(new Product(123, "T-shirt","T-Shirt long description", "L", 1, 2, true, 99.5));
        products.add(new Product(123, "T-shirt","T-Shirt long description", "L", 1, 2, true, 99.5));
        products.add(new Product(123, "T-shirt","T-Shirt long description", "L", 1, 2, true, 99.5));
        products.add(new Product(123, "T-shirt","T-Shirt long description", "L", 1, 2, true, 99.5));
        products.add(new Product(123, "T-shirt","T-Shirt long description", "L", 1, 2, true, 99.5));
        products.add(new Product(123, "T-shirt","T-Shirt long description", "L", 1, 2, true, 99.5));
        products.add(new Product(123, "T-shirt","T-Shirt long description", "L", 1, 2, true, 99.5));
*/
        //return products;
        // TODO: 29/06/2021 to return all products
    //}

    @GetMapping("/products/{itemNumber}")
    public Product getProductPath(@PathVariable int itemNumber) {
        return demoProduct();
    }

    @PostMapping("/products")
    public List<Product> postProductPath(@RequestBody Product product) {
        // TODO: 29/06/2021 to create a new item
        return null;
    }

    @PutMapping("/products/{itemNumber}")
    public Product putProductPath(@PathVariable int itemNumber,@RequestBody Product product) {
        // TODO: 29/06/2021 to edit a specific product
    return null;
    }

    @DeleteMapping("/products/{itemNumber}")
    public Product deleteProductPath(@PathVariable int itemNumber) {
        // TODO: 29/06/2021 to delete a specific product
    return null;
    }

    private Product demoProduct() {
        return new Product(123, "T-shirt","T-Shirt long description", "L", 1, 2, true, 99.5);
        // TODO: 29/06/2021 to be deleted later! }
}
}