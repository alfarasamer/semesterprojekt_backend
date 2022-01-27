package com.example.semesterprojektbackend.model;

import io.micrometer.core.lang.Nullable;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Setter
@Getter
public class ProductImageDTO {

    private Long itemNumber;
    private String productImageUrl;
}
