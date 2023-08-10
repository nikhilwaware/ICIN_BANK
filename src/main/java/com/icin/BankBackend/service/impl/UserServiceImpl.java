package com.icin.BankBackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.BankBackend.model.User;
import com.icin.BankBackend.repo.UserRepository;
import com.icin.BankBackend.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	@Override
	public User getUser(String accountNumber, String password) {
		// TODO Auto-generated method stub
		return repo.findUserByAccountNumberAndPassword(accountNumber, password);
	}

	@Override
	public User getUser(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public boolean updateUserBalance(String accountNumber,Long balance) {
		int u=repo.setUserInfoByAccountNumber(accountNumber, balance);
		return u>0;
	}

	@Override
	public User getUserByAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		return repo.findUserByAccountNumber(accountNumber);
	}

	@Override
	public void updateUserBalance(User user) {
		if(repo.findUserByAccountNumber(user.getAccountNumber()) != null) {
			repo.save(user);
		}	
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
}
