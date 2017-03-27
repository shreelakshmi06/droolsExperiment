package com.shre.drools.services;

import com.shre.drools.dto.EmployeeDesignation;
import com.shre.drools.facts.Employeefact;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private  KieContainer kieContainer;

    public EmployeeDesignation getDesignation(Employeefact empFact) {
        KieSession kieSession = kieContainer.newKieSession("employeeDesignationSession");
        kieSession.insert(empFact);
        kieSession.fireAllRules();

        EmployeeDesignation eDesignation = findEmployeeDesignation(kieSession);
        kieSession.dispose();
        return eDesignation;
        //code for applying rule sheet

    }
//    public EmployeeDesignation getEmployeeDesignation(Person person) {
//        KieSession kieSession = kieContainer.newKieSession("BusPassSession");
//        kieSession.insert(person);
//        kieSession.fireAllRules();
//        BusPass busPass = findBusPass(kieSession);
//        kieSession.dispose();
//        return busPass;
//    }


}
