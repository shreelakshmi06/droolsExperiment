package com.shre.drools.services;

import com.shre.drools.dto.EmployeeDesignation;
import com.shre.drools.facts.Employeefact;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
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
        kieSession.addEventListener( new DebugRuleRuntimeEventListener() );
        kieSession.insert(empFact);
        kieSession.fireAllRules();
        EmployeeDesignation eDesignation = new EmployeeDesignation();
       // EmployeeDesignation eDesignation = findEmployeeDesignation(kieSession);
        System.out.println(eDesignation);
        System.out.println(empFact);
        kieSession.dispose();
        return eDesignation;
        //code for applying rule sheet

    }

}