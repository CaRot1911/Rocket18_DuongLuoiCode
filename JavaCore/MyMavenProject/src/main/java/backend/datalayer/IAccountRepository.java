package backend.datalayer;

import entity.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountRepository {
    public List<Account> getListAccounts() throws SQLException;
    public void createAccount(Account account) throws SQLException;
    public void getAccountByID(int id) throws SQLException;
    public boolean isAccountExists(String username) throws SQLException;
    public boolean isAccountExists(int id) throws SQLException;
    public void updateAccountByID(int id,Account account) throws Exception;
    public void deleteAccount(int id) throws SQLException;
}
