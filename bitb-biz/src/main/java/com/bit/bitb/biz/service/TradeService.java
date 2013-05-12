package com.bit.bitb.biz.service;

import com.bit.bitb.biz.entity.Buying;
import com.bit.bitb.biz.entity.Deal;
import com.bit.bitb.biz.entity.Selling;

public interface TradeService {

	public boolean buy(Buying buying);

	public boolean sell(Selling selling);
	
	public boolean finishDeal(Deal donedeal);
	
	public float calcDealCost(Deal donedeal);

	public void removeExpiredOffer();

	public boolean receiveDealCost(Deal donedealAC);
	
	public boolean freezeBtcWhenSell(Selling selling);

	public boolean freezeMoneyWhenBuy(Buying buying);

	public boolean unfreezeWhenCancel(Selling selling);

	public boolean unfreezeWhenCancel(Buying buying);

	

	/**
	 * 匹配
	 * 
	 * <pre>
	 * 1.从买家匹配表中拿到出价最高,order by gmt_create,id
	 * 2.从卖家匹配表中拿到出价最低,order by gmt_create desc,id desc
	 * 3.匹配成功即成交.
	 * 
	 * 买739
	 * 卖730卖
	 * 
	 * 先开1个盘口.
	 * 
	 * 每5秒启动一次匹配.
	 * 
	 * 开2个盘口，F5均衡
	 * 
	 * 
	 * @return
	 */
	public boolean match();

	/**
	 * 买.
	 * 
	 * <pre>
	 * 下单
	 * 系统记录下单
	 * 推送单子到买匹配库;
	 * 
	 * @param userId
	 * @param price
	 * @param quantity
	 * @param tradePwd MD5加密.
	 * @return
	 */
	public boolean buy(String userId, double price, double quantity,
			String tradePwd);

	/**
	 * 卖.
	 * 
	 * <pre>
	 * 下单
	 * 系统记录下单
	 * 推送单子到卖匹配库;
	 * @param userId
	 * @param price
	 * @param quantity
	 * @param tradePwd
	 * @return
	 */
	public boolean sell(String userId, double price, double quantity,
			String tradePwd);
	
}
