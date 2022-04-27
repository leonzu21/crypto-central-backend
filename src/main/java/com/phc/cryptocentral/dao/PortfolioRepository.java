package com.phc.cryptocentral.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.phc.cryptocentral.entity.Portfolio;

public interface PortfolioRepository extends PagingAndSortingRepository<Portfolio, Integer> {

	@Query(value = "SELECT * FROM portfolio WHERE user = ?1", 
			nativeQuery = true)
	public Page<Portfolio> findByUser(String theUser, Pageable p);
}
