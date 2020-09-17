package com.epfox.controller;

import com.epfox.dao.DepartmentDao;
import com.epfox.dao.EmployeeDao;
import com.epfox.pojo.Department;
import com.epfox.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getall();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddpage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("save=>"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id, Model model){
        System.out.println("id=>"+id);
        Employee employee = employeeDao.getEmployeeById(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        model.addAttribute("emp",employee);
        return "emp/update";
    }
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
