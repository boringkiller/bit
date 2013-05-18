package com.bit.bitb.biz.service;

import com.bit.bitb.biz.entity.Deal;

/**
 * 负责处理交易费用问题
 * @author jimmy.du
 * May 13, 2013
 */
public interface DealCostService {
	
	/**
	 * 一手交钱一手交货，并且收取交易手续费，将会调用calcDealCost方法,收取费用存入公共账户
	 * @param donedealAC
	 * @return
	 */
	public boolean payAndReceiveDealCost(Deal deal);
	
	/**
	 * 根据交易意向计算交易收费，比特币。
	 * @param donedeal
	 * @return
	 */
	public double calcDealCostInBtc(Deal deal);
	
	/**
	 * 根据交易意向计算交易收费，现金。
	 * @param donedeal
	 * @return
	 */
	public double calcDealCostInMoney(Deal deal);
}
