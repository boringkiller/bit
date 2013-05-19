package com.bit.bitb.biz.service.impl;

import com.bit.bitb.biz.entity.Buying;
import com.bit.bitb.biz.entity.Selling;
import com.bit.bitb.biz.entity.User;
import com.bit.bitb.biz.service.FreezeService;
import com.bit.bitb.biz.service.UserService;
import com.bit.bitb.biz.util.MathUtils;

public class FreezeServiceImpl implements FreezeService {

	
	private UserService userService;
	
	@Override
	public boolean freezeBtcWhenSell(Selling selling) {
		try {
			User user = userService.getUserById(selling.getSeller());
			Double btcBalance = MathUtils.sub(user.getBtcbalance(), selling.getQuantity()).doubleValue();
			if (btcBalance > 0) {
				user.setBtcbalance(btcBalance.toString());
				user.setBtcfreeze(selling.getQuantity());
				userService.updateUser(user);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean freezeMoneyWhenBuy(Buying buying) {
		try {
			Double totalAmount =  MathUtils.multWithAccurated(buying.getQuantity(), buying.getPrice());
			User user = userService.getUserById(buying.getBuyer());
			Double balance = MathUtils.sub(user.getMoneybalance(), totalAmount.toString()).doubleValue();
			if (balance > 0) {
				user.setMoneybalance(balance.toString());
				user.setMoneyfreeze(totalAmount.toString());
				userService.updateUser(user);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


}
