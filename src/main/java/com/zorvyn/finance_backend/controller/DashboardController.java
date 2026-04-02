package com.zorvyn.finance_backend.controller;

import com.zorvyn.finance_backend.dto.DashboardSummaryDTO;
import com.zorvyn.finance_backend.security.RoleChecker;
import com.zorvyn.finance_backend.service.DashboardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/summary")
    public DashboardSummaryDTO getSummary(
            @RequestHeader("role") String role) {

        RoleChecker.checkReadAccess(role);

        return new DashboardSummaryDTO(
                dashboardService.getTotalIncome(),
                dashboardService.getTotalExpense(),
                dashboardService.getNetBalance()
        );
    }
}