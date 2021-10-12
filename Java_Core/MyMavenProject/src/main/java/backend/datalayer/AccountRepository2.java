package backend.datalayer;

import entity.Account;

import java.sql.SQLException;
import java.util.List;

public class AccountRepository2 implements IAccountRepository {
    @Override
    public List<Account> getListAccounts() throws SQLException {
        return null;
    }

    @Override
    public void createAccount(Account account) throws SQLException {

    }

    @Override
    public void getAccountByID(int id) {

    }

    @Override
    public boolean isAccountExists(String username) {

        return false;
    }

    @Override
    public boolean isAccountExists(int id) {
        return false;
    }

    @Override
    public void updateAccountByID(int id,Account account) {

    }

    @Override
    public void deleteAccount(int id) {

    }
}
