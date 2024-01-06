package com.userService.co.service;

import java.util.List;

import com.userService.co.entities.User;
import com.userService.co.exceptions.ResourceNotFoundEx;

public interface UserService {

	public User saveUser(User user);

	public List<User> getUsers();

	// public User addUser(User c);

	public User updateUser(User c);

	public User getUserbyID(String ID) throws ResourceNotFoundEx;

	public void deleteUser(String c);

}
