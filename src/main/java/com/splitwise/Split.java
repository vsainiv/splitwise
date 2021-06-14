package com.splitwise;

public class Split {

  private Person person;
  private int share;

  public Split(Person person, int share) {
    this.person = person;
    this.share = share;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public int getShare() {
    return share;
  }

  public void setShare(int share) {
    this.share = share;
  }
}
