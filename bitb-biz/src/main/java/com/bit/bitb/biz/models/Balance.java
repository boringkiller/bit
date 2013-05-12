package com.bit.bitb.biz.models;

/**
 * 账户.
 * 
 * @author simple56
 * 
 */
public  class Balance {
	private String userId;
	/**
	 * 可用比特币
	 */
	private String usableBitCoinAmount;
	/**
	 * 冻结比特币
	 */
	private String frozenBitCoinAmount;
	/**
	 * 可用人民币
	 */
	private String usableMoney;
	/**
	 * 冻结人民币
	 */
	private String frozenMoney;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsableBitCoinAmount() {
		return usableBitCoinAmount;
	}

	public void setUsableBitCoinAmount(String usableBitCoinAmount) {
		this.usableBitCoinAmount = usableBitCoinAmount;
	}

	public String getFrozenBitCoinAmount() {
		return frozenBitCoinAmount;
	}

	public void setFrozenBitCoinAmount(String frozenBitCoinAmount) {
		this.frozenBitCoinAmount = frozenBitCoinAmount;
	}

	public String getUsableMoney() {
		return usableMoney;
	}

	public void setUsableMoney(String usableMoney) {
		this.usableMoney = usableMoney;
	}

	public String getFrozenMoney() {
		return frozenMoney;
	}

	public void setFrozenMoney(String frozenMoney) {
		this.frozenMoney = frozenMoney;
	}


}
