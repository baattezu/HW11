import models.Buyer;
import models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main{
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Buyer.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        startApp(sessionFactory);
    }


    static void startApp(SessionFactory sessionFactory){
        Session session = null;
        while (true){
            System.out.println("*** WELCOME IN SHOP ***");
            System.out.println("1. Enter shop as me");
            System.out.println("2. Enter shop as Director");
            System.out.println("*** Enter your input ***");
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 1:
                    System.out.println("*** WELCOME IN SHOP ***");
                    System.out.println("*** Enter your name ***");
                    String name = scanner.nextLine();
                    session = sessionFactory.getCurrentSession();
                    Buyer buyer = new Buyer(name);
                    session.beginTransaction();
                    session.save(buyer);
                    session.getTransaction().commit();
                    while (true){
                        System.out.println("*** WELCOME," + name +" ***");
                        System.out.println("1. Buy product");
                        System.out.println("2. Show my products");
                        System.out.println("*** Enter your input ***");
                        int input2 = scanner.nextInt();
                        scanner.nextLine();
                        switch (input2){
                            case 1:
                                System.out.println("*** SELECT PRODUCT ***");
                                session.createQuery("from products").getResultList();
                        }
                    }
            }
        }
    }
}