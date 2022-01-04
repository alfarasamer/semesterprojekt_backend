package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.Brand;
import com.example.semesterprojektbackend.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/brands")
public class BrandController {

    private final BrandService brandService;

    @GetMapping()
    public List<Brand> getBrand() {
        return brandService.getBrands();
    }

    @GetMapping("/{brandId}")
    public Optional<Brand> findById(@PathVariable int brandId) {
        return brandService.findById(brandId);
    }

    @PostMapping()
    public String addNew(@Valid Brand brand) {
        brandService.save(brand);
        return "Brand created";
    }

    @PutMapping("/{brandId}")
    public ResponseEntity<Brand> updateBrand(@PathVariable int brandId, @RequestBody Brand brandDetails) {
        Brand brand = brandService.findById(brandId)
                .orElseThrow(() -> new NullPointerException("Brand not exist with id :" + brandId));
        brand.setBrandName(brandDetails.getBrandName());
        Brand updatedBrand = brandService.save(brand);
        return ResponseEntity.ok(updatedBrand);
    }

    @DeleteMapping("/brands/{brandId}")
    public ResponseEntity<Map<String, Boolean>> deleteBrand(@PathVariable int brandId) {
        brandService.delete(brandId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
