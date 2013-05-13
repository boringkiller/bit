package com.bit.bitb.biz.service;

/**
 * 日志模块
 * @author jimmy.du
 * May 13, 2013
 */
public interface BizLogService {
	
	/**
	 * 将完成的交易移到交易历史表
	 */
	public void moveFinishedDealToHistoryTable();
}
