package com.bit.bitb.biz.service;

import com.bit.bitb.biz.entity.Buying;
import com.bit.bitb.biz.entity.Deal;
import com.bit.bitb.biz.entity.Selling;

public interface TradeService {

	/**
	 * 下单购买
	 * @param buying
	 * @return
	 */
	public boolean buy(Buying buying);

	/**
	 * 下单出售
	 * @param selling
	 * @return
	 */
	public boolean sell(Selling selling);
	
	/**
	 * 根据购买订单寻找合适的卖家，达成交易意向
	 * @param buying
	 * @return
	 */
	public Deal match(Buying buying);
	
	/**
	 * 根据出售订单寻找合适的买家，达成交易意向
	 * @param selling
	 * @return
	 */
	public Deal match(Selling selling);
	
	/**
	 * 完成交易
	 * @param donedeal
	 * @return
	 */
	public boolean finishDeal(Deal donedeal);
	
	/**
	 * 根据交易意向计算交易收费
	 * @param donedeal
	 * @return
	 */
	public float calcDealCost(Deal donedeal);

	/**
	 * 定期移除过期的订单
	 */
	public void removeExpiredOffer();

	/**
	 * 收取交易手续费，将会调用calcDealCost方法
	 * @param donedealAC
	 * @return
	 */
	public boolean receiveDealCost(Deal donedealAC);
	
}
