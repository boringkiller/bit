package com.bit.bitb.biz.service;

import com.bit.bitb.biz.entity.User;

/**
 * 负责与bitcoin客户端交互，操作比特币
 * @author jimmy.du
 * May 13, 2013
 */
public interface BitcoinService {

	/**
	 * 比特币转账
	 * @param fromUser
	 * @param toUser
	 * @param bitcoin
	 * @return
	 */
	public boolean transfer(User fromUser, User toUser, double bitcoin);
}
