package com.bit.bitb.biz.service.impl;

import com.bit.bitb.biz.enums.UserCapacityEnum;
import com.bit.bitb.biz.models.BalanceModel;
import com.bit.bitb.biz.service.BalanceService;
import com.bit.bitb.biz.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private BalanceService balanceService;
	@Override
	public boolean place(String userId,double price, double quantity,
			UserCapacityEnum userCapacity) {
		// TODO 入参校验
		BalanceModel b=balanceService.findBalanceByUserId(userId);
		if (userCapacity==UserCapacityEnum.buyer) {
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
