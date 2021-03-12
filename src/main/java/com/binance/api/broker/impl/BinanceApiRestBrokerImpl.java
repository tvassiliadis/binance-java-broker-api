package com.binance.api.broker.impl;

import static com.binance.api.broker.impl.BinanceApiBrokerServiceGenerator.createService;
import static com.binance.api.broker.impl.BinanceApiBrokerServiceGenerator.executeSync;

import java.util.List;

import com.binance.api.broker.BinanceApiRestBroker;
import com.binance.api.broker.domain.subaccount.SubAccountApiKey;
import com.binance.api.broker.domain.subaccount.SubAccountResult;
import com.binance.api.broker.domain.subaccount.SummaryResult;
import com.binance.api.broker.domain.subaccount.TransferResult;
import com.binance.api.broker.domain.subaccount.BuildRebateResult;
import com.binance.api.broker.domain.subaccount.DepositHistory;
import com.binance.api.broker.domain.subaccount.FuturesResult;
import com.binance.api.broker.domain.subaccount.InfoResult;
import com.binance.api.broker.domain.subaccount.MarginResult;
import com.binance.api.broker.domain.subaccount.RebateHistoryResult;
import com.binance.api.broker.domain.subaccount.RebateResult;
import com.binance.api.broker.domain.subaccount.SubAccount;

public class BinanceApiRestBrokerImpl implements BinanceApiRestBroker {

	private final BinanceApiBrokerService binanceApiService;

	public BinanceApiRestBrokerImpl(String apiKey, String secret) {
		binanceApiService = createService(BinanceApiBrokerService.class, apiKey, secret);
	}

	@Override
	public SubAccountResult newSubAccount(Long recvWindow, Long timestamp) {
		return executeSync(binanceApiService.newSubAccount(recvWindow, timestamp));
	}

	@Override
	public MarginResult enableMargin(String subAccountId, Long recvWindow, Long timestamp) {
		return executeSync(binanceApiService.enableMargin(subAccountId, true, recvWindow, timestamp));
	}

	@Override
	public FuturesResult enableFutures(String subAccountId, Long recvWindow, Long timestamp) {
		return executeSync(binanceApiService.enableFutures(subAccountId, true, recvWindow, timestamp));
	}

	@Override
	public SubAccountApiKey newApiKey(String subAccountId, Boolean canTrade, Boolean marginTrade, Boolean futuresTrade,
			Long recvWindow, Long timestamp) {
		return executeSync(
				binanceApiService.newApiKey(subAccountId, canTrade, marginTrade, futuresTrade, recvWindow, timestamp));
	}

	@Override
	public void deleteApiKey(String subAccountId, String subAccountApiKey, Long recvWindow, Long timestamp) {
		executeSync(binanceApiService.deleteApiKey(subAccountId, subAccountApiKey, recvWindow, timestamp));
	}

	@Override
	public List<SubAccountApiKey> getAllApiKeys(String subAccountId, String subAccountApiKey, Long recvWindow,
			Long timestamp) {
		return executeSync(binanceApiService.getAllApiKeys(subAccountId, subAccountApiKey, recvWindow, timestamp));
	}

	@Override
	public List<SubAccount> getAllSubAccounts(String subAccountId, Long page, Long size, Long recvWindow,
			Long timestamp) {
		return executeSync(binanceApiService.getAllSubAccounts(subAccountId, page, size, recvWindow, timestamp));
	}

	@Override
	public void deleteSubAccount(String subAccountId, Long recvWindow, Long timestamp) {
		executeSync(binanceApiService.deleteSubAccount(subAccountId, recvWindow, timestamp));
	}

	@Override
	public InfoResult getInfo(Long recvWindow, Long timestamp) {
		return executeSync(binanceApiService.getInfo(recvWindow, timestamp));
	}

	@Override
	public List<DepositHistory> getAllDepositHistory(String subAccountId, String coin, Integer status, Long startTime,
			Long endTime, Integer limit, Integer offest, Long recvWindow, Long timestamp) {
		return executeSync(binanceApiService.getAllDepositHistory(subAccountId, coin, status, startTime, endTime, limit,
				offest, recvWindow, timestamp));
	}

	@Override
	public TransferResult transfer(String fromId, String toId, String clientTranId, String asset, Double amount,
			Long recvWindow, Long timestamp) {
		return executeSync(
				binanceApiService.transfer(fromId, toId, clientTranId, asset, amount, recvWindow, timestamp));
	}
	
	@Override
	public List<SummaryResult> getSpotSummary(String subAccountId, Long page, Long size, Long recvWindow, Long timestamp) {
		return executeSync(
				binanceApiService.getSpotSummary(subAccountId, page, size, recvWindow, timestamp));
	}

	@Override
	public BuildRebateResult buildRebateHistory(String subAccountId, Long startTime, Long endTime, Integer limit,
			Long recvWindow, Long timestamp) {
		return executeSync(
				binanceApiService.buildRebateHistory(subAccountId, startTime, endTime, limit, recvWindow, timestamp));
	}

	@Override
	public RebateResult getRebateHistoryLink(String subAccountId, Long startTime, Long endTime, Integer limit,
			Long recvWindow, Long timestamp) {
		return executeSync(
				binanceApiService.getRebateHistoryLink(subAccountId, startTime, endTime, limit, recvWindow, timestamp));
	}

	@Override
	public List<RebateHistoryResult> getRecentRebateHistory(String subAccountId, Long startTime, Long endTime, Long page, Long size,
			Long recvWindow, Long timestamp) {
		return executeSync(
				binanceApiService.getRecentRebateHistory(subAccountId, startTime, endTime, page, size, recvWindow, timestamp));
	}



}
