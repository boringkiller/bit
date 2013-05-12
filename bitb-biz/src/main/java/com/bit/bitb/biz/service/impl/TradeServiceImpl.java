package com.bit.bitb.biz.service.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bit.bitb.biz.entity.Buying;
import com.bit.bitb.biz.entity.Deal;
import com.bit.bitb.biz.entity.Selling;
import com.bit.bitb.biz.enums.UserCapacityEnum;
import com.bit.bitb.biz.models.BalanceModel;
import com.bit.bitb.biz.service.BalanceService;
import com.bit.bitb.biz.service.OrderService;
import com.bit.bitb.biz.service.TradeService;
import com.bit.bitb.dal.dao.MatchLibDAO;
import com.bit.bitb.dal.dataobjects.MatchLibDO;

public class TradeServiceImpl implements TradeService {
	private static final Logger logger = LoggerFactory
			.getLogger(TradeService.class);
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
	public boolean finishDeal(Deal donedeal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveDealCost(Deal donedealAC) {
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

	public boolean match() {
		MatchLibDO buyerMatchLibInfo = buyerMatchLibDAO.queryMatchInfo();// 找到买方出价最高的
		MatchLibDO sellerMatchLibInfo = sellerMatchLibDAO.queryMatchInfo();// 找卖家出价最低的
		// 实际成交价：以买方价格为准
		// 比特币个数一致
		double buyerQ = buyerMatchLibInfo.getQuantity();
		double sellerQ = sellerMatchLibInfo.getQuantity();

		if (buyerQ == sellerQ) {

			orderService.cancel(buyerMatchLibInfo.getOrderId());
			orderService.cancel(sellerMatchLibInfo.getOrderId());
		}

		// 买方多

		// 卖方多

		return false;
	}

	@Override
	public boolean buy(String userId, double price, double quantity,
			String tradePwd) {
		if (StringUtils.isBlank(userId) || StringUtils.isBlank(tradePwd)
				|| quantity == 0 || price == 0) {
			return false;
		}

		BalanceModel b = balanceService.findBalanceByUserId(userId);
		if (b == null) {
			logger.error("balanceService findBalanceByUserId result is null.userId="
					+ userId);
			return false;
		}
		if (!tradePwd.equals(b.getTradePwd())) {// TODO
												// 可以不用，改在交易密码输入结束时，先验证交易密码是否输入正确：see
												// balanceService.validate
			return false;
		}
		if (orderService.place(userId, price, quantity, UserCapacityEnum.buyer)) {
			// 向匹配库新增一条记录.
			MatchLibDO matchLibDO = new MatchLibDO();
			matchLibDO.setPrice(price);
			matchLibDO.setQuantity(quantity);
			matchLibDO.setUserId(userId);
			if (buyerMatchLibDAO.insert(matchLibDO)) {

			} else {
				// TOOD
			}
		} else {
			// TODO 记录失败.
		}
		// 记录一笔订单.
		return true;
	}

	@Override
	public boolean sell(String userId, double price, double quantity,
			String tradePwd) {
		if (StringUtils.isBlank(userId) || StringUtils.isBlank(tradePwd)
				|| quantity == 0 || price == 0) {
			return false;
		}

		balanceService.findBalanceByUserId(userId);

		if (orderService
				.place(userId, price, quantity, UserCapacityEnum.seller)) {
			MatchLibDO matchLibDO = new MatchLibDO();
			matchLibDO.setPrice(price);
			matchLibDO.setQuantity(quantity);
			matchLibDO.setUserId(userId);
			if (sellerMatchLibDAO.insert(matchLibDO)) {

			} else {
				// TOOD
			}
		} else {
			// TODO 记录失败.
		}
		// 记录一笔订单.
		return true;
	}

	@Override
	public float calcDealCost(Deal donedeal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeExpiredOffer() {
		// TODO Auto-generated method stub

	}

}
