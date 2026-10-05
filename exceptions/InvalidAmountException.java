package exceptions;

public class InvalidAmountException extends RuntimeException {
    private double amount;

    public InvalidAmountException(String message, double amount) {
        super(message);
        this.amount = amount;
    }

    public boolean checked() {
        if (this.amount > 0) {
            return true;
        } else {
            return false;
        }
    }

    public double getAmount() {
        return amount;
    }
}
