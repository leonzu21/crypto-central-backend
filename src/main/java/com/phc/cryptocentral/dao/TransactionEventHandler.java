package com.phc.cryptocentral.dao;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.phc.cryptocentral.entity.Coin;
import com.phc.cryptocentral.entity.Transaction;

@Component
@RepositoryEventHandler(Transaction.class)
public class TransactionEventHandler {

	Logger logger = Logger.getLogger("Class TransactionEventHandler");
	
	@Autowired
	private CoinRepository coinRepository;
	
	@HandleBeforeCreate
	public void handleTransactionBeforeCreate(Transaction theTransaction) {
		logger.info("Inside Transaction Before Create...");
		String symbol = theTransaction.getSymbol();
		logger.info(symbol);
		
		Coin theCoin = coinRepository.findBySymbol(symbol);
		
		if (theCoin != null) {
			logger.info("Coin already exists.");
		}
		else {
			theCoin = new Coin();
			theCoin.setSymbol(symbol);
			theCoin.setName(symbol);
					
			coinRepository.save(theCoin);
		}
		
	}
}
