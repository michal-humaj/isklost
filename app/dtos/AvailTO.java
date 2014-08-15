package dtos;

import models.Category;

import java.math.BigDecimal;

/**
 * Created by MiHu on 15.8.2014.
 */
public class AvailTO {

    public String name;
    public Category category;
    public int available;
    public int reserved;
    public int rented;

    public AvailTO(String name, Category category, int available, int reserved, int rented) {
        this.name = name;
        this.category = category;
        this.available = available;
        this.reserved = reserved;
        this.rented = rented;
    }

    public void reserve(int a){
        available -= a;
        reserved += a;
    }

    public void rent(int a){
        available -= a;
        rented += a;
    }
}
