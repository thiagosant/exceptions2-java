package com.sansoft.exercicio;

import com.sansoft.exercicio.model.entities.Account;
import com.sansoft.exercicio.model.exceptions.BusinessException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class ExercicioApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExercicioApplication.class, args);

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = input.nextInt();
        System.out.print("Holder: ");
        input.nextLine();
        String holder = input.nextLine();
        System.out.print("Initial balance: ");
        double balance = input.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = input.nextDouble();

        Account acc = new Account(number, holder, balance, withdrawLimit);

        System.out.println();
        System.out.print("Enter amount for withdraw: ");
        double amount = input.nextDouble();

        try {
            acc.withdraw(amount);
            System.out.printf("New balance: %.2f%n", acc.getBalance());
        }
        catch(BusinessException e) {
            System.out.println(e.getMessage());
        }

        input.close();
    }

}
