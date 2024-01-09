package com.example.spirngapi.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private long id;
    private String name;
    private int price;
    private int quantity;
    private String description;

    public ProductDTO() {

    }

    public ProductDTO(String name, int price, int quantity, String desc) {
        this.name = name;
        this.description = desc;
        this.price = price;
        this.quantity=quantity;

    }
}
