package com.itworx.starbucksspringboot.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Drinks")
public class Drink extends Product {
	
	@Column(nullable = false)
	private boolean lactoseFree;
	@Column(name = "from_date")
	private LocalDate from;
	@Column(name = "to_date")
	private LocalDate to;
	
	public Drink() {
		super();
	}

	public Drink(String title, double price, boolean lactoseFree, LocalDate from, LocalDate to) {
		super(title, price);
		this.lactoseFree = lactoseFree;
		this.setFrom(from);
		this.setTo(to);
	}

	public boolean isLactoseFree() {
		return lactoseFree;
	}

	public void setLactoseFree(boolean lactoseFree) {
		this.lactoseFree = lactoseFree;
	}

	@Override
	public String toString() {
		return "Drink [lactoseFree=" + lactoseFree + ", " + super.toString() + "]";
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
