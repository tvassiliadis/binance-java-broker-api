package com.binance.api.broker.domain.subaccount;

public class SubAccount {
	private String subaccountId;
	private Float makerCommission;
	private Float takerCommission;
	private Float marginMakerCommission;
	private Float marginTakerCommission;
	private Long createTime;
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubaccountId() {
		return subaccountId;
	}

	public void setSubaccountId(String subaccountId) {
		this.subaccountId = subaccountId;
	}

	public Float getMakerCommission() {
		return makerCommission;
	}

	public void setMakerCommission(Float makerCommission) {
		this.makerCommission = makerCommission;
	}

	public Float getTakerCommission() {
		return takerCommission;
	}

	public void setTakerCommission(Float takerCommission) {
		this.takerCommission = takerCommission;
	}

	public Float getMarginMakerCommission() {
		return marginMakerCommission;
	}

	public void setMarginMakerCommission(Float marginMakerCommission) {
		this.marginMakerCommission = marginMakerCommission;
	}

	public Float getMarginTakerCommission() {
		return marginTakerCommission;
	}

	public void setMarginTakerCommission(Float marginTakerCommission) {
		this.marginTakerCommission = marginTakerCommission;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SubAccount [subaccountId=" + subaccountId + ", makerCommission=" + makerCommission
				+ ", takerCommission=" + takerCommission + ", marginMakerCommission=" + marginMakerCommission
				+ ", marginTakerCommission=" + marginTakerCommission + ", createTime=" + createTime + "]";
	}

}
