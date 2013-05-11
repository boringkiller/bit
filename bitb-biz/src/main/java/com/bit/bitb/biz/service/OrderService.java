package com.bit.bitb.biz.service;

import com.bit.bitb.biz.enums.PlaceTypeEnum;

public interface OrderService {
	/**
	 * 下单
	 * 
	 * @param userId
	 * @param price
	 * @param bitCoinAmount
	 * @param placeType
	 * @return
	 */
	public boolean place(String userId, String price, double bitCoinAmount,
			PlaceTypeEnum placeType);

	/**
	 * 撤单.
	 * 
	 * @param orderId
	 * @return
	 */
	public boolean cancel(long orderId);
}
