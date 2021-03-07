package com.ideas2it.employee.model;

import java.sql.Date;

/**
 * Class Employee holds Employee details
 * @author Ezhilmathi.M
 * @created 24.02.2021
 */
public class Employee {
   
    private String name;
    private long contactNumber;
    private long salary;
    private String designation;
    Date dateOfBirth;

    public Employee() {
    }
    
    public Employee(String name, long contactNumber, long salary,
                    String designation, Date dateOfBirth) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.salary = salary;
        this.designation = designation;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String toString() {
        return ("EmployeeId" + "\nName:" + this.name + "  ContactNumber:" + this.contactNumber +
               "  Salary:" + this.salary + "  Designation:" + this.designation + "Date: " + dateOfBirth + "\n");
    }
}