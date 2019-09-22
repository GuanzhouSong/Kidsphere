package com.example.kidsphere.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Coupon {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private CPType cpType;

  private Date expire;

  private boolean inUse;

  private boolean valid;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public CPType getCpType() {
    return cpType;
  }

  public void setCpType(CPType cpType) {
    this.cpType = cpType;
  }

  public Date getExpire() {
    return expire;
  }

  public void setExpire(Date expire) {
    this.expire = expire;
  }

  public boolean isInUse() {
    return inUse;
  }

  public void setInUse(boolean inUse) {
    this.inUse = inUse;
  }

  public boolean isValid() {
    return valid;
  }

  public void setValid(boolean valid) {
    this.valid = valid;
  }
}
