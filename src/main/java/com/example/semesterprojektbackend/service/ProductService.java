package com.example.semesterprojektbackend.service;

import com.example.semesterprojektbackend.model.Product;
import com.example.semesterprojektbackend.model.enumuration.Status;
import com.example.semesterprojektbackend.repositories.ProductRepo;
import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;
    //private static final String UPLOAD_DIR = System.getProperty("user.home") +"\\desktop\\Projekt Samer\\SemesterProjektBackend - Backup\\src\\main\\resources\\images\\products";
    private static final String UPLOAD_DIR ="./src/main/resources/images/products";


    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public List<Product> getActiveProducts() {
        List<Product> activeProducts = productRepo.findAll().stream().filter(p -> p.getStatus() == Status.ACTIVE).collect(Collectors.toList());

        return activeProducts;
    }


    public Product save(Product product) {
        productRepo.save(product);
        return product;
    }

    public Product findByItemNumber(Long itemNumber) {
        return productRepo.findByItemNumber(itemNumber);
    }

    public Optional<Product> findById(Long itemNumber) {
        return productRepo.findById(itemNumber);
    }

    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    public @ResponseBody
    byte[] getImg(long id) {


        try {
            BufferedImage originalImage = ImageIO.read(new File(UPLOAD_DIR +"/"+ id + ".jpg"));
            int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

            BufferedImage resizeImageBmp = resizeImage(originalImage, type);
            ImageIO.write(resizeImageBmp, "jpg", new File(UPLOAD_DIR +"/"+ id + ".jpg"));

            File file = new File(UPLOAD_DIR +"/"+ id + ".jpg");
            FileInputStream inputStream = new FileInputStream(file);
            return IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }


    private BufferedImage resizeImage(BufferedImage originalImage, int type) {
        int IMG_WIDTH = 512;
        int IMG_CLAHEIGHT = 512;
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_CLAHEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_CLAHEIGHT, null);
        g.dispose();
        return resizedImage;
    }

}
