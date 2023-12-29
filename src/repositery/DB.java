package repositery;

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
}
