package com.example.bankingapp.service.impl;

import com.example.bankingapp.dto.accountdto;
import com.example.bankingapp.entity.account;
import com.example.bankingapp.mapper.accountmapper;
import com.example.bankingapp.service.accountservice;
import org.springframework.stereotype.Service;
import com.example.bankingapp.repository.accountrepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class accountserviceimpl implements accountservice {

    private final accountrepo accountrepository;

    public accountserviceimpl(accountrepo accountrepository) {
        this.accountrepository = accountrepository;
    }

    @Override
    public accountdto createaccount(accountdto accountdto) {
        account account = accountmapper.maptoaccount(accountdto);
        account savedaccount = accountrepository.save(account);

        return accountmapper.maptoaccountdto(savedaccount);
    }

    @Override
    public accountdto deposit(Long id, double amount) {
        account account = accountrepository
                .findById(id).orElseThrow(() -> new RuntimeException("Account doesn't exist"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        account savedaccount = accountrepository.save(account);
        return accountmapper.maptoaccountdto(savedaccount);
    }

    @Override
    public accountdto getaccountbyid(Long id) {
        account account = accountrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account doesn't exist"));

        return accountmapper.maptoaccountdto(account);
    }

    @Override
    public accountdto withdraw(Long id, double amount) {
        account account = accountrepository
                .findById(id).orElseThrow(() -> new RuntimeException("Account doesn't exist"));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);
        account savedaccount = accountrepository.save(account);
        return accountmapper.maptoaccountdto(savedaccount);
    }

    @Override
    public List<accountdto> getallaccounts() {
        List<account> accounts = accountrepository.findAll();
        return accounts.stream()
                .map(account -> accountmapper.maptoaccountdto(account))
                .collect(Collectors.toList());  // Fixed this line
    }

    @Override
    public void deletebyid(long id) {
        account account = accountrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account doesn't exist"));
        accountrepository.deleteById(id);
    }
}


    /*@Override
    public accountdto getallaccounts(accountdto accountdto) {
        account account = accountmapper.maptoaccount(accountdto);
        account getallaccounts = accountrepository.findAll(account);
        return accountmapper.maptoaccountdto(getallaccounts);

    }*/

