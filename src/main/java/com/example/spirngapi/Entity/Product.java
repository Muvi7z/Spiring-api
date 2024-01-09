package com.example.spirngapi.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;


    @Column(name = "quantity")
    private int quantity;

    @Column(name = "description")
    private String description;

    public Product() {

    }
    public Product( long id, String name, int price, int quantity, String desc) {
        this.id = id;
        this.name = name;
        this.description = desc;
        this.price = price;
        this.quantity=quantity;

    }
    public Product(String name, int price, int quantity, String desc) {
        this.name = name;
        this.description = desc;
        this.price = price;
        this.quantity=quantity;

    }
}
