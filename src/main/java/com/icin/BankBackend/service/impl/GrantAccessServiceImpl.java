package com.icin.BankBackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.BankBackend.model.GrantAccess;
import com.icin.BankBackend.repo.GrantAccessRepository;
import com.icin.BankBackend.service.GrantAccessService;

@Service
public class GrantAccessServiceImpl implements GrantAccessService{

	@Autowired
	private GrantAccessRepository grantAccessRepository;

	@Override
	public List<GrantAccess> getGrantAccess() {
		return grantAccessRepository.findAll();
	}

	@Override
	public GrantAccess saveGrantAccess(GrantAccess theGrantAccess) {
		return grantAccessRepository.save(theGrantAccess);
	}

	@Override
	public void deleteGrantAccess(Integer theId) {
		 grantAccessRepository.deleteById(theId);
		
	}
}
