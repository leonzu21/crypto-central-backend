package com.phc.cryptocentral.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="whalealert_request")
public class WhaleAlertRequest {

	// define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="result")
	private String result;
	
	@Column(name="whale_cursor")
	private String whaleCursor;
	
	@Column(name="count")
	private int count;
	
	@Column(name="count_with_identified_address")
	private int countWithIdentifiedAddress;
	
	@Column(name="timestamp")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime timestamp;
	
	@OneToMany(fetch=FetchType.LAZY,
			mappedBy="whaleAlertRequest", cascade={CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Transaction> transactions;
	
	@Column(name="created_at")
	@CreationTimestamp
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdAt;
	
	@Column(name="updated_at")
	@UpdateTimestamp
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updatedAt;
	
	// define constructors
	
	public WhaleAlertRequest() {
		
	}
	
	public WhaleAlertRequest(int id, String result, String whaleCursor, int count, int countWithIdentifiedAddress,
			LocalDateTime timestamp, List<Transaction> transactions, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.result = result;
		this.whaleCursor = whaleCursor;
		this.count = count;
		this.countWithIdentifiedAddress = countWithIdentifiedAddress;
		this.timestamp = timestamp;
		this.transactions = transactions;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getWhaleCursor() {
		return whaleCursor;
	}

	public void setWhaleCursor(String whaleCursor) {
		this.whaleCursor = whaleCursor;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCountWithIdentifiedAddress() {
		return countWithIdentifiedAddress;
	}

	public void setCountWithIdentifiedAddress(int countWithIdentifiedAddress) {
		this.countWithIdentifiedAddress = countWithIdentifiedAddress;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
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
		return "WhaleAlertRequest [id=" + id + ", result=" + result + ", whaleCursor=" + whaleCursor + ", count="
				+ count + ", countWithIdentifiedAddress=" + countWithIdentifiedAddress + ", timestamp=" + timestamp
				+ ", transactions=" + transactions + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	

}
