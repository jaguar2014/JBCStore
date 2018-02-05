package com.ashu.demo.model;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@MappedSuperclass
public class GroceryItem {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private double price;

    @NotNull
    private int quantity;

    public GroceryItem(){
        this.name="";
        this.price=0.0;
        this.quantity=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
