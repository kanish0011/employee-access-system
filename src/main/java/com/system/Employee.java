package com.system;

public class Employee {
    private String employeeId;
    private String name;
    private int age;
    private String department;
    private String employmentStatus; // e.g., "Active", "Inactive"
    private int securityClearanceLevel; // e.g., 1 (Low) to 3 (High)
    private boolean isIdValid;

    public Employee(String employeeId, String name, int age, String department, 
                    String employmentStatus, int securityClearanceLevel, boolean isIdValid) {
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.department = department;
        this.employmentStatus = employmentStatus;
        this.securityClearanceLevel = securityClearanceLevel;
        this.isIdValid = isIdValid;
    }

    // Getters
    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
    public String getEmploymentStatus() { return employmentStatus; }
    public int getSecurityClearanceLevel() { return securityClearanceLevel; }
    public boolean isIdValid() { return isIdValid; }
}
