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
			user.setBtcbalance(MathUtils.sub(user.getBtcbalance(),selling.getQuantity()).toString());
			user.setBtcfreeze(selling.getQuantity());
			userService.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean freezeMoneyWhenBuy(Buying buying) {
		try {
			Double totalAmount =  MathUtils.multWithAccurated(buying.getQuantity(), buying.getPrice());
			User user = userService.getUserById(buying.getBuyer());
			user.setMoneybalance(MathUtils.sub(user.getMoneybalance(), totalAmount.toString()).toString());
			user.setMoneyfreeze(totalAmount.toString());
			userService.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
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
