package com.prog3.db.ormbean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
  @Id
  @Column(name="admin_id")
  private int admin_id;

  @Column(name="email")
  private String email;

  @Column(name="password", nullable = false)
  private String password;

  public Admin() {
  }

  public Admin(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public int getAdmin_id() {
    return admin_id;
  }

  public void setAdmin_id(int admin_id) {
    this.admin_id = admin_id;
  }

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
