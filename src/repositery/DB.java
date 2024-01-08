package repositery;

import bean.ApiResponse;
import bean.CarBean;
import bean.UserBean;

import java.util.ArrayList;

public class DB {
    static ArrayList<UserBean> USERS = new ArrayList<>();

    static {
        Integer size = USERS.size();
        USERS.add(new UserBean("Qudrat", "1111", 1000., size));
        USERS.add(new UserBean("Abdurahmon", "2222", 1000., size));
        USERS.add(new UserBean("Ali", "3333", 1000., size));
        USERS.add(new UserBean("Samandar", "4444", 1000., size));
    }


    public static UserBean addUser(UserBean newUser) {
        if (!isUsernameExist(newUser.getUsername())) {
            USERS.add(newUser);
            newUser.setId(USERS.size() - 1);
            return newUser;
        }
        return null;
    }

    private static boolean isUsernameExist(String username) {
        for (UserBean user : USERS) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static UserBean getUser(UserBean bean) {
        for (UserBean user : USERS) {
            if (user.getUsername().equals(bean.getUsername()) && user.getPassword().equals(bean.getPassword())) {
                return user;
            }
        }
        return null;
    }


    static ArrayList<CarBean> CARS = new ArrayList<>();

    public static boolean addCar(CarBean car) {
        for (UserBean user : USERS) {
            if (user.getId().equals(car.getUserId()) && user.getBalance() >= car.getPrice()) {
                user.setBalance(user.getBalance() - car.getPrice());
                car.setId(CARS.size());
                CARS.add(car);
                return true;
            }
        }
        return false;
    }

    public static boolean sellCar(int carId) {
        for (CarBean car : CARS) {
            if (car.getId() == carId) {
                car.setInStore(true);
                return true;
            }
        }
        return false;
    }

    public static void printUserCars(int userId) {
        for (CarBean car : CARS) {
            if (car.getUserId() != null && car.getUserId() == userId) {
                String status = car.isInStore() ? "Sotuvda" : "Garajda"; // "For Sale" or "In Garage"
                System.out.println("Car ID: " + car.getId() + ", Name: " + car.getName() + ", Status: " + status);
            }
        }
    }

    public static void printCarsForSale() {
        System.out.println("Sotuvdagi mashinalar:");
        for (CarBean car : CARS) {
            if (car.isInStore()) {
                System.out.println("ID: " + car.getId() + ", Name: " + car.getName() + ", Color: " + car.getColor() + ", Price: " + car.getPrice());
            }
        }
    }

    public static boolean buyCar(int userId, int carId) {
        UserBean buyer = getUserById(userId);
        CarBean carToBuy = getCarById(carId);

        if (buyer != null && carToBuy != null && carToBuy.isInStore() && buyer.getBalance() >= carToBuy.getPrice()) {

            buyer.setBalance(buyer.getBalance() - carToBuy.getPrice());
            carToBuy.setUserId(userId);
            carToBuy.setInStore(false);

            UserBean seller = getUserById(carToBuy.getUserId());
            if (seller != null) {
                seller.setBalance(seller.getBalance() + carToBuy.getPrice());
            }

            return true;
        }
        return false;
    }

    public static UserBean getUserById(int userId) {
        for (UserBean user : USERS) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public static CarBean getCarById(int carId) {
        for (CarBean car : CARS) {
            if (car.getId().equals(carId)) {
                return car;
            }
        }
        return null;
    }


}
