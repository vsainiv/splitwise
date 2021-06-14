package com.splitwise;

import java.util.List;

public class Bill {

  private String description;
  private int totalAmount;
  private String groupId;
  private List<Split> involvedInBill;
  private List<Split> billPaidBy;

  public Bill(String description, int totalAmount, String groupId,
      List<Split> involvedInBill, List<Split> billPaidBy) {
    this.description = description;
    this.totalAmount = totalAmount;
    this.groupId = groupId;
    this.involvedInBill = involvedInBill;
    this.billPaidBy = billPaidBy;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(int totalAmount) {
    this.totalAmount = totalAmount;
  }

  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public List<Split> getInvolvedInBill() {
    return involvedInBill;
  }

  public void setInvolvedInBill(List<Split> involvedInBill) {
    this.involvedInBill = involvedInBill;
  }

  public List<Split> getBillPaidBy() {
    return billPaidBy;
  }

  public void setBillPaidBy(List<Split> billPaidBy) {
    this.billPaidBy = billPaidBy;
  }
}
