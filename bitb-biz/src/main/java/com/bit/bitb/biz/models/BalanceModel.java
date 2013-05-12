package com.bit.bitb.biz.models;

/**
 * 账户.
 * 
 * @author simple56
 * 
 */
public class BalanceModel {
	private String userId;
	/**
	 * 可用比特币
	 */
	private Double usableBitCoinAmount;
	/**
	 * 冻结比特币
	 */
	private Double frozenBitCoinAmount;
	/**
	 * 可用人民币
	 */
	private Double usableMoney;
	/**
	 * 冻结人民币
	 */
	private Double frozenMoney;
	/**
	 * 交易密码.
	 */
	private String tradePwd;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Double getUsableBitCoinAmount() {
		return usableBitCoinAmount;
	}

	public void setUsableBitCoinAmount(Double usableBitCoinAmount) {
		this.usableBitCoinAmount = usableBitCoinAmount;
	}

	public Double getFrozenBitCoinAmount() {
		return frozenBitCoinAmount;
	}

	public void setFrozenBitCoinAmount(Double frozenBitCoinAmount) {
		this.frozenBitCoinAmount = frozenBitCoinAmount;
	}

	public Double getUsableMoney() {
		return usableMoney;
	}

	public void setUsableMoney(Double usableMoney) {
		this.usableMoney = usableMoney;
	}

	public Double getFrozenMoney() {
		return frozenMoney;
	}

	public void setFrozenMoney(Double frozenMoney) {
		this.frozenMoney = frozenMoney;
	}

	public String getTradePwd() {
		return tradePwd;
	}

	public void setTradePwd(String tradePwd) {
		this.tradePwd = tradePwd;
	}

}
