package models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    @ManyToMany(mappedBy = "products_bought")
    private List<Buyer> buyers_of_product;
}
