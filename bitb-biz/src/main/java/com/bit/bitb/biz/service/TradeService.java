package com.bit.bitb.biz.service;

import com.bit.bitb.biz.entity.Buying;
import com.bit.bitb.biz.entity.Deal;
import com.bit.bitb.biz.entity.Selling;
import com.bit.bitb.biz.entity.User;

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
	
	/**
	 * 卖家出售时，冻结他要出售的那部分比特币
	 * @param selling
	 * @return
	 */
	public boolean freezeBtcWhenSell(Selling selling);

	/**
	 * 买家买入时，冻结他出价的那部分资金
	 * @param buying
	 * @return
	 */
	public boolean freezeMoneyWhenBuy(Buying buying);

	/**
	 * 解冻，在出售订单取消的时候
	 * @param selling
	 * @return
	 */
	public boolean unfreezeWhenCancel(Selling selling);

	/**
	 * 解冻，在购买订单取消的时候
	 * @param buying
	 * @return
	 */
	public boolean unfreezeWhenCancel(Buying buying);

	
	/**
	 * 短信验证
	 * @return
	 */
	public boolean doSMSverification(User user);
}
