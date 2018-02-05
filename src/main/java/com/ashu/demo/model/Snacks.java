package com.ashu.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Snacks extends GroceryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    @NotNull
    private String crunchiness;


    public String getCrunchiness() {
        return crunchiness;
    }

    public void setCrunchiness(String crunchiness) {
        this.crunchiness = crunchiness;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
