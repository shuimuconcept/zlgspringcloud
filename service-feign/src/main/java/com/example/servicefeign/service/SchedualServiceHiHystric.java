package com.example.servicefeign.service;

import com.example.servicefeign.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        System.out.println("namekkk");
        return "sorry "+name;
    }
}
