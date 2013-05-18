package com.bit.bitb.biz.dao;

import java.util.List;

import com.bit.bitb.biz.entity.Buying;
import com.bit.bitb.biz.entity.Selling;

public interface TradeDao {

	public List<Selling> match(Buying buying);

	public void insertBuying(Buying buying);

	public void updateSelling(Selling selling);

}
