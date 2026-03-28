package com.cg.service;

import com.cg.entity.Loan;

public interface LoanService {
	Loan addLoan(Loan loan);
	Loan updateLoan(Long id, String status);
}
