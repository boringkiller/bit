package com.bit.bitb.biz.service;

import com.bit.bitb.biz.entity.Buying;
import com.bit.bitb.biz.entity.Selling;

/**
 * 冻结相关的业务
 * @author jimmy.du
 * May 13, 2013
 */
public interface FreezeService {
	
	/**
	 * 卖家出售时，冻结他要出售的那部分比特币，移入btcfreeze字段
	 * @param selling
	 * @return
	 */
	public boolean freezeBtcWhenSell(Selling selling);

	/**
	 * 买家买入时，冻结他出价的那部分资金,移入moneyfreeze字段
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

}
