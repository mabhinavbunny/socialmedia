package com.ums.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Component;

import com.ums.Dao.UserDao;
import com.ums.beans.User;
import com.ums.exceptions.UserException;

@Persistent
@Component
public class UserModel {
	
	@Autowired
	UserDao userDao;
	
	public User saveUser(User user) throws UserException {
		
		if(!userDao.findById(user.getEmail()).isEmpty()) {
			throw new UserException("User already exists");
		}
		userDao.save(user);
		return userDao.findById(user.getEmail()).get();
	}
	public List<User> getUsers(){
		return (List<User>) userDao.findAll();
	}
	public User getUser(String emailId) {
		return userDao.findById(emailId).get();
	}
	public void updateUser(User user) {
		userDao.save(user);
	}
}
