package com.phc.cryptocentral.rest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.phc.cryptocentral.dao.PortfolioTransactionRepository;
import com.phc.cryptocentral.entity.PortfolioTransaction;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@RestController
@RequestMapping("api/portfolios")
public class PortfolioRestController {

	private float total2Binance;
	private float symbolInvestment;
	private float symbolCount;
	private float symbolAvgPrice;
	private float symbolCurrentPrice;
	private float whereLambo;
	private float dcaInvest;
	private float tendies;
	private float totalInvestment;

	@Autowired
	private PortfolioTransactionRepository portfolioTransactionRepository;

	@GetMapping(value = "/{portfolioId}/situation")
	public JSONObject getPortfolioSituation(@PathVariable(value = "portfolioId") int portfolioId) {

		List<PortfolioTransaction> fiatTransactions = new ArrayList<>();

		List<PortfolioTransaction> coinTransactions = new ArrayList<>();

		fiatTransactions = portfolioTransactionRepository.findByPortfolioAndType("fiat2binance", portfolioId);

		coinTransactions = portfolioTransactionRepository.findByPortfolioAndType("cointransaction", portfolioId);

		total2Binance = 0;
		tendies = 0;
		totalInvestment = 0;

		fiatTransactions.forEach(transaction -> {
			total2Binance += transaction.getCoinAmount();
		});

		Map<Object, List<PortfolioTransaction>> transactionsGroupedBySymbol = coinTransactions.stream()
				.collect(Collectors.groupingBy(w -> w.getSymbol()));

		RestTemplate restTemplate = new RestTemplate();

		JSONArray arrayInvest = new JSONArray();
		JSONArray arrayAux = new JSONArray();

		transactionsGroupedBySymbol.entrySet().forEach(entry -> {
			symbolInvestment = 0;
			symbolCount = 0;
			symbolAvgPrice = 0;
			symbolCurrentPrice = 0;
			whereLambo = 0;
			dcaInvest = 0;

			entry.getValue().forEach(transaction -> {
				symbolCount += transaction.getCoinAmount();
				symbolInvestment += transaction.getCoinAmount() * transaction.getBuyPrice();
			});

			try {
				String result = restTemplate.getForObject(
						"https://api.binance.com/api/v3/ticker/price?symbol={symbol}USDT", String.class,
						entry.getKey().toString());
				JSONParser parser = new JSONParser(result);
				LinkedHashMap<String, Object> json = parser.object();
				if (!json.containsKey("price"))
					return;
				symbolCurrentPrice = Float.parseFloat(json.get("price").toString());

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			} catch (HttpClientErrorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}

			symbolAvgPrice = symbolInvestment / symbolCount;
			whereLambo = symbolCurrentPrice * symbolCount - symbolInvestment;
			dcaInvest = (symbolCurrentPrice - symbolAvgPrice) / symbolAvgPrice * 100;
			totalInvestment += symbolInvestment;
			tendies += whereLambo;

			JSONObject item = new JSONObject();
			JSONObject itemInvest = new JSONObject();
			item.put("symbol", entry.getKey().toString());
			item.put("symbolInvestment", symbolInvestment);
			item.put("symbolCount", symbolCount);
			item.put("symbolAvgPrice", symbolAvgPrice);
			item.put("symbolCurrentPrice", symbolCurrentPrice);
			item.put("whereLambo", whereLambo);
			item.put("dcaInvest", dcaInvest);
			itemInvest.put("symbol", entry.getKey().toString());
			itemInvest.put("symbolInvestment", symbolInvestment);
			arrayAux.add(item);
			arrayInvest.add(itemInvest);

		});

		JSONObject json = new JSONObject();
		json.put("symbols", arrayAux);
		json.put("total2binance", total2Binance);
		json.put("tendies", tendies);
		json.put("totalInvestment", totalInvestment);
		json.put("investmentChart", arrayInvest);

		return json;
	}
}
