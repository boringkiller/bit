package com.bit.bitb.biz.service;

import java.util.List;

import com.bit.bitb.biz.entity.Buying;
import com.bit.bitb.biz.entity.Selling;

public interface ReportService {

	public List<Buying> getTopBuyings(int top);
	
	public List<Selling> getTopSellings(int top);
}
