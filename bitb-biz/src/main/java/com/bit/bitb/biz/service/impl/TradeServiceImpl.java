package com.bit.bitb.biz.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bit.bitb.biz.dao.TradeDao;
import com.bit.bitb.biz.entity.Buying;
import com.bit.bitb.biz.entity.Deal;
import com.bit.bitb.biz.entity.Selling;
import com.bit.bitb.biz.service.TradeService;

public class TradeServiceImpl implements TradeService {

	private TradeDao tradeDao;
	
	
	@Override
	public List<Deal> buy(Buying buying) {
		List<Deal> deals = match(buying);
		return deals;
	}

	@Override
	public List<Deal> sell(Selling selling) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Deal> match(Buying buying) {
			List<Deal> deals = new ArrayList<Deal>();
			List<Selling> sellings = tradeDao.match(buying);
			Selling leftSelling = null;
			for (Selling selling : sellings) {
				if (buying.getQuantity() != null && Double.valueOf(buying.getQuantity()) > 0) {
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
						}
					}
					
					Deal deal = new Deal();
					deal.setBuyer(buying.getBuyer());
					deal.setCreateTs(new Date());
					deal.setIdbuying(buying.getIdbuying());
					deal.setIdselling(selling.getIdselling());
					deal.setInitiator(buying.getBuyer());
					deal.setMemo("");
					deal.setModifyTs(null);
					deal.setPrice(buying.getPrice());
					deal.setQuantity(qtyDouble.toString());
					deal.setSeller(selling.getSeller());
					
					deals.add(deal);
					
				} else {
					//卖方还有多
					break;
				}
			}
			
			for (Deal deal : deals) {
				finishDeal(deal); //匹配成功
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean finishDeal(Deal donedeal) {
		// TODO Auto-generated method stub
		return false;
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
