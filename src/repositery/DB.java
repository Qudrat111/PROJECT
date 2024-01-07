package repositery;

import bean.ApiResponse;
import bean.CarBean;
import bean.UserBean;

import java.util.ArrayList;

public class DB {
    static ArrayList<UserBean> USERS = new ArrayList<>();
    static {
        Integer size = USERS.size();
        USERS.add(new UserBean("Qudrat","1111",1000.,size));
        USERS.add(new UserBean("Abdurahmon","2222",1000.,size));
        USERS.add(new UserBean("Ali","3333",1000.,size));
        USERS.add(new UserBean("Samandar","4444",1000.,size));
    }
    static ArrayList<CarBean> CARS = new ArrayList<>();

    public static UserBean addUser(UserBean bean){
        if(existUserByLogin(bean.getUsername())){
            return null;
        }
        bean.setId(USERS.size());
        bean.setBalance(1000.);
        return bean;
    }
    private static boolean existUserByLogin(String login){
        for (UserBean user:USERS) {
            if (user.getUsername().equals(login)){
                return true;
            }
        }
        return false;
    }
    public static UserBean getUser(UserBean bean){
        for (UserBean user : USERS) {
            if(user.getUsername().equals(bean.getUsername()) && user.getPassword().equals(bean.getPassword())){
                return user;
            }
        }
        return null;
    }


    public static ApiResponse buyCar(int userId, int carId) {
        CarBean carToBuy = null;
        for (CarBean car : CARS) {
            if (car.getId() == carId && car.isInStore()) {
                carToBuy = car;
                break;
            }
        }

        if (carToBuy == null) {
            return new ApiResponse(404, "Car not found or not for sale", null);
        }

        UserBean buyer = null;
        for (UserBean user : USERS) {
            if (user.getId() == userId) {
                buyer = user;
                break;
            }
        }

        if (buyer == null) {
            return new ApiResponse(404, "User not found", null);
        }

        if (buyer.getBalance() < carToBuy.getPrice()) {
            return new ApiResponse(400, "Insufficient balance", null);
        }

        buyer.setBalance(buyer.getBalance() - carToBuy.getPrice());
        carToBuy.setUserId(userId);
        carToBuy.setInStore(false);

        return new ApiResponse(200, "Car purchased successfully", carToBuy);
    }


    public static ApiResponse sellCar(int userId, int carId) {
        CarBean carToSell = null;
        for (CarBean car : CARS) {
            if (car.getId() == carId && car.getUserId() == userId && !car.isInStore()) {
                carToSell = car;
                break;
            }
        }

        if (carToSell == null) {
            return new ApiResponse(404, "Car not found or not owned by user", null);
        }

        // Set car as available for sale
        carToSell.setInStore(true);

        return new ApiResponse(200, "Car is now for sale", carToSell);
    }


}
