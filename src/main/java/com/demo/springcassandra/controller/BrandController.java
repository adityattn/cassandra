package com.demo.springcassandra.controller;

import com.demo.springcassandra.model.Brand;
import com.demo.springcassandra.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
    public String getHealthCheck() {
        return "{ \"isWorking\" : true }";
    }

    @GetMapping("/brands")
    public List<Brand> getBrands() {
        return brandService.getBrands();
    }

    @GetMapping("/brand/{contentId}")
    public Optional<Brand> getBrandById(@PathVariable String contentId) {
        return brandService.getBrandById(contentId);
    }

    @PutMapping("/brand/{contentId}")
    public Optional<Brand> updateBrand(@RequestBody Brand brand, @PathVariable String contentId) {
        return brandService.updateBrand(brand, contentId);
    }

    @DeleteMapping(value = "/brand/{contentId}", produces = "application/json; charset=utf-8")
    public String deleteById(@PathVariable String contentId) {
        return brandService.deleteBrandById(contentId);
    }

    @PostMapping("/brand")
    public Brand addBrand(@RequestBody Brand newBrand) {
        return brandService.addNewBrand(newBrand);
    }
}
