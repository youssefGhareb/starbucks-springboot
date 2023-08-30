package com.itworx.starbucksspringboot.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Coffee_Beans")
public class CoffeeBeans extends Product {

	@Column(nullable = false)
	private String roast;
	@Column(name = "from_date")
	private LocalDate from;
	@Column(name = "to_date")
	private LocalDate to;

	public CoffeeBeans() {
		super();
	}

	public CoffeeBeans(String title, Double price, String roast, LocalDate from, LocalDate to) {
		super(title, price);
		this.roast = roast;
		this.from = from;
		this.to = to;
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
