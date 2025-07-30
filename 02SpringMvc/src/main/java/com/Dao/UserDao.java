package com.Dao;

import com.entity.UserEntity;

public interface UserDao {

	//Read
	public UserEntity findByUsernameAndPassword(String username,String password);
	
	
	//Create
	
	public void addUser(UserEntity userEntity);
	
	
	//Update
	
	public void updateUser(UserEntity userEnity);
	
	
	//Delete
	public void delUser(UserEntity userEnity);
}
