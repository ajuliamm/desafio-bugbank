package com.bugbank.tests.clients;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class ClientFake {

    private String email ;
    private String name ;
    private String password ;
    private boolean addBalance ;

    

    public ClientFake( boolean addBalance) {

        Faker faker = new Faker(); 

        FakeValuesService fakeValuesService = new FakeValuesService(
        new Locale("en-GB"), new RandomService());

        this.email = fakeValuesService.bothify("????##@gmail.com");
        this.name = faker.name().fullName();;
        this.password = fakeValuesService.regexify("[a-z1-9]{10}");
        this.addBalance = addBalance;


    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAddBalance() {
        return addBalance;
    }

    public void setAddBalance(boolean addBalance) {
        this.addBalance = addBalance;
    } 

}
