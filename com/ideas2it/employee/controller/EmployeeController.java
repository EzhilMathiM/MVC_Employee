/**
 * Package com.ideas2it.employee.controller contains EmployeeController class
 * It passes values from EmployeeView class to EmployeeService class
 */
package com.ideas2it.employee.controller;

import com.ideas2it.employee.service.EmployeeService;

/** 
 * Class EmployeeController passes input from user to EmployeeService.
 * @author EzhilMathi.M 
 * @created 24.02.2021
 */
public class EmployeeController {
    EmployeeService employeeService = new EmployeeService();
    
    /** 
     * Method createEmployee passes user input to EmployeeService Class
     * @param name 
     *        name of employee
     * @param address
     *        address of employee
     * @param salary 
     *        salary of employee
     * @param designation
     *        designation of employee
     * @return true
     *         value returned from EmployeService class
     */
    public boolean createEmployee(String name,String address,
            long salary, String designation) {
        return employeeService.createEmployee(name, address, salary,
                designation);
    }

    /**
     * Method displayEmployee passes employeeId to EmployeeService class.
     * @param employeeId 
     *        id of employee to be displayed
     * @return List
     *         List returned from EmployeeService class
     */
    public String displayEmployee(int employeeId) {
        return employeeService.displayEmployee(employeeId);
    }

    /**
     * Method searchEmployee passes employeeId to EmployeeService class.
     * @param employeeId 
     *        id of employee to be found
     * @return boolean
     *         value returned from EmployeeService class
     */
    public boolean searchEmployee(int employeeId) {
        return employeeService.searchEmployee(employeeId);
    }

    /**
     * Method deleteEmployee passes employeeId to EmployeeService class.
     * @param employeeId 
     *        id of employee to be deleted
     * @return boolean
     *         value returned from EmployeeService class
     */
    public boolean deleteEmployee(int employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }

    /** 
     * Method displayAllEmployees calls displayAllEmployees Method of Service
     * @return List
     *         List returned from EmployeeService class
     */
    public String displayAllEmployees() {
        return employeeService.displayAllEmployees();
    }

    /**
     * Method updateEmployee passes employeeId to be updated 
     * choice and updated value to EmployeeService class.
     * Updates value based on choice
     * @param employeeId
     *        id of employee to be updated
     * @param choice
     *        choice for field to be updated
     * @param updatedField 
     *        updated value of the field
     * @return boolean 
     *         value returned from EmployeeService class
     */
    public boolean updateEmployee(int employeeId, int choice,
                                  String updatedRecord) {
        return employeeService.updateEmployee(employeeId, choice, 
                updatedRecord);
    }
}
