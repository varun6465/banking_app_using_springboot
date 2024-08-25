package com.example.bankingapp.service;

import com.example.bankingapp.dto.accountdto;
import com.example.bankingapp.entity.account;

import java.util.List;

public interface accountservice {
    accountdto createaccount(accountdto accountdto);
    //accountdto getallaccounts(accountdto accountdto);
    accountdto deposit(Long id, double amount);
    accountdto getaccountbyid(Long id);
    accountdto withdraw(Long id, double amount);
    List<accountdto> getallaccounts();
    void deletebyid(long id);
}
