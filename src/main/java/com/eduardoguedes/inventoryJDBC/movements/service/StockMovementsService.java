package com.eduardoguedes.inventoryJDBC.movements.service;

import com.eduardoguedes.inventoryJDBC.infra.database.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StockMovementsService {


  public void createStockMovements( Long product_id, double quantity, String type) {
    String sqlInsert = "INSERT INTO movimentacoes (product_id, quantity, type, date)\n" +
                        "VALUES (?, ?, ?, NOW());";

    try(Connection connection = ConnectionDB.startConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert)
    ) {
      preparedStatement.setLong(1, product_id);
      preparedStatement.setDouble(2, quantity);
      preparedStatement.setString(3, type);
      preparedStatement.execute();

      System.out.println("Movimentacao criada com sucesso");
    }
    catch (SQLException e) {
      System.out.println("Ocorreu o seguinte erro: " + e.getMessage());
    }

  }


}
