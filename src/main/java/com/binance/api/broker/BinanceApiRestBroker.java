package com.binance.api.broker;

import java.util.List;

import com.binance.api.broker.domain.subaccount.SubAccountApiKey;
import com.binance.api.broker.domain.subaccount.SubAccountResult;
import com.binance.api.broker.domain.subaccount.SummaryResult;
import com.binance.api.broker.domain.subaccount.TransferResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import com.binance.api.broker.constant.BinanceApiBrokerConstants;
import com.binance.api.broker.domain.subaccount.BuildRebateResult;
import com.binance.api.broker.domain.subaccount.DepositHistory;
import com.binance.api.broker.domain.subaccount.FuturesResult;
import com.binance.api.broker.domain.subaccount.InfoResult;
import com.binance.api.broker.domain.subaccount.MarginResult;
import com.binance.api.broker.domain.subaccount.RebateHistoryResult;
import com.binance.api.broker.domain.subaccount.RebateResult;
import com.binance.api.broker.domain.subaccount.SubAccount;

public interface BinanceApiRestBroker {
	// Sub Account endpoints

	/*
	 * Create a Sub Account
	 * 
	 * This request will generate a sub account under your brokerage master account.
	 * You need to enable "trade" option for the api key which requests this
	 * endpoint.
	 * 
	 * @param recvWindow No mandatory. It is recommended to use a small recvWindow
	 * of 5000 or less. The max cannot go beyond 60,000!
	 * 
	 * @param timestamp The current timestamp in milliseconds
	 * 
	 * @return subaccountId
	 */
	SubAccountResult newSubAccount(Long recvWindow, Long timestamp);

	/*
	 * Enable Margin for Sub Account
	 * 
	 * @param subAccountId The sub account id to be margin enabled
	 * 
	 * @param recvWindow No mandatory. It is recommended to use a small recvWindow
	 * of 5000 or less. The max cannot go beyond 60,000!
	 * 
	 * @param timestamp The current timestamp in milliseconds
	 * 
	 * @return MarginResult
	 * 
	 */
	MarginResult enableMargin(String subAccountId, Long recvWindow, Long timestamp);

	/*
	 * Enable Futures for Sub Account
	 * 
	 * @param subAccountId The sub account id to be margin enabled
	 * 
	 * @param recvWindow No mandatory. It is recommended to use a small recvWindow
	 * of 5000 or less. The max cannot go beyond 60,000!
	 * 
	 * @param timestamp The current timestamp in milliseconds
	 * 
	 * @return FuturesResult
	 * 
	 */
	FuturesResult enableFutures(String subAccountId, Long recvWindow, Long timestamp);

	/*
	 * Create Api Key for Sub Account
	 * 
	 * @param subAccountId The sub account id to be margin enabled
	 * 
	 * @param canTrade Mandatory. Spot trade
	 * 
	 * @param marginTrade margin trade
	 * 
	 * @param futuresTrade futures trade
	 * 
	 * @param recvWindow No mandatory. It is recommended to use a small recvWindow
	 * of 5000 or less. The max cannot go beyond 60,000!
	 * 
	 * @param timestamp The current timestamp in milliseconds
	 * 
	 * @return ApiKeyResult
	 * 
	 */
	SubAccountApiKey newApiKey(String subAccountId, Boolean canTrade, Boolean marginTrade, Boolean futuresTrade,
			Long recvWindow, Long timestamp);

	/*
	 * Delete Api Key for Sub Account
	 * 
	 * @param subAccountId The sub account id to be margin enabled
	 * 
	 * @param subAccountApiKey the api/key created before
	 * 
	 * @param recvWindow No mandatory. It is recommended to use a small recvWindow
	 * of 5000 or less. The max cannot go beyond 60,000!
	 * 
	 * @param timestamp The current timestamp in milliseconds
	 * 
	 * @return Empty String
	 * 
	 */
	void deleteApiKey(String subAccountId, String subAccountApiKey, Long recvWindow, Long timestamp);

	/*
	 * Query Api Key for Sub Account
	 * 
	 * @param subAccountId The sub account id to be margin enabled
	 * 
	 * @param subAccountApiKey the api/key created before
	 * 
	 * @param recvWindow No mandatory. It is recommended to use a small recvWindow
	 * of 5000 or less. The max cannot go beyond 60,000!
	 * 
	 * @param timestamp The current timestamp in milliseconds
	 * 
	 * @return ApiKeyResult
	 * 
	 */
	List<SubAccountApiKey> getAllApiKeys(String subAccountId, String subAccountApiKey, Long recvWindow, Long timestamp);

	/*
	 * Query Sub Account
	 * 
	 * @param subAccountId optional filter by id
	 * 
	 * @param page default 1
	 * 
	 * @param size default 500
	 * 
	 * @param recvWindow No mandatory. It is recommended to use a small recvWindow
	 * of 5000 or less. The max cannot go beyond 60,000!
	 * 
	 * @param timestamp The current timestamp in milliseconds
	 * 
	 * @return List of SubAccount
	 * 
	 */
	List<SubAccount> getAllSubAccounts(String subAccountId, Long page, Long size, Long recvWindow, Long timestamp);

	void deleteSubAccount(String subAccountId, Long recvWindow, Long timestamp);

	InfoResult getInfo(Long recvWindow, Long timestamp);

	List<DepositHistory> getAllDepositHistory(String subAccountId, String coin, Integer status, Long startTime,
			Long endTime, Integer limit, Integer offest, Long recvWindow, Long timestamp);

	TransferResult transfer(String fromId, String toId, String clientTranId, String asset, Double amount,
			Long recvWindow, Long timestamp);

	List<SummaryResult> getSpotSummary(String subAccountId, Long page, Long size, Long recvWindow, Long timestamp);

	BuildRebateResult buildRebateHistory(String subAccountId, Long startTime, Long endTime, Integer limit,
			Long recvWindow, Long timestamp);

	RebateResult getRebateHistoryLink(String subAccountId, Long startTime, Long endTime, Integer limit,
			Long recvWindow, Long timestamp);

	List<RebateHistoryResult> getRecentRebateHistory(String subAccountId, Long startTime, Long endTime, Long page, Long size,
			Long recvWindow, Long timestamp);

}
