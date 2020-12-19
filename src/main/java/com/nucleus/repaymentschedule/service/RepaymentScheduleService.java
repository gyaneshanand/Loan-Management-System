package com.nucleus.repaymentschedule.service;

import com.nucleus.loanaplications.model.LoanApplications;
import com.nucleus.repaymentschedule.model.RepaymentSchedules;

import java.util.List;

public interface RepaymentScheduleService {


    public List<RepaymentSchedules> getRepaymentScheduleReport(int loanApplicationNumber) ;
    public int addRepaymentSchedule(LoanApplications loanApplications) ;

}
