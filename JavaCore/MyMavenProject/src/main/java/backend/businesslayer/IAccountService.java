package backend.businesslayer;

import entity.Account;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface IAccountService {

    public void createAccount(Account account) throws SQLException, ParseException;
    public List<Account> getListAccounts() throws SQLException, FileNotFoundException;
    public void getAccountByID(int id) throws Exception;
    public boolean isAccountExists(String username) throws SQLException;
    public boolean isAccountExists(int id) throws SQLException;
    public void updateAccountByID(int id,Account account) throws Exception;
    public void deleteAccount(int id) throws SQLException;
}
