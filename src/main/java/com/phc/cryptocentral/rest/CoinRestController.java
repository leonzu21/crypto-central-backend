package com.phc.cryptocentral.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phc.cryptocentral.dao.CoinRepository;
import net.minidev.json.JSONObject;


@RestController
@RequestMapping("/api/symbols")
public class CoinRestController {

	private CoinRepository coinRepository;

	@Autowired
	public CoinRestController(CoinRepository theCoinRepository) {
		coinRepository = theCoinRepository;
	}
	
	@GetMapping(value = "/all")
	public List<JSONObject> findAllSymbols() {

		return coinRepository.findAllSymbols();
		
	}

}
