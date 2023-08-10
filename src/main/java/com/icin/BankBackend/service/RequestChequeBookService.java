package com.icin.BankBackend.service;

import java.util.List;

import com.icin.BankBackend.model.RequestChequeBook;

public interface RequestChequeBookService {

	public RequestChequeBook saveChequeBook(RequestChequeBook rcb);
	
	public List<RequestChequeBook> getAllChequeBook();
	
	public RequestChequeBook getById(Integer id);
	
	public void updateChequeBook(RequestChequeBook rcb);
	
	public void deleteChequeBookRequest(Integer id);
}
