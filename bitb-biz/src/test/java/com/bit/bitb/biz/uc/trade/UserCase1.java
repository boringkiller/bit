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
		//用于设置有效期
		Date now = new Date();
		Calendar validTo = Calendar.getInstance();
		validTo.setTime(now);
		validTo.add(Calendar.MONTH, 1);

		//用户A出售一个比特币，要价500
		System.out.println("user A sell 1 btc price 500 :");
		Selling userAselling = new Selling();
		userAselling.setIdselling("S" + OrderUtil.genereateOrderNumberString());
		userAselling.setSeller("001");
		userAselling.setPrice(String.valueOf(500f));
		userAselling.setQty(1f);
		userAselling.setValidFrom(now);
		userAselling.setValidTo(validTo.getTime());
		when(tradeService.sell(userAselling)).thenReturn(false);
		when(tradeService.freezeBtcWhenSell(userAselling)).thenReturn(true);
		System.out.println(tradeService.sell(userAselling));
		System.out.println(tradeService.freezeBtcWhenSell(userAselling));
		

		//用户B购买一个比特币，出价499，购买失败
		System.out.println("user B buy 1 btc price 499 :");
		Buying userBbuying = new Buying();
		userBbuying.setIdbuying("B" + OrderUtil.genereateOrderNumberString());
		userBbuying.setBuyer("002");
		userBbuying.setPrice(String.valueOf(499f));
		userBbuying.setQty(1f);
		userBbuying.setValidFrom(now);
		userBbuying.setValidTo(validTo.getTime());
		when(tradeService.buy(userBbuying)).thenReturn(false);
		when(tradeService.freezeMoneyWhenBuy(userBbuying)).thenReturn(true);
		when(tradeService.match(userBbuying)).thenReturn(null);
		System.out.println(tradeService.buy(userBbuying));
		System.out.println(tradeService.freezeMoneyWhenBuy(userBbuying));
		System.out.println(tradeService.match(userBbuying));

		//用户C购买一个比特币，出价501，购买成功
		System.out.println("user C buy 1 btc price 501 :");
		Buying userCbuying = new Buying();
		userCbuying.setIdbuying("B" + OrderUtil.genereateOrderNumberString());
		userCbuying.setBuyer("003");
		userCbuying.setPrice(String.valueOf(501f));
		userCbuying.setQty(1f);
		userCbuying.setValidFrom(now);
		userCbuying.setValidTo(validTo.getTime());
		when(tradeService.buy(userCbuying)).thenReturn(true);
		when(tradeService.freezeMoneyWhenBuy(userBbuying)).thenReturn(true);
		System.out.println(tradeService.buy(userCbuying));
		System.out.println(tradeService.freezeMoneyWhenBuy(userBbuying));
		
		Deal donedealAC = new Deal();
		donedealAC.setBuyer("003"); // C
		donedealAC.setSeller("001"); // A
		donedealAC.setIdbuying(userCbuying.getIdbuying());
		donedealAC.setIdselling(userAselling.getIdselling());
		donedealAC.setIddeal(0);
		donedealAC.setInitiator("001");
		donedealAC.setPrice(String.valueOf(501f));
		donedealAC.setQuantity(String.valueOf(1f));
		when(tradeService.match(userCbuying)).thenReturn(donedealAC);
		System.out.println(tradeService.match(userCbuying));

		//完成A和C交易
		System.out.println("完成A和C交易.");
		when(tradeService.finishDeal(donedealAC)).thenReturn(true);
		System.out.println(tradeService.finishDeal(donedealAC));
		

	}

}
