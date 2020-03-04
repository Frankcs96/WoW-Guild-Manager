package model.dao;

import db.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Server;

public class ServerDao {
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
