import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exceptions.InsufficientBalanceException;
import exceptions.InvalidAmountException;

public class BankManager {
    Map<String, BankAccount> accounts = new HashMap<>();

    public BankManager() {
    }

    public void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public BankAccount findAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void displayAllAccounts() {
        for (BankAccount account : accounts.values()) {
            account.display();
        }
    }

    public void transferMoney(String fromAccountNumber, String toAccountNumber, double amount) {
        try {
            BankAccount fromAccount = findAccount(fromAccountNumber);
            BankAccount toAccount = findAccount(toAccountNumber);
            if (fromAccount != null && toAccount != null) {
                fromAccount.withdraw(amount);
                toAccount.deposit(amount);
            }
        } catch (InsufficientBalanceException e) {
            e.printStackTrace();
        } catch (InvalidAmountException e) {
            e.printStackTrace();
        }
    }

    public double calculateTotalBalance(List<? extends BankAccount> accounts) {
        try {
            double totalBalance = 0;
            for (BankAccount account : accounts) {
                totalBalance += account.getBalance();
            }
            return totalBalance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
