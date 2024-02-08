package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "buyers")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "buyer_product",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Product> products_bought;

    public Buyer(){
    }
    public Buyer(String name){
        this.name = name;
    }
}
