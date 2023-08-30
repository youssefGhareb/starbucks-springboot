package com.itworx.starbucksspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itworx.starbucksspringboot.model.CoffeeBeans;
import com.itworx.starbucksspringboot.repository.CoffeeBeansRepository;

@Service
public class CoffeeBeansService {

	@Autowired
	private CoffeeBeansRepository coffeeBeansRepo;

	public Optional<CoffeeBeans> getCoffeeBeans(Long id) {
		return coffeeBeansRepo.findById(id);
	}

	public CoffeeBeans createCoffeeBeans(CoffeeBeans o) {
		CoffeeBeans c = coffeeBeansRepo.save(o);
		return c;
	}

	public void deleteCoffeeBeans(Long id) {
		coffeeBeansRepo.deleteById(id);
	}

	public List<CoffeeBeans> listCoffeeBeans() {
		return (List<CoffeeBeans>) coffeeBeansRepo.findAll();
	}
}
