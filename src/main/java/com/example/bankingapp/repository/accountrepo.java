package com.example.bankingapp.repository;

import com.example.bankingapp.entity.account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface accountrepo extends JpaRepository<account, Long> {

    //account findAll(account account);
}
