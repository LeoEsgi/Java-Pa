package model;

public class Product {

   public enum ProductType {
         STARTER,
         DISH,
         DESSERT,
         DRINK
     }

     String name;
     ProductType type;
     double price;
     int size;

    public Product() {
    }

    public Product(String name, ProductType type, double price, int size) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", size=" + size +
                '}';
    }
}
