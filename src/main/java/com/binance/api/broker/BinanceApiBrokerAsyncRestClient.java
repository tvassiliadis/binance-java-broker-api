package com.binance.api.broker;

import com.binance.api.broker.domain.subaccount.SubAccountApiKey;
import com.binance.api.broker.domain.subaccount.FuturesResult;
import com.binance.api.broker.domain.subaccount.MarginResult;
import com.binance.api.broker.domain.subaccount.SubAccount;

import java.util.List;

/**
 * Binance API facade, supporting asynchronous/non-blocking access Binance's
 * REST API.
 */
public interface BinanceApiBrokerAsyncRestClient {

	// General endpoints

	/**
	 * Create a Sub Account
	 */
	void newSubAccount(Long recvWindow, Long timestamp, BinanceApiBrokerCallback<String> callback);

	/**
	 * Enable Margin for Sub Account
	 */
	void enableMargin(String subAccountId, Long recvWindow, Long timestamp, BinanceApiBrokerCallback<MarginResult> callback);

	/**
	 * Enable Futures for Sub Account
	 */
	void enableFutures(String subAccountId, Long recvWindow, Long timestamp, BinanceApiBrokerCallback<FuturesResult> callback);
	
	// TODO: implement other functions

}