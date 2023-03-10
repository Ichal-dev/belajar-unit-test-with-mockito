package com.chaldev.belajarunittestingmockito;

public class Person {

    public String getName(String name){
        return name;
    }

    public Throwable trouble(){
        return new RuntimeException("Exception call running");
    }
}
