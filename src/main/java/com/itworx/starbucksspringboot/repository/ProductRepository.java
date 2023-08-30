package com.itworx.starbucksspringboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.itworx.starbucksspringboot.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
