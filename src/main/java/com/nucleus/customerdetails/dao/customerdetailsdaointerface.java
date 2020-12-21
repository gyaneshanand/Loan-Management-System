package com.nucleus.customerdetails.dao;
import com.nucleus.customer.model.Customer;
import org.hibernate.Session;

public interface customerdetailsdaointerface {
    public Customer getcustomerdetails(String customerCode);
}
