package com.bit.bitb.biz.service;

import com.bit.bitb.biz.models.Balance;

/**
 * 账户服务.
 * 
 * @author simple56
 * 
 */
public interface BalanceService {
	/**
	 * 扣款.
	 * 
	 * @return
	 */
	public Balance deduct(String userId, String money, String memo);

	/**
	 * 打款.
	 * 
	 * @param userId
	 * @param money
	 * @param memo
	 * @return
	 */
	public Balance deposit(String userId, String money, String memo);

	/**
	 * 冻结账户.
	 * <p>
	 * 预留.
	 * 
	 * @param userId
	 * @return
	 */
	public boolean frozen(String userId);

}
