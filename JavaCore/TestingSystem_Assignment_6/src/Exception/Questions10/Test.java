package Exception.Questions10;

import Exception.Questions8.ScannerUtils;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        Account account = new Account();
        List<Account> accountList = new ArrayList<>();
        int chose = 0;
        chose = ScannerUtils.inputInt();
        switch (chose) {
            case 1:
                account.idAcc = ScannerUtils.inputInt();
                account.age = ScannerUtils.inputInt();
                account.userName = ScannerUtils.inputString();
                account.password = ScannerUtils.inputString();
                account.createDate = ScannerUtils.inputString();
                accountList.add(account);
                break;
            case 2:
                break;
        }
    }
}
