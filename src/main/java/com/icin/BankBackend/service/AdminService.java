package com.icin.BankBackend.service;

import com.icin.BankBackend.model.Admin;

public interface AdminService {

	public Admin saveAdmin(Admin admin);
	
	public Admin adminLogin(String email, String password);
	
	public Admin getAdmin(String email);
	
	public void updatePassword(Admin admin);
	
}
