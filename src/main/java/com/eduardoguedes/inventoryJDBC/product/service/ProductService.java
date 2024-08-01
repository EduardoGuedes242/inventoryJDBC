package com.eduardoguedes.inventoryJDBC.product.service;

import com.eduardoguedes.inventoryJDBC.infra.database.ConnectionDB;
import com.eduardoguedes.inventoryJDBC.product.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {


  public List<Product> getAllProdutcs() {
    String slqSelect = """
            SELECT
              id,
              description,
              inventory,
              price
            FROM tbl$product
            """;
    List<Product> listProducts = new ArrayList<>();
    Long id;
    String description;
    double inventory;
    double price;

    try(Connection connection = ConnectionDB.startConnection();
        ResultSet resultSet = connection.createStatement().executeQuery(slqSelect)
      ) {
      while (resultSet.next()) {
        id = resultSet.getLong("id");
        description = resultSet.getString("description");
        inventory =  resultSet.getDouble("inventory");
        price = resultSet.getDouble("price");

        listProducts.add(new Product(id, description, price, inventory));
      }

    } catch (SQLException e) {
      System.out.println("Ocorreu i seguinte erro: " + e.getMessage());
    }
    return listProducts;
  }

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

  public void deleteProduct(Long id) {
    String sqlDelete = """
              DELETE FROM tbl$product
              WHERE id = ?
              """;

    try(Connection connectionLocal = ConnectionDB.startConnection();
        PreparedStatement preparedStatement = connectionLocal.prepareStatement(sqlDelete)
    ) {
      preparedStatement.setLong(1, id);
      preparedStatement.execute();
      System.out.println("Produto deletado com sucesso");

    } catch (SQLException e) {
      System.out.println("Ocorreu um erro ao cadastrar Produto: " + e.getMessage());
    }
  }

}
