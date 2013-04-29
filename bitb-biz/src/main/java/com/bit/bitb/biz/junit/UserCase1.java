package com.bit.bitb.biz.junit;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bit.bitb.biz.entity.Buying;
import com.bit.bitb.biz.entity.Selling;
import com.bit.bitb.biz.service.TradeService;
import com.bit.bitb.biz.util.OrderUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/bitb-all.xml" })
public class UserCase1 {

	@Autowired
	public TradeService tradeService;

	@Test
	public void test() {
		Date now = new Date();
		System.out.println(tradeService);
		Selling userAselling = new Selling();
		userAselling.setIdselling("S" + OrderUtil.genereateOrderNumberString());
		userAselling.setSeller("001");
		userAselling.setPrice(500f);
		userAselling.setQty(1f);
		userAselling.setValidFrom(now);
		Calendar validTo = Calendar.getInstance();
		validTo.setTime(now);
		validTo.add(Calendar.MONTH, 1);
		userAselling.setValidTo(validTo.getTime());
		
		//user A sell 1 btc price 500
		tradeService.sell(userAselling);

		Buying userBbuying = new Buying();
		userBbuying.setIdbuying("B" + OrderUtil.genereateOrderNumberString());
		userBbuying.setBuyer("001");
		userBbuying.setPrice(499f);
		userBbuying.setQty(1f);
		userBbuying.setValidFrom(now);
		userBbuying.setValidTo(validTo.getTime());
		
		//user B buy 1 btc price 499
		tradeService.buy(userBbuying);
		
		
	}

}
