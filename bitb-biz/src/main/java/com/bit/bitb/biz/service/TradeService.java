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
}
