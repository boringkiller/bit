package com.bit.bitb.biz.uc.trade;

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
import com.bit.bitb.biz.entity.Deal;
import com.bit.bitb.biz.entity.Selling;
import com.bit.bitb.biz.entity.User;
import com.bit.bitb.biz.service.TradeService;
import com.bit.bitb.biz.service.UserService;
import com.bit.bitb.biz.util.OrderUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:bitb-all.xml" })
public class UserCase1 {

	@Autowired
	public TradeService tradeService;
	
	@Autowired
	public UserService userService;

	@Test
	public void test() {

		User userA = new User();
		userA.setIduser("001");
		userA.setMoneybalance(String.valueOf(0f));
		userA.setBtcbalance(String.valueOf(1f));
		
		User userB = new User();
		userB.setIduser("002");
		userB.setMoneybalance(String.valueOf(499f));
		userB.setBtcbalance(String.valueOf(0f));
		
		User userC = new User();
		userC.setIduser("003");
		userC.setMoneybalance(String.valueOf(501f));
		userC.setBtcbalance(String.valueOf(0f));
		
		tradeService = mock(TradeService.class);
		userService = mock(UserService.class);
		Date now = new Date();
		System.out.println(tradeService);
		Calendar validTo = Calendar.getInstance();
		validTo.setTime(now);
		validTo.add(Calendar.MONTH, 1);

		// user A sell 1 btc price 500
		System.out.println("user A sell 1 btc price 500 :");
		Selling userAselling = new Selling();
		userAselling.setIdselling("S" + OrderUtil.genereateOrderNumberString());
		userAselling.setSeller("001");
		userAselling.setPrice(String.valueOf(500f));
		userAselling.setQty(1f);
		userAselling.setValidFrom(now);
		userAselling.setValidTo(validTo.getTime());
		when(tradeService.sell(userAselling)).thenReturn(false);
		System.out.println(tradeService.sell(userAselling));
		when(tradeService.freezeBtcWhenSell(userAselling)).thenReturn(true);
		

		// user B buy 1 btc price 499
		System.out.println("user B buy 1 btc price 499 :");
		Buying userBbuying = new Buying();
		userBbuying.setIdbuying("B" + OrderUtil.genereateOrderNumberString());
		userBbuying.setBuyer("002");
		userBbuying.setPrice(String.valueOf(499f));
		userBbuying.setQty(1f);
		userBbuying.setValidFrom(now);
		userBbuying.setValidTo(validTo.getTime());
		when(tradeService.buy(userBbuying)).thenReturn(false);
		System.out.println(tradeService.buy(userBbuying));
		when(tradeService.freezeMoneyWhenBuy(userBbuying)).thenReturn(true);

		// user C buy 1 btc price 501
		System.out.println("user C buy 1 btc price 501 :");
		Buying userCbuying = new Buying();
		userCbuying.setIdbuying("B" + OrderUtil.genereateOrderNumberString());
		userCbuying.setBuyer("003");
		userCbuying.setPrice(String.valueOf(501f));
		userCbuying.setQty(1f);
		userCbuying.setValidFrom(now);
		userCbuying.setValidTo(validTo.getTime());
		when(tradeService.buy(userCbuying)).thenReturn(true);
		System.out.println(tradeService.buy(userCbuying));
		when(tradeService.freezeMoneyWhenBuy(userBbuying)).thenReturn(true);


		// insert into donedeal table
		System.out.println("A deal is made between A and C, btc 1 price 501.");
		Deal donedealAC = new Deal();
		donedealAC.setBuyer("003"); // C
		donedealAC.setSeller("001"); // A
		donedealAC.setIdbuying(userCbuying.getIdbuying());
		donedealAC.setIdselling(userAselling.getIdselling());
		donedealAC.setIddeal(0);
		donedealAC.setInitiator("001");
		donedealAC.setPrice(String.valueOf(501f));
		donedealAC.setQuantity(String.valueOf(1f));
		
		when(tradeService.calcDealCost(donedealAC)).thenReturn(0.003f); //calculate deal cost
		when(userService.increaseMoneyBalance(userA, 501f)).thenReturn(true);
		when(userService.reduceMoneyBalance(userC, 501f)).thenReturn(true);
		when(userService.increaseBtcBalance(userC, 1f-tradeService.calcDealCost(donedealAC))).thenReturn(true);
		when(userService.reduceBtcBalance(userA, 1f)).thenReturn(true);
		when(tradeService.receiveDealCost(donedealAC)).thenReturn(true); //receive the payment into our own account
		when(tradeService.finishDeal(donedealAC)).thenReturn(true);
		
		System.out.println("cost: "+tradeService.calcDealCost(donedealAC));
		System.out.println(userService.increaseMoneyBalance(userA, 501f));
		System.out.println(userService.reduceMoneyBalance(userC, 501f));
		System.out.println(userService.increaseBtcBalance(userC, 1f-tradeService.calcDealCost(donedealAC)));
		System.out.println(userService.reduceBtcBalance(userA, 1f));
		System.out.println(tradeService.receiveDealCost(donedealAC));
		System.out.println(tradeService.finishDeal(donedealAC));
		

	}

}
