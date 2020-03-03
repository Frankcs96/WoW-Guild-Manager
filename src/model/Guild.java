package model;

public class Guild {

  private int id;
  private String guildName;
  private int userId;
  private int serverId;

  public Guild(String guildName, int serverId) {
    this.guildName = guildName;
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
