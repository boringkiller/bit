package com.bit.bitb.biz.service.impl;

import com.bit.bitb.biz.entity.Buying;
import com.bit.bitb.biz.entity.Donedeal;
import com.bit.bitb.biz.entity.Selling;
import com.bit.bitb.biz.enums.PlaceTypeEnum;
import com.bit.bitb.biz.models.Balance;
import com.bit.bitb.biz.service.BalanceService;
import com.bit.bitb.biz.service.OrderService;
import com.bit.bitb.biz.service.TradeService;
import com.bit.bitb.dal.dao.MatchLibDAO;
import com.bit.bitb.dal.dataobjects.MatchLibDO;

public class TradeServiceImpl implements TradeService {
	private OrderService orderService;
	private BalanceService balanceService;
	private MatchLibDAO buyerMatchLibDAO;
	private MatchLibDAO sellerMatchLibDAO;
	@Override
	public boolean buy(Buying buying) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sell(Selling selling) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean finishDeal(Donedeal donedeal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float calcDealCost(Donedeal donedeal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeExpiredOffer() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean receiveDealCost(Donedeal donedealAC) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean freezeBtcWhenSell(Selling selling) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean freezeMoneyWhenBuy(Buying buying) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unfreezeWhenCancel(Selling selling) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unfreezeWhenCancel(Buying buying) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean match() {
		MatchLibDO buyerMatchLibInfo=buyerMatchLibDAO.queryMatchInfo();//找到买方出价最高的
		MatchLibDO sellerMatchLibInfo=sellerMatchLibDAO.queryMatchInfo();//找卖家出价最低的
		//实际成交价：以买方价格为准
		//比特币个数一致
		
		//买方多
		
		//卖方多
		
		return false;
	}

	@Override
	public boolean buy(String userId, String price, double bitCoinAmount) {
		if (orderService.place(userId, price, bitCoinAmount, PlaceTypeEnum.buying)) {
			MatchLibDO matchLibDO=new MatchLibDO();
			matchLibDO.setPrice(price);
			matchLibDO.setQuantity(bitCoinAmount);
			matchLibDO.setUserId(userId);
			if (buyerMatchLibDAO.insert(matchLibDO)) {
				
			}else{
				//TOOD
			}
		}else{
			//TODO 记录失败.
		}
		//记录一笔订单.
		return true;
	}

	@Override
	public boolean sell(String userId, String price, double bitCoinAmount) {

		if (orderService.place(userId, price, bitCoinAmount, PlaceTypeEnum.selling)) {
			MatchLibDO matchLibDO=new MatchLibDO();
			matchLibDO.setPrice(price);
			matchLibDO.setQuantity(bitCoinAmount);
			matchLibDO.setUserId(userId);
			if (sellerMatchLibDAO.insert(matchLibDO)) {
				
			}else{
				//TOOD
			}
		}else{
			//TODO 记录失败.
		}
		//记录一笔订单.
		return true;
	}

}
