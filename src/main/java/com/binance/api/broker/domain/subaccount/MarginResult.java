package com.binance.api.broker.domain.subaccount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Dummy type to wrap a listen key from a server response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginResult {
	private String subaccountId;
	private Boolean enableMargin;
	private Long updateTime;
	
	public String getSubaccountId() {
		return subaccountId;
	}
	
	public void setSubaccountId(String subaccountId) {
		this.subaccountId = subaccountId;
	}
	
	public Boolean isMarginEnabled() {
		return enableMargin;
	}
	
	public void setEnableMargin(Boolean enableMargin) {
		this.enableMargin = enableMargin;
	}
	
	public Long getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}
	
	@Override
	public String toString() {
		return "MarginResult [subaccountId=" + subaccountId + ", enableFutures=" + enableMargin + ", updateTime="
				+ updateTime + "]";
	}
	
	
}
