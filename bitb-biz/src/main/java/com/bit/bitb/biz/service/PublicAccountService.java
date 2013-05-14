package com.bit.bitb.biz.service;

/**
 * 负责公共账户管理
 * @author jimmy.du
 * May 14, 2013
 */
public interface PublicAccountService {

	/**
	 * 现金存入公共账户
	 * @param money
	 */
	public boolean addMoneyToPubAccount(float money);
	
	/**
	 * 比特币存入公共账户
	 * @param btc
	 * @return
	 */
	public boolean addBtcToPubAccount(float btc); 
}
