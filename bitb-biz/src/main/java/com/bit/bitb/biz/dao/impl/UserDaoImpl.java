package com.bit.bitb.biz.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bit.bitb.biz.dao.UserDao;
import com.bit.bitb.biz.entity.User;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	
	@Override
	public void updateUser(User user) {
		Session session = sessionFactory.openSession();
		session.update(user);
		session.close();
	}

	@Override
	public User getUserById(String userId) {
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, userId);
		session.close();
		return user;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
