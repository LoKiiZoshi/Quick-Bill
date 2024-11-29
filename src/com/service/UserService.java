package com.service;
import java.util.List;
import com.model.Product;
import com.model.User;
import com.model.User2Login;
import com.model.UserLogin;

public interface UserService {
	List<User> getAllUser();
	void addUserLogin(UserLogin us);
	void addUser(User user);
	void addUseru2Login(User2Login u2);
	void addUser2Login(User2Login u2);
	List<Product> getAllProductinfo();

}