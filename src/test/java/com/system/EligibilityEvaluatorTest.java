package com.system;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.system.EligibilityEvaluator.EvaluationResult;

public class EligibilityEvaluatorTest {

    @Test
    public void testFullyEligibleEmployee() {
        Employee emp = new Employee("E01", "John", 25, "IT", "Active", 3, true);
        EvaluationResult res = EligibilityEvaluator.evaluateAccess(emp, 2);
        assertEquals("Eligible", res.status);
        assertTrue(res.reasons.isEmpty());
    }

    @Test
    public void testConditionallyEligibleBoundary() {
        Employee emp = new Employee("E02", "Jane", 21, "HR", "Active", 1, true);
        EvaluationResult res = EligibilityEvaluator.evaluateAccess(emp, 2);
        assertEquals("Conditionally Eligible", res.status);
        assertEquals(1, res.reasons.size());
    }

    @Test
    public void testMultipleFailuresScenario() {
        Employee emp = new Employee("E03", "Jake", 20, "Sales", "Inactive", 1, false);
        EvaluationResult res = EligibilityEvaluator.evaluateAccess(emp, 2);
        assertEquals("Not Eligible", res.status);
        assertTrue(res.reasons.size() >= 3); // Underage, Invalid Dept, Inactive Status
    }

    @Test
    public void testInvalidInputException() {
        assertThrows(IllegalArgumentException.class, () -> {
            EligibilityEvaluator.evaluateAccess(null, 1);
        });
    }
}
