package com_vti_fontend;

import com_vti_backend.controller.AccountController;
import com_vti_backend.repository.AccountRepository;
import com_vti_backend.sevice.AccountService;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo {


    public static void main(String[] args) throws SQLException, IOException {

        AccountRepository accountRepository = new AccountRepository();
        AccountService accountService = new AccountService(accountRepository);
        AccountController accountController = new AccountController(accountService);

        int chose = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Input: ");
            chose = sc.nextInt();
            switch (chose) {
                case 1:
                    System.out.println("Nhap project ID: ");
                    int projectID = sc.nextInt();
                    System.out.println("Danh sach: ");
                    accountController.getList(projectID);
                    break;
                case 2:
                    System.out.println("Danh sach quan ly:");
                    accountController.getListManager();
                    break;
                case 3:
                    System.out.println("Nhap mail: ");
                    String mail = sc.next();
                    System.out.println("Nhap pass: ");
                    String pass = sc.next();
                    accountController.Login(mail, pass);
                    break;
                case 0:
                    break;
            }
        } while (chose != 0);
    }
}


