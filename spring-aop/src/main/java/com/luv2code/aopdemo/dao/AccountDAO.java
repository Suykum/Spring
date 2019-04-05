package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String service;

    public List<Account> findAccounts() {
        List<Account> accounts = new ArrayList<Account>();
        Account account1 = new Account("John", "Silver");
        Account account2 = new Account("Anna", "platinum");
        Account account3 = new Account("Marry", "silver");

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        return accounts;
    }

    public void simulateThrowing() {
        throw new RuntimeException("Simulated runtimeException");
    }

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
