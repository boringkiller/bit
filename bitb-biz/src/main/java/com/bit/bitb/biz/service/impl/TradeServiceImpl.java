package com.bit.bitb.biz.service.impl;

import com.bit.bitb.biz.service.TradeService;

public class TradeServiceImpl implements TradeService {
	@Override
	public void buy(String rmb, String bitb) {
		System.out.println("buy rmb:" + rmb + ",bitb:" + bitb);
	}

	@Override
	public void sell(String rmb, String bitb) {
		System.out.println("sell rmb:" + rmb + ",bitb:" + bitb);
	}

}
