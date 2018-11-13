package com.scb.ga.dao.mybatis;

import com.scb.ga.domain.User;

/**
 * @author David Wang
 *
 */
public interface UserDao {

	public User findByUserName(String username);
}
