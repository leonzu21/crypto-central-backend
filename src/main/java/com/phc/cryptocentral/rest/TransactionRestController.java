package com.phc.cryptocentral.rest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phc.cryptocentral.dao.TransactionRepository;
import com.phc.cryptocentral.entity.Transaction;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/api/whales")
public class TransactionRestController {

	private float totalToWallet;
	private float totalFromWallet;
	private float totalSum;
	private float totalDifference;

	private TransactionRepository transactionRepository;

	@Autowired
	public TransactionRestController(TransactionRepository theTransactionRepository) {
		transactionRepository = theTransactionRepository;
	}

	@GetMapping(value = "/dailyChart")
	public JSONArray findDailyChartDataBySymbol(@RequestParam("theDate") String theDate,
			@RequestParam(name = "theSymbol", required = false) String theSymbol) {

		List<Transaction> theTransactions = new ArrayList<>();
		theTransactions = theSymbol != null ? transactionRepository.findDailyChartDataBySymbol(theDate, theSymbol)
				: transactionRepository.findDailyChartData(theDate);
		Map<Object, List<Transaction>> transactionsGroupedByHour = theTransactions.stream()
				.collect(Collectors.groupingBy(w -> w.getTimestamp().getHour()));

		JSONArray array = new JSONArray();
		transactionsGroupedByHour.entrySet().forEach(entry -> {
			totalToWallet = 0;
			totalFromWallet = 0;
			entry.getValue().forEach(transaction -> {
				if (transaction.getToOwner() == null) {
					totalToWallet += theSymbol != null ? transaction.getAmount() : transaction.getAmountUsd();
				} else {
					totalFromWallet += theSymbol != null ? transaction.getAmount() : transaction.getAmountUsd();
				}
			});

			totalSum = totalToWallet + totalFromWallet;
			totalDifference = totalToWallet - totalFromWallet;

			LocalDateTime dt = LocalDate.parse(theDate).atTime(Integer.parseInt(entry.getKey().toString()), 0);

			JSONObject json = new JSONObject();
			JSONObject item = new JSONObject();
			item.put("To Wallet", totalToWallet);
			item.put("From Wallet", totalFromWallet);
			item.put("Total", totalSum);
			item.put("Difference", totalDifference);
			item.put("Timestamp", dt);
			json.put("values", item);
			array.add(item);
		});

		return array;
	}

	@GetMapping(value = "/monthlyChart")
	public JSONArray findMonthlyChartDataBySymbol(@RequestParam("theDate") String theDate,
			@RequestParam(name = "theSymbol", required = false) String theSymbol) {

		List<Transaction> theTransactions = new ArrayList<>();
		theTransactions = theSymbol != null ? transactionRepository.findMonthlyChartDataBySymbol(theDate, theSymbol)
				: transactionRepository.findMonthlyChartData(theDate);

		Map<Object, List<Transaction>> transactionsGroupedByHour = theTransactions.stream()
				.collect(Collectors.groupingBy(w -> w.getTimestamp().getDayOfMonth()));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		JSONArray array = new JSONArray();
		transactionsGroupedByHour.entrySet().forEach(entry -> {
			totalToWallet = 0;
			totalFromWallet = 0;
			entry.getValue().forEach(transaction -> {
				if (transaction.getToOwner() == null) {
					totalToWallet += theSymbol != null ? transaction.getAmount() : transaction.getAmountUsd();
				} else {
					totalFromWallet += theSymbol != null ? transaction.getAmount() : transaction.getAmountUsd();
				}
			});

			totalSum = totalToWallet + totalFromWallet;
			totalDifference = totalToWallet - totalFromWallet;

			String day = entry.getKey().toString().length() == 1 ? "0" + entry.getKey().toString()
					: entry.getKey().toString();
			LocalDate dt = LocalDate.parse(theDate + "-" + day, formatter);

			JSONObject json = new JSONObject();
			JSONObject item = new JSONObject();
			item.put("To Wallet", totalToWallet);
			item.put("From Wallet", totalFromWallet);
			item.put("Total", totalSum);
			item.put("Difference", totalDifference);
			item.put("Timestamp", dt);
			json.put("values", item);
			array.add(item);
		});

		return array;
	}

	@GetMapping(value = "/yearlyChart")
	public JSONArray findYearlyChartDataBySymbol(@RequestParam("theDate") String theDate,
			@RequestParam(name = "theSymbol", required = false) String theSymbol) {

		List<Transaction> theTransactions = new ArrayList<>();
		theTransactions = theSymbol != null ? transactionRepository.findYearlyChartDataBySymbol(theDate, theSymbol)
				: transactionRepository.findYearlyChartData(theDate);

		Map<Object, List<Transaction>> transactionsGroupedByHour = theTransactions.stream()
				.collect(Collectors.groupingBy(w -> w.getTimestamp().getMonthValue()));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		JSONArray array = new JSONArray();
		transactionsGroupedByHour.entrySet().forEach(entry -> {
			totalToWallet = 0;
			totalFromWallet = 0;
			entry.getValue().forEach(transaction -> {
				if (transaction.getToOwner() == null) {
					totalToWallet += theSymbol != null ? transaction.getAmount() : transaction.getAmountUsd();
				} else {
					totalFromWallet += theSymbol != null ? transaction.getAmount() : transaction.getAmountUsd();
				}
			});

			totalSum = totalToWallet + totalFromWallet;
			totalDifference = totalToWallet - totalFromWallet;

			String month = entry.getKey().toString().length() == 1 ? "0" + entry.getKey().toString()
					: entry.getKey().toString();
			LocalDate dt = LocalDate.parse(theDate + "-" + month + "-01", formatter);

			JSONObject json = new JSONObject();
			JSONObject item = new JSONObject();
			item.put("To Wallet", totalToWallet);
			item.put("From Wallet", totalFromWallet);
			item.put("Total", totalSum);
			item.put("Difference", totalDifference);
			item.put("Timestamp", dt);
			json.put("values", item);
			array.add(item);
		});

		return array;
	}

}
