package com.shre.drools.controller;

import com.shre.drools.dto.EmployeeDesignation;
import com.shre.drools.facts.Employeefact;
import com.shre.drools.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        System.out.println("Constructor bean creation happened"+employeeService);
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/getDesignation",
            method = RequestMethod.GET, produces = "application/json")
    public EmployeeDesignation getEmployeeDesignation(
            @RequestParam(required = true) String name,
            @RequestParam(required = true) int age) {

        EmployeeDesignation eDesignation = new EmployeeDesignation();
        System.out.println("controller called"+eDesignation);

//        Person person = new Person(name, age);
//        log.debug("Bus pass request received for: " + person);
//        BusPass busPass = busPassService.getBusPass(person);

        Employeefact empFact = new Employeefact(name,age);
        eDesignation=employeeService.getDesignation(empFact);

        return eDesignation;
    }
}
