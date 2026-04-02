package com.zorvyn.finance_backend.service;

import com.zorvyn.finance_backend.model.FinancialRecord;
import com.zorvyn.finance_backend.repository.FinancialRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    private final FinancialRecordRepository recordRepository;

    public DashboardService(FinancialRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public double getTotalIncome() {
        List<FinancialRecord> records = recordRepository.findAll();
        return records.stream()
                .filter(r -> "INCOME".equalsIgnoreCase(r.getType()))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    public double getTotalExpense() {
        List<FinancialRecord> records = recordRepository.findAll();
        return records.stream()
                .filter(r -> "EXPENSE".equalsIgnoreCase(r.getType()))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    public double getNetBalance() {
        return getTotalIncome() - getTotalExpense();
    }
}