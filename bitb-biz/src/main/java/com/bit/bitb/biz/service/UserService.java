package com.bit.bitb.biz.service;

import com.bit.bitb.biz.entity.User;

public interface UserService {

	/**
	 * 现金账户增加
	 * @param user
	 * @param num
	 * @return
	 */
	public boolean increaseMoneyBalance(User user, float num);

	/**
	 * 现金账户减少
	 * @param user
	 * @param num
	 * @return
	 */
	public boolean reduceMoneyBalance(User user, float num);

	/**
	 * 比特币账户增加
	 * @param user
	 * @param num
	 * @return
	 */
	public boolean increaseBtcBalance(User user, float num);

	/**
	 * 比特币账户减少
	 * @param user
	 * @param num
	 * @return
	 */
	public boolean reduceBtcBalance(User user, float num);
	
}
