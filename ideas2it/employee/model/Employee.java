package com.ideas2it.employee.model;

/**
 * Class Employee holds Employee details
 * @author Ezhilmathi.M
 * @created 24.02.2021
 */
public class Employee {
    private long salary;
    private String name;
    private String address;
    private String designation;
    
    public Employee(String name, String address, long salary,
                    String designation) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.designation = designation;
    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String toString() {
        return ("\nName:" + this.name + "  Address:" + this.address+
               "  Salary:" + this.salary + "  Designation:" + this.designation + "\n");
    }
}