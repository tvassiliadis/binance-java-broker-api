package com.binance.api.broker.domain.subaccount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Dummy type to wrap a listen key from a server response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RebateResult {
	private String link;

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "RebateResult [link=" + link + "]";
	}

}
