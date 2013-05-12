package com.bit.bitb.biz.service;

import com.bit.bitb.biz.enums.UserCapacityEnum;

public interface OrderService {
	/**
	 * 下单.
	 * 
	 * <pre>
	 * 插一条订单记录
	 * 更新账户.
	 * 
	 * @param userId
	 * @param price
	 * @param quantity
	 * @param userCapacity
	 * @return
	 */
	public boolean place(String userId, double price, double quantity,
			UserCapacityEnum userCapacity);

	/**
	 * 撤单.
	 * 
	 * @param orderId
	 * @return
	 */
	public boolean cancel(long orderId);

	/**
	 * 完结订单.
	 * 
	 * @param orderId
	 * @return
	 */
	public boolean close(long orderId);
}
