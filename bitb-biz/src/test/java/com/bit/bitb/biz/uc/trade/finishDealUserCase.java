package com.bit.bitb.biz.uc.trade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bit.bitb.biz.service.TradeService;
import com.bit.bitb.biz.service.UserService;

/**
 * 
 * 完成交易的逻辑，包括用户余额修改、交易费收取等
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:bitb-all.xml" })
public class finishDealUserCase {

	@Autowired
	public UserService userService;
	
	@Autowired
	public TradeService tradeService;
	
	@Test
	public void test() {
//	when(userService.increaseMoneyBalance(userA, 501f)).thenReturn(true);
//	when(userService.reduceMoneyBalance(userC, 501f)).thenReturn(true);
//	when(userService.increaseBtcBalance(userC, 1f-tradeService.calcDealCost(donedealAC))).thenReturn(true);
//	when(userService.reduceBtcBalance(userA, 1f)).thenReturn(true);
//	when(tradeService.receiveDealCost(donedealAC)).thenReturn(true); //receive the payment into our own account
//	
//	System.out.println("cost: "+tradeService.calcDealCost(donedealAC));
//	System.out.println(userService.increaseMoneyBalance(userA, 501f));
//	System.out.println(userService.reduceMoneyBalance(userC, 501f));
//	System.out.println(userService.increaseBtcBalance(userC, 1f-tradeService.calcDealCost(donedealAC)));
//	System.out.println(userService.reduceBtcBalance(userA, 1f));
//	System.out.println(tradeService.receiveDealCost(donedealAC));
	}

}
