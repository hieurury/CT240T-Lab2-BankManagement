package exceptions;

public class InsufficientBalanceException extends Exception {
    private double balance;
    private double amount;

    public InsufficientBalanceException(String message, double balance, double amount) {
        super(message);
        this.balance = balance;
        this.amount = amount;
    }

    public InsufficientBalanceException(double amount) {
        super("So tien rut ra khong hop le");
        this.amount = amount;
    }

    public InsufficientBalanceException(String message) {
        super(message);
    }

    // @Override
    // public String getMessage() {
    // return "So du hien tai khong du de thuc hien giao dich nay, Vui long nap
    // them tien vao tai khoan!";
    // }

    // kiem tra so du hop le chua
    public boolean checked() {
        if (this.balance - this.amount > 0) {
            return true;
        } else {
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }

    public double getAmount() {
        return amount;
    }
}
