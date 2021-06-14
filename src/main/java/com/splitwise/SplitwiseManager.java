package com.splitwise;

import com.splitwise.enums.SplitStrategy;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SplitwiseManager {

  Map<String, Person> personMap;
  Map<String, Group> groupMap;
  private Map<String, Map<String, Double>> balanceSheet;

  SplitwiseManager() {
    personMap = new HashMap<>();
    groupMap = new HashMap<>();
    balanceSheet = new HashMap<>();
  }

  public void addPerson(Person person) {
    personMap.put(person.getEmailId(), person);
    balanceSheet.put(person.getEmailId(), new HashMap<>());
  }

  public void addGroup(Group group) {
    groupMap.put(group.getId(), group);
    for (Person person : group.getPersonList()) {
      balanceSheet.get(person.getEmailId()).put(group.getId(), 0.0);
    }
  }

  public void addBill(Bill bill, SplitStrategy splitStrategy) {

    switch (splitStrategy) {
      case EQUALLY:

        for (Split split : bill.getInvolvedInBill()) {
          int groupSize = groupMap.get(bill.getGroupId()).getPersonList().size();
          Map<String, Double> groupShareMap = balanceSheet.get(split.getPerson().getEmailId());
          double shareAsOfNow = groupShareMap.get(bill.getGroupId());
          double share = getEqualShare(bill.getTotalAmount(), groupSize);
          groupShareMap.put(bill.getGroupId(), shareAsOfNow + share);
          balanceSheet.put(split.getPerson().getEmailId(), groupShareMap);
        }

        for (Split split : bill.getBillPaidBy()) {
          Map<String, Double> groupShareMap = balanceSheet.get(split.getPerson().getEmailId());
          double shareAsOfNow = groupShareMap.get(bill.getGroupId());
          groupShareMap.put(bill.getGroupId(), shareAsOfNow - (double) split.getShare());
          balanceSheet.put(split.getPerson().getEmailId(), groupShareMap);
        }
        break;
      case PERCENTAGE_SHARE:

        for (Split split : bill.getInvolvedInBill()) {
          Map<String, Double> groupShareMap = balanceSheet.get(split.getPerson().getEmailId());
          double shareAsOfNow = groupShareMap.get(bill.getGroupId());
          double share = getPercentShare(bill.getTotalAmount(), split.getShare());
          groupShareMap.put(bill.getGroupId(), shareAsOfNow + share);
          balanceSheet.put(split.getPerson().getEmailId(), groupShareMap);
        }

        for (Split split : bill.getBillPaidBy()) {
          Map<String, Double> groupShareMap = balanceSheet.get(split.getPerson().getEmailId());
          double shareAsOfNow = groupShareMap.get(bill.getGroupId());
          groupShareMap.put(bill.getGroupId(), shareAsOfNow - (double) split.getShare());
          balanceSheet.put(split.getPerson().getEmailId(), groupShareMap);
        }
        break;
    }
  }

  public double getEqualShare(int amount, int totalPerson) {
    return amount / totalPerson;
  }

  public double getPercentShare(int amount, int percent) {
    return (amount * percent) / 100;
  }

  public void getBalanceForPerson(String id) {
    System.out.println("Total Balance for person :" + id);
    double totalShare = 0.0;
    for (Entry<String, Double> entry : balanceSheet.get(id).entrySet()) {
      totalShare += entry.getValue();
    }
    System.out.println(totalShare);
  }

  public void getBalanceForPersonInEachGroup(String id) {
    System.out.println("Balance for person in each group:" + id);
    for (Entry<String, Double> entry : balanceSheet.get(id).entrySet()) {
      System.out.println("Group :" + entry.getKey() + " Balance :" + entry.getValue());
    }
  }
}
