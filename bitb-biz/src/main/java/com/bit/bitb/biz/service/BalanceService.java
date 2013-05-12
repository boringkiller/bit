package com.bit.bitb.biz.service;

import com.bit.bitb.biz.models.BalanceModel;

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
	public BalanceModel deduct(String userId, String money, String memo);

	/**
	 * 查询账户信息.
	 * 
	 * @param userId
	 * @return
	 */
	public BalanceModel findBalanceByUserId(String userId);
	

	/**
	 * 打款.
	 * 
	 * @param userId
	 * @param money
	 * @param memo
	 * @return
	 */
	public BalanceModel deposit(String userId, String money, String memo);

	/**
	 * 更新买家资金账户.
	 * 
	 * <pre>
	 * 当买卖双方匹配时
	 * @param balance
	 */
	public void changeBuyerBalanceForMatch(BalanceModel balance);

	/**
	 * 验证交易密码是否正确.
	 * 
	 * @param userId
	 * @param tradePwd
	 * @return
	 */
	public boolean validate(String userId, String tradePwd);

	/**
	 * 更新卖家资金账户.
	 * 
	 * <pre>
	 * 当买卖双方匹配时
	 * @param balance
	 */
	public void changeSellerBalanceForMatch(BalanceModel balance);

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
