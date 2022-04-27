package com.phc.cryptocentral.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phc.cryptocentral.dao.PortfolioRepository;
import com.phc.cryptocentral.dao.PortfolioTransactionRepository;
import com.phc.cryptocentral.entity.PortfolioTransaction;

@RestController
public class PortfolioTransactionRestController {

	@Autowired
	private PortfolioRepository portfolioRepository;

	@Autowired
	private PortfolioTransactionRepository portfolioTransactionRepository;

	@PostMapping("/api/portfolioTransactions/{portfolioId}/transactions")
	public PortfolioTransaction createComment(@PathVariable(value = "portfolioId") int portfolioId,
			@RequestBody PortfolioTransaction theTransaction) {
		return portfolioRepository.findById(portfolioId).map(portfolio -> {
			theTransaction.setPortfolio(portfolio);
			return portfolioTransactionRepository.save(theTransaction);
		}).orElseThrow(() -> new ResourceNotFoundException("PortfolioId " + portfolioId + " not found"));
	}

}
