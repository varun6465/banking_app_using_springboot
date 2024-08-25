package com.example.bankingapp.controller;
import com.example.bankingapp.dto.accountdto;
import com.example.bankingapp.service.accountservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class accountcontroller {
    public accountcontroller(com.example.bankingapp.service.accountservice accountservice) {
        this.accountservice = accountservice;
    }

    private accountservice accountservice;

    //add account request
    @PostMapping
    public ResponseEntity<accountdto> addaccount(@RequestBody accountdto accoundto){
        return new ResponseEntity<>(accountservice.createaccount(accoundto), HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public ResponseEntity<accountdto> getaccountbyid(@PathVariable Long id){
        accountdto accountdto = accountservice.getaccountbyid(id);
        return new ResponseEntity<>((accountdto),HttpStatus.OK);
    }
    @PutMapping("/{id}/deposit")
    public ResponseEntity<accountdto> depoist(@PathVariable Long id, @RequestBody  Map<String, Double> request){
        Double amount = request.get("amount");
        accountdto accountdto = accountservice.deposit(id, amount);
        return ResponseEntity.ok(accountdto);
    }
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<accountdto> withdraw(@PathVariable Long id, @RequestBody Map<String,  Double> request){
        Double amount = request.get("amount");
        accountdto accountdto = accountservice.withdraw(id, amount);
        return ResponseEntity.ok(accountdto);
    }
    @GetMapping
    public ResponseEntity<List<accountdto>> getallaccounts(){
        List<accountdto> accounts = accountservice.getallaccounts();
        return ResponseEntity.ok(accounts);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteaccount(Long id){
        accountservice.deletebyid(id);
        return ResponseEntity.ok("account is deleted");
    }




}
