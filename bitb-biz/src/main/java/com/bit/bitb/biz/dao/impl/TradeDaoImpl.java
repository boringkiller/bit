package com.bit.bitb.biz.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bit.bitb.biz.dao.TradeDao;
import com.bit.bitb.biz.entity.Buying;
import com.bit.bitb.biz.entity.Deal;
import com.bit.bitb.biz.entity.Selling;

public class TradeDaoImpl implements TradeDao {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Selling> match(Buying buying) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from Selling where price <" + buying.getPrice() +" order by create_ts");
		@SuppressWarnings("unchecked")
		List<Selling> sellings = query.list();
		session.close();
		return sellings;
	}


	@Override
	public void insertBuying(Buying buying) {
		Session session = this.sessionFactory.openSession();
		session.save(buying);
		session.close();
	}

	@Override
	public void updateSelling(Selling selling) {
		Session session = this.sessionFactory.openSession();
		session.update(selling);
		session.close();
	}

	@Override
	public void deleteSelling(String idselling) {
		Session session = this.sessionFactory.openSession();
		session.createQuery("delete from Selling where idselling = "+idselling).executeUpdate();
		session.close();
	}

	@Override
	public void deleteBuying(String idbuying) {
		Session session = this.sessionFactory.openSession();
		session.createQuery("delete from Buying where idselling = "+idbuying).executeUpdate();
		session.close();		
	}

	@Override
	public void insertDeal(Deal deal) {
		Session session = this.sessionFactory.openSession();
		session.save(deal);
		session.close();
	}

	@Override
	public List<Buying> match(Selling selling) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from Buying where price >" + selling.getPrice() +" order by create_ts");
		@SuppressWarnings("unchecked")
		List<Buying> buyings = query.list();
		session.close();
		return buyings;
	}

	@Override
	public void insertSelling(Selling selling) {
		Session session = this.sessionFactory.openSession();
		session.save(selling);
		session.close();
	}

	@Override
	public void updateBuying(Buying buying) {
		Session session = this.sessionFactory.openSession();
		session.update(buying);
		session.close();
	}


}
