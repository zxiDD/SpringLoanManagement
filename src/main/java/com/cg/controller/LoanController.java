package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Loan;
import com.cg.repo.LoanRepository;
import com.cg.service.LoanService;

import jakarta.validation.Valid;

@RestController
public class LoanController {
	@Autowired
	private LoanRepository loanRepo;

	@Autowired
	private LoanService loanService;

	@PostMapping("/loans")
	public ResponseEntity<Loan> applyLoan(@Valid @RequestBody Loan loan) {
		Loan bookedLoan = loanService.addLoan(loan);
		return new ResponseEntity<>(bookedLoan, HttpStatus.OK);
	}

	@GetMapping("/loans")
	public ResponseEntity<List<Loan>> getAllLoans() {
		List<Loan> lst = loanRepo.findAll();
		return new ResponseEntity<>(lst, HttpStatus.OK);
	}

	@GetMapping("/loans/{id}")
	public ResponseEntity<Loan> getLoanById(@Valid @PathVariable("id") Long loanId) {
		Loan loan = loanRepo.findById(loanId).get();
		return new ResponseEntity<>(loan, HttpStatus.OK);
	}

	@PutMapping("/loans/{id}/status")
	public ResponseEntity<Loan> updateBookingStatus(@Valid @PathVariable("id") Long loanId,
			@RequestParam String status) {
		Loan updatedLoan = loanService.updateLoan(loanId, status);
		return new ResponseEntity<>(updatedLoan, HttpStatus.OK);
	}
}
