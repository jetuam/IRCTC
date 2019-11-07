package com.example.Authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Authentication.dao.UserDAO;
import com.example.Authentication.exception.UserIdNotFoundException;
import com.example.Authentication.model.User;

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;

	int Id = (int) (Math.random()*Math.pow(10, 3)); ;

	public String userRegister(User user) {
		user.setUserId("USR" + Id);
		String userId = user.getUserId();
		userDAO.save(user);

		return userId;
	}

	public String userLogin(String userId, String password) {
		User user = userDAO.findByUserIdAndPassword(userId, password);
		if (user == null) {
			throw new UserIdNotFoundException(userId + " NotFound");
		}
		return "User has successfully logged in";

	}

}
