package model;

public class Guild {

  private int id;
  private String guildName;
  private int userId;
  private int serverId;

  public Guild(int id, String guildName, int userId, int serverId) {
    this.id = id;
    this.guildName = guildName;
    this.userId = userId;
    this.serverId = serverId;
  }

  public Guild(String guildName, int userId, int serverId) {
    this.guildName = guildName;
    this.userId = userId;
    this.serverId = serverId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getGuildName() {
    return guildName;
  }

  public void setGuildName(String guildName) {
    this.guildName = guildName;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getServerId() {
    return serverId;
  }

  public void setServerId(int serverId) {
    this.serverId = serverId;
  }
}
