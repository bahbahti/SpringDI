package com.netcracker.lookupInjection;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class Passenger {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}