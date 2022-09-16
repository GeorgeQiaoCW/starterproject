package com.example.bookstore;


import javax.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private int price;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
