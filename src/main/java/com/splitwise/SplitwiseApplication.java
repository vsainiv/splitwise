package com.splitwise;

import com.splitwise.enums.SplitStrategy;
import java.util.ArrayList;
import java.util.List;

public class SplitwiseApplication {

  public static void main(String[] args) {

    SplitwiseManager splitwiseManager = new SplitwiseManager();

    //Add Persons
    Person person1 = new Person("person1@xyz.com", "Person1");
    Person person2 = new Person("person2@xyz.com", "Person2");
    Person person3 = new Person("person3@xyz.com", "Person3");
    // Person person4 = new Person("person4@xyz.com", "Person4");
    splitwiseManager.addPerson(person1);
    splitwiseManager.addPerson(person2);
    splitwiseManager.addPerson(person3);
    //splitwiseManager.addPerson(person4);

    //Add Groups
    List<Person> group1PersonList = new ArrayList<>();
    group1PersonList.add(person1);
    group1PersonList.add(person2);
    group1PersonList.add(person3);
    //group1PersonList.add(person3);
    Group group1 = new Group("group1", "Movie", group1PersonList);
    splitwiseManager.addGroup(group1);
    List<Person> group2PersonList = new ArrayList<>();
    //group2PersonList.add(person4);
    group2PersonList.add(person2);
    group2PersonList.add(person3);
    Group group2 = new Group("group2", "Dinner", group2PersonList);
    splitwiseManager.addGroup(group2);

    //Add Bills
    List<Split> personInvolved = new ArrayList<>();
    personInvolved.add(new Split(person1, 25));
    personInvolved.add(new Split(person2, 50));
    personInvolved.add(new Split(person3, 25));
    //personInvolved.add(new Split(person3, 0));
    List<Split> personPaid = new ArrayList<>();
    personPaid.add(new Split(person1, 25));
    personPaid.add(new Split(person2, 75));
    Bill bill = new Bill("movie bill", 100, "group1", personInvolved, personPaid);
    splitwiseManager.addBill(bill, SplitStrategy.EQUALLY);

//    List<Split> personInvolved2 = new ArrayList<>();
//    personInvolved2.add(new Split(person1, 0));
//    personInvolved2.add(new Split(person2, 0));
//    //personInvolved.add(new Split(person3, 0));
//    List<Split> personPaid2 = new ArrayList<>();
//    personPaid2.add(new Split(person2, 500));
//    Bill bill2 = new Bill("movie bill", 500, "group1", personInvolved2, personPaid2);
//    splitwiseManager.addBill(bill2, SplitStrategy.EQUALLY);
//
//    List<Split> personInvolved3 = new ArrayList<>();
//    personInvolved3.add(new Split(person3, 10));
//    personInvolved3.add(new Split(person2, 90));
//    //personInvolved.add(new Split(person3, 0));
//    List<Split> personPaid3 = new ArrayList<>();
//    personPaid.add(new Split(person3, 100));
//    Bill bill3 = new Bill("movie bill", 100, "group2", personInvolved3, personPaid3);
//    splitwiseManager.addBill(bill3, SplitStrategy.PERCENTAGE_SHARE);
//
//    List<Split> personInvolved4 = new ArrayList<>();
//    personInvolved4.add(new Split(person3, 0));
//    personInvolved4.add(new Split(person2, 0));
//    //personInvolved.add(new Split(person3, 0));
//    List<Split> personPaid4 = new ArrayList<>();
//    personPaid4.add(new Split(person2, 200));
//    personPaid4.add(new Split(person3, 100));
//    Bill bill4 = new Bill("movie bill", 300, "group2", personInvolved4, personPaid4);
//    splitwiseManager.addBill(bill4, SplitStrategy.EQUALLY);

    splitwiseManager.getBalanceForPersonInEachGroup(person1.getEmailId());
    splitwiseManager.getBalanceForPersonInEachGroup(person2.getEmailId());
    splitwiseManager.getBalanceForPersonInEachGroup(person3.getEmailId());
//    splitwiseManager.getBalanceForPersonInEachGroup(person2.getEmailId());
//    splitwiseManager.getBalanceForPersonInEachGroup(person3.getEmailId());

    splitwiseManager.getBalanceForPerson(person1.getEmailId());
    splitwiseManager.getBalanceForPerson(person2.getEmailId());
    splitwiseManager.getBalanceForPerson(person3.getEmailId());
//    splitwiseManager.getBalanceForPerson(person2.getEmailId());
//    splitwiseManager.getBalanceForPerson(person3.getEmailId());

  }

}
