package com.bit.bitb.biz.service;

import com.bit.bitb.biz.entity.Buying;
import com.bit.bitb.biz.entity.Selling;

public interface TradeService {

	public boolean buy(Buying buying);

	public boolean sell(Selling selling);
}
