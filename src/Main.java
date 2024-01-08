import bean.CarBean;
import bean.UserBean;
import repositery.DB;

import java.util.Scanner;

public class Main {


    private static UserBean currentUser;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            if (currentUser == null) {
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        register();
                        break;
                    case 2:
                        login();
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice.");
                }
            } else {
                System.out.println("1. Add Car");
                System.out.println("2. My Cars");
                System.out.println("3. Put My Car for Sale");
                System.out.println("4. Buy Car");
                System.out.println("5. Logout");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        addCar();
                        break;
                    case 2:
                        DB.printUserCars(currentUser.getId());
                        break;
                    case 3:
                        putCarForSale();
                        break;
                    case 4:
                        buyCar();
                        break;
                    case 5:
                        currentUser = null;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
    }

    private static void register() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        UserBean newUser = new UserBean(username, password, 1000.0, -1);
        UserBean registeredUser = DB.addUser(newUser);
        if (registeredUser != null) {
            System.out.println("Registration successful.");
        } else {
            System.out.println("Registration failed. Username already exists.");
        }
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        currentUser = DB.getUser(new UserBean(username, password));
        if (currentUser != null) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed. Username or password incorrect.");
        }
    }

    private static void addCar() {
        System.out.print("Enter car name: ");
        String name = scanner.next();
        System.out.print("Enter car color: ");
        String color = scanner.next();
        System.out.print("Enter car price: ");
        double price = scanner.nextDouble();

        CarBean newCar = new CarBean(null, name, color, price, currentUser.getId(), false);
        boolean success = DB.addCar(newCar);
        if (success) {
            System.out.println("Car added successfully.");
        } else {
            System.out.println("Failed to add car. Insufficient balance.");
        }
    }

    private static void putCarForSale() {
        System.out.print("Enter car ID to put for sale: ");
        int carId = scanner.nextInt();
        boolean success = DB.sellCar(carId);
        if (success) {
            System.out.println("Car is now for sale.");
        } else {
            System.out.println("Failed to put car for sale. Car not found.");
        }
    }

    private static void buyCar() {
        DB.printCarsForSale();
        System.out.print("Enter car ID to buy: ");
        int carId = scanner.nextInt();
        boolean success = DB.buyCar(currentUser.getId(), carId);
        if (success) {
            System.out.println("Car purchased successfully.");
        } else {
            System.out.println("Failed to purchase car. Car not found or insufficient balance.");
        }
    }


}
