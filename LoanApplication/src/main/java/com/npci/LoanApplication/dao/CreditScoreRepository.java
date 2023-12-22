package com.npci.LoanApplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.npci.LoanApplication.entity.Credit_Score;
import com.npci.LoanApplication.entity.Employee;

@Repository
public interface CreditScoreRepository extends JpaRepository<Credit_Score, String> {

}
