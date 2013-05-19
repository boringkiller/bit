package com.bit.bitb.biz.service;

import com.bit.bitb.biz.entity.User;

/**
 * 专门处理现金和比特币的余额
 * @author jimmy.du
 * May 13, 2013
 */
public interface BalanceService {

	/**
	 * 现金账户增加
	 * @param user
	 * @param num
	 * @return
	 */
	public boolean increaseMoneyBalance(User user, double num);

	/**
	 * 现金账户减少
	 * @param user
	 * @param d
	 * @return
	 */
	public boolean reduceMoneyBalance(User user, double num);

	/**
	 * 比特币账户增加
	 * @param user
	 * @param num
	 * @return
	 */
	public boolean increaseBtcBalance(User user, double num);

	/**
	 * 比特币账户减少
	 * @param user
	 * @param num
	 * @return
	 */
	public boolean reduceBtcBalance(User user, double num);
	
	/**
	 * 增加现金减少比特币
	 * @param user
	 * @param money
	 * @param btc
	 * @return
	 */
	public boolean increaseMoneyReduceBtc(User user, double money, double btc);
	
	/**
	 * 增加比特币，减少现金
	 * @param user
	 * @param btc
	 * @param money
	 * @return
	 */
	public boolean increaseBtcReduceMoney(User user, double btc, double money);
}
