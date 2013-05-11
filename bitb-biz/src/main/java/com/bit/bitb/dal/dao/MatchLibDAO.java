package com.bit.bitb.dal.dao;

import com.bit.bitb.dal.dataobjects.MatchLibDO;

public interface MatchLibDAO {
	/**
	 * 查询匹配信息.
	 * 
	 * @return
	 */
	public MatchLibDO queryMatchInfo();

	/**
	 * 插入一条匹配记录.
	 * 
	 * @param matchLibDO
	 * @return
	 */
	public boolean insert(MatchLibDO matchLibDO);
}
