package com.binance.api.broker.domain.subaccount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Dummy type to wrap a listen key from a server response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepositHistory {
	private String subaccountId;
	private String address;
	private String addressTag;
	private String amount;
	private String coin;
	private Long insertTime;
	private String network;
	private Integer status; // 0(0:pending,6: credited but cannot withdraw, 1:success)
	private String txId;
	private String sourceAddress;
	private String confirmTimes;

	public String getSubaccountId() {
		return subaccountId;
	}

	public void setSubaccountId(String subaccountId) {
		this.subaccountId = subaccountId;
	}

	public String getAddress() {
		return address;
	}
	
	public String getAddressTag() {
		return addressTag;
	}
	
	public void setAddressTag(String addressTag) {
		this.addressTag = addressTag;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCoin() {
		return coin;
	}

	public void setCoin(String coin) {
		this.coin = coin;
	}

	public Long getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Long insertTime) {
		this.insertTime = insertTime;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public String getSourceAddress() {
		return sourceAddress;
	}

	public void setSourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
	}

	public String getConfirmTimes() {
		return confirmTimes;
	}

	public void setConfirmTimes(String confirmTimes) {
		this.confirmTimes = confirmTimes;
	}

	@Override
	public String toString() {
		return "DepositHistory [subaccountId=" + subaccountId + ", address=" + address + ", addressTag-" + addressTag + ", amount=" + amount
				+ ", coin=" + coin + ", insertTime=" + insertTime + ", network=" + network + ", status=" + status
				+ ", txId=" + txId + ", sourceAddress=" + sourceAddress + ", confirmTimes=" + confirmTimes + "]";
	}

}
