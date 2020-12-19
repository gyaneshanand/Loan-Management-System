package com.nucleus.repaymentschedule.controller;


import com.nucleus.repaymentschedule.model.LoanApplications;
import com.nucleus.repaymentschedule.model.RepaymentSchedules;
import com.nucleus.repaymentschedule.service.RepaymentScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.List;

@Controller
//@RequestMapping("/repaymentSchedule")
public class RepaymentScheduleController {

    @Autowired
    private RepaymentScheduleService repaymentScheduleService;


//    @GetMapping("/addRepaymentReport")
//    public void addRepaymentSchedule(@Valid @ModelAttribute LoanApplications loanApplications,
//                                     BindingResult result)
//    {
//        if(result.hasErrors())
//            return;
//        LoanApplications loanApplications=new LoanApplications();
//        loanApplications.setInstallmentDueDate("2020-01-03");
//        loanApplications.setLoanAmountRequested(300000);
//        loanApplications.setLoanApplicationNumber(2);
//        loanApplications.setProductCode("p1");
//        loanApplications.setTenure(6);
//        loanApplications.setRate(3.7);
//
//        int r=repaymentScheduleService.addRepaymentSchedule(loanApplications);
//        return;
//
//    }

    @GetMapping("/addRepaymentReport")
    public void addRepaymentSchedule()
    {

        LoanApplications loanApplications=new LoanApplications();
        loanApplications.setInstallmentDueDate("2020-01-03");
        loanApplications.setLoanAmountRequested(300000);
        loanApplications.setLoanApplicationNumber(3);
        loanApplications.setProductCode("p1");
        loanApplications.setTenure(6);
        loanApplications.setRate(3.7);

        int r=repaymentScheduleService.addRepaymentSchedule(loanApplications);
        return;

    }

    @GetMapping("/getLoanAppNo")
    public String showRepaymentScheduleForm(ModelMap map)
    {
//        int loanApplicationNumber=0;
    RepaymentSchedules repaymentSchedules=new RepaymentSchedules();
//        map.put("loanApplicationNumber",loanApplicationNumber);
        map.put("repaymentSchedules",repaymentSchedules);
        return "views/repaymentschedule/getLoanAppNo";

    }
    @PostMapping("/getLoanAppNo")
    public ModelAndView showRepaymentScheduleSubmit(@Valid @ModelAttribute RepaymentSchedules repaymentSchedules,
                                                    BindingResult result)
    {
        if(result.hasErrors())
        {

        }
        int loanApplicationNumber=repaymentSchedules.getLoanApplicationNumber();
        List<RepaymentSchedules> rslist=repaymentScheduleService.getRepaymentScheduleReport(loanApplicationNumber);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("views/repaymentschedule/showRepaymentReport");
        mv.addObject("rslist",rslist);
        return mv;

    }


}






//    @RequestMapping(value = "/getRepaymentSchedule", method = RequestMethod.GET)
//    public String getRepaymentSchedule(@RequestParam(value="loan_id", required=true) Integer id,
//                                       Model model ) {
//        model.addAttribute("loanIdAttribute",repaymentScheduleService.getRepaymentScheduleReport(id));
//        return "displaypage";
//    }

//    @PostMapping(value = "/addRepaymentSchedule", method = RequestMethod.POST)
//    public String add(@Valid LoanApplications loanApplications, BindingResult result, ModelMap map) {
//        if(result.hasErrors())
//            return "addpage";
//        int id = repaymentScheduleService.addRepaymentSchedule(loanApplications);
//        map.addAttribute("id",id);
//        return "addedpage";
//    }

//    @RequestMapping(path="/showRepaymentPolicy",method = RequestMethod.GET)
//    public ModelAndView showRepaymentSchedule()
//    {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("views/repaymentschedule/");
//        mv.addObject();
//        return mv;
//
//    }

//    @RequestMapping(value = "/newRepaymentPolicies/add", method = RequestMethod.GET)
//    public String getAdd(Model model) {
//
//        model.addAttribute("newRepaymentPolicy", new NewRepaymentPolicy());
//        return "views/repaymentpolicy/newRepaymentPolicyScreenMaker";
//    }
