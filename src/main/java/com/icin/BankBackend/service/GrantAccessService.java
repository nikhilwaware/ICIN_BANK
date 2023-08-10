package com.icin.BankBackend.service;

import java.util.List;

import com.icin.BankBackend.model.GrantAccess;

public interface GrantAccessService {

	public List<GrantAccess> getGrantAccess();
	
	public GrantAccess saveGrantAccess(GrantAccess theGrantAccess);
	
	public void deleteGrantAccess(Integer theId);
}
