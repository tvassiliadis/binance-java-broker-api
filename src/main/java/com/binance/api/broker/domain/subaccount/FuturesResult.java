package com.binance.api.broker.domain.subaccount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Dummy type to wrap a listen key from a server response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FuturesResult {
	private String subaccountId;
	private Boolean enableFutures;
	private Long updateTime;

	public String getSubaccountId() {
		return subaccountId;
	}

	public void setSubaccountId(String subaccountId) {
		this.subaccountId = subaccountId;
	}

	public Boolean isFuturesEnabled() {
		return enableFutures;
	}

	public void setEnableFutures(Boolean enableFutures) {
		this.enableFutures = enableFutures;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "FutureResult [subaccountId=" + subaccountId + ", enableFutures=" + enableFutures + ", updateTime="
				+ updateTime + "]";
	}

}
