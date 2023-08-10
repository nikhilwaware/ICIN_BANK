package com.icin.BankBackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.BankBackend.model.UserTransactions;
import com.icin.BankBackend.repo.UserTransactionsRepository;
import com.icin.BankBackend.service.UserTransactionsService;

@Service
public class UserTransactionsServiceImpl implements UserTransactionsService{

	@Autowired
	private UserTransactionsRepository userTransactionsRepository;

	@Override
	public List<UserTransactions> getUserTransactions() {
		// TODO Auto-generated method stub
		return userTransactionsRepository.findAll();
	}

	@Override
	public UserTransactions saveUserTransactions(UserTransactions theUserTransactions) {
		// TODO Auto-generated method stub
		return userTransactionsRepository.save(theUserTransactions);
	}

	@Override
	public UserTransactions getUserTransactions(Integer theId) {
		// TODO Auto-generated method stub
		return userTransactionsRepository.findById(theId).get();
	}

	@Override
	public void deleteUserTransactions(Integer theId) {
		userTransactionsRepository.deleteById(theId);	
	}

	@Override
	public List<UserTransactions> getUserTransactions(String accountNumber) {
		// TODO Auto-generated method stub
		return userTransactionsRepository.getUserTransactionsByAccountNumber(accountNumber);
	}
}
