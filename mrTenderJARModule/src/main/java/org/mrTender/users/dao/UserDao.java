package org.mrTender.users.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.mrTender.users.model.User;

public class UserDao implements IUserDao {

	private SessionFactory sessionFactory;
	
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();

		users = getSessionFactory().getCurrentSession()
			.createQuery("from User where username=?")
			.setParameter(0, username).list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
