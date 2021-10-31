package backend.businesslayer;

import backend.datalayer.IAccountRepository;
import entity.Account;


import java.sql.*;
import java.text.ParseException;
import java.util.List;

public class AccountService implements IAccountService {

    IAccountRepository accountRepository;

    public AccountService(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void createAccount(Account account) throws SQLException, ParseException {
        accountRepository.createAccount(account);
    }

    @Override
    public List<Account> getListAccounts() throws SQLException {
        return accountRepository.getListAccounts();
    }

    @Override
    public void getAccountByID(int id) throws Exception {
        accountRepository.getAccountByID(id);
    }

    @Override
    public boolean isAccountExists(String usernameAcc) throws SQLException {
        return accountRepository.isAccountExists(usernameAcc);

    }

    @Override
    public boolean isAccountExists(int id) throws SQLException {
        return accountRepository.isAccountExists(id);
    }

    @Override
    public void updateAccountByID(int id,Account account) throws Exception {
        accountRepository.updateAccountByID(id,account);
    }

    @Override
    public void deleteAccount(int id) throws SQLException {
        accountRepository.deleteAccount(id);
    }
}
