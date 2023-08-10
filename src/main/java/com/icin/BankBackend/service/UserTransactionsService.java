package com.icin.BankBackend.service;

import java.util.List;

import com.icin.BankBackend.model.UserTransactions;

public interface UserTransactionsService {

	public List<UserTransactions> getUserTransactions();
	
	public UserTransactions saveUserTransactions(UserTransactions theUserTransactions);
	
	public UserTransactions getUserTransactions(Integer theId);
	
	public void deleteUserTransactions(Integer theId);
	
	public List<UserTransactions> getUserTransactions(String accountNumber);
}
