package model;

import java.util.Objects;

public class User {
  private int id;
  private String userName;
  private String password;

  public User(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public User(int id, String userName, String password) {
    this.id = id;
    this.userName = userName;
    this.password = password;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return userName.equals(user.userName) &&
        password.equals(user.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName, password);
  }
}
