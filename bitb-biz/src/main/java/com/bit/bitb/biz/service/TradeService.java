package com.bit.bitb.biz.service;

import java.util.List;

import com.bit.bitb.biz.entity.Buying;
import com.bit.bitb.biz.entity.Deal;
import com.bit.bitb.biz.entity.Selling;

/**
 * 核心交易模块
 * @author jimmy.du
 * May 13, 2013
 */
public interface TradeService {

	/**
	 * 下单购买, 将调用match方法做匹配
	 * @param buying
	 * @return
	 */
	public List<Deal> buy(Buying buying);

	/**
	 * 下单出售，将调用match方法做匹配
	 * @param selling
	 * @return
	 */
	public List<Deal> sell(Selling selling);
	
	/**
	 * 根据购买订单寻找合适的卖家，达成交易意向，match成功则调finishDeal。失败则插入buying表
	 * @param buying
	 * @return
	 */
	public List<Deal> match(Buying buying);
	
	/**
	 * 根据出售订单寻找合适的买家，达成交易意向，match成功则调finishDeal。失败则插入selling表
	 * @param selling
	 * @return
	 */
	public List<Deal> match(Selling selling);
	
	/**
	 * 完成交易，包括向买卖双方收取交易费，将成功信息插入deal表。
	 * @param donedeal
	 * @return
	 */
	public boolean finishDeal(Deal donedeal);
	
	/**
	 * 定期移除过期的订单
	 */
	public void removeExpiredOffer();
	
}
