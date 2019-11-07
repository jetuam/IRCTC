package com.example.Authentication.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Authentication.model.User;

@Repository
public interface UserDAO extends CrudRepository<User, String> {

	User findByUserIdAndPassword(String userId, String password);

}
