package com.epfox.controller;

import com.epfox.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    public String list(){
        return "ok";
    }
}
