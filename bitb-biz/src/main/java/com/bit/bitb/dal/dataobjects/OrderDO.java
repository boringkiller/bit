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
	private String price;
	/**
	 * 总的比特币量.
	 */
	private Double quantity;
	/**
	 * 尚未成交的量.
	 */
	private Double handlingQuantity;
	
	private String status;
	private String memo;
	
	
	
}
