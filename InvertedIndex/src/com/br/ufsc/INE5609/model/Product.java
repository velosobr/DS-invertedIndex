package com.br.ufsc.INE5609.model;

import java.math.BigDecimal;

public class Product {
    private String name;
    private String brand;
    private String type;
    private String value; //Quantidade por produto


    public Product(String name, String brand, String type, String value) {
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.value = value;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", Brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
