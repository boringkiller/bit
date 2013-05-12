package com.bit.bitb.biz.models;

import com.bit.bitb.biz.enums.PlaceTypeEnum;

public class OrderModel {
	private Long id;
	private String userId;
	/**
	 * 买/卖.
	 */
	private PlaceTypeEnum placeType;
	/**
	 * 下单数量
	 */
	private double quantity;
	/**
	 * 下单价格
	 */
	private String price;
	/**
	 * 成交金额
	 */
	private String realPrice;
	/**
	 * 成交量
	 */
	private double realQuantity;
	/**
	 * 尚未成交量
	 */
	private double unHandledQuantity;

}
