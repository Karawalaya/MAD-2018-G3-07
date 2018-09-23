package com.karawalaya.alliantbankapp.POJO_MODEL.transaction_management;

import java.io.Serializable;

public class Account implements Serializable {
    private String customerId;
    private int accountNo;
    private double balance;

    public Account() {}

    public Account(String customerId, int accountNo, double balance) {
        this.setCustomerId(customerId);
        this.setAccountNo(accountNo);
        this.setBalance(balance);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
