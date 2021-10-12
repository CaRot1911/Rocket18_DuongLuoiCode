package fontend;

import backend.businesslayer.AccountService;
import backend.datalayer.AccountRepository;
import backend.presentationlayer.AccountController;
import entity.Account;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class program {

    public static void main(String[] args) throws Exception {

        AccountRepository accountRepository = new AccountRepository();
        AccountService accountService = new AccountService(accountRepository);
        AccountController accountController = new AccountController(accountService);

        Scanner sc = new Scanner(System.in);
        int chose = 0;
        do {
            System.out.println("Input chose: ");
            chose = sc.nextInt();
            switch (chose) {
                case 1:
                    List<Account> accountList = accountController.getListAccounts();
                    for (Account elem : accountList) {
                        System.out.println(elem);
                    }
                    break;
                case 2:
                    System.out.println("Input ID: ");
                    int id = sc.nextInt();
                    System.out.println("Input Username: ");
                    String username = sc.next();
                    System.out.println("Input Email: ");
                    String mail = sc.next();
                    System.out.println("Input First Name And Last Name: ");
                    String firstName = sc.next();
                    String lastName = sc.next();
                    String fullName = firstName + " " + lastName;
                    System.out.println("Input DepId: ");
                    int depId = sc.nextInt();
                    System.out.println("Input PosId: ");
                    int posId = sc.nextInt();
                    System.out.println("Input Gender: ");
                    String gender = sc.next();
                    System.out.println("Input Create Date: ");
                    String d = sc.next();
                    /*
                    Covert Date -> Date sql
                     */
                    DateFormat df = new SimpleDateFormat("yyyy-M-dd");
                    Date date = null;
                    java.sql.Date newDte = null;
                    date = df.parse(d);
                    newDte = new java.sql.Date(date.getTime());
                    Account account = new Account();
                    account.setAccountID(id);
                    account.setEmail(mail);
                    account.setUserName(username);
                    account.setFullName(fullName);
                    account.setDepartmentID(depId);
                    account.setPositionID(posId);
                    account.setCreateDate(newDte);
                    account.setGender(gender);

                    accountController.createAccount(account);
                    break;
                case 3:
                    System.out.println("Input ID: ");
                    int idSearch = sc.nextInt();

                    accountController.getAccountByID(idSearch);
                    break;
                case 4:
                    System.out.println("Input ID: ");
                    int idSearch1 = sc.nextInt();

                    System.out.println(accountController.isAccountExists(idSearch1));
                    break;
                case 5:
                    System.out.println("Input User Name: ");
                    String userNameSearch = sc.next();

                    System.out.println(accountController.isAccountExists(userNameSearch));
                    break;
                case 6:
                    System.out.println("Input ID: ");
                    int idUser = sc.nextInt();
                    System.out.println("Input Email: ");
                    String mailAfter = sc.next();
                    System.out.println("Input DepId: ");
                    int idDep = sc.nextInt();
                    System.out.println("Input PosID: ");
                    int idPos = sc.nextInt();

                    Account accountUpdate = new Account();
                    accountUpdate.setEmail(mailAfter);
                    accountUpdate.setDepartmentID(idDep);
                    accountUpdate.setPositionID(idPos);

                    accountController.updateAccountByID(idUser,accountUpdate);
                    break;
                case 7:
                    System.out.println("Input ID: ");
                    int idDelete = sc.nextInt();

                    accountController.deleteAccount(idDelete);
                    break;

            }
        }while (chose != 0) ;
    }
}