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
	 * 鍖归厤
	 * <pre>
	 * 1.浠庝拱瀹跺尮閰嶈〃涓嬁鍒板嚭浠锋渶楂�order by gmt_create,id
	 * 2.浠庡崠瀹跺尮閰嶈〃涓嬁鍒板嚭浠锋渶浣�order by gmt_create desc,id desc
	 * 3.鍖归厤鎴愬姛鍗虫垚浜�
	 * 
	 * 涔�39
	 * 鍗�30鍗�	 * 
	 * 鍏堝紑1涓洏鍙�
	 * 
	 * 姣�绉掑惎鍔ㄤ竴娆″尮閰�
	 * 
	 * 寮�涓洏鍙ｏ紝F5鍧囪　
	 * 
	 * 
	 * @return
	 */
	public boolean match();

	/**
	 * 涔�
	 * <pre>
	 * 涓嬪崟
	 * 绯荤粺璁板綍涓嬪崟
	 * 鎺ㄩ�鍗曞瓙鍒颁拱鍖归厤搴�
	 * 
	 * @param userId
	 * @param price
	 * @param bitCoinAmount
	 * @return
	 */
	public boolean buy(String userId,String price,double bitCoinAmount);
	
	/**
	 * 鍗�
	 * <pre>
	 * 涓嬪崟
	 * 绯荤粺璁板綍涓嬪崟
	 * 鎺ㄩ�鍗曞瓙鍒板崠鍖归厤搴�
	 * 
	 * @param userId
	 * @param price
	 * @param bitCoinAmount
	 * @return
	 */
	public boolean sell(String userId,String price,double bitCoinAmount);
	
}
