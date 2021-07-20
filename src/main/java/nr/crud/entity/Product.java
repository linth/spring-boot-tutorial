package nr.crud.entity;

/**
 * 定義資料結構
 * 
 * Reference -
 * https://chikuwa-tech-study.blogspot.com/2021/05/spring-boot-controller-1.html
 * 
 * 問題: - 是否有快速處理 get(), set() function?
 */

public class Product {
    private String id;
    private String name;
    private int price;

    public Product() {

    }

    public Product(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
