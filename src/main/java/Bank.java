import java.util.Scanner;
public class Bank {
    private static double money;
    private static int PIN;
    private static String name;
    static Scanner reader = new Scanner(System.in);
    public static void showMenu() {
        System.out.println("Press 0 to Deposit");
        System.out.println("Press 1 to Withdraw");
        System.out.println("Press 2 to Change PIN");
        System.out.println("Press 3 to Change Name");
        System.out.println("Press 4 to Exit");
        int choice = reader.nextInt();
        switch(choice) {
            case 0 -> depositMoney();
            case 1 -> withdrawMoney();
            case 2 -> setPIN();
            case 3 -> setName();
            case 4 -> SaveValues.writeValues();
            default -> {
                System.out.println("Invalid Option. Please Try Again");
                showMenu();
            }
        }
    }
    public static void depositMoney() {
        System.out.println("Press 0 to return to menu");
        System.out.println("Deposit amount: ");
        double choice = reader.nextDouble();
        if (choice == 0) {
            showMenu();
        }
        else {
            money += choice;
        }
        System.out.println("New Balance $" + money);
        showMenu();
    }
    public static void withdrawMoney() {
        System.out.println("Press 0 to return to menu");
        System.out.println("Withdrawal amount: ");
        double choice = reader.nextDouble();
        if (choice == 0) {
            showMenu();
        }
        else {
            money -= choice;
        }
        System.out.println("New Balance: $" + money);
        showMenu();
    }
    public static void setPIN() {
        System.out.println("New PIN: ");
        PIN = reader.nextInt();
        showMenu();
    }
    public static int getPIN() { return PIN; }
    public static void setName() {
        System.out.println("New Name: ");
        name = reader.nextLine();
        showMenu();
    }
    public static double getMoney() { return money; }
    public static void checkPIN() {
        System.out.println("Enter PIN: ");
        int pin = reader.nextInt();
        if(pin != PIN) {
            System.out.println("Incorrect PIN. Please try again");
            checkPIN();
        }
    }
    public static void init() {
        money = SaveValues.readValues()[0];
        PIN = (int)SaveValues.readValues()[1];
        checkPIN();
        showMenu();
    }
}
