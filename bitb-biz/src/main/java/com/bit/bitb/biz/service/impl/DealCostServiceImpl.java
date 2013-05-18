package com.bit.bitb.biz.service.impl;

import com.bit.bitb.biz.entity.Deal;
import com.bit.bitb.biz.entity.User;
import com.bit.bitb.biz.service.BalanceService;
import com.bit.bitb.biz.service.DealCostService;
import com.bit.bitb.biz.service.PublicAccountService;
import com.bit.bitb.biz.service.UserService;
import com.bit.bitb.biz.util.ConstantUtil;
import com.bit.bitb.biz.util.MathUtils;

public class DealCostServiceImpl implements DealCostService {

	private BalanceService balanceService;
	
	private UserService userService;
	
	private PublicAccountService publicAccountService;
	
	@Override
	public boolean payAndReceiveDealCost(Deal deal) {
		try {
			User buyer = userService.getUserById(deal.getBuyer());
			User seller = userService.getUserById(deal.getSeller());
			//买家付钱，卖家付比特币
			double totalAmount = MathUtils.multWithAccurated(deal.getQuantity(), deal.getPrice());
			double quantity = Double.valueOf(deal.getQuantity());
			double moneyCost = calcDealCostInMoney(deal);
			double btcCost = calcDealCostInBtc(deal);
			balanceService.reduceMoneyBalance(buyer, totalAmount); //付出现金，从冻结的现金里面
			balanceService.increaseBtcBalance(buyer, MathUtils.sub(quantity, btcCost));
			balanceService.reduceBtcBalance(seller, quantity); //付出比特币，从冻结的比特币里面
			balanceService.increaseMoneyBalance(seller, MathUtils.sub(totalAmount, moneyCost));
			publicAccountService.addBtcToPubAccount(btcCost);
			publicAccountService.addMoneyToPubAccount(moneyCost);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public double calcDealCostInBtc(Deal deal) {
		Double qtyDouble = Double.valueOf(deal.getQuantity());
		Double cost = qtyDouble * ConstantUtil.DEAL_COST_RATE;
		return cost;
	}

	@Override
	public double calcDealCostInMoney(Deal deal) {
		Double qtyDouble = Double.valueOf(deal.getQuantity());
		Double priceDouble = Double.valueOf(deal.getPrice());
		Double cost = qtyDouble * priceDouble * ConstantUtil.DEAL_COST_RATE;
		return cost;
	}

	public BalanceService getBalanceService() {
		return balanceService;
	}

	public void setBalanceService(BalanceService balanceService) {
		this.balanceService = balanceService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public PublicAccountService getPublicAccountService() {
		return publicAccountService;
	}

	public void setPublicAccountService(PublicAccountService publicAccountService) {
		this.publicAccountService = publicAccountService;
	}

}
