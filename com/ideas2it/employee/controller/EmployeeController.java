/**
 * Package com.ideas2it.employee.controller contains EmployeeController class
 * It passes values from EmployeeView class to EmployeeService class
 */
package com.ideas2it.employee.controller;

import java.sql.Date;
import com.ideas2it.employee.service.impl.EmployeeServiceImpl;

/** 
 * Class EmployeeController passes input from user to EmployeeService.
 * @author EzhilMathi.M 
 * @created 01.03.2021
 */
public class EmployeeController {
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    
    /** 
     * Method createEmployee passes user input to EmployeeService Class
     * @param name 
     *        name of employee
     * @param contactNumber
     *        contact number of employee
     * @param salary 
     *        salary of employee
     * @param designation
     *        designation of employee
     * @return int
     *         value returned from EmployeService class
     */
    public int createEmployee(String name, long contactNumber, long salary, String designation, Date dateOfBirth) {
        return employeeService.createEmployee(name, contactNumber, salary,
                designation, dateOfBirth);
    }

    /**
     * Method getEmployee passes employeeId to EmployeeService class.
     * @param employeeId 
     *        id of employee to be displayed
     * @return String
     *         Employeedetails returned from EmployeeService class
     */
    public String getEmployee(int employeeId) {
        return employeeService.getEmployee(employeeId);
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
     * Method getAllEmployees calls displayAllEmployees Method of Service
     * @return String
     *         emploee details  returned from EmployeeService class
     */
    public String getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /**
     * Method updateEmployee passes employeeId to be updated 
     * choice and updated value to EmployeeService class.
     * Updates value based on choice
     * @param employeeId
     *        id of employee to be updated
     * @param choice
     *        choice for field to be updated
     * @param updatedValue
     *        updated value of the field
     * @return boolean 
     *         value returned from EmployeeService class
     */
    public boolean updateEmployee(int employeeId, int choice,
            String updatedValue) {
        return employeeService.updateEmployee(employeeId, choice, updatedValue);
    }

    /** 
     * Method createAddress passes user input to EmployeeService Class
     * Returns values obtained from service class to view class
     * @param name 
     *        name of employee
     * @param contactNumber
     *        contact number of employee
     * @param salary 
     *        salary of employee
     * @param designation
     *        designation of employee
     * @return int
     *         value returned from EmployeService class
     */
    public boolean createAddress(int employeeId, String houseNumber,
            String streetName, String area, String city, String state, String country, int pinCode) {
        return employeeService.createAddress(employeeId, houseNumber, streetName,
                area, city, state, country, pinCode);
    }

    /**
     * Method getAddress passes employeeId to EmployeeService class.
     * Returns values obtained from service class to view class
     * @param employeeId 
     *        id of employee to be displayed
     * @return String
     *         Addressdetails returned from EmployeeService class
     */
    public String getAddress(int employeeId) {
        return employeeService.getAddress(employeeId);
    }

    /**
     * Method deleteAddress passes employeeId to EmployeeService class.
     * Returns values obtained from service class to view class
     * @param employeeId 
     *        id of employee to be deleted
     * @return boolean
     *         value returned from EmployeeService class
     */
    public boolean deleteAddress(int employeeId) {
        return employeeService.deleteAddress(employeeId);
    }

    
    /** 
     * Method getAllAddresses calls getAllAddresses Method of Service
     * Returns values obtained from service class to view class
     * @return String
     *         values  returned from EmployeeService class
     */
    public String getAllAddresses() {
        return employeeService.getAllAddresses();
    }

    /**
     * Method updateAddress passes employeeId to be updated 
     * choice and updated value to EmployeeService class.
     * Updates value based on choice
     * @param employeeId
     *        id of employee to be updated
     * @param choice
     *        choice for field to be updated
     * @param updatedValue
     *        updated value of the field
     * @return boolean 
     *         value returned from EmployeeService class
     */
    public boolean updateAddress(int employeeId, int choice,
            String updatedValue) {
        return employeeService.updateAddress(employeeId, choice, updatedValue);
    }

    /**
     * Method validateContactNumber Sends the contactNumber to Service class
     * @param contactNumber
     *        contactNumber of employee
     * @return boolean
     *         true if contactNumber is valid else false
     */
    public boolean validateContactNumber(String contactNumber) {
        return employeeService.validateContactNumber(contactNumber); 
    }
	
    /**
     * Method validateDate Sends the date to Service class
     * @param dateOfBirth
     *        dateOfBirth of employee
     * @return boolean
     *         true if date is valid else false
     */
    public boolean validateDate(String dateOfBirth) {
        return employeeService.validateDate(dateOfBirth); 
    }

}
