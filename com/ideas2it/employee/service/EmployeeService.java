/**
 *package com.ideas2it.employee.service contains EmployeeService class
 *All employee operations performed in the database are obatined from Dao class
 */
package com.ideas2it.employee.service;

import java.sql.Date;
import java.util.Map;
import java.util.HashMap;

import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.model.Address;


/** 
 * Class EmployeeService performs create,delete,display,update operations.
 * @author EzhilMathi.M 
 * @created 01.03.2021
 */
public interface EmployeeService {
    
    /**
     * Method createEmployee creates an employee record.
     * Constructs an Employee Pojo with the values obtained from controller class
     * sends the constructed Pojo to the dao class.
     * @param name 
     *        name of employee
     * @param contactNumber
     *        contact number of employee
     * @param salary 
     *        salary of employee
     * @param designation
     *        designation of employee
     * @return int
     *         employee returned from employeeDaoImpl class
     */
     public int createEmployee(String name, long contactNumber, long salary, String designation, Date dateOfBirth);
   
    /**
     * Method getEmployee constructs a string based an te value returned from dao class.
     * Sends the constructed String to controller class
     * @param employeeId 
     *        id of employee to be displayed
     * @return employee
     *         EmployeeDetails associated with the particular id returned from database
     * @return null
     *         if no details exist
     */
    public String getEmployee(int employeeId);

    /**
     * Method deleteEmployee returns the result returned from dao class.
     * @param employeeId 
     *        id of employee to be deleted
     * @return boolean
     *         true if employee record removed
     */
    public boolean deleteEmployee(int employeeId);

    /** 
     * Method getAllEmployees constructs a String from the employee Details retrieved from the database
     * Sends the constructed string to controller class
     * @return employeeRecords
     *         All employee records
     */
    public String getAllEmployees();

     /**
     * Method updateEmployee updates an employee record constructs a Pojo and sends it to dao class.
     * Updates value based on choice
     * @param employeeId
     *        id of employee to be updated
     * @param choice
     *        choice for field to be updated
     * @param updatedValue 
     *        updated value of the field
     * @return boolean 
     *         true if updated
     */
    public boolean updateEmployee(int employeeId, int choice, String updatedValue);

    /**
     * Method createAddress passes values to be inserted into db to dao class.
     * Adds address details to Map with id as the key
     * @param employeeId
     *        id of employee is inserted into database after creation 
     * @param houseNumber
     * @param streetName
     * @param area
     * @param city
     * @param state
     * @param country
     * @param pinCode
     * @return boolean
     *         true if created else false
     */
    public boolean createAddress(int employeeId, String houseNumber, String streetName, String area, String city, String state,String country, int pinCode);

    /**
     * Method getAddress gets the address details retreived from the dao class.
     * Constructs a string and sends it to controller class
     * @param employeeId 
     *        id of employee whose address is to be displayed
     * @return address
     *         AddressDetails associated with the particular id returned from database
     * @return null
     *         if no details exist
     */
    public String getAddress(int employeeId);

    /** 
     * Method getAllAddresses gets the address details retreived from the dao class.
     * Constructs a string and sends it to controller class
     * @return addresses
     *         All employee's addresses 
     */
    public String getAllAddresses();

    /**
     * Method deleteAddress passes employeeId to dao class and returns the result to the controller class.
     * @param employeeId 
     *        id of employee whose address is to be deleted
     * @return boolean
     *         true if employee's address is removed else false
     */
    public boolean deleteAddress(int employeeId);

    /**
     * Method updateAddress updates an employee's address constructs a Pojo and sends it to dao class.
     * Returns the result from dao to controller class
     * @param employeeId
     *        id of employee whose address is to be updated
     * @param choice
     *        choice for field to be updated
     * @param updatedValue 
     *        updated value of the field
     * @return boolean 
     *         true if updated else false
     */
    public boolean updateAddress(int employeeId, int choice, String updatedValue);
    
    /**
     * Method validateContactNumber checks if the contact number is valid 
     * @param contactNumber
     *        contact number entered by user
     * @return boolean 
     *         true if valid else false
     */
    public boolean validateContactNumber(String contactNumber);

    /**
     * Method validateDate checks if the date is valid 
     * @param dateOfBirth
     *        dateOfBirth entered by user
     * @return boolean 
     *         true if valid else false
     */
    public boolean validateDate(String dateOfBirth);
}