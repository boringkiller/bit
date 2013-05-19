package com.bit.bitb.biz.service.impl;

import com.bit.bitb.biz.entity.User;
import com.bit.bitb.biz.service.BalanceService;
import com.bit.bitb.biz.service.MoneyService;

public class MoneyServiceImpl implements MoneyService {

	private BalanceService balanceService;
	
	@Override
	public boolean withdrawDepositRequest(User user, double money) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean depositConfirmRequest(User user, double money) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean depositConfirm(User user, double money) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean withdrawDepositConfirmRequest(User user, double money) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean withdrawDepositConfirm(User user, double money) {
		// TODO Auto-generated method stub
		return false;
	}

}
