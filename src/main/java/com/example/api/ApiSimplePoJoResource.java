package com.example.api;


import com.example.springaop.pojos.SimplePoJo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ApiSimplePoJoResource {
    private static final Logger logger = Logger.getLogger(ApiSimplePoJoResource.class.getName());
    @Autowired
    SimplePoJo simplePojo;


    @GetMapping("/getSimplePojoName")
    public String getSimplePojoName() {
      return   simplePojo.getName();

    }

    @PostMapping("/setSimplePojoName")
    public String setSimplePojoName(@RequestParam String name) {
        try {
            simplePojo.setName(name);
        }
        catch(Exception Ex){logger.log(Level.SEVERE,Ex.getMessage(),Ex);}
      return simplePojo.getName();
    }

}
