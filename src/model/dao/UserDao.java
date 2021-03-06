package model.dao;


import db.DataBase;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDao {

  public List getAllUsers() throws SQLException, ClassNotFoundException {
    ArrayList<User> userList = new ArrayList();
    DataBase db = new DataBase();
    Connection con = db.getConnection();
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM user");
    while (rs.next()) {
      int userId = rs.getInt("userId");
      String userName = rs.getString("userName");
      String password = rs.getString("password");
      userList.add(new User(userId, userName, password));
    }

    return userList;
  }

  public boolean isUserInDB(String username) throws SQLException, ClassNotFoundException {
    DataBase db = new DataBase();
    Connection con = db.getConnection();
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM user WHERE userName = '" + username + "'");

    return rs.next();
  }

  public void addUser(String username, String password)
      throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
    DataBase db = new DataBase();
    Connection con = db.getConnection();
    Statement st = con.createStatement();
    st.execute("INSERT INTO `user`(userName,password) VALUE ('" + username + "','" + DataBase
        .encryptPassword(password) + "')");
  }

  public int getUserIdByName(String userName) throws SQLException, ClassNotFoundException {
    DataBase db = new DataBase();
    Connection con = db.getConnection();
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT userId FROM user WHERE userName = '" + userName + "'");
    if (rs.next()) {
      return rs.getInt("userId");
    } else {
      return 0;
    }
  }


}
