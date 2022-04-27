package com.phc.cryptocentral.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.phc.cryptocentral.entity.Coin;

import net.minidev.json.JSONObject;

public interface CoinRepository extends PagingAndSortingRepository<Coin, Integer> {

	@Query(value = "SELECT DISTINCT * FROM coin WHERE symbol = ?1", 
			nativeQuery = true)
	public Coin findBySymbol(String theSymbol);
	
	@Query(value = "SELECT id, symbol as label FROM coin", 
			nativeQuery = true)
	public List<JSONObject> findAllSymbols();
}
