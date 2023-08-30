package com.itworx.starbucksspringboot.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Goodies")
public class Goodie extends Product {

	@Column(nullable = false)
	private boolean glutenFree;
	@Column(name = "from_date")
	private LocalDate from;
	@Column(name = "to_date")
	private LocalDate to;

	public Goodie() {
		super();
	}

	public Goodie(String title, Double price, boolean glutenFree, LocalDate from, LocalDate to) {
		super(title, price);
		this.glutenFree = glutenFree;
		this.from = from;
		this.to = to;
	}
	
	

	public boolean isGlutonFree() {
		return glutenFree;
	}

	public void setGlutonFree(boolean glutenFree) {
		this.glutenFree = glutenFree;
	}

	public LocalDate getFrom() {
		return from;
	}

	public void setFrom(LocalDate from) {
		this.from = from;
	}

	public LocalDate getTo() {
		return to;
	}

	public void setTo(LocalDate to) {
		this.to = to;
	}

}
