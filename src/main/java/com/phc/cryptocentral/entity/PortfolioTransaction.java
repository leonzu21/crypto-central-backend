package com.phc.cryptocentral.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "portfolio_transaction")
public class PortfolioTransaction {

	// define fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "symbol")
	private String symbol;

	@Column(name = "coin_amount")
	private float coinAmount;

	@Column(name = "buy_price")
	private float buyPrice;

	@Column(name = "type")
	private String type; // fiat2binance or cointransaction

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JsonIgnoreProperties(value = { "portfolioTransactions", "handler",
			"hibernateLazyInitializer" }, allowSetters = true)
	@JoinColumn(name = "portfolio_id")
	private Portfolio portfolio;

	@Column(name = "timestamp")
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime timestamp;

	@Column(name = "created_at")
	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	@UpdateTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updatedAt;

	// generate constructors

	public PortfolioTransaction() {

	}

	public PortfolioTransaction(int id, String name, String symbol, float coinAmount, float buyPrice, String type,
			Portfolio portfolio, LocalDateTime timestamp, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.name = name;
		this.symbol = symbol;
		this.coinAmount = coinAmount;
		this.buyPrice = buyPrice;
		this.type = type;
		this.portfolio = portfolio;
		this.timestamp = timestamp;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;

	}

	// generate getters and setters

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

	public float getCoinAmount() {
		return coinAmount;
	}

	public void setCoinAmount(float coinAmount) {
		this.coinAmount = coinAmount;
	}

	public float getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(float buyPrice) {
		this.buyPrice = buyPrice;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	// generate toString method

	@Override
	public String toString() {
		return "PortfolioTransaction [id=" + id + ", name=" + name + ", symbol=" + symbol + ", coinAmount=" + coinAmount
				+ ", buyPrice=" + buyPrice + ", type=" + type + ", portfolio=" + portfolio + ", timestamp=" + timestamp
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
