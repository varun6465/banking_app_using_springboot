package com.example.bankingapp.mapper;

import com.example.bankingapp.dto.accountdto;
import com.example.bankingapp.entity.account;

public class accountmapper {
    public static account maptoaccount(accountdto accountdto){
        account account = new account(
                accountdto.getId(),
                accountdto.getAccountholdername(),
                accountdto.getBalance()
        );
        return account;
    }
    public static accountdto maptoaccountdto(account account){
        accountdto accountdto = new accountdto(
              account.getId(),
              account.getAccountholdername(),
              account.getBalance()
        );
        return accountdto;
    }

}
