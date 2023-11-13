import models.Cart;
import models.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main( String[] args ) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Cart cart = new Cart(1000, "random_name");
        Item item1 = new Item(150);
        Item item2 = new Item(300);
        Item item3 = new Item(450);
        Item item4 = new Item(550);
        Item item5 = new Item(170);
        cart.setItems(new HashSet<>(Arrays.asList(item1, item2, item3, item4, item5)));
        session.persist(cart);
        transaction.commit();
        session.close();
    }
}
