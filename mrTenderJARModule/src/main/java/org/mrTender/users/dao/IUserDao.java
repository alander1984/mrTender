package org.mrTender.users.dao;

import org.mrTender.users.model.User;

public interface IUserDao {
	User findByUserName(String username);
}
