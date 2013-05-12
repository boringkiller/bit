package com.bit.bitb.biz.service.impl;

import com.bit.bitb.biz.enums.UserCapacityEnum;
import com.bit.bitb.biz.models.BalanceModel;
import com.bit.bitb.biz.service.BalanceService;
import com.bit.bitb.biz.service.OrderService;
import com.bit.bitb.biz.util.MathUtils;

public class OrderServiceImpl implements OrderService {
	private BalanceService balanceService;
	@Override
	public boolean place(String userId,double price, double quantity,
			UserCapacityEnum userCapacity) {
		// TODO 入参校验
		//TODO 校验可用人民币>0,==改在设置完价格和数量时校验，可用人民币大于price*quantity
		
		double totalRmb=MathUtils.multWithAccurated(price, quantity);
		
		BalanceModel b=balanceService.findBalanceByUserId(userId);
		if (userCapacity==UserCapacityEnum.buyer) {
			b.setUsableMoney(MathUtils.sub(b.getUsableMoney(), totalRmb));
		}
		return true;
	}

	@Override
	public boolean cancel(long orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean close(long orderId) {
		// TODO Auto-generated method stub
		return false;
	}

}
