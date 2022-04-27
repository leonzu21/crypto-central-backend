package com.phc.cryptocentral.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.phc.cryptocentral.entity.PortfolioTransaction;

public interface PortfolioTransactionRepository extends PagingAndSortingRepository<PortfolioTransaction, Integer> {

	@Query(value = "SELECT *, (select sum(coin_amount) from portfolio_transaction where type='fiat2binance' and portfolio_id = ?1) as total2binance, (select sum(coin_amount) from portfolio_transaction where type='cointransaction' and portfolio_id = ?1) as totalcointransactions\n"
			+ " FROM portfolio_transaction WHERE portfolio_id = ?1", nativeQuery = true)
	public Page<PortfolioTransaction> findByPortfolio(String thePortfolio, Pageable p);
	
	@Query(value = "SELECT * FROM portfolio_transaction WHERE type = ?1 AND portfolio_id = ?2", 
			nativeQuery = true)
	public List<PortfolioTransaction> findByPortfolioAndType(String theType, int portfolioId);
}
