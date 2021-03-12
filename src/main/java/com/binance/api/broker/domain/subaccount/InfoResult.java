package com.binance.api.broker.domain.subaccount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Dummy type to wrap a listen key from a server response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoResult {
	private Float maxMakerCommission;
	private Float minMakerCommission;
	private Float maxTakerCommission;
	private Float minTakerCommission;
	private Float subAccountQty;
	private Float maxSubAccountQty;

	public Float getMaxMakerCommission() {
		return maxMakerCommission;
	}

	public void setMaxMakerCommission(Float maxMakerCommission) {
		this.maxMakerCommission = maxMakerCommission;
	}

	public Float getMinMakerCommission() {
		return minMakerCommission;
	}

	public void setMinMakerCommission(Float minMakerCommission) {
		this.minMakerCommission = minMakerCommission;
	}

	public Float getMaxTakerCommission() {
		return maxTakerCommission;
	}

	public void setMaxTakerCommission(Float maxTakerCommission) {
		this.maxTakerCommission = maxTakerCommission;
	}

	public Float getMinTakerCommission() {
		return minTakerCommission;
	}

	public void setMinTakerCommission(Float minTakerCommission) {
		this.minTakerCommission = minTakerCommission;
	}

	public Float getSubAccountQty() {
		return subAccountQty;
	}

	public void setSubAccountQty(Float subAccountQty) {
		this.subAccountQty = subAccountQty;
	}

	public Float getMaxSubAccountQty() {
		return maxSubAccountQty;
	}

	public void setMaxSubAccountQty(Float maxSubAccountQty) {
		this.maxSubAccountQty = maxSubAccountQty;
	}

	@Override
	public String toString() {
		return "InfoResult [maxMakerCommission=" + maxMakerCommission + ", minMakerCommission=" + minMakerCommission
				+ ", maxTakerCommission=" + maxTakerCommission + ", minTakerCommission=" + minTakerCommission
				+ ", subAccountQty=" + subAccountQty + ", maxSubAccountQty=" + maxSubAccountQty + "]";
	}
}
