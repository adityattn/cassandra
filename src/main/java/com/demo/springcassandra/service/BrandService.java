package com.demo.springcassandra.service;

import com.demo.springcassandra.model.Brand;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BrandService {

    List<Brand> getBrands();
    Optional<Brand> getBrandById(String contentId);
    Optional<Brand> updateBrand(Brand brand, String contentId);
    String deleteBrandById(String contentId);
    Brand addNewBrand(Brand brand);
}
