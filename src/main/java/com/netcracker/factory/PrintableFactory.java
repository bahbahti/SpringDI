package com.netcracker.factory;

public class PrintableFactory {
    //static
    public static Printable getPrintable() {
        return new Car();
    }
    public Printable getPrintableNonStatic() {
        return new Train();
    }
}
