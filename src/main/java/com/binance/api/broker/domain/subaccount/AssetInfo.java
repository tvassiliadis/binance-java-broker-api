package com.binance.api.broker.domain.subaccount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Dummy type to wrap a listen key from a server response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetInfo {
	private String subAccountId;
	private Long totalBalanceOfBtc;

	public String getSubAccountId() {
		return subAccountId;
	}

	public void setSubAccountId(String subAccountId) {
		this.subAccountId = subAccountId;
	}

	public Long getTotalBalanceOfBtc() {
		return totalBalanceOfBtc;
	}

	public void setTotalBalanceOfBtc(Long totalBalanceOfBtc) {
		this.totalBalanceOfBtc = totalBalanceOfBtc;
	}

	@Override
	public String toString() {
		return "AssetInfo [subAccountId=" + subAccountId + ", totalBalanceOfBtc=" + totalBalanceOfBtc + "]";
	}
}
