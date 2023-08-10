package com.icin.BankBackend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icin.BankBackend.model.GrantAccess;

@Repository
public interface GrantAccessRepository extends JpaRepository<GrantAccess, Integer>{

	List<GrantAccess> findGrantAccessByAction(String action);
}
