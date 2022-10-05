package com.example.api;


import com.example.springaop.simpleops.SimpleOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ApiSimpleOperationsResource {
    private static final Logger logger = Logger.getLogger(ApiSimpleOperationsResource.class.getName());
    @Autowired
    SimpleOperations simpleOperations;

    @Autowired
    ApplicationContext ctx;


    @GetMapping("/getSomevar")
    public String getSomevar() {
        return simpleOperations.getSomevar();

    }

    @PostMapping("/setSomevar")
    public String setSomevar(@RequestParam String var) {
        try {
            simpleOperations.setSomevar(var);
        } catch (Exception Ex) {
            logger.log(Level.SEVERE, Ex.getMessage(), Ex);
        }
        return simpleOperations.getSomevar();
    }


    @PostMapping("/addsomenumbers")
    public int addSomenumbers(@RequestParam int a, @RequestParam int b) {
        int result = 0;
        try {
            simpleOperations.addsomenumbers(a, b);
        } catch (Exception Ex) {
            logger.log(Level.SEVERE, Ex.getMessage(), Ex);
        }
        return result;
    }
}
