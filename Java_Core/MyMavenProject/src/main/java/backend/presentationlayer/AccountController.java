package backend.presentationlayer;

import backend.businesslayer.IAccountService;
import entity.Account;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

public class AccountController {

    private IAccountService accountService;

    public AccountController(IAccountService accountService){
        this.accountService = accountService;
    }
    public List<Account> getListAccounts() throws Exception {
        if(accountService.getListAccounts() == null){
            throw new SQLException("List is exits!");
        }
        return accountService.getListAccounts();
    }
    public void createAccount(Account account) {
        try{
            accountService.createAccount(account);
        }catch (Exception e){
            System.out.println("ID already exists");
        }

    }
    public void getAccountByID(int id) throws Exception {
        List<Account>  accountList = accountService.getListAccounts();
        for (Account elem:accountList){
            if(id == elem.getAccountID()){
                accountService.getAccountByID(id);
                break;
            }else {
                throw new Exception("Account does not exist !");
            }

        }
    }
    public boolean isAccountExists(String username) throws SQLException, FileNotFoundException {
        List<Account>  accountList = accountService.getListAccounts();
        for (Account elem : accountList){
            if(username.equalsIgnoreCase(elem.getUserName())){
                return true;
            }else {
                throw new SQLException("UserName does not exist !");
            }
        }
        return accountService.isAccountExists(username);
    }

    public boolean isAccountExists(int id) throws SQLException, FileNotFoundException {
        List<Account>  accountList = accountService.getListAccounts();
        for (Account elem:accountList){
            if(id == elem.getAccountID()){
                return true;
            }else {
                throw new SQLException("Account does not exist !");
            }
        }
        return accountService.isAccountExists(id);
    }
    public void updateAccountByID(int id,Account account) throws Exception {
        List<Account>  accountList = accountService.getListAccounts();
        for (Account elem:accountList) {
            if (id == elem.getAccountID()) {
                accountService.updateAccountByID(id,account);
                break;
            } else {
                throw new Exception(" ID Account does not exist !");
            }
        }

    }

    public void deleteAccount(int id) throws SQLException, FileNotFoundException {
        List<Account>  accountList = accountService.getListAccounts();
        for (Account elem:accountList) {
            if (id == elem.getAccountID()) {
                accountService.deleteAccount(id);
                break;
            } else {
                throw new SQLException(" ID Account does not exist !");
            }
        }

    }
}
