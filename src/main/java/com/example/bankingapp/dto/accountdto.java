package com.example.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class accountdto {
    private Long id;
    private  String accountholdername;
    private Double balance;
}
