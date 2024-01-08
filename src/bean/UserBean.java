package bean;

public class UserBean extends BaseIdBean{
    private String username;
    private String password;
    private Double balance;


    public UserBean(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public UserBean(String username, String password,Double balance,Integer id) {
        super(id);
        this.username = username;
        this.password = password;
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "UserBean{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +'\''+
                ", id = " + super.getId() +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
