package com.bit.bitb.dal.dao;

import com.bit.bitb.dal.dataobject.DemoDO;
import com.bit.bitb.dal.params.DemoParam;

public interface DemoDAO {
	public DemoDO queryDemoBy(DemoParam param);
}
