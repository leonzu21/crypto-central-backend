package com.phc.cryptocentral.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
public class Portfolio {

	// define fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "total_usd")
	private float totalUsd;

	@Column(name = "user")
	private String user;

	@Column(name = "tendies")
	private float tendies;

	@Column(name = "total_investment")
	private float totalInvestment;

	@OneToMany(mappedBy = "portfolio", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private List<PortfolioTransaction> portfolioTransactions;

	@Column(name = "created_at")
	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	@UpdateTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updatedAt;

	// generate constructors

	public Portfolio() {

	}

	public Portfolio(int id, float totalUsd, String user, float tendies, float totalInvestment,
			List<PortfolioTransaction> portfolioTransactions, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.totalUsd = totalUsd;
		this.user = user;
		this.tendies = tendies;
		this.totalInvestment = totalInvestment;
		this.portfolioTransactions = portfolioTransactions;
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

	public float getTotalUsd() {
		return totalUsd;
	}

	public void setTotalUsd(float totalUsd) {
		this.totalUsd = totalUsd;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public float getTendies() {
		return tendies;
	}

	public void setTendies(float tendies) {
		this.tendies = tendies;
	}

	public float getTotalInvestment() {
		return totalInvestment;
	}

	public void setTotalInvestment(float totalInvestment) {
		this.totalInvestment = totalInvestment;
	}

	public List<PortfolioTransaction> getPortfolioTransactions() {
		return portfolioTransactions;
	}

	public void setPortfolioTransactions(List<PortfolioTransaction> portfolioTransactions) {
		this.portfolioTransactions = portfolioTransactions;
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
		return "Portfolio [id=" + id + ", totalUsd=" + totalUsd + ", user=" + user + ", tendies=" + tendies
				+ ", totalInvestment=" + totalInvestment + ", portfolioTransactions=" + portfolioTransactions
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
