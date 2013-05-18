package com.bit.bitb.biz.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bit.bitb.biz.dao.TradeDao;
import com.bit.bitb.biz.entity.Buying;
import com.bit.bitb.biz.entity.Deal;
import com.bit.bitb.biz.entity.Selling;
import com.bit.bitb.biz.service.DealCostService;
import com.bit.bitb.biz.service.TradeService;
import com.bit.bitb.biz.util.ConstantUtil;

public class TradeServiceImpl implements TradeService {

	private TradeDao tradeDao;
	
	private DealCostService dealCostService;
	
	
	@Override
	public List<Deal> buy(Buying buying) {
		List<Deal> deals = match(buying);
		return deals;
	}

	@Override
	public List<Deal> sell(Selling selling) {
		List<Deal> deals = match(selling);
		return deals;
	}

	@Override
	public List<Deal> match(Buying buying) {
			List<Deal> deals = new ArrayList<Deal>();
			List<Selling> sellings = tradeDao.match(buying);
			Selling leftSelling = null;
			for (Selling selling : sellings) {
				if (buying.getQuantity() != null && Double.valueOf(buying.getQuantity()) > 0) {
					Deal deal = new Deal();
					Double qtyDoubleBuying = Double.valueOf(buying.getQuantity());
					Double qtyDoubleSelling = Double.valueOf(selling.getQuantity());
					Double qtyDouble;
					//判断实际交易数量
					if (qtyDoubleBuying > qtyDoubleSelling) {
						//买方多余
						qtyDouble = qtyDoubleSelling; 
						buying.setQuantity(String.valueOf(qtyDoubleBuying - qtyDoubleSelling));
					} else {
						if (qtyDoubleBuying == qtyDoubleSelling) {
							//双方都没有多余
							qtyDouble = qtyDoubleBuying;
							buying.setQuantity("0");
						} else {
							//卖方多余
							qtyDouble = qtyDoubleBuying;
							buying.setQuantity("0");
							selling.setQuantity(String.valueOf(qtyDoubleSelling - qtyDoubleBuying));
							leftSelling = selling;
							deal.setMemo(ConstantUtil.MEMO_SELLINGSURPLUS);
						}
					}
					
					deal.setBuyer(buying.getBuyer());
					deal.setCreateTs(new Date());
					deal.setIdbuying(buying.getIdbuying());
					deal.setIdselling(selling.getIdselling());
					deal.setInitiator(buying.getBuyer());
					deal.setModifyTs(null);
					deal.setPrice(buying.getPrice());
					deal.setQuantity(qtyDouble.toString());
					deal.setSeller(selling.getSeller());
					
					deals.add(deal);
					finishDeal(deal); //匹配成功
					
				} else {
					//卖方还有多
					break;
				}
			}
			
			if (buying.getQuantity() != null && Double.valueOf(buying.getQuantity()) > 0) {
				//买方无法满足，插入buying表继续等待
				tradeDao.insertBuying(buying);
			}
			if (leftSelling != null) {
				tradeDao.updateSelling(leftSelling);
			}
	
		return deals;
	}

	@Override
	public List<Deal> match(Selling selling) {
		List<Deal> deals = new ArrayList<Deal>();
		List<Buying> buyings = tradeDao.match(selling);
		Buying leftBuying = null;
		for (Buying buying : buyings) {
			if (selling.getQuantity() != null && Double.valueOf(selling.getQuantity()) > 0) {
				Deal deal = new Deal();
				Double qtyDoubleBuying = Double.valueOf(buying.getQuantity());
				Double qtyDoubleSelling = Double.valueOf(selling.getQuantity());
				Double qtyDouble;
				//判断实际交易数量
				if (qtyDoubleSelling > qtyDoubleBuying ) {
					//卖方多余
					qtyDouble = qtyDoubleBuying; 
					selling.setQuantity(String.valueOf(qtyDoubleSelling - qtyDoubleBuying));
				} else {
					if (qtyDoubleBuying == qtyDoubleSelling) {
						//双方都没有多余
						qtyDouble = qtyDoubleBuying;
						selling.setQuantity("0");
					} else {
						//买方多余
						qtyDouble = qtyDoubleSelling;
						selling.setQuantity("0");
						buying.setQuantity(String.valueOf(qtyDoubleSelling - qtyDoubleBuying));
						leftBuying = buying;
						deal.setMemo(ConstantUtil.MEMO_BUYINGSURPLUS);
					}
				}
				
				deal.setBuyer(buying.getBuyer());
				deal.setCreateTs(new Date());
				deal.setIdbuying(buying.getIdbuying());
				deal.setIdselling(selling.getIdselling());
				deal.setInitiator(buying.getBuyer());
				deal.setModifyTs(null);
				deal.setPrice(buying.getPrice());
				deal.setQuantity(qtyDouble.toString());
				deal.setSeller(selling.getSeller());
				
				deals.add(deal);
				finishDeal(deal); //匹配成功
				
			} else {
				//卖方还有多
				break;
			}
		}
		
		if (selling.getQuantity() != null && Double.valueOf(selling.getQuantity()) > 0) {
			//买方无法满足，插入buying表继续等待
			tradeDao.insertSelling(selling);
		}
		if (leftBuying != null) {
			tradeDao.updateBuying(leftBuying);
		}

		return deals;
	}

	@Override
	public boolean finishDeal(Deal deal) {
		try {
			if (deal.getInitiator().equals(deal.getBuyer())) {
				//买入单
				if (deal.getMemo().equals(ConstantUtil.MEMO_SELLINGSURPLUS)) {
					//最后一位卖家有多余，不能直接删除
					tradeDao.insertDeal(deal);
				} else {
					tradeDao.deleteSelling(deal.getIdselling());
					tradeDao.insertDeal(deal);
				}
			} else {
				// 卖出单
				if (deal.getMemo().equals(ConstantUtil.MEMO_BUYINGSURPLUS)) {
					//最后一位买家有多余，不能直接删除
					tradeDao.insertDeal(deal);
				} else {
					tradeDao.deleteBuying(deal.getIdbuying());
					tradeDao.insertDeal(deal);
				}
			}
			
			//收取交易费用
			dealCostService.payAndReceiveDealCost(deal);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public void removeExpiredOffer() {
		// TODO Auto-generated method stub

	}

	public TradeDao getTradeDao() {
		return tradeDao;
	}

	public void setTradeDao(TradeDao tradeDao) {
		this.tradeDao = tradeDao;
	}

}
