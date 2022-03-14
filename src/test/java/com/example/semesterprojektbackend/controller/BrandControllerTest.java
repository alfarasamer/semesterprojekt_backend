package com.example.semesterprojektbackend.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.semesterprojektbackend.model.Brand;
import com.example.semesterprojektbackend.service.BrandService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {BrandController.class})
@ExtendWith(SpringExtension.class)
class BrandControllerTest {
    @Autowired
    private BrandController brandController;

    @MockBean
    private BrandService brandService;

    @Test
    void testAddNew() throws Exception {
        when(this.brandService.getBrands()).thenReturn(new ArrayList<>());

        Brand brand = new Brand();
        brand.setBrandName("Brand Name");
        brand.setId(1);
        String content = (new ObjectMapper()).writeValueAsString(brand);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/brands")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.brandController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testFindById() throws Exception {
        Brand brand = new Brand();
        brand.setBrandName("Brand Name");
        brand.setId(1);
        Optional<Brand> ofResult = Optional.of(brand);
        when(this.brandService.findById(anyInt())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/brands/{brandId}", 123);
        MockMvcBuilders.standaloneSetup(this.brandController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"brandName\":\"Brand Name\"}"));
    }

    @Test
    void testDeleteBrand() throws Exception {
        doNothing().when(this.brandService).delete(anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/brands/{brandId}", 123);
        MockMvcBuilders.standaloneSetup(this.brandController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"deleted\":true}"));
    }

    @Test
    void testGetBrand() throws Exception {
        when(this.brandService.getBrands()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/brands");
        MockMvcBuilders.standaloneSetup(this.brandController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testUpdateBrand() throws Exception {
        Brand brand = new Brand();
        brand.setBrandName("Brand Name");
        brand.setId(1);
        Optional<Brand> ofResult = Optional.of(brand);

        Brand brand1 = new Brand();
        brand1.setBrandName("Brand Name");
        brand1.setId(1);
        when(this.brandService.save((Brand) any())).thenReturn(brand1);
        when(this.brandService.findById(anyInt())).thenReturn(ofResult);

        Brand brand2 = new Brand();
        brand2.setBrandName("Brand Name");
        brand2.setId(1);
        String content = (new ObjectMapper()).writeValueAsString(brand2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/brands/{brandId}", 123)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.brandController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"brandName\":\"Brand Name\"}"));
    }
}

