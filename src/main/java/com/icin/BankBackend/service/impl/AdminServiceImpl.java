package com.icin.BankBackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.BankBackend.model.Admin;
import com.icin.BankBackend.repo.AdminRepository;
import com.icin.BankBackend.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository repo;

	@Override
	public Admin saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return repo.save(admin);
	}

	@Override
	public Admin adminLogin(String email, String password) {
		// TODO Auto-generated method stub
		return repo.findByEmailAndPassword(email, password);
	}

	@Override
	public Admin getAdmin(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmail(email);
	}

	@Override
	public void updatePassword(Admin admin) {
		// TODO Auto-generated method stub
		if(repo.findByEmail(admin.getEmail())!=null) {
			repo.save(admin);
		}
	}

}
