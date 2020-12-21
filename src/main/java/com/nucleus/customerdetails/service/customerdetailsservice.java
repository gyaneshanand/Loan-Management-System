package com.nucleus.customerdetails.service;
import com.nucleus.customer.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.nucleus.customerdetails.dao.customerdetailsdao;

@Service
public class customerdetailsservice {
    @Autowired
    private customerdetailsdao customerdao;

    public Customer getCustomerDetails(String customerCode){
        return customerdao.getcustomerdetails(customerCode);
    }

}


