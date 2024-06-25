package com.employeemanagement.manage_employee.controller;

import com.employeemanagement.manage_employee.ManageEmployeeApplication;
import com.employeemanagement.manage_employee.entity.EmployeeDetails;
import com.employeemanagement.manage_employee.entity.ManagerDetails;
import com.employeemanagement.manage_employee.repository.AdminInfo;
import com.employeemanagement.manage_employee.repository.EmployeeInfo;
import com.employeemanagement.manage_employee.repository.ManagerInfo;
import com.employeemanagement.manage_employee.repository.WorkInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.logging.Logger;


@RestController
@RequestMapping("/add-employee")
public class EmployeeController {
    Logger logger = Logger.getLogger(ManageEmployeeApplication.class.getName());
    @Autowired
    private EmployeeInfo employeeInfo;
    @Autowired
    private ManagerInfo manager;
    @Autowired
    private AdminInfo admin;
    @Autowired
    private WorkInfo work;

//    Adding a new employee to the database
    @PostMapping
    public EmployeeDetails addEmployee(@RequestBody EmployeeDetails employeeDetails) {
        Date date = new Date();
        employeeDetails.setDate_of_joining(date);
        employeeInfo.save(employeeDetails);
        return employeeDetails;

    }
//    Fetching all the employees from the database
    @GetMapping
    public Iterable<EmployeeDetails> getEmployee() {
        return employeeInfo.findAll();
    }


//    Fetching a manager details using employee id (checking if manager exists for a given employee id)
    @GetMapping("/{id}")
    public EmployeeDetails getEmployeeById(@PathVariable("id") String id) {

        EmployeeDetails emp = employeeInfo.findById(id).get();
        logger.info("Manager Details fetched Successfully");
        return  emp;

    }

//    Adding a manager to an employee using manager id and employee id
    @PutMapping("/{mng_id}/{emp_id}")
    public EmployeeDetails addManagerToEmployee( @PathVariable("mng_id") String mngid,@PathVariable("emp_id") String empid) {
        ManagerDetails mng = manager.findById(mngid).get();
        EmployeeDetails employee = employeeInfo.findById(empid).get();
        employee.setManagerDetails(mng);
        employeeInfo.save(employee);
        return employee;
    }

//   Deleting an employee using employee id
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") String id) {
        employeeInfo.deleteById(id);

        logger.info("Employee Deleted Successfully");
        return "Employee deleted";
    }

}