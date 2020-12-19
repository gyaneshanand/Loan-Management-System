package com.nucleus.repaymentschedule.service;


import com.nucleus.repaymentschedule.model.LoanApplications;
import com.nucleus.repaymentschedule.dao.RepaymentScheduleDAO;
import com.nucleus.repaymentschedule.model.RepaymentSchedules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import java.net.ServerSocket;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RepaymentScheduleServiceImpl implements RepaymentScheduleService{

    @Autowired
    private RepaymentScheduleDAO repaymentScheduleDAO;

    @Autowired
    private PlatformTransactionManager transactionManager;

    private TransactionTemplate transactionTemplate;


    @PostConstruct
    public void init() {
        transactionTemplate = new TransactionTemplate(transactionManager);
    }

    static LocalDate returnDate(String date) {
        LocalDate dt = LocalDate.parse(date);
        return dt;
    }

//    @Override
//    public int addRepaymentSchedule(LoanApplications loanApplications) {
//        int id = 	transactionTemplate.execute(new TransactionCallback<Integer>() {
//            @Override
//            public Integer doInTransaction(TransactionStatus status) {
//
//                int id = repaymentScheduleDAO.addRepaymentSchedule(repaymentSchedules);
//
//                return id;
//            }
//
//        });
//
////	int id = 	transactionTemplate.execute(status->{ return employeeDao.add(employee);});
//        System.out.println(id);
////		 employeeDao.add(employee);
//        return id;
//
//    }

    @Override
    public List<RepaymentSchedules> getRepaymentScheduleReport(int loanApplicationNumber) {
        List<RepaymentSchedules> repaymentScheduleReport = repaymentScheduleDAO.getRepaymentScheduleReport(loanApplicationNumber);
        return repaymentScheduleReport;
    }

    @Override
    public int addRepaymentSchedule(LoanApplications loanApplications) {

        int loanApplicationNumber=loanApplications.getLoanApplicationNumber();
        String productCode=loanApplications.getProductCode();
        double loanAmountRequested=loanApplications.getLoanAmountRequested();
        int tenure=loanApplications.getTenure();
        double rate= loanApplications.getRate();
        String installmentDueDate = loanApplications.getInstallmentDueDate();

        List<RepaymentSchedules> repaymentSchedules=generateRepaymentSchedule(loanApplicationNumber, rate,loanAmountRequested,tenure,
                installmentDueDate);
        for(int i=0;i<repaymentSchedules.size();i++){
            System.out.println("+++++++++++++++++++++");
            System.out.println(repaymentSchedules.get(i).getLoanApplicationNumber());
            System.out.println(repaymentSchedules.get(i).getBillFlag());
            System.out.println(repaymentSchedules.get(i).getClosingBalance());
            System.out.println(repaymentSchedules.get(i).getDueDate());
            System.out.println(repaymentSchedules.get(i).getEmi());
            System.out.println(repaymentSchedules.get(i).getInstallmentNumber());
            System.out.println(repaymentSchedules.get(i).getInterestComponent());
            System.out.println(repaymentSchedules.get(i).getPrincipalComponent());
            System.out.println(repaymentSchedules.get(i).getOpeningBalance());

        }
//        RepaymentSchedules repaymentSchedules1=new RepaymentSchedules();
//
//        repaymentSchedules1.setLoanApplicationNumber(3);
//        repaymentSchedules1.setInstallmentNumber(1);
//        repaymentSchedules1.setOpeningBalance(400000.0);
//        repaymentSchedules1.setInterestComponent(400000.0);
//        repaymentSchedules1.setPrincipalComponent(400000.0);
//        repaymentSchedules1.setClosingBalance(400000.0);
//        repaymentSchedules1.setBillFlag("F");
//        repaymentSchedules1.setDueDate(returnDate("2020-01-03"));
//        repaymentSchedules1.setEmi(400000.0);
//        int r=repaymentScheduleDAO.addRepaymentSchedule(repaymentSchedules1);
        int r=0;
        for(int i=0;i<repaymentSchedules.size();i++){
            repaymentScheduleDAO.addRepaymentSchedule(repaymentSchedules.get(i));
        }


//        return repaymentScheduleDAO.addRepaymentSchedule(repaymentSchedules);
        return r;
    }
    Double calculateEMI(double rate,double loanAmount,int tenure,int numberOfInstallment,
                        double residualValue){
        Double r = (rate/numberOfInstallment);

        Double num = loanAmount*r - ((residualValue*r)/Math.pow(1+r,tenure));
        Double den= 1 - (1/Math.pow(1+r,tenure));

        double installmentAmt=num/den;

        return Double.parseDouble(String.format("%.2f", installmentAmt));

    }

    List<RepaymentSchedules> generateRepaymentSchedule(int loanApplicationNumber, double rate,double loanAmount, int tenure,
                                                       String installmentDueDate) {
        int numberOfInstallment=12;
        Double residualValue = 0.0;
        Double installmentAmt=calculateEMI(rate,loanAmount,tenure,numberOfInstallment,50000.0);
        int size = (int) (numberOfInstallment * tenure);
        Integer installmentNumber;
        Double principalComp;
        Double interestComp;
        Double openingBalance;
        Double closingBalance;
        double outPrincipalAmt = loanAmount;
        ArrayList<RepaymentSchedules> repaymentSchedules=new ArrayList<RepaymentSchedules>();

        for (int i = 0; i < size && outPrincipalAmt > installmentAmt; i++) {

            installmentNumber=i+1;
            openingBalance=outPrincipalAmt;
            interestComp = outPrincipalAmt * rate / 12;
            principalComp = installmentAmt - interestComp;
            outPrincipalAmt -= principalComp;
            closingBalance =outPrincipalAmt;

            RepaymentSchedules repaymentSchedules1=new RepaymentSchedules();

            repaymentSchedules1.setLoanApplicationNumber(loanApplicationNumber);
            repaymentSchedules1.setInstallmentNumber(installmentNumber);
            repaymentSchedules1.setOpeningBalance(openingBalance);
            repaymentSchedules1.setInterestComponent(interestComp);
            repaymentSchedules1.setPrincipalComponent(principalComp);
            repaymentSchedules1.setClosingBalance(closingBalance);
            repaymentSchedules1.setBillFlag("F");
            repaymentSchedules1.setDueDate(installmentDueDate);
            repaymentSchedules1.setEmi(installmentAmt);

            repaymentSchedules.add(repaymentSchedules1);
        }
        return repaymentSchedules;
    }


}



//    Integer installmentNumber[] = new Integer[size];
//    Double principalComp[] = new Double[size];
//    Double emi[] = new Double[size];
//    Double interestComp[] = new Double[size];
//    Double openingBalance[] =new Double[size];
//    Double closingBalance[] =new Double[size];
//    double outPrincipalAmt = loanAmount;
//    RepaymentSchedules[] repaymentSchedules=new RepaymentSchedules[size];
//        LocalDate agreement_date=loanApplications.getAgreement_date();
//        LocalDate createDate=loanApplications.getCreateDate();
//        String createdBy = loanApplications.getCreatedBy();
//        LocalDate modifiedDate = loanApplications.getModifiedDate();
//        String modifiedBy = loanApplications.getModifiedBy();
//        LocalDate authorizedDate = loanApplications.getAuthorizedDate();
//        String authorizedBy = loanApplications.getAuthorizedBy();