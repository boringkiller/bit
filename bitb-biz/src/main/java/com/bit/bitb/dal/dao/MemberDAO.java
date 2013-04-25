package com.bit.bitb.dal.dao;

import com.bit.bitb.dal.dataobjects.MemberDO;

public interface MemberDAO {
	public boolean insert(MemberDO memberDO);

	public boolean update(MemberDO memberDO);
}
