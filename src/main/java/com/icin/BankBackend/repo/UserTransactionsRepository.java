package com.icin.BankBackend.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icin.BankBackend.model.UserTransactions;

@Repository
public interface UserTransactionsRepository extends JpaRepository<UserTransactions, Integer>{
	
	List<UserTransactions> getUserTransactionsByAccountNumber(String accountNumber);

}
