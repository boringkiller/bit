package com.bit.bitb.biz.service;

import com.bit.bitb.biz.entity.User;

public interface UserService {

	public boolean increaseMoneyBalance(User user, float num);

	public boolean reduceMoneyBalance(User user, float num);

	public boolean increaseBtcBalance(User user, float num);

	public boolean reduceBtcBalance(User user, float num);
	
}
