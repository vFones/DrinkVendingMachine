package com.prog3.hibernate.ormbean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
  private static final String pwd="password";
  @Id
  @Column(name="email")
  private String email;

  @Column(name="password", nullable = false)
  private String password;

  public void setEmail(String email) {
    this.email = email;
  }
  public String getEmail() {
    return email;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  public String getPassword() {
    return password;
  }
}
