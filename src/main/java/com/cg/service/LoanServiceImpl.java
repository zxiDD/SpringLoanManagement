package com.cg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Loan;
import com.cg.exception.LoanNotFoundException;
import com.cg.exception.DuplicateLoanApplicationException;
import com.cg.exception.InvalidLoanAmountException;
import com.cg.repo.LoanRepository;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanRepository loanRepo;

	@Override
	public Loan addLoan(Loan loan) {
		if (loan.getLoanAmount() <= 0 || loan.getLoanAmount() > 50_00_000.0) {
			throw new InvalidLoanAmountException(
					"Loan amount cannot be less than or equal to 0 or greater than 50,00,000");
		}

		Optional<Loan> pendingLoan = loanRepo.findByApplicantNameAndStatus(loan.getApplicantName(), "PENDING");
		if (pendingLoan.isPresent()) {
			throw new DuplicateLoanApplicationException("You already have a pending loan application");
		}
		loan.setStatus("PENDING");
		Loan savedLoan = loanRepo.save(loan);

		return savedLoan;
	}

	@Override
	public Loan updateLoan(Long id, String status) {
		Optional<Loan> optLoan = loanRepo.findById(id);
		if (optLoan.isEmpty()) {
			throw new LoanNotFoundException("Loan not found with the given Id");
		}
		Loan loan = optLoan.get();
		loan.setStatus(status);
		Loan savedLoan = loanRepo.save(loan);
		return savedLoan;
	}
}
