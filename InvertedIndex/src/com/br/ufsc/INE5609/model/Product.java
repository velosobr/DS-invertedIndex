package com.br.ufsc.INE5609.model;

import java.math.BigDecimal;

public class Product {
    private String name;
    private String brand;
    private String type;
    private String flavor;
    private int amount; //amount per product in ml's


    public Product(String name, String brand, String type, String flavor, int amount) {
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.flavor = flavor;
        this.amount = amount;
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

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getAmount() {
        return amount;
    }

    public void setamount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Nome ='" + name + '\'' +
                ", Marca='" + brand + '\'' +
                ", Tipo='" + type + '\'' +
                ", Sabor='" + flavor + '\'' +
                ", Quantidade=" + amount +
                '}';
    }
}
