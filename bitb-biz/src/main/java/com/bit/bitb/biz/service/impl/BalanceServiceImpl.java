package com.bit.bitb.biz.service.impl;

import com.bit.bitb.biz.dao.UserDao;
import com.bit.bitb.biz.entity.User;
import com.bit.bitb.biz.service.BalanceService;
import com.bit.bitb.biz.service.BitcoinService;
import com.bit.bitb.biz.service.MoneyService;
import com.bit.bitb.biz.util.MathUtils;

public class BalanceServiceImpl implements BalanceService {

	private MoneyService moneyService; //alipay api不知道怎么调用
	
	private BitcoinService bitcoinService;
	
	private UserDao userDao;
	
	@Override
	public boolean increaseMoneyBalance(User user, double num) {
		
		try {
			user.setMoneybalance(MathUtils.add(user.getMoneybalance(), String.valueOf(num)).toString());
			userDao.updateUser(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean reduceMoneyBalance(User user, double num) {
		try {
			user.setMoneybalance(MathUtils.sub(user.getMoneybalance(), String.valueOf(num)).toString());
			userDao.updateUser(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean increaseBtcBalance(User user, double num) {
		try {
			user.setBtcbalance(MathUtils.add(user.getBtcbalance(), String.valueOf(num)).toString());
			userDao.updateUser(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean reduceBtcBalance(User user, double num) {
		try {
			user.setBtcbalance(MathUtils.sub(user.getBtcbalance(), String.valueOf(num)).toString());
			userDao.updateUser(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean increaseMoneyReduceBtc(User user, double money, double btc) {
		try {
			increaseMoneyBalance(user, money);
			reduceBtcBalance(user, btc);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean increaseBtcReduceMoney(User user, double btc, double money) {
		try {
			increaseBtcBalance(user, btc);
			reduceMoneyBalance(user, money);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public MoneyService getMoneyService() {
		return moneyService;
	}

	public void setMoneyService(MoneyService moneyService) {
		this.moneyService = moneyService;
	}

	public BitcoinService getBitcoinService() {
		return bitcoinService;
	}

	public void setBitcoinService(BitcoinService bitcoinService) {
		this.bitcoinService = bitcoinService;
	}

}
