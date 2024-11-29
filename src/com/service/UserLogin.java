package com.service;

import java.util.List;

import com.model.User;

public interface UserLogin {
	void addUserLogin(UserLogin us);

	void deleteUserLogin(int id);

	List<User> getAllUserLogin();
}
