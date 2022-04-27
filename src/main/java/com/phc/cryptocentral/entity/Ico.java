package com.phc.cryptocentral.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
public class Ico {

	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;

	@Column(name = "name")
	public String name;

	@Column(name = "tokens_sale")
	public String tokensSale;

	@Column(name = "price")
	public String price;

	@Column(name = "soft_cap")
	public String softCap;

	@Column(name = "fund_goal")
	public String fundGoal;

	@Column(name = "tokens_sold")
	public String tokensSold;

	@Column(name = "buy_on")
	public String buyOn;

	@Column(name = "cent_total")
	public String centTotal;

	@Column(name = "accept")
	public String accept;

	@Column(name = "access")
	public String access;

	@Column(name = "blockchain")
	public String blockchain;

	@Column(name = "website")
	public String website;

	@Column(name = "whitepaper")
	public String whitepaper;

	@Column(name = "contract")
	public String contract;

	@Column(name = "user")
	public String user;

	@Column(name = "confidence_level")
	public int confidenceLevel;

	@Column(name = "description")
	public String description;

	@Column(name = "accepted")
	public boolean accepted;

	@Column(name = "birthday")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthday;

	@Column(name = "created_at")
	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	@UpdateTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updatedAt;

	// define constructors

	public Ico() {

	}

	public Ico(String name, String tokensSale, String price, String softCap, String fundGoal, String tokensSold,
			String buyOn, String centTotal, String accept, String access, String blockchain, String website,
			String whitepaper, String contract, String user, int confidenceLevel, String description, boolean accepted,
			LocalDate birthday, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.name = name;
		this.tokensSale = tokensSale;
		this.price = price;
		this.softCap = softCap;
		this.fundGoal = fundGoal;
		this.tokensSold = tokensSold;
		this.buyOn = buyOn;
		this.centTotal = centTotal;
		this.accept = accept;
		this.access = access;
		this.blockchain = blockchain;
		this.website = website;
		this.whitepaper = whitepaper;
		this.contract = contract;
		this.user = user;
		this.confidenceLevel = confidenceLevel;
		this.description = description;
		this.accepted = accepted;
		this.birthday = birthday;
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

	public String getTokensSale() {
		return tokensSale;
	}

	public void setTokensSale(String tokensSale) {
		this.tokensSale = tokensSale;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSoftCap() {
		return softCap;
	}

	public void setSoftCap(String softCap) {
		this.softCap = softCap;
	}

	public String getFundGoal() {
		return fundGoal;
	}

	public void setFundGoal(String fundGoal) {
		this.fundGoal = fundGoal;
	}

	public String getTokensSold() {
		return tokensSold;
	}

	public void setTokensSold(String tokensSold) {
		this.tokensSold = tokensSold;
	}

	public String getBuyOn() {
		return buyOn;
	}

	public void setBuyOn(String buyOn) {
		this.buyOn = buyOn;
	}

	public String getCentTotal() {
		return centTotal;// generate toString method
	}

	public void setCentTotal(String centTotal) {
		this.centTotal = centTotal;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public String getBlockchain() {
		return blockchain;
	}

	public void setBlockchain(String blockchain) {
		this.blockchain = blockchain;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getWhitepaper() {
		return whitepaper;
	}

	public void setWhitepaper(String whitepaper) {
		this.whitepaper = whitepaper;
	}

	public String getContract() {
		return contract;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUser() {
		return user;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public int getConfidenceLevel() {
		return confidenceLevel;
	}

	public void setConfidenceLevel(int confidenceLevel) {
		this.confidenceLevel = confidenceLevel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
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
		return "Ico [id=" + id + ", name=" + name + ", tokensSale=" + tokensSale + ", price=" + price + ", softCap="
				+ softCap + ", fundGoal=" + fundGoal + ", tokensSold=" + tokensSold + ", buyOn=" + buyOn
				+ ", centTotal=" + centTotal + ", accept=" + accept + ", access=" + access + ", blockchain="
				+ blockchain + ", website=" + website + ", whitepaper=" + whitepaper + ", contract=" + contract
				+ ", user=" + user + ", confidenceLevel=" + confidenceLevel + ", description=" + description
				+ ", accepted=" + accepted + ", birthday=" + birthday + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}

}
