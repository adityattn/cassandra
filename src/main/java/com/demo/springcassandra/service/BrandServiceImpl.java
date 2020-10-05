package com.demo.springcassandra.service;

import com.demo.springcassandra.model.Brand;
import com.demo.springcassandra.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository brandRepository;

    @Override
    public List<Brand> getBrands() {
        Iterable<Brand> result = brandRepository.findAll();
        List<Brand> brandList = new ArrayList<>();
        result.forEach(brandList::add);
        return brandList;
    }

    @Override
    public Optional<Brand> getBrandById(String contentId) {
        Optional<Brand> brand = brandRepository.findByContentId(contentId);
        return brand;
    }

    @Override
    public Optional<Brand> updateBrand(Brand brand, String contentId) {
        Optional<Brand> optionalEmp = brandRepository.findByContentId(contentId);
        if (optionalEmp.isPresent()) {
            Brand bnd = optionalEmp.get();
            bnd.setContentId(brand.getContentId());
            bnd.setTitle(brand.getTitle());
            bnd.setDescription(brand.getDescription());
            brandRepository.save(bnd);
        }
        return optionalEmp;
    }

    @Override
    public String deleteBrandById(String contentId) {
        Boolean result = brandRepository.existsBrandByContentId(contentId);
        if(result) {
        Optional<Brand> brand= brandRepository.findByContentId(contentId);
            brandRepository.delete(brand.get());
        }
        return "{ \"success\" : "+ (result ? "true" : "false") +" }";    }

    @Override
    public Brand addNewBrand(Brand newBrand) {
        String id = String.valueOf(new Random().nextInt());
        Brand brand= new Brand(id,newBrand.getContentId(),newBrand.getTitle(),newBrand.getDescription());
        brandRepository.save(brand);
        return brand;
    }
}