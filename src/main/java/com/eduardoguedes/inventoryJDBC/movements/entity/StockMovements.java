package com.eduardoguedes.inventoryJDBC.movements.entity;

import java.util.Date;

public class StockMovements {

  private Long id;
  private Long product_id;
  private double quantity;
  private String type;
  private Date date;

  public StockMovements(Long product_id, double quantity, String type) {
    this.product_id = product_id;
    this.quantity = quantity;
    this.type = type;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public Long getProduct_id() {
    return product_id;
  }
  public void setProduct_id(Long product_id) {
    this.product_id = product_id;
  }

  public double getQuantity() {
    return quantity;
  }
  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }

}
