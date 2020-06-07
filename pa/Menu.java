package pa;

import java.util.Date;
import java.util.List;

public class Menu {

    String name;
    List<Product> content;
    Date creationDate;
    double price;


    public Menu(String name, List<Product> content, Date creationDate, double price) {
        this.name = name;
        this.content = content;
        this.creationDate = creationDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getContent() {
        return content;
    }

    public void setContent(List<Product> content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
