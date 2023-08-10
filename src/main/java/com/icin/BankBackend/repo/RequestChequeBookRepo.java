package com.icin.BankBackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icin.BankBackend.model.RequestChequeBook;

@Repository
public interface RequestChequeBookRepo extends JpaRepository<RequestChequeBook, Integer> {

	public RequestChequeBook findByAccountNumber(String accountNumber);
}
