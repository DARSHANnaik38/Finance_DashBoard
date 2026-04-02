package com.zorvyn.finance_backend.security;

public class RoleChecker {

    public static void checkAdmin(String role) {
        if (!"ADMIN".equalsIgnoreCase(role)) {
            throw new RuntimeException("Access denied. ADMIN only.");
        }
    }

    public static void checkReadAccess(String role) {
        if (!(role.equalsIgnoreCase("ADMIN") ||
                role.equalsIgnoreCase("ANALYST") ||
                role.equalsIgnoreCase("VIEWER"))) {

            throw new RuntimeException("Access denied.");
        }
    }
}