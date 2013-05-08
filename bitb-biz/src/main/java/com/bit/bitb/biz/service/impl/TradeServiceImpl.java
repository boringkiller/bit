package com.bit.bitb.biz.service.impl;

import com.bit.bitb.biz.entity.Buying;
import com.bit.bitb.biz.entity.Donedeal;
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
	public boolean finishDeal(Donedeal donedeal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeExpiredOffer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float calcDealCost(Donedeal donedeal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean receiveDealCost(Donedeal donedealAC) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
