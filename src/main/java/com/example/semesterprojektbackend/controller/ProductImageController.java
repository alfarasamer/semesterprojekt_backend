package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.Product;
import com.example.semesterprojektbackend.model.ProductImageDTO;
import com.example.semesterprojektbackend.model.ImageDTO;
import com.example.semesterprojektbackend.repositories.ProductRepo;
import com.example.semesterprojektbackend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController

@AllArgsConstructor
public class ProductImageController {
    private final ProductService productService;
    private final ProductRepo productRepo;

    private static final String UPLOAD_DIR = System.getProperty("user.home") +"\\Desktop\\Webshop-Projekt-Final\\SemesterWebShop-Frontend\\images\\products";


    @PostMapping("/upload-product-image")
    public ResponseEntity<?> multiUploadFileModel(@ModelAttribute ImageDTO form) {

        System.out.println("ItemNumber:" + form.getItemNumber());
        Long itemNumber = form.getItemNumber();
        String uploadDirectory;
        try {
            uploadDirectory = this.saveUploadedFiles(form.getFile(),itemNumber.toString());

            String imageLink = "/images/products/"+itemNumber+".jpg";

            System.out.println("Upload Directory is " +uploadDirectory);
            System.out.println("Imagelink is " +imageLink);
            ProductImageDTO productImageDTO = new ProductImageDTO();
            productImageDTO.setProductImageUrl(imageLink);
            productImageDTO.setItemNumber(itemNumber);
            addNewProductImageUrl(productImageDTO);
        }
        catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<ProductImageDTO>(HttpStatus.OK);
    }

    // Save Files
    private String saveUploadedFiles(MultipartFile[] file,String itemNumber) throws IOException {

        // Make sure directory exists!
        File uploadDir = new File(UPLOAD_DIR);
        uploadDir.mkdirs();

        StringBuilder sb = new StringBuilder();

        //String newFileName = itemNumber;

        String uploadFilePath = UPLOAD_DIR + "/" + itemNumber+".jpg";

        //System.out.println("This is the Original File Name"+originalFileName);
            byte[] bytes = file[0].getBytes();

            Path path = Paths.get(uploadFilePath);

            Files.write(path, bytes);

            sb.append(uploadFilePath);

        return sb.toString();
    }

    //write Product image url in database
    public String addNewProductImageUrl(@Valid ProductImageDTO productImageDTO) {
        Product product = productService.findByItemNumber(productImageDTO.getItemNumber());
        product.setImageUrl(productImageDTO.getProductImageUrl());

        productRepo.save(product);
        return "Product image URL Created";
    }

}

