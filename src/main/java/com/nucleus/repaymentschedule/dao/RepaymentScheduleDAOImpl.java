package com.nucleus.repaymentschedule.dao;

import com.nucleus.repaymentschedule.model.RepaymentSchedules;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Repository

public class RepaymentScheduleDAOImpl implements RepaymentScheduleDAO{

    @Autowired
    private SessionFactory sessionFactory;

    static LocalDate returnDate(String date) {
        LocalDate dt = LocalDate.parse(date);
        return dt;
    }

@Override
@Transactional(propagation=Propagation.REQUIRED)
public List<RepaymentSchedules> getRepaymentScheduleReport(int loanApplicationNumber) {
    Session session = sessionFactory.openSession();
//    RepaymentSchedules rslist = session.get(RepaymentSchedules.class,loanApplicationNumber);
//    List<RepaymentSchedules> rslist = session.createQuery("from RepaymentSchedules").list();
    session.beginTransaction();
    Query query = session.createQuery("from RepaymentSchedules where loanApplicationNumber = :code ");
    query.setParameter("code", loanApplicationNumber);
    List<RepaymentSchedules> rslist = query.getResultList();
    session.getTransaction().commit();
    session.close();
    return rslist;
}



    //RepaymentSchedules repaymentSchedules
    @Override
    public int addRepaymentSchedule(RepaymentSchedules repaymentSchedules) {
        Integer id;

        try {
        Session session = sessionFactory.openSession();
         session.beginTransaction();
         session.save(repaymentSchedules);
         session.getTransaction().commit();
        session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
