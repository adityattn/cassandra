package com.demo.springcassandra.repository;

import com.demo.springcassandra.model.Brand;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.Optional;

public interface BrandRepository extends CassandraRepository<Brand,String> {

    @AllowFiltering
    Optional<Brand> findByContentId(String contentId);
    @AllowFiltering
    Boolean existsBrandByContentId(String contentId);
}
