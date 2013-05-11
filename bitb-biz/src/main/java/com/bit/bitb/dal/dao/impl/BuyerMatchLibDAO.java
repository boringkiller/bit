package com.bit.bitb.dal.dao.impl;

import com.bit.bitb.dal.dao.MatchLibDAO;
import com.bit.bitb.dal.dataobjects.MatchLibDO;

/**
 * 买家匹配库.
 * 
 * @author simple56
 * 
 */
public class BuyerMatchLibDAO implements MatchLibDAO {

	
	/**
	 * 查出买家库中出价最高的记录.
	 * 
	 * order by gmt_create desc,id desc 时间早的优先.
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
