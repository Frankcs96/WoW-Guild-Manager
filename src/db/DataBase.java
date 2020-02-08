package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

  public Connection getConnection () throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager
        .getConnection("jdbc:mysql://localhost:3306/crud_db","root", "****");

    return connection;

  }
}
