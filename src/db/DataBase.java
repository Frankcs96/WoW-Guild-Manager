package db;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.xml.bind.DatatypeConverter;

public class DataBase {

  public Connection getConnection () throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager
        .getConnection("jdbc:mysql://localhost:3306/crud_db","root", "1234");

    return connection;

  }

  public static String encryptPassword (String password) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(password.getBytes());
    String passwordHashed = DatatypeConverter.printHexBinary(md.digest());
    return passwordHashed;
  }
}
