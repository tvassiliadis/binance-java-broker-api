package com.binance.api.broker.domain.subaccount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Dummy type to wrap a listen key from a server response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RebateHistoryResult {
	private String subaccountId;
	private String income;
	private String asset;
	private String symbol;
	private Long tradeId;
	private Long time;

	public String getSubaccountId() {
		return subaccountId;
	}

	public void setSubaccountId(String subaccountId) {
		this.subaccountId = subaccountId;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Long getTradeId() {
		return tradeId;
	}

	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "RebateHistoryResult [subaccountId=" + subaccountId + ", income=" + income + ", asset=" + asset
				+ ", symbol=" + symbol + ", tradeId=" + tradeId + ", time=" + time + "]";
	}
}
