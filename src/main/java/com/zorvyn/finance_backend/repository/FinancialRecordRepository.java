package com.zorvyn.finance_backend.repository;

import com.zorvyn.finance_backend.model.FinancialRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {
}