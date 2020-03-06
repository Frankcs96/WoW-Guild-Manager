package model;

public class Player {
  private int playerId;
  private String playerName;
  private String playerClass;
  private String playerRole;
  private int playerLevel;
  private int playerItemLevel;
  private String playerInfo;
  private int guildId;

  public Player(int playerId, String playerName, String playerClass, String playerRole,
      int playerLevel, int playerItemLevel, String playerInfo, int guildId) {
    this.playerId = playerId;
    this.playerName = playerName;
    this.playerClass = playerClass;
    this.playerRole = playerRole;
    this.playerLevel = playerLevel;
    this.playerItemLevel = playerItemLevel;
    this.playerInfo = playerInfo;
    this.guildId = guildId;
  }

  public Player(String playerName, String playerClass, String playerRole, int playerLevel,
      int playerItemLevel, String playerInfo, int guildId) {
    this.playerName = playerName;
    this.playerClass = playerClass;
    this.playerRole = playerRole;
    this.playerLevel = playerLevel;
    this.playerItemLevel = playerItemLevel;
    this.playerInfo = playerInfo;
    this.guildId = guildId;
  }

  public int getPlayerId() {
    return playerId;
  }

  public void setPlayerId(int playerId) {
    this.playerId = playerId;
  }

  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public String getPlayerClass() {
    return playerClass;
  }

  public void setPlayerClass(String playerClass) {
    this.playerClass = playerClass;
  }

  public String getPlayerRole() {
    return playerRole;
  }

  public void setPlayerRole(String playerRole) {
    this.playerRole = playerRole;
  }

  public int getPlayerLevel() {
    return playerLevel;
  }

  public void setPlayerLevel(int playerLevel) {
    this.playerLevel = playerLevel;
  }

  public int getPlayerItemLevel() {
    return playerItemLevel;
  }

  public void setPlayerItemLevel(int playerItemLevel) {
    this.playerItemLevel = playerItemLevel;
  }

  public String getPlayerInfo() {
    return playerInfo;
  }

  public void setPlayerInfo(String playerInfo) {
    this.playerInfo = playerInfo;
  }

  public int getGuildId() {
    return guildId;
  }

  public void setGuildId(int guildId) {
    this.guildId = guildId;
  }
}
