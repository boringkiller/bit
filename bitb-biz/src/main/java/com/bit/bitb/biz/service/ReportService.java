package com.bit.bitb.biz.service;

import java.util.List;

import com.bit.bitb.biz.entity.Buying;
import com.bit.bitb.biz.entity.Selling;

/**
 * 报表模块
 * @author jimmy.du
 * May 13, 2013
 */
public interface ReportService {

	/**
	 * 获取购买订单前几名
	 * @param top
	 * @return
	 */
	public List<Buying> getTopBuyings(int top);
	
	/**
	 * 获取出售订单前几名
	 * @param top
	 * @return
	 */
	public List<Selling> getTopSellings(int top);
}
