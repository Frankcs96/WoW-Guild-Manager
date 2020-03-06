package model.dao;

import db.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Guild;
import model.Player;
import model.Server;

public class PlayerDao {

  public List getAllPlayers(int guildIden) throws SQLException, ClassNotFoundException {
    ArrayList<Player> playerList = new ArrayList();
    DataBase db = new DataBase();
    Connection con = db.getConnection();
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM player WHERE guildId = " + guildIden);
    while (rs.next()) {
      int playerId = rs.getInt("playerId");
      String playerName = rs.getString("playerName");
      String playerClass = rs.getString("playerClass");
      String playerRole = rs.getString("playerRole");
      int playerLevel = rs.getInt("playerLevel");
      int playerItemLevel = rs.getInt("playerItemLevel");
      String playerInfo = rs.getString("playerInfo");
      int guildId = rs.getInt("guildId");
      playerList.add(
          new Player(playerId, playerName, playerClass, playerRole, playerLevel, playerItemLevel,
              playerInfo, guildId));
    }
    return playerList;
  }

  public void createPlayer(Player player) throws SQLException, ClassNotFoundException {

    DataBase db = new DataBase();
    Connection con = db.getConnection();
    Statement st = con.createStatement();
    st.execute(
        "INSERT INTO `player`(playerName,playerClass,playerRole,playerLevel,PlayerItemLevel,playerInfo, guildId) VALUE ('"
            + player.getPlayerName() + "','"
            + player.getPlayerClass() + "','"
            + player.getPlayerRole() + "',"
            + player.getPlayerLevel() + ","
            + player.getPlayerItemLevel() + ",'"
            + player.getPlayerInfo() + "',"
            + player.getGuildId() + ")");
  }

  public Player getPlayerById(int id) throws SQLException, ClassNotFoundException {
    DataBase db = new DataBase();
    Connection con = db.getConnection();
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM player where playerId = '" + id + "'");
    Player player = null;
    while (rs.next()) {
      int playerId = rs.getInt("playerId");
      String playerName = rs.getString("playerName");
      String playerClass = rs.getString("playerClass");
      String playerRole = rs.getString("playerRole");
      int playerLevel = rs.getInt("playerLevel");
      int playerItemLevel = rs.getInt("playerItemLevel");
      String playerInfo = rs.getString("playerInfo");
      int guildId = rs.getInt("guildId");
      player = new Player(playerId, playerName, playerClass, playerRole, playerLevel,
          playerItemLevel, playerInfo, guildId);

    }
    return player;

  }

  public void updatePlayer(Player player) throws SQLException, ClassNotFoundException {
    DataBase db = new DataBase();
    Connection con = db.getConnection();
    Statement st = con.createStatement();
    String query = "UPDATE player SET "
        + "playerName='" + player.getPlayerName()
        + "', playerClass='" + player.getPlayerClass()
        + "', playerRole='" + player.getPlayerRole()
        + "', playerLevel=" + player.getPlayerLevel()
        +  ", playerItemLevel=" + player.getPlayerItemLevel()
        +  ", playerInfo='" + player.getPlayerInfo()
        + "' WHERE playerId=" + player.getPlayerId();
    st.execute(query);


  }

  public void deletePlayerById (int playerId) throws SQLException, ClassNotFoundException {
    DataBase db = new DataBase();
    Connection con = db.getConnection();
    Statement st = con.createStatement();

    st.execute("DELETE FROM player WHERE playerId = " + playerId);
  }

}
