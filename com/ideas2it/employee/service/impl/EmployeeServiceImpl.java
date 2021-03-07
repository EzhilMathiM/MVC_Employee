/**
 *package com.ideas2it.employee.service.impl contains EmployeeServiceImpl class
 *All employee operations are performed in this class
 */
package com.ideas2it.employee.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.regex.*;
import java.util.Map;

import com.ideas2it.employee.dao.EmployeeDao;
import com.ideas2it.employee.dao.impl.EmployeeDaoImpl;
import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.service.EmployeeService;

/** 
 * Class EmployeeService performs create,delete,display,update operations.
 * @author EzhilMathi.M 
 * @created 01.03.2021
 */
public class EmployeeServiceImpl implements EmployeeService {
    
    EmployeeDao employeeDao = new EmployeeDaoImpl();
   
    /**
     * {@inheritDoc}
     */
    public int createEmployee(String name, long contactNumber, long salary,
            String designation, Date dateOfBirth) {
        Employee employee = new Employee(name, contactNumber, salary,
                designation, dateOfBirth);
        return employeeDao.insertEmployee(employee);
    }

    /**
     * {@inheritDoc}
     */
    public String getEmployee(int employeeId) {
        Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
        employeeMap = employeeDao.getEmployee(employeeId);
        if(employeeMap.isEmpty()) {
            return null;
        } else {
            String employee = employeeMap.toString().replaceAll("[{,=}]","");
            return employee;
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean deleteEmployee(int employeeId) {
        return employeeDao.deleteEmployee(employeeId);
    }
 
    /**
     * {@inheritDoc}
     */
    public String getAllEmployees() {
        Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
        employeeMap = employeeDao.getAllEmployees();
        String employees = employeeMap.toString().replaceAll("[{,=}]","");
        return employees;
    }

    /**
     * {@inheritDoc}
     */
    public boolean updateEmployee(int employeeId, int choice,
            String updatedValue) {
        Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
        employeeMap = employeeDao.getEmployee(employeeId);
        Employee employee = employeeMap.get(employeeId);
        switch (choice) {
            case 1:
                employee.setName(updatedValue);
                break;
            case 2:
                employee.setContactNumber(Long.valueOf(updatedValue));
                break;
            case 3:
                employee.setSalary(Long.valueOf(updatedValue));
                break;
            case 4:
                employee.setDesignation(updatedValue);
                break;
            case 5:
                employee.setDateOfBirth(Date.valueOf(updatedValue));
                break;
        }
        return employeeDao.updateEmployee(employeeId, employee);
    }

    /**
     * {@inheritDoc}
     */
    public boolean createAddress(int employeeId, String houseNumber,
            String streetName, String area, String city, String state,
            String country, int pinCode) {
        Address address = new Address(employeeId, houseNumber,
                streetName, city, state, area, country, pinCode);
        return employeeDao.insertAddress(employeeId, address);
    }

    /**
     * {@inheritDoc}
     */
    public String getAddress(int employeeId) {
        Map<Integer, Address> addressDetails = new HashMap<Integer, Address>();
        addressDetails = employeeDao.getAddress(employeeId);
        if(addressDetails.isEmpty()) {
            return null;
        } else {
            String address = addressDetails.toString().replaceAll("[{,=}]","");
            return address;
        }
    }

    /**
     * {@inheritDoc}
     */
    public String getAllAddresses() {
        Map<Integer, Address> addressDetails = new HashMap<Integer, Address>();
        addressDetails = employeeDao.getAllAddresses();
        String addresses = addressDetails.toString().replaceAll("[{,=}]","");
        return addresses;
    }

    /**
     * {@inheritDoc}
     */
    public boolean deleteAddress(int employeeId) {
        return employeeDao.deleteAddress(employeeId);
    }

    /**
     * {@inheritDoc}
     */
    public boolean updateAddress(int employeeId, int choice, String updatedValue) {
        Map<Integer, Address> addressDetails = new HashMap<Integer, Address>();
        addressDetails = employeeDao.getAddress(employeeId);
        Address address = addressDetails.get(employeeId);
        switch (choice) {
            case 1:
                address.setHouseNumber(updatedValue);
                break;
            case 2:
                address.setStreetName(updatedValue);
                break;
            case 3:
                address.setArea(updatedValue);
                break;
            case 4:
                address.setCity(updatedValue);
                break;
            case 5:
                address.setState(updatedValue);
                break;
            case 6:
                address.setCountry(updatedValue);
                break;
            case 7:
                address.setPinCode(Integer.parseInt(updatedValue));
                break;
        }
        return employeeDao.updateAddress(employeeId, address);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validateContactNumber(String contactNumber) {
        String regex = "(0/91)?[7-9][0-9]{9}"; 
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(contactNumber).matches() ? true : false; 
    }
	
    /**
     * {@inheritdoc}
     */
    @Override
    public boolean validateDate(String dateOfBirth) {
        String regex = "^([0-9]{4})-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$";
        return dateOfBirth.matches(regex) ? true : false;		
    }
}