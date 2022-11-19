package com.sansoft.exercicio.model.entities;

import com.sansoft.exercicio.model.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;


    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount) throws BusinessException {
        validateWithdraw(amount);
        balance -= amount;
    }

    private void validateWithdraw(double amount) throws BusinessException{
        if (amount > getWithdrawLimit()){
            throw new BusinessException("Withdraw error: The amount exceeds withdraw limit");
        }
        if (amount > getBalance()) {
            throw new BusinessException("Withdraw error: Not enough balance");
        }
    }
}
