package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String service;

    public void addAccount() {
        System.out.println(getClass() + " addAccount no parameter");
    }
    public void addAccount(Account account) {
        System.out.println(getClass() + " addAccount with parameter");
    }

    public String getName() {
        System.out.println(getClass() + " in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " in setName()");
        this.name = name;
    }

    public String getService() {
        System.out.println(getClass() + " in getService()");
        return service;
    }

    public void setService(String service) {
        System.out.println(getClass() + " in setService()");
        this.service = service;
    }
}
