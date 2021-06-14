package com.splitwise;

public class Person {

  private String emailId;
  private String name;

  public Person(String emailId, String name) {
    this.emailId = emailId;
    this.name = name;
  }

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
