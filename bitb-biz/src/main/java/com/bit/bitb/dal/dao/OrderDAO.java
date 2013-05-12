package com.bit.bitb.dal.dao;

import com.bit.bitb.dal.dataobjects.OrderDO;

/**
 * 订单DAO.
 * 
 * @author simple56
 * 
 */
public interface OrderDAO {
	public boolean insert(OrderDO orderDO);

	public boolean update(OrderDO orderDO);

	public boolean delete(Long orderId);

	public OrderDO queryById(Long id);
}
