package com.prog3.db.ormbean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The type Admin.
 */
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

  /**
   * Instantiates a new Admin.
   */
  public Admin() {
  }

  /**
   * Instantiates a new Admin.
   *
   * @param email    the email
   * @param password the password
   */
  public Admin(String email, String password) {
    this.email = email;
    this.password = password;
  }

  /**
   * Gets admin id.
   *
   * @return the admin id
   */
  public int getAdmin_id() {
    return admin_id;
  }

  /**
   * Sets admin id.
   *
   * @param admin_id the admin id
   */
  public void setAdmin_id(int admin_id) {
    this.admin_id = admin_id;
  }

  /**
   * Sets email.
   *
   * @param email the email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets email.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets password.
   *
   * @param password the password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Gets password.
   *
   * @return the password
   */
  public String getPassword() {
    return password;
  }
}
