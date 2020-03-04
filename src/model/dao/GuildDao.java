package model.dao;

import db.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Guild;
import model.User;

public class GuildDao {

  public boolean userHasGuild(int userId) throws SQLException, ClassNotFoundException {
    DataBase db = new DataBase();
    Connection con = db.getConnection();
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM guild WHERE userId = '" + userId + "'");
    return rs.next();
  }

  public Guild getUserGuildById(int userIde) throws SQLException, ClassNotFoundException {
    DataBase db = new DataBase();
    Connection con = db.getConnection();
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM guild where userId = '" + userIde + "'");
    Guild guild = null;
    while (rs.next()) {
      int guildId = rs.getInt("guildId");
      String guildName = rs.getString("guildName");
      int userId = rs.getInt("userId");
      int serverId = rs.getInt("serverId");
      guild = new Guild(guildId,guildName,userId,serverId);

    }
    return guild;
  }
}
