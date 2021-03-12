package com.binance.api.broker.domain.subaccount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Dummy type to wrap a listen key from a server response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransferResult {
	private String txnId;
	private String clientTranId;

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public String getClientTranId() {
		return clientTranId;
	}

	public void setClientTranId(String clientTranId) {
		this.clientTranId = clientTranId;
	}

	@Override
	public String toString() {
		return "TransferResult [txnId=" + txnId + ", clientTranId=" + clientTranId + "]";
	}

}
