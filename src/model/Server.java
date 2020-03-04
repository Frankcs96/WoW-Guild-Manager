package model;

public class Server {
  private int serverId;
  private String serverName;
  private String serverRegion;

  public int getServerId() {
    return serverId;
  }

  public void setServerId(int serverId) {
    this.serverId = serverId;
  }

  public String getServerName() {
    return serverName;
  }

  public void setServerName(String serverName) {
    this.serverName = serverName;
  }

  public String getServerRegion() {
    return serverRegion;
  }

  public void setServerRegion(String serverRegion) {
    this.serverRegion = serverRegion;
  }

  public Server(int serverId, String serverName, String serverRegion) {
    this.serverId = serverId;
    this.serverName = serverName;
    this.serverRegion = serverRegion;


  }
}
