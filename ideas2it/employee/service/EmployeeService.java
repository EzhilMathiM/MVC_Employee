/**
 *package com.ideas2it.employee.service contains EmployeeService class
 *All employee operations are performed in this class
 */
package com.ideas2it.employee.service;

import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import com.ideas2it.employee.model.Employee;

/** 
 * Class EmployeeService performs create,delete,display,update operations.
 * @author EzhilMathi.M 
 * @created 24.02.2021
 */
public class EmployeeService {
    Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
    int employeeId = 1;

    /**
     * Method createEmployee creates an employee record.
     * Adds employee details to Map with id as the key
     * @param name 
     *        name of employee
     * @param address
     *        address of employee
     * @param salary 
     *        salary of employee
     * @param designation
     *        designation of employee
     * @return true
     */
    public boolean createEmployee(String name, String address, long salary,
            String designation) {
        Employee employee = new Employee(name, address, salary, designation);
        if(null == employees.put(employeeId, employee)) {
            ++employeeId;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method displayEmployee displays an employee record.
     * @param employeeId 
     *        id of employee to be displayed
     * @return employeeList
     *         EmployeeDetails associated with the particular id
     */
    public String displayEmployee(int employeeId) {
        Employee employeeValue = employees.get(employeeId);
        if(true == searchEmployee(employeeId)) {
            String employee = "Employee Name:" + employeeValue.getName() + 
                    "\nEmployee Address:" + employeeValue.getAddress() +
                    "\nEmployee Salary:" + employeeValue.getSalary() + 
                    "\nEmployee Designation:" + employeeValue.getDesignation();
            return employee;
        } else {
            return null;
        }
    } 

    /**
     * Method deleteEmployee deletes an employee record.
     * @param employeeId 
     *        id of employee to be deleted
     * @return boolean
     *         true if employee record removed
     */
    public boolean deleteEmployee(int employeeId) {
        if(null != employees.remove(employeeId)) {
            return true;
        } else {
            return false;
        }
    }
 
    /** 
     * Method displayAllEmployees displays all the employee details
     * @return employeeRecords
     *         All employee records
     */
    public String displayAllEmployees() {
        String employeeDetails = employees.toString();
        String alterRecords = employeeDetails.replaceAll("[={}]","");
        String employeeRecords = alterRecords.replaceAll("[,]","Employee Id:");
        return employeeRecords;
    }

    /**
     * Method searchEmployee searches an employee record.
     * @param employeeId 
     *        id of employee to be found
     * @return boolean
     *         true if employee record is null
     */
    public boolean searchEmployee(int employeeId) {
        Employee employee = employees.get(employeeId);
        if(null == employee) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Method updateEmployee updates an employee record.
     * Updates value based on choice
     * @param employeeId
     *        id of employee to be updated
     * @param choice
     *        choice for field to be updated
     * @param updatedField 
     *        updated value of the field
     * @return boolean 
     *         true if updated
     */
    public boolean updateEmployee(int employeeId, int choice,
            String updatedField) {
        Employee employee = employees.get(employeeId);
        if(true == searchEmployee(employeeId)) {
            switch(choice) {
                case 1 :
                    employee.setName(updatedField);
                    break;
                case 2 :
                    employee.setAddress(updatedField);
                    break;
                case 3 :
                    employee.setSalary(Long.parseLong(updatedField));
                    break;
                case 4 :
                    employee.setDesignation(updatedField);
                    break;
                default:
                    break;
            }
            return true;
        } else {
            return false;
        }
    }
}