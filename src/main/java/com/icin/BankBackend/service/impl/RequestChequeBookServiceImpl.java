package com.icin.BankBackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.BankBackend.model.RequestChequeBook;
import com.icin.BankBackend.repo.RequestChequeBookRepo;
import com.icin.BankBackend.service.RequestChequeBookService;

@Service
public class RequestChequeBookServiceImpl implements RequestChequeBookService{

	@Autowired
	private RequestChequeBookRepo repo;

	@Override
	public RequestChequeBook saveChequeBook(RequestChequeBook rcb) {
		// TODO Auto-generated method stub
		return repo.save(rcb);
	}

	@Override
	public List<RequestChequeBook> getAllChequeBook() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void updateChequeBook(RequestChequeBook rcb) {
		// TODO Auto-generated method stub
		if(repo.findById(rcb.getId()).get() !=null) {
			repo.save(rcb);
		}
	}

	@Override
	public void deleteChequeBookRequest(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public RequestChequeBook getById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}
}
