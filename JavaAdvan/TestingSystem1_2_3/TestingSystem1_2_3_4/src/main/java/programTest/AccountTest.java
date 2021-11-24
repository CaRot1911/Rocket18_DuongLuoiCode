package programTest;

import entity.Account;
import repository.AccountRepository;

import java.util.List;

public class AccountTest {
    public static void main(String[] args) {

        AccountRepository accountRepository = new AccountRepository();

        List<Account> lstAccount = accountRepository.getListAccount();

        for (Account elem : lstAccount){
            System.out.println(elem.getAccountID() + "-" + elem.getFullName()+"-"+elem.getSalaryID().getSalaryID());

        }

    }
}
