package com.quickPay.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.quickPay.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	public User findByUuid(String uuid);
}



