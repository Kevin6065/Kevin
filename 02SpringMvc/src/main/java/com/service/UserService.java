package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.UserDao;
import com.entity.UserEntity;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public boolean checklogin(String username ,String password ) {
		
		//呼叫  Dao/Repository;
		
		UserEntity user=userDao.findByUsernameAndPassword(username, password);
		
		//return user != null;
		if (user != null) {
			return true;
		} else {
			return false;
		}
		
		
		
	}
	
	public void addUser(String username ,String password) {
		UserEntity entity =new UserEntity();
		entity.setUsername(username);
		entity.setPassword(password);
		
		userDao.addUser(entity);
	}
}
