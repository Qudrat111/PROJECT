package bean;

public class CarBean extends BaseIdBean{

    private String name;
    private String color;
    private Double price;
    private Integer userId;
    private boolean isInStore;

    public String getName() {
        return name;
    }

    public CarBean(String name, String color, Double price, Integer userId, boolean isInStore) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.userId = userId;
        this.isInStore = isInStore;
    }

    public CarBean(Integer id, String name, String color, Double price, Integer userId, boolean isInStore) {
        super(id);
        this.name = name;
        this.color = color;
        this.price = price;
        this.userId = userId;
        this.isInStore = isInStore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean isInStore() {
        return isInStore;
    }

    public void setInStore(boolean inStore) {
        isInStore = inStore;
    }
}
