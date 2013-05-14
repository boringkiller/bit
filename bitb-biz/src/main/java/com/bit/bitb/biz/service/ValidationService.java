package com.bit.bitb.biz.service;

import com.bit.bitb.biz.entity.Buying;
import com.bit.bitb.biz.entity.Selling;

public interface ValidationService {

	/**
	 * 审核购买订单
	 * @param buying
	 */
	public void validateBuying(Buying buying);
	
	/**
	 * 审核销售订单
	 * @param selling
	 */
	public void validateSelling(Selling selling);
}
