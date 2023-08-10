package com.icin.BankBackend.service;

import java.util.List;

import com.icin.BankBackend.model.User;

public interface UserService {

	public User saveUser(User user);
	
	public User getUser(String accountNumber, String password);
	
	public User getUser(Integer id);
	
	public boolean updateUserBalance(String accountNumber,Long balance);
	
	public User getUserByAccountNumber(String accountNumber);

	public void updateUserBalance(User user);
	
	public List<User> getAllUser();
	
	public void deleteUser(Integer id);
}
