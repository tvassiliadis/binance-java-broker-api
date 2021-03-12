package com.binance.api.broker.domain.subaccount;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Dummy type to wrap a listen key from a server response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SummaryResult {
	private AssetInfo[] data;
	private Long timestamp;

	public AssetInfo[] getData() {
		return data;
	}

	public void setData(AssetInfo[] data) {
		this.data = data;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "SummaryResult [data=" + Arrays.toString(data) + ", timestamp=" + timestamp + "]";
	}

}
