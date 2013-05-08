package com.bit.bitb.biz.uc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bit.bitb.biz.entity.Buying;
import com.bit.bitb.biz.entity.Donedeal;
import com.bit.bitb.biz.entity.Selling;
import com.bit.bitb.biz.service.TradeService;
import com.bit.bitb.biz.util.OrderUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:bitb-all.xml" })
public class UserCase5 {

	@Autowired
	public TradeService tradeService;

	@Test
	public void test() {

		tradeService = mock(TradeService.class);
		Date now = new Date();
		System.out.println(tradeService);
		Calendar validTo = Calendar.getInstance();
		validTo.setTime(now);
		validTo.add(Calendar.MONTH, 1);

		// user A sell 10 btc price 500
		System.out.println("user A sell 1 btc price 500 :");
		Selling userAselling = new Selling();
		userAselling.setIdselling("S" + OrderUtil.genereateOrderNumberString());
		userAselling.setSeller("001");
		userAselling.setPrice(500f);
		userAselling.setQty(10f);
		userAselling.setValidFrom(now);
		userAselling.setValidTo(validTo.getTime());
		when(tradeService.sell(userAselling)).thenReturn(false);
		System.out.println(tradeService.sell(userAselling));

		// user B buy 1 btc price 501
		System.out.println("user B buy 1 btc price 510 :");
		Buying userBbuying = new Buying();
		userBbuying.setIdbuying("B" + OrderUtil.genereateOrderNumberString());
		userBbuying.setBuyer("002");
		userBbuying.setPrice(510f);
		userBbuying.setQty(1f);
		userBbuying.setValidFrom(now);
		userBbuying.setValidTo(validTo.getTime());
		when(tradeService.buy(userBbuying)).thenReturn(true);
		System.out.println(tradeService.buy(userBbuying));

		// insert into donedeal table
		System.out.println("A deal is made between A and B, btc 1 price 510.");
		Donedeal donedealAB = new Donedeal();
		donedealAB.setBuyer("002"); // B
		donedealAB.setSeller("001"); // A
		donedealAB.setIdbuying(userBbuying.getIdbuying());
		donedealAB.setIdselling(userAselling.getIdselling());
		donedealAB.setIddonedeal(0);
		donedealAB.setInitiator("001");
		donedealAB.setPrice(510f);
		donedealAB.setQty(1f);
		when(tradeService.finishDeal(donedealAB)).thenReturn(true);
		System.out.println(tradeService.finishDeal(donedealAB));

	}

}
