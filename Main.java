import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankManager bankManager = new BankManager();
        // them hang loat tai khoan
        bankManager.addAccount(new SavingAccount("1", "Nguyen Van A", 10000000, 0.05));
        bankManager.addAccount(new SavingAccount("2", "Nguyen Van B", 20000000, 0.1));
        bankManager.addAccount(new SavingAccount("3", "Nguyen Van C", 30000000, 0.0));
        bankManager.addAccount(new SavingAccount("4", "Nguyen Van D", 40000000, 0.05));
        bankManager.addAccount(new SavingAccount("5", "Nguyen Van E", 50000000, 0.01));

        while (true) {
            try {
                System.out.println("1. Xem danh sach tai khoan ");
                System.out.println("2. Nap tien ");
                System.out.println("3. Rut tien ");
                System.out.println("4. Chuyen tien ");
                System.out.println("5. Xem thong tin tai khoan ");
                System.out.println("0. Thoat ");
                System.out.print("Vui long nhap lua chon: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                // tao san de dung
                String accountNumber;
                double amount;

                switch (choice) {
                    case 1:
                        System.out
                                .println("---------------------------------------------------------------------------");
                        bankManager.displayAllAccounts();
                        break;
                    case 2:
                        System.out
                                .println("---------------------------------------------------------------------------");
                        System.out.print("Nhap so tai khoan can nap tien: ");
                        accountNumber = scanner.nextLine();
                        System.out.print("Nhap so tien can nap: ");
                        amount = scanner.nextDouble();
                        if (bankManager.findAccount(accountNumber) != null) {
                            bankManager.findAccount(accountNumber).deposit(amount);
                            System.out.println(">>> DA NAP " + amount + "VND vao tai khoan "
                                    + bankManager.findAccount(accountNumber).getHolderName());
                        }
                        System.out
                                .println("---------------------------------------------------------------------------");
                        break;
                    case 3:
                        System.out
                                .println("---------------------------------------------------------------------------");
                        System.out.print("Nhap so tai khoan can rut tien: ");
                        accountNumber = scanner.nextLine();
                        System.out.print("Nhap so tien can rut: ");
                        amount = scanner.nextDouble();
                        if (bankManager.findAccount(accountNumber) != null) {
                            bankManager.findAccount(accountNumber).withdraw(amount);
                            System.out.println(">>> DA RUT " + amount + "VND tu tai khoan "
                                    + bankManager.findAccount(accountNumber).getHolderName());
                        }
                        System.out
                                .println("---------------------------------------------------------------------------");
                        break;
                    case 4:
                        System.out
                                .println("---------------------------------------------------------------------------");
                        System.out.print("Nhap so tai khoan nguoi gui: ");
                        accountNumber = scanner.nextLine();
                        System.out.print("Nhap so tai khoan nguoi nhan: ");
                        String toAccountNumber = scanner.nextLine();
                        System.out.print("Nhap so tien can chuyen: ");
                        amount = scanner.nextDouble();
                        bankManager.transferMoney(accountNumber, toAccountNumber, amount);
                        System.out.println(">>> DA CHUYEN " + amount + "VND tu tai khoan "
                                + bankManager.findAccount(accountNumber).getHolderName() + " sang tai khoan "
                                + bankManager.findAccount(toAccountNumber).getHolderName());
                        System.out
                                .println("---------------------------------------------------------------------------");
                        break;
                    case 5:
                        System.out
                                .println("---------------------------------------------------------------------------");
                        System.out.print("Nhap so tai khoan can xem: ");
                        accountNumber = scanner.nextLine();
                        if (bankManager.findAccount(accountNumber) != null) {
                            bankManager.findAccount(accountNumber).display();
                        }
                        break;
                    case 0:
                        System.out.println("Thoat chuong trinh");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Lua chon khong hop le.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Vui long nhap so!");
                scanner.next();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
