package com.eduardoguedes.inventoryJDBC.product.service;

import com.eduardoguedes.inventoryJDBC.infra.database.ConnectionDB;
import com.eduardoguedes.inventoryJDBC.product.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductService {


  public void insertProduct(Product product) {
    String sqlInsert = """
              INSERT INTO tbl$product
              (description, inventory, price)
              VALUES (?, 0, ?)
            """;

    try(Connection connectionLocal = ConnectionDB.startConnection();
        PreparedStatement preparedStatement = connectionLocal.prepareStatement(sqlInsert)
    ) {
      preparedStatement.setString(1, product.getDescription());
      preparedStatement.setDouble(2, product.getPrice());
      preparedStatement.execute();

      System.out.println("Produto cadastrado com sucesso");

    } catch (SQLException e) {
      System.out.println("Ocorreu um erro ao cadastrar Produto");

    }
  }

}
