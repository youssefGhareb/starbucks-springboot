package com.itworx.starbucksspringboot.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itworx.starbucksspringboot.model.CoffeeBeans;
import com.itworx.starbucksspringboot.model.Drink;
import com.itworx.starbucksspringboot.model.Goodie;
import com.itworx.starbucksspringboot.model.Product;
import com.itworx.starbucksspringboot.service.CoffeeBeansService;
import com.itworx.starbucksspringboot.service.DrinkService;
import com.itworx.starbucksspringboot.service.GoodieService;
import com.itworx.starbucksspringboot.service.ProductService;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
	@Autowired
	private DrinkService drinkService;
	@Autowired
	private ProductService productService;
	@Autowired
	private GoodieService goodieService;
	@Autowired
	private CoffeeBeansService coffeeBeansService;

	@GetMapping
	public List<Product> list() {
		return productService.listProducts();
	}

	@GetMapping
	@RequestMapping("{id}")
	public Optional<Drink> get(@PathVariable Long id) {
		return drinkService.getDrink(id);
	}

	@PostMapping
	public Product create(@RequestBody Map<String, String> body) {
		Product p = null;
		System.out.println(body.get("type"));
		if (body.get("type").equals("Drink")) {
			System.out.println("In if");

		}

		switch (body.get("type")) {
		case "Drink": {
			Drink d = new Drink(String.valueOf(body.get("title")), Double.valueOf((String) body.get("price")),
					Boolean.valueOf(body.get("lactoseFree")), LocalDate.parse(body.get("from")),
					LocalDate.parse(body.get("to")));
			drinkService.createDrink(d);
			p = (Product) d;
		}
		case "Goodie": {
			Goodie g = new Goodie(String.valueOf(body.get("title")), Double.valueOf((String) body.get("price")),
					Boolean.valueOf(body.get("glutenFree")), LocalDate.parse(body.get("from")),
					LocalDate.parse(body.get("to")));
			goodieService.createGoodie(g);
			p = (Product) g;
		}
		case "CoffeeBeans": {
			CoffeeBeans cb = new CoffeeBeans(String.valueOf(body.get("title")), Double.valueOf((String) body.get("price")),
					String.valueOf(body.get("roast")), LocalDate.parse(body.get("from")),
					LocalDate.parse(body.get("to")));
			coffeeBeansService.createCoffeeBeans(cb);
			p = (Product) cb;
		}
		}
		return p;
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		drinkService.deleteDrink(id);
	}
}
