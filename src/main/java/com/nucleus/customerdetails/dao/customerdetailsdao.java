package com.nucleus.customerdetails.dao;

import com.nucleus.customer.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class customerdetailsdao implements customerdetailsdaointerface {
    @Autowired
    private SessionFactory sessionFactory;

    public Customer getcustomerdetails(String customerCode){
        Session session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class, customerCode);
        session.close();
        return customer;
    }
}


