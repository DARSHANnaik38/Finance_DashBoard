package com.zorvyn.finance_backend.dto;

public class DashboardSummaryDTO {

    private double totalIncome;
    private double totalExpense;
    private double netBalance;

    public DashboardSummaryDTO(double totalIncome, double totalExpense, double netBalance) {
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.netBalance = netBalance;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public double getNetBalance() {
        return netBalance;
    }
}