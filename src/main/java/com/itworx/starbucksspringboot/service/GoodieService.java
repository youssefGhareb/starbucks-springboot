package com.itworx.starbucksspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itworx.starbucksspringboot.model.Goodie;
import com.itworx.starbucksspringboot.repository.GoodieRepository;

@Service
public class GoodieService {

	@Autowired
	private GoodieRepository goodieRepo;

	public Optional<Goodie> getGoodie(Long id) {
		return goodieRepo.findById(id);
	}

	public Goodie createGoodie(Goodie o) {
		Goodie g = goodieRepo.save(o);
		return g;
	}

	public void deleteGoodie(Long id) {
		goodieRepo.deleteById(id);
	}

	public List<Goodie> listGoodies() {
		return (List<Goodie>) goodieRepo.findAll();
	}
}
