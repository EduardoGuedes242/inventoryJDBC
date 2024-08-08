package com.eduardoguedes.inventoryJDBC.movements.service;

import com.eduardoguedes.inventoryJDBC.infra.database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StockMovementsService {


  public void createStockMovements( Long product_id, double quantity, String type) {
    String sqlInsert = "INSERT INTO tbl$stock_movements (product_id, quantity, type, date)\n" +
                        "VALUES (?, ?, ?, NOW());";

    try(Connection connection = ConnectionDB.startConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert)
    ) {
      preparedStatement.setLong(1, product_id);
      preparedStatement.setDouble(2, quantity);
      preparedStatement.setString(3, type);
      preparedStatement.execute();

      String operador = "-";
      if(type.equals("E"))
        operador = "+";

      updateStockProduct(product_id, quantity, operador);

      System.out.println("Movimentacao criada com sucesso");
    }
    catch (SQLException e) {
      System.out.println("Ocorreu o seguinte erro: " + e.getMessage());
    }

  }

  public void updateStockProduct(Long product_id, double quantity, String operation) {
    String sqlUpdate = "UPDATE tbl$product SET inventory = inventory " + operation + " ? WHERE id = ?";
    try( Connection connection = ConnectionDB.startConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
         ) {

      preparedStatement.setDouble(1, quantity);
      //preparedStatement.setString(1, operation);
      preparedStatement.setLong(2, product_id);
      preparedStatement.execute();
    } catch (SQLException e) {
      System.out.println("OCorreu um erro na operação" + e.getMessage());
    }
  }


}
