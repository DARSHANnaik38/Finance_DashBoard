package com.zorvyn.finance_backend.controller;

import com.zorvyn.finance_backend.model.FinancialRecord;
import com.zorvyn.finance_backend.service.FinancialRecordService;
import com.zorvyn.finance_backend.security.RoleChecker;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class FinancialRecordController {

    private final FinancialRecordService recordService;

    public FinancialRecordController(FinancialRecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    public FinancialRecord createRecord(
            @RequestHeader("role") String role,
            @RequestBody FinancialRecord record) {

        RoleChecker.checkAdmin(role);

        if(record.getAmount() == null || record.getAmount() <= 0){
            throw new RuntimeException("Amount must be positive");
        }

        if(record.getType() == null){
            throw new RuntimeException("Type is required");
        }

        return recordService.createRecord(record);
    }

    @GetMapping
    public List<FinancialRecord> getAllRecords(
            @RequestHeader("role") String role) {

        RoleChecker.checkReadAccess(role);
        return recordService.getAllRecords();
    }

    @GetMapping("/filter")
    public List<FinancialRecord> filterRecords(
            @RequestHeader("role") String role,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String category) {

        RoleChecker.checkReadAccess(role);
        return recordService.filterRecords(type, category);
    }

    @PutMapping("/{id}")
    public FinancialRecord updateRecord(
            @RequestHeader("role") String role,
            @PathVariable Long id,
            @RequestBody FinancialRecord record) {

        RoleChecker.checkAdmin(role);
        return recordService.updateRecord(id, record);
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(
            @RequestHeader("role") String role,
            @PathVariable Long id) {

        RoleChecker.checkAdmin(role);
        recordService.deleteRecord(id);
    }
}