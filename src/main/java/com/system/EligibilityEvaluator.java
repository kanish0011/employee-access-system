package com.system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EligibilityEvaluator {
    private static final List<String> AUTHORIZED_DEPARTMENTS = 
            Arrays.asList("IT", "HR", "FINANCE", "ADMINISTRATION");

    public static class EvaluationResult {
        public String status;
        public List<String> reasons = new ArrayList<>();
    }

    public static EvaluationResult evaluateAccess(Employee emp, int requestedAccessLevel) {
        EvaluationResult result = new EvaluationResult();
        
        if (emp == null) {
            throw new IllegalArgumentException("Employee details cannot be null.");
        }

        // Validate individual rules accumulating all errors
        if (emp.getAge() < 21) {
            result.reasons.add("Age is under 21 (" + emp.getAge() + ").");
        }
        if (emp.getDepartment() == null || !AUTHORIZED_DEPARTMENTS.contains(emp.getDepartment().toUpperCase())) {
            result.reasons.add("Department '" + emp.getDepartment() + "' is not authorized.");
        }
        if (!"ACTIVE".equalsIgnoreCase(emp.getEmploymentStatus())) {
            result.reasons.add("Employment status is not Active.");
        }
        if (!emp.isIdValid() || emp.getEmployeeId() == null || emp.getEmployeeId().trim().isEmpty()) {
            result.reasons.add("Employee ID is invalid or missing.");
        }

        // Evaluate Status
        if (!result.reasons.isEmpty()) {
            result.status = "Not Eligible";
        } else if (emp.getSecurityClearanceLevel() < requestedAccessLevel) {
            result.status = "Conditionally Eligible";
            result.reasons.add("Insufficient security clearance (Has level " 
                    + emp.getSecurityClearanceLevel() + ", needs " + requestedAccessLevel + ").");
        } else {
            result.status = "Eligible";
        }

        return result;
    }
}
