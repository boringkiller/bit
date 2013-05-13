package com.bit.bitb.biz.service;

import com.bit.bitb.biz.entity.Deal;

/**
 * 负责处理交易费用问题
 * @author jimmy.du
 * May 13, 2013
 */
public interface DealCostService {
	
	/**
	 * 收取交易手续费，将会调用calcDealCost方法
	 * @param donedealAC
	 * @return
	 */
	public boolean receiveDealCost(Deal donedealAC);
	
	/**
	 * 根据交易意向计算交易收费，比特币。
	 * @param donedeal
	 * @return
	 */
	public float calcDealCostInBtc(Deal donedeal);
	
	/**
	 * 根据交易意向计算交易收费，现金。
	 * @param donedeal
	 * @return
	 */
	public float calcDealCostInMoney(Deal donedeal);
}
