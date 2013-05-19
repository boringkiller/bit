package com.bit.bitb.biz.service;

import com.bit.bitb.biz.entity.User;

/**
 * 负责与alipay支付宝交互，操作现金，人工充值，人工提现
 * @author jimmy.du
 * May 13, 2013
 */
public interface MoneyService {
	
	/**
	 * 充值确认请求,由客户发起
	 * @return
	 */
	public boolean depositConfirmRequest(User customer, double money);

	/**
	 * 充值确认，由客服完成
	 * @return
	 */
	public boolean depositConfirm(User customer, double money, boolean isDeposited, User customerService);
	
	/**
	 * 提现请求，由客户发起
	 * @return
	 */
	public boolean withdrawDepositRequest(User customer, double money);
	
	/**
	 * 客服打钱到客户支付宝后，请求客户确认
	 * @return
	 */
	public boolean withdrawDepositConfirmRequest(User customer, double money, User customerService);
	
	/**
	 * 客户提现之后确认
	 * @return
	 */
	public boolean withdrawDepositConfirm(User customer, double money, boolean isWithdrawed);
}
