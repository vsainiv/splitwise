package com.splitwise;

import java.util.List;

public class Group {

  private String id;
  private String name;
  private List<Person> personList;

  public Group(String id, String name, List<Person> personList) {
    this.id = id;
    this.name = name;
    this.personList = personList;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Person> getPersonList() {
    return personList;
  }

  public void setPersonList(List<Person> personList) {
    this.personList = personList;
  }
}
