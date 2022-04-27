package com.phc.cryptocentral.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Coin {

	// define fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "symbol")
	private String symbol;
	
	@Column(name = "contract")
	private String contract;
	
	@Column(name = "value")
	private double value;
	
	// define constructors
	
	public Coin() {
		
	}
	
	public Coin(String name, String symbol, String contract, double value) {
		this.name = name;
		this.symbol = symbol;
		this.contract = contract;
		this.value = value;
	}
	
	// define getter/setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}


	// define toString
	
	public Coin(int id, String name, String symbol, String contract, double value) {
		this.id = id;
		this.name = name;
		this.symbol = symbol;
		this.contract = contract;
		this.value = value;
	}

}
