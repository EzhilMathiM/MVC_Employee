package com.ideas2it.employee.dao;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;


/**
 * EmployeeDao is an interface which contains various methods.
 * These Methods are related to EmployeeManagement 
 * @author EzhilMathi.M 
 * @created 01.03.2021
 */
public interface EmployeeDao {
    /**
     * Method createEmployee creates an employee Record in the database with various fields
     * @param employee
     *        Employee Details
     * @return id
     *         id of employee is returned if created 
     */
     public int insertEmployee(Employee employee);
    /**
     * Method deleteEmployee deletes an employee Record based on employeeId entered
     * @param id
     *        id of employee to be deleted
     * @return boolean
     *         true if the employee Record is deleted 
     */	
    public boolean deleteEmployee(int employeeId);
	
    /**
     * Method updateEmployee updates employee Record based on employeeId entered
     * @param id
     *        id of employee to be updated
     * @param name
     *        updated name
     * @param address 
     *        updated address
     * @param salary
     *        updated salary
     * @param designation
     *        updated designation
     * @return boolean
     *         true if employee Record is updated
     */	
    public boolean updateEmployee(int employeeId, Employee employee);

    /**
     * Method displayEmployee dislays a particular employee record based on the id
     * @param id
     *        id of employee to be displayed
     * @return employeeDetails
     *         employee record from the database
     * @return null
     *         if employee record is not found
     */
    public Map<Integer, Employee> getEmployee(int employeeId);
    /**
     * Method displayAllEmployees displays entire employee Records from the database
     * @return List<String>
     *         All employee details from the database
     */
    public Map<Integer, Address> getAllAddresses();

    public boolean insertAddress(int employeeId, Address address);

    public Map<Integer, Address> getAddress(int employeeId);

    public Map<Integer, Employee> getAllEmployees();

    public boolean deleteAddress(int employeeId);

    public boolean updateAddress(int employeeId, Address address);

   

    
}