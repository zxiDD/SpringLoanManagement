package com.cg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "abes_loan")
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loan_id")
	private Long loanId;

	@Column(name = "applicant_name", length = 45, nullable = false)
	@NotBlank(message = "applicant name cannot be empty")
	private String applicantName;

	@Column(name = "loan_amount")
	private double loanAmount;

	@Column(name = "status", length = 10)
	private String status;

	public Loan() {

	}

	public Loan(Long loanId, String applicantName, double loanAmount, String status) {
		this.loanId = loanId;
		this.applicantName = applicantName;
		this.loanAmount = loanAmount;
		this.status = status;
	}

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", applicantName=" + applicantName + ", loanAmount=" + loanAmount
				+ ", status=" + status + "]";
	}

}
