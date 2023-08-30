package com.itworx.starbucksspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itworx.starbucksspringboot.model.Drink;
import com.itworx.starbucksspringboot.repository.DrinkRepository;

@Service
public class DrinkService {

	@Autowired
	private DrinkRepository drinkRepo;

	public Optional<Drink> getDrink(Long id) {
		return drinkRepo.findById(id);
	}

	public Drink createDrink(Drink o) {
		Drink d = drinkRepo.save(o);
		return d;
	}

	public void deleteDrink(Long id) {
		drinkRepo.deleteById(id);
	}

	public List<Drink> listDrinks() {
		return (List<Drink>) drinkRepo.findAll();
	}
}
