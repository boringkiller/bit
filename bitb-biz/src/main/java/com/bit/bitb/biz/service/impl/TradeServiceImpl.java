package com.bit.bitb.biz.service.impl;

import com.bit.bitb.biz.entity.Buying;
import com.bit.bitb.biz.entity.Deal;
import com.bit.bitb.biz.entity.Selling;
import com.bit.bitb.biz.service.TradeService;

public class TradeServiceImpl implements TradeService {

	@Override
	public boolean buy(Buying buying) {
		return false;
	}

	@Override
	public boolean sell(Selling selling) {
		return false;
	}

	@Override
	public boolean finishDeal(Deal donedeal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeExpiredOffer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float calcDealCost(Deal donedeal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean receiveDealCost(Deal donedealAC) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean freezeBtcWhenSell(Selling selling) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean freezeMoneyWhenBuy(Buying buying) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unfreezeWhenCancel(Selling selling) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unfreezeWhenCancel(Buying buying) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
