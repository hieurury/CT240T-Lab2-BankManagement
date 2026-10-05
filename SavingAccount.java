import exceptions.InsufficientBalanceException;
import exceptions.InvalidAmountException;

public class SavingAccount extends BankAccount {

    private double interestRate;

    public SavingAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    // getters and setters

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // method display

    @Override
    public void display() {
        System.out.print("| So tai khoan: " + getAccountNumber());
        System.out.print("| Ho ten: " + getHolderName());
        System.out.print("| So du: " + String.format("%.0f", getBalance())); // dinh dang VND
        System.out.println("| Lai suat: " + interestRate + " | ");
        System.out.println("---------------------------------------------------------------------------");
    }

    @Override
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("So tien nap vao phai lon hon 0", amount);
        }
        setBalance(getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("So tien rut ra phai lon hon 0", amount);
        }
        if (getBalance() - amount < 50000) {
            throw new InsufficientBalanceException("So du hien tai khong du, tai khoan con lai toi thieu 50.000VND");
        }
        setBalance(getBalance() - amount);
    }

}
