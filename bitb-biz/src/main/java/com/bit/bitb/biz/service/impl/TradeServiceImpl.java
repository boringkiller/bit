package com.bit.bitb.biz.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bit.bitb.biz.entity.Buying;
import com.bit.bitb.biz.entity.Deal;
import com.bit.bitb.biz.entity.Selling;
import com.bit.bitb.biz.entity.User;
import com.bit.bitb.biz.service.TradeService;

public class TradeServiceImpl implements TradeService {
	private static final Logger logger = LoggerFactory
			.getLogger(TradeService.class);

	@Override
	public boolean buy(Buying buying) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sell(Selling selling) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean finishDeal(Deal donedeal) {
		// TODO Auto-generated method stub
		return false;
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

	@Override
	public float calcDealCost(Deal donedeal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeExpiredOffer() {
		// TODO Auto-generated method stub

	}

	@Override
	public Deal match(Buying buying) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Deal match(Selling selling) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doSMSverification(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
