package com.bit.bitb.dal.dao.impl;

import com.bit.bitb.dal.dao.MatchLibDAO;
import com.bit.bitb.dal.dataobjects.MatchLibDO;

public class SellerMatchLibDAO implements MatchLibDAO{
	/**
	 * 查出卖家库中出价最低的
	 * 
	 * order by gmt_create desc,order by id desc
	 */
	public MatchLibDO queryMatchInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(MatchLibDO matchLibDO) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
