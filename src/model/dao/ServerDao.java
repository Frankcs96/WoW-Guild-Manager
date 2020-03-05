package model.dao;

import db.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Server;
import model.User;

public class ServerDao {


  public List getAllServers() throws SQLException, ClassNotFoundException {
    ArrayList<Server> serverList = new ArrayList();
    DataBase db = new DataBase();
    Connection con = db.getConnection();
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM server");
    while (rs.next()) {
      int serverId = rs.getInt("serverId");
      String serverName = rs.getString("serverName");
      String serverRegion = rs.getString("serverRegion");
      serverList.add(new Server(serverId, serverName, serverRegion));
    }

    return serverList;
  }


  public Server getServerById(int serverIde) throws SQLException, ClassNotFoundException {
    DataBase db = new DataBase();
    Connection con = db.getConnection();
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM server where serverId = '" + serverIde + "'");
    Server server = null;
    while (rs.next()) {
      int serverId = rs.getInt("serverId");
      String serverName = rs.getString("serverName");
      String serverRegion = rs.getString("serverRegion");
      server = new Server(serverId,serverName,serverRegion);

    }
    return server;
  }
}
