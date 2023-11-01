package com.cokicoki.mvc03.controller;

import com.cokicoki.mvc03.model.CustomerModel;
import com.cokicoki.mvc03.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("customer/index");
        // get data from service
        List<CustomerModel> data = service.gets();

        view.addObject("listData", data);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView addCustomer(){
        ModelAndView view = new ModelAndView("customer/add");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView saveCustomer(CustomerModel request){
        // call save from service
        service.save(request);
        // redirect to index
        return new ModelAndView("redirect:/customer");
    }
}
