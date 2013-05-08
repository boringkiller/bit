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
public class UserCase2 {

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

		// user A buy 1 btc price 500
		System.out.println("user A buy 1 btc price 500 :");
		Buying userAbuying = new Buying();
		userAbuying.setIdbuying("B" + OrderUtil.genereateOrderNumberString());
		userAbuying.setBuyer("001");
		userAbuying.setPrice(500f);
		userAbuying.setQty(1f);
		userAbuying.setValidFrom(now);
		userAbuying.setValidTo(validTo.getTime());
		when(tradeService.buy(userAbuying)).thenReturn(false);
		System.out.println(tradeService.buy(userAbuying));

		// user B sell 1 btc price 501
		System.out.println("user B sell 1 btc price 501 :");
		Selling userBselling = new Selling();
		userBselling.setIdselling("S" + OrderUtil.genereateOrderNumberString());
		userBselling.setSeller("002");
		userBselling.setPrice(501f);
		userBselling.setQty(1f);
		userBselling.setValidFrom(now);
		userBselling.setValidTo(validTo.getTime());
		when(tradeService.sell(userBselling)).thenReturn(false);
		System.out.println(tradeService.sell(userBselling));

		// user C sell 1 btc price 499
		System.out.println("user C sell 1 btc price 499 :");
		Selling userCselling = new Selling();
		userCselling.setIdselling("S" + OrderUtil.genereateOrderNumberString());
		userCselling.setSeller("003");
		userCselling.setPrice(499f);
		userCselling.setQty(1f);
		userCselling.setValidFrom(now);
		userCselling.setValidTo(validTo.getTime());
		when(tradeService.sell(userCselling)).thenReturn(true);
		System.out.println(tradeService.sell(userCselling));

		// insert into donedeal table
		System.out.println("A deal is made between A and C, btc 1 price 500.");
		Donedeal donedealAC = new Donedeal();
		donedealAC.setBuyer("001"); // A
		donedealAC.setSeller("003"); // C
		donedealAC.setIdbuying(userAbuying.getIdbuying());
		donedealAC.setIdselling(userCselling.getIdselling());
		donedealAC.setIddonedeal(0);
		donedealAC.setInitiator("001");
		donedealAC.setPrice(500f);
		donedealAC.setQty(1f);
		when(tradeService.finishDeal(donedealAC)).thenReturn(true);
		System.out.println(tradeService.finishDeal(donedealAC));
	}

}
