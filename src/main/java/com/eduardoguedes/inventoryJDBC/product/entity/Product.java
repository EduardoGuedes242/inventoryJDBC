package com.eduardoguedes.inventoryJDBC.product.entity;

public class Product {
  private Long id;
  private String description;
  private double inventory;
  private double price;

  public Product(String description, double price) {
    this.description = description;
    this.inventory = 0;
    this.price = price;
  }

  public Product(Long id, String description, double price, double inventory) {
    this.id = id;
    this.description = description;
    this.inventory = inventory;
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  public double getInventory() {
    return inventory;
  }
  public void setInventory(double inventory) {
    this.inventory = inventory;
  }

  public double getPrice() {
    return price;
  }
  public void setPrice(double price) {
    this.price = price;
  }

}
