package com.phc.cryptocentral.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="transaction")
public class Transaction {

	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private BigInteger id;
	
	@Column(name="whalealert_id")
	private BigInteger whalealertId;
	
	@Column(name="blockchain")
	private String blockchain;
	
	@Column(name="symbol")
	private String symbol;
	
	@Column(name="amount_usd")
	private float amountUsd;
	
	@Column(name="timestamp")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime timestamp;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="from_address")
	private String fromAddress;
	
	@Column(name="from_owner")
	private String fromOwner;
	
	@Column(name="from_owner_type")
	private String fromOwnerType;
	
	@Column(name="to_address")
	private String toAddress;
	
	@Column(name="to_owner")
	private String toOwner;
	
	@Column(name="to_owner_type")
	private String toOwnerType;
	
	@Column(name="transaction_count")
	private int transactionCount;
	
	@Column(name="hash")
	private String hash;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="whalealert_request_id")
	private WhaleAlertRequest whaleAlertRequest;
	
	@Column(name="created_at")
	@CreationTimestamp
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdAt;
	
	@Column(name="updated_at")
	@UpdateTimestamp
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updatedAt;
	
	
	// define constructors
	
	public Transaction() {
		
	}

	public Transaction(BigInteger whalealertId, String blockchain, String symbol, float amountUsd,
			LocalDateTime timestamp, float amount, String fromAddress, String fromOwner, String fromOwnerType,
			String toAddress, String toOwner, String toOwnerType, int transactionCount, String hash,
			WhaleAlertRequest whaleAlertRequest, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.whalealertId = whalealertId;
		this.blockchain = blockchain;
		this.symbol = symbol;
		this.amountUsd = amountUsd;
		this.timestamp = timestamp;
		this.amount = amount;
		this.fromAddress = fromAddress;
		this.fromOwner = fromOwner;
		this.fromOwnerType = fromOwnerType;
		this.toAddress = toAddress;
		this.toOwner = toOwner;
		this.toOwnerType = toOwnerType;
		this.transactionCount = transactionCount;
		this.hash = hash;
		this.whaleAlertRequest = whaleAlertRequest;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	// generate getters and setters

	public BigInteger getId() {
		return id;
	}


	public void setId(BigInteger id) {
		this.id = id;
	}


	public BigInteger getWhalealertId() {
		return whalealertId;
	}


	public void setWhalealertId(BigInteger whalealertId) {
		this.whalealertId = whalealertId;
	}


	public String getBlockchain() {
		return blockchain;
	}


	public void setBlockchain(String blockchain) {
		this.blockchain = blockchain;
	}


	public String getSymbol() {
		return symbol;
	}


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	public float getAmountUsd() {
		return amountUsd;
	}


	public void setAmountUsd(float amountUsd) {
		this.amountUsd = amountUsd;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}


	public String getFromAddress() {
		return fromAddress;
	}


	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}


	public String getFromOwner() {
		return fromOwner;
	}


	public void setFromOwner(String fromOwner) {
		this.fromOwner = fromOwner;
	}


	public String getFromOwnerType() {
		return fromOwnerType;
	}


	public void setFromOwnerType(String fromOwnerType) {
		this.fromOwnerType = fromOwnerType;
	}


	public String getToAddress() {
		return toAddress;
	}


	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}


	public String getToOwner() {
		return toOwner;
	}


	public void setToOwner(String toOwner) {
		this.toOwner = toOwner;
	}


	public String getToOwnerType() {
		return toOwnerType;
	}


	public void setToOwnerType(String toOwnerType) {
		this.toOwnerType = toOwnerType;
	}


	public int getTransactionCount() {
		return transactionCount;
	}


	public void setTransactionCount(int transactionCount) {
		this.transactionCount = transactionCount;
	}


	public String getHash() {
		return hash;
	}


	public void setHash(String hash) {
		this.hash = hash;
	}

	public WhaleAlertRequest getWhaleAlertRequest() {
		return whaleAlertRequest;
	}

	public void setWhaleAlertRequest(WhaleAlertRequest whaleAlertRequest) {
		this.whaleAlertRequest = whaleAlertRequest;
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
		return "Transaction [id=" + id + ", whalealertId=" + whalealertId + ", blockchain=" + blockchain + ", symbol="
				+ symbol + ", amountUsd=" + amountUsd + ", timestamp=" + timestamp + ", amount=" + amount
				+ ", fromAddress=" + fromAddress + ", fromOwner=" + fromOwner + ", fromOwnerType=" + fromOwnerType
				+ ", toAddress=" + toAddress + ", toOwner=" + toOwner + ", toOwnerType=" + toOwnerType
				+ ", transactionCount=" + transactionCount + ", hash=" + hash + ", whaleAlertRequest="
				+ whaleAlertRequest + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	

}
