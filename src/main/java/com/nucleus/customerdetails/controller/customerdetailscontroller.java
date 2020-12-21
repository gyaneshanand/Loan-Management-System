package com.nucleus.customerdetails.controller;
import com.nucleus.customer.model.Customer;
import com.nucleus.customerdetails.service.customerdetailsservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class customerdetailscontroller {

        @Autowired
        private customerdetailsservice customerdetailsservice;

        @GetMapping(value = {"/customerdetailsform" })
        public ModelAndView productOverview() {
            ModelAndView modelAndView = new ModelAndView("views/customerdetails/customerdetailsform");
            return modelAndView;
        }

        @GetMapping(path = "/customerdetails")
        public ModelAndView getLoanDisbursals(@RequestParam("customerCode") String customerCode){
            Customer customer=customerdetailsservice.getCustomerDetails(customerCode);
            if(customer==null){
                return new ModelAndView("views/customerdetails/ErrorPage", "Message", "Customer NOT found: "+ customerCode);
        }
            return new ModelAndView("views/customerdetails/customerdetailsview", "customerObj", customer);
    }
}




