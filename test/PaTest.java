package test;

import org.junit.Test;
import model.Account;
import model.Menu;
import model.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class PaTest {


    @Test
    public void testCreateAccount() {

        Account A = new Account("jean", "petigros","Marseille", "France", Account.AccountType.CUSTOMER, true);

        assertEquals(A.toString(), "Account{" +
                "firstname='" + "jean" + '\'' +
                ", lastname='" + "petigros" + '\'' +
                ", city='" + "Marseille" + '\'' +
                ", country='" + "France" + '\'' +
                ", type=" + Account.AccountType.CUSTOMER +
                ", activated=" + true +
                '}');

    }

    @Test
    public void testCreateProduct() {

        Product P = new Product("pomme", Product.ProductType.DESSERT, 1.50 , 20);

        assertEquals(P.toString(), "Product{" +
                "name='" + "pomme" + '\'' +
                ", type=" + Product.ProductType.DESSERT +
                ", price=" + 1.50 +
                ", size=" + 20 +
                '}');


    }

    @Test
    public void testCreateMenu() {


        Product P = new Product("pomme", Product.ProductType.DESSERT, 1.50 , 20);
        List<Product> productList = new ArrayList<>();
        productList.add(P);
        Date date = new Date();

        Menu M = new Menu("MenuTest" , productList, date, 10.50);

        assertEquals(M.toString(), "Menu{" +
                "name='" + "MenuTest" + '\'' +
                ", content=" + productList +
                ", creationDate=" + date +
                ", price=" + 10.50 +
                '}');


    }


}
