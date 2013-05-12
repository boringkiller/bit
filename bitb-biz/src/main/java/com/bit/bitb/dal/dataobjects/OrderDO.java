package com.bit.bitb.dal.dataobjects;

import java.sql.Date;

/**
 * 订单DO.
 * 
 * @author simple56
 * 
 */
public class OrderDO {
	private Long id;
	private Date gmtCreate;
	private Date gmtModified;

	private String userId;
	/**
	 * 买/卖.
	 */
	private String placeType;
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

	private String status;
	private String memo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRealPrice() {
		return realPrice;
	}

	public void setRealPrice(String realPrice) {
		this.realPrice = realPrice;
	}

	public double getRealQuantity() {
		return realQuantity;
	}

	public void setRealQuantity(double realQuantity) {
		this.realQuantity = realQuantity;
	}

	public double getUnHandledQuantity() {
		return unHandledQuantity;
	}

	public void setUnHandledQuantity(double unHandledQuantity) {
		this.unHandledQuantity = unHandledQuantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
