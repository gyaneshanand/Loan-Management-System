package com.nucleus.repaymentschedule.dao;

import com.nucleus.loanaplications.model.LoanApplications;
import com.nucleus.repaymentschedule.model.RepaymentSchedules;

import java.util.List;


public interface RepaymentScheduleDAO {
    public List<RepaymentSchedules> getRepaymentScheduleReport(int loanApplicationNumber);
    public int addRepaymentSchedule(RepaymentSchedules repaymentSchedules) ;

    //RepaymentSchedules repaymentSchedules
//    int addRepaymentSchedule();
}


