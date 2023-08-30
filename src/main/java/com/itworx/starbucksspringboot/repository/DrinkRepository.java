package com.itworx.starbucksspringboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.itworx.starbucksspringboot.model.Drink;

public interface DrinkRepository extends CrudRepository<Drink, Long> {

}
