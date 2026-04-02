package com.zorvyn.finance_backend.service;

import com.zorvyn.finance_backend.model.FinancialRecord;
import com.zorvyn.finance_backend.repository.FinancialRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FinancialRecordService {

    private final FinancialRecordRepository recordRepository;

    public FinancialRecordService(FinancialRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public FinancialRecord createRecord(FinancialRecord record) {
        return recordRepository.save(record);
    }

    public List<FinancialRecord> getAllRecords() {
        return recordRepository.findAll();
    }

    public Optional<FinancialRecord> getRecordById(Long id) {
        return recordRepository.findById(id);
    }

    public FinancialRecord updateRecord(Long id, FinancialRecord updated) {
        return recordRepository.findById(id).map(record -> {
            record.setAmount(updated.getAmount());
            record.setType(updated.getType());
            record.setCategory(updated.getCategory());
            record.setDate(updated.getDate());
            record.setDescription(updated.getDescription());
            return recordRepository.save(record);
        }).orElseThrow(() -> new RuntimeException("Record not found"));
    }

    public List<FinancialRecord> filterRecords(String type, String category) {
        List<FinancialRecord> records = recordRepository.findAll();

        return records.stream()
                .filter(r -> type == null || r.getType().equalsIgnoreCase(type))
                .filter(r -> category == null || r.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    public List<FinancialRecord> filterByDate(LocalDate start, LocalDate end) {
        List<FinancialRecord> records = recordRepository.findAll();

        return records.stream()
                .filter(r -> (start == null || !r.getDate().isBefore(start)))
                .filter(r -> (end == null || !r.getDate().isAfter(end)))
                .toList();
    }

    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }
}