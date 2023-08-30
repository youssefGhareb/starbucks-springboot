package com.itworx.starbucksspringboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.itworx.starbucksspringboot.model.CoffeeBeans;

public interface CoffeeBeansRepository extends CrudRepository<CoffeeBeans, Long> {

}
