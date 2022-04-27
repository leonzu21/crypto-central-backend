package com.phc.cryptocentral.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.phc.cryptocentral.entity.Transaction;

public interface TransactionRepository extends PagingAndSortingRepository<Transaction, BigInteger> {

	@RestResource(path = "/day", rel = "DAY(timestamp)")
	public Page<Transaction> findBySymbolStartsWith(@Param("timestamp") String day, Pageable p);

	@Query(value = "SELECT * FROM transaction WHERE DATE(timestamp) = ?1 ORDER BY amount_usd DESC", 
			countQuery = "SELECT COUNT(*) FROM transaction WHERE DATE(timestamp) = ?1", 
			nativeQuery = true)
	public Page<Transaction> findAllByDayOrderByAmountDesc(String theDate, Pageable p);
	
	@Query(value = "SELECT * FROM transaction WHERE DATE(timestamp) = ?1 AND symbol = ?2 ORDER BY amount_usd DESC", 
			countQuery = "SELECT COUNT(*) FROM transaction WHERE DATE(timestamp) = ?1 AND symbol = ?2", 
			nativeQuery = true)
	public Page<Transaction> findAllBySymbolByDayOrderByAmountDesc(String theDate, String theSymbol, Pageable p);

	@Query(value = "SELECT * FROM transaction WHERE DATE_FORMAT(timestamp, '%Y-%m') = ?1 ORDER BY amount_usd DESC", 
			countQuery = "SELECT COUNT(*) FROM transaction WHERE DATE_FORMAT(timestamp, '%Y-%m') = ?1", 
			nativeQuery = true)
	public Page<Transaction> findAllByMonthOrderByAmountDesc(String theDate, Pageable p);
	
	@Query(value = "SELECT * FROM transaction WHERE DATE_FORMAT(timestamp, '%Y-%m') = ?1 AND symbol = ?2 ORDER BY amount_usd DESC", 
			countQuery = "SELECT COUNT(*) FROM transaction WHERE DATE_FORMAT(timestamp, '%Y-%m') = ?1 AND symbol = ?2", 
			nativeQuery = true)
	public Page<Transaction> findAllBySymbolByMonthOrderByAmountDesc(String theDate, String theSymbol, Pageable p);

	@Query(value = "SELECT * FROM transaction WHERE YEAR(timestamp) = ?1 ORDER BY amount_usd DESC", 
			countQuery = "SELECT COUNT(*) FROM transaction WHERE YEAR(timestamp) = ?1 ORDER BY amount_usd DESC", 
			nativeQuery = true)
	public Page<Transaction> findAllByYearOrderByAmountDesc(String theDate, Pageable p);
	
	@Query(value = "SELECT * FROM transaction WHERE YEAR(timestamp) = ?1 AND symbol = ?2 ORDER BY amount_usd DESC", 
			countQuery = "SELECT COUNT(*) FROM transaction WHERE YEAR(timestamp) = ?1 AND symbol = ?2", 
			nativeQuery = true)
	public Page<Transaction> findAllBySymbolByYearOrderByAmountDesc(String theDate, String theSymbol, Pageable p);
	
	@Query(value = "SELECT * FROM transaction WHERE DATE(timestamp) = ?1", 
			nativeQuery = true)
	public List<Transaction> findDailyChartData(String theDate);

	@Query(value = "SELECT * FROM transaction WHERE DATE(timestamp) = ?1 AND symbol = ?2", 
			nativeQuery = true)
	public List<Transaction> findDailyChartDataBySymbol(String theDate, String theSymbol);
	
	@Query(value = "SELECT * FROM transaction WHERE DATE_FORMAT(timestamp, '%Y-%m') = ?1", 
			nativeQuery = true)
	public List<Transaction> findMonthlyChartData(String theDate);

	@Query(value = "SELECT * FROM transaction WHERE DATE_FORMAT(timestamp, '%Y-%m') = ?1 AND symbol = ?2", 
			nativeQuery = true)
	public List<Transaction> findMonthlyChartDataBySymbol(String theDate, String theSymbol);
	
	@Query(value = "SELECT * FROM transaction WHERE YEAR(timestamp) = ?1", 
			nativeQuery = true)
	public List<Transaction> findYearlyChartData(String theDate);

	@Query(value = "SELECT * FROM transaction WHERE YEAR(timestamp) = ?1 AND symbol = ?2", 
			nativeQuery = true)
	public List<Transaction> findYearlyChartDataBySymbol(String theDate, String theSymbol);
}
