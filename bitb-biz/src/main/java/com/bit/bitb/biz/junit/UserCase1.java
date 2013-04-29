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
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/bitb-all.xml" })
public class UserCase1 {

	@Autowired
	public TradeService tradeService;

	@Test
	public void test() {
		
		tradeService = mock(TradeService.class);
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
		System.out.println("user A sell 1 btc price 500 :");
		when(tradeService.sell(userAselling)).thenReturn(false);
		System.out.println(tradeService.sell(userAselling));

		Buying userBbuying = new Buying();
		userBbuying.setIdbuying("B" + OrderUtil.genereateOrderNumberString());
		userBbuying.setBuyer("002");
		userBbuying.setPrice(499f);
		userBbuying.setQty(1f);
		userBbuying.setValidFrom(now);
		userBbuying.setValidTo(validTo.getTime());
		
		//user B buy 1 btc price 499
		System.out.println("user B buy 1 btc price 499 :");
		when(tradeService.buy(userBbuying)).thenReturn(false);
		System.out.println(tradeService.buy(userBbuying));
		
		Buying userCbuying = new Buying();
		userCbuying.setIdbuying("B" + OrderUtil.genereateOrderNumberString());
		userCbuying.setBuyer("003");
		userCbuying.setPrice(501f);
		userCbuying.setQty(1f);
		userCbuying.setValidFrom(now);
		userCbuying.setValidTo(validTo.getTime());
		
		//user C buy 1 btc price 501
		System.out.println("user C buy 1 btc price 501 :");
		when(tradeService.buy(userCbuying)).thenReturn(true);
		System.out.println(tradeService.buy(userCbuying));
		
	}

}
