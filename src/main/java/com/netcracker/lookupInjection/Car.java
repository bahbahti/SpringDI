package com.netcracker.lookupInjection;

public class Car {
    public Passenger createPassenger() {
        return null;
    };
    public String drive(String name) {
        Passenger passenger = createPassenger();
        passenger.setName(name);
        return "car with " + passenger.getName();
    }
}
