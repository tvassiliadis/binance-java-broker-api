package com.binance.api.broker.impl;

import java.util.List;

import com.binance.api.broker.constant.BinanceApiBrokerConstants;
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

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Binance's REST API URL mappings and endpoint security configuration.
 */
public interface BinanceApiBrokerService {

	// Sub Account endpoints

	@Headers(BinanceApiBrokerConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@POST("/sapi/v1/broker/subAccount")
	Call<SubAccountResult> newSubAccount(@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

	@Headers(BinanceApiBrokerConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@POST("/sapi/v1/broker/subAccount/margin")
	Call<MarginResult> enableMargin(@Query("subAccountId") String subAccountId, @Query("margin") Boolean margin,
			@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

	@Headers(BinanceApiBrokerConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@POST("/sapi/v1/broker/subAccount/futures")
	Call<FuturesResult> enableFutures(@Query("subAccountId") String subAccountId, @Query("futures") Boolean margin,
			@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

	@Headers(BinanceApiBrokerConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@POST("/sapi/v1/broker/subAccountApi")
	Call<SubAccountApiKey> newApiKey(@Query("subAccountId") String subAccountId, @Query("canTrade") Boolean canTrade,
			@Query("marginTrade") Boolean marginTrade, @Query("futuresTrade") Boolean futuresTrade,
			@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

	@Headers(BinanceApiBrokerConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@DELETE("/sapi/v1/broker/subAccountApi")
	Call<Void> deleteApiKey(@Query("subAccountId") String subAccountId,
			@Query("subAccountApiKey") String subAccountApiKey, @Query("recvWindow") Long recvWindow,
			@Query("timestamp") Long timestamp);

	@Headers(BinanceApiBrokerConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@GET("/sapi/v1/broker/subAccountApi")
	Call<List<SubAccountApiKey>> getAllApiKeys(@Query("subAccountId") String subAccountId,
			@Query("subAccountApiKey") String subAccountApiKey, @Query("recvWindow") Long recvWindow,
			@Query("timestamp") Long timestamp);

	@Headers(BinanceApiBrokerConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@GET("/sapi/v1/broker/subAccount")
	Call<List<SubAccount>> getAllSubAccounts(@Query("subAccountId") String subAccountId, @Query("page") Long page,
			@Query("size") Long size, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

	@Headers(BinanceApiBrokerConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@DELETE("/sapi/v1/broker/subAccount")
	Call<Void> deleteSubAccount(@Query("subAccountId") String subAccountId, @Query("recvWindow") Long recvWindow,
			@Query("timestamp") Long timestamp);

	@Headers(BinanceApiBrokerConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@GET("/sapi/v1/broker/info")
	Call<InfoResult> getInfo(@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

	@Headers(BinanceApiBrokerConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@GET("/sapi/v1/broker/subAccount/depositHist")
	Call<List<DepositHistory>> getAllDepositHistory(@Query("subAccountId") String subAccountId,
			@Query("coin") String coin, @Query("status") Integer status, @Query("startTime") Long startTime,
			@Query("endTime") Long endTime, @Query("limit") Integer limit, @Query("offest") Integer offest,
			@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

	@Headers(BinanceApiBrokerConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@POST("/sapi/v1/broker/transfer")
	Call<TransferResult> transfer(@Query("fromId") String fromId, @Query("toId") String toId,
			@Query("clientTranId") String clientTranId, @Query("asset") String asset, @Query("amount") Double amount,
			@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

	@Headers(BinanceApiBrokerConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@GET("/sapi/v1/broker/subAccount/spotSummary")
	Call<List<SummaryResult>> getSpotSummary(@Query("subAccountId") String subAccountId, @Query("page") Long page,
			@Query("size") Long size, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

	@Headers(BinanceApiBrokerConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@POST("/sapi/v1/broker/rebate/historicalRecord")
	Call<BuildRebateResult> buildRebateHistory(@Query("subAccountId") String subAccountId,
			@Query("startTime") Long startTime, @Query("endTime") Long endTime, @Query("limit") Integer limit,
			@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

	@Headers(BinanceApiBrokerConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@GET("/sapi/v1/broker/rebate/historicalRecord")
	Call<RebateResult> getRebateHistoryLink(@Query("subAccountId") String subAccountId,
			@Query("startTime") Long startTime, @Query("endTime") Long endTime, @Query("limit") Integer limit,
			@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

	@Headers(BinanceApiBrokerConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@GET("/sapi/v1/broker/rebate/recentRecord")
	Call<List<RebateHistoryResult>> getRecentRebateHistory(@Query("subAccountId") String subAccountId,
			@Query("startTime") Long startTime, @Query("endTime") Long endTime, @Query("page") Long page,
			@Query("size") Long size, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);
}
