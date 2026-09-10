package com.system;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        
        // Sample test batch
        employees.add(new Employee("EMP001", "Alice", 28, "IT", "Active", 3, true));
        employees.add(new Employee("EMP002", "Bob", 19, "Marketing", "Inactive", 1, false));
        employees.add(new Employee("EMP003", "Charlie", 35, "HR", "Active", 1, true));

        int targetConfidentialLevel = 2;

        System.out.println("=== ACCESS ELIGIBILITY REPORT ===");
        for (Employee emp : employees) {
            System.out.println("\nEvaluating Employee: " + emp.getName());
            try {
                EligibilityEvaluator.EvaluationResult res = EligibilityEvaluator.evaluateAccess(emp, targetConfidentialLevel);
                System.out.println("Status: " + res.status);
                if (!res.reasons.isEmpty()) {
                    System.out.println("Reasons/Remarks:");
                    res.reasons.forEach(r -> System.out.println(" - " + r));
                }
            } catch (Exception e) {
                System.err.println("Error processing record: " + e.getMessage());
            }
        }
    }
}
