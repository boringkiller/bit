package com.bit.bitb.biz.service.impl;

import com.bit.bitb.biz.service.MoneyService;
import com.bit.bitb.biz.service.PublicAccountService;

public class PublicAccountServiceImpl implements PublicAccountService {
	
	private MoneyService moneyService;

	@Override
	public boolean addMoneyToPubAccount(double money) {
		return false;
	}

	@Override
	public boolean addBtcToPubAccount(double btc) {
		return false;
	}

	public MoneyService getMoneyService() {
		return moneyService;
	}

	public void setMoneyService(MoneyService moneyService) {
		this.moneyService = moneyService;
	}

}
