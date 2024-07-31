package com.eduardoguedes.inventoryJDBC.infra.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
  private static final String url = "jdbc:postgresql:inventory";
  private static final String user = "postgres";
  private static final String password = "masterkey";

  public static Connection startConnection() {
    Connection connection = null;
    try {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager.getConnection(url, user, password);
    } catch (ClassNotFoundException | SQLException erro) {
      System.out.println("Erro ao se conectar no banco de dados");
    }
    return connection;
  }
}
