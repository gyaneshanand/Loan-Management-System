package com.nucleus.loanaplications.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "loan_application")
public class LoanApplications {

    @Id
    @Column(name = "loan_application_number")
    private int loanApplicationNumber;

    @Column(name = "product_code", nullable = false)
    private String productCode;

    @Column(name = "loan_amount_requested", nullable = false)
    private double loanAmountRequested;

    @Column(name = "tenure", nullable = false)
    private int tenure;

    @Column(name = "rate", nullable = false)
    private double rate;

//    @Column(name = "agreement_date", nullable = false)
//    private String agreement_date;

    @Column(name = "installment_due_date", nullable = false)
    private String installmentDueDate;

//    @Column(name = "create_date", nullable = false)
//    private String createDate;
//
//    @Column(name = "created_by", nullable = false, length = 30)
//    private String createdBy;
//
//    @Column(name = "modified_date", nullable = false)
//    private String modifiedDate;

    public int getLoanApplicationNumber() {
        return loanApplicationNumber;
    }

    public void setLoanApplicationNumber(int loanApplicationNumber) {
        this.loanApplicationNumber = loanApplicationNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getLoanAmountRequested() {
        return loanAmountRequested;
    }

    public void setLoanAmountRequested(double loanAmountRequested) {
        this.loanAmountRequested = loanAmountRequested;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

//    public String getAgreement_date() {
//        return agreement_date;
//    }
//
//    public void setAgreement_date(String agreement_date) {
//        this.agreement_date = agreement_date;
//    }

    public String getInstallmentDueDate() {
        return installmentDueDate;
    }

    public void setInstallmentDueDate(String installmentDueDate) {
        this.installmentDueDate = installmentDueDate;
    }

//    public String getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(String createDate) {
//        this.createDate = createDate;
//    }
//
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public String getModifiedDate() {
//        return modifiedDate;
//    }
//
//    public void setModifiedDate(String modifiedDate) {
//        this.modifiedDate = modifiedDate;
//    }

//    public String getModifiedBy() {
//        return modifiedBy;
//    }
//
//    public void setModifiedBy(String modifiedBy) {
//        this.modifiedBy = modifiedBy;
//    }
//
//    public String getAuthorizedDate() {
//        return authorizedDate;
//    }
//
//    public void setAuthorizedDate(String authorizedDate) {
//        this.authorizedDate = authorizedDate;
//    }
//
//    public String getAuthorizedBy() {
//        return authorizedBy;
//    }
//
//    public void setAuthorizedBy(String authorizedBy) {
//        this.authorizedBy = authorizedBy;
//    }
//
//    @Column(name = "modified_by", nullable = false, length = 30)
//    private String modifiedBy;
//
//    @Column(name = "authorized_date", nullable = false)
//    private String authorizedDate;
//
//    @Column(name = "authorized_by", nullable = false, length = 30)
//    private String authorizedBy;

}
