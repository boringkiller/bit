package com.bit.bitb.biz.service.impl;

import org.apache.commons.lang.StringUtils;

import com.bit.bitb.biz.service.DemoService;
import com.bit.bitb.dal.dao.DemoDAO;
import com.bit.bitb.dal.dataobject.DemoDO;
import com.bit.bitb.dal.params.DemoParam;

public class DemoServiceImpl implements DemoService {
	private DemoDAO demoDAO;

	@Override
	public boolean validate(String userName, String pwd) {
		if (StringUtils.isBlank(userName) || StringUtils.isBlank(pwd)) {
			return false;
		}
		DemoParam param = new DemoParam();
		param.setPwd(pwd);
		param.setUserName(userName);
		DemoDO demo = demoDAO.queryDemoBy(param);
		if (demo == null) {
			return false;
		}

		return true;
	}

	public void setDemoDAO(DemoDAO demoDAO) {
		this.demoDAO = demoDAO;
	}

}
