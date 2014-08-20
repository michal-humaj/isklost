package dtos;

import models.Category;

import java.math.BigDecimal;

/**
 * Created by MiHu on 15.8.2014.
 */
public class AvailTO {

    public Long id;
    public String name;
    public Category category;
    public BigDecimal available;
    public BigDecimal reserved;
    public BigDecimal rented;

    public AvailTO(Long id, String name, Category category, BigDecimal available, BigDecimal reserved, BigDecimal rented) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.available = available;
        this.reserved = reserved;
        this.rented = rented;
    }

    public void reserve(BigDecimal a){
        available = available.subtract(a);
        reserved = reserved.add(a);
    }

    public void rent(BigDecimal a){
        available = available.subtract(a);
        rented = rented.add(a);
    }
}
