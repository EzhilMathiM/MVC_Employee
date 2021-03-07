/**
 *package com.ideas2it.employee.dao contains EmployeeService class
 *All employee operations are performed in this class
 */
package com.ideas2it.employee.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.ideas2it.db.DatabaseConnection;
import com.ideas2it.employee.dao.EmployeeDao;
import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;

/** 
 * Class EmployeeDaoImpl performs create,delete,display,update operations.
 * These operations are done on the Employee details stored in the database.
 * @author EzhilMathi.M 
 * @created 01.03.2021
 */
public class EmployeeDaoImpl implements EmployeeDao {

    private Connection connection = DatabaseConnection.getConnection();
    /**
     * {@inheritDoc}
     */
    public int insertEmployee(Employee employee) {
        try {
            String insertQuery  = "INSERT INTO employee(name, contactnumber,"
                    +"salary, designation, dateofbirth) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(
                    insertQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setLong(2, employee.getContactNumber());
            preparedStatement.setLong(3, employee.getSalary());
            preparedStatement.setString(4, employee.getDesignation());
            preparedStatement.setDate(5, employee.getDateOfBirth());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    /**
     * {@inheritDoc}
     */
    public Map<Integer, Employee> getEmployee(int employeeId) {
        Map<Integer, Employee> employeeDetails = new HashMap<Integer,
                Employee>();
        try {
            String selectQuery = "SELECT * FROM employee where id ="
                    + employeeId;
            PreparedStatement preparedStatement = connection.prepareStatement(
                    selectQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = preparedStatement.executeQuery(); 
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getString(2),
                        resultSet.getLong(3), resultSet.getLong(4),
                        resultSet.getString(5), resultSet.getDate(6));
                employeeDetails.put(resultSet.getInt(1), employee);
                
            }
            return employeeDetails;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public boolean deleteEmployee(int employeeId) {
        try {
            Statement statement = connection.createStatement();
            int isDeleted = statement.executeUpdate(
                    "DELETE FROM Employee WHERE id=" + employeeId);
            if(1 == isDeleted) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
        
    }
    
    /**
     * {@inheritDoc}
     */
    public Map<Integer, Employee> getAllEmployees() {
        Map<Integer, Employee> employeeDetails = new HashMap<Integer, 
                Employee>();
        try {
            String selectQuery = "SELECT * FROM employee";
            PreparedStatement preparedStatement = connection.prepareStatement(
                    selectQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = preparedStatement.executeQuery(); 
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getString(2),
                        resultSet.getLong(3), resultSet.getLong(4),
                        resultSet.getString(5), resultSet.getDate(6));
                employeeDetails.put(resultSet.getInt(1), employee);
                
            }
            return employeeDetails;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public boolean updateEmployee(int employeeId, Employee employee) {
        Map<Integer, Employee> employeeDetails = new HashMap<Integer, 
                Employee>();
        employeeDetails = getEmployee(employeeId);
        if(employeeDetails.isEmpty()) {
            return false;
        } else {
            try {
                PreparedStatement preparedStatement = connection.
                        prepareStatement("UPDATE Employee SET name = ?,"
                        +"contactnumber = ?, salary = ?, designation = ?, dateofbirth = ? WHERE id= "+employeeId);
                preparedStatement.setString(1, employee.getName());
                preparedStatement.setLong(2, employee.getContactNumber());
                preparedStatement.setLong(3, employee.getSalary());
                preparedStatement.setString(4, employee.getDesignation());
                preparedStatement.setDate(5, employee.getDateOfBirth());
                preparedStatement.executeUpdate();
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();    
            }
        }
    return false;
    }

    /**
     * {@inheritDoc}
     */
    public Map<Integer, Address> getAllAddresses() {
        Map<Integer, Address> addressDetails = new HashMap<Integer, 
                Address>();
        try {
            String selectQuery = "SELECT * FROM address";
            PreparedStatement preparedStatement = connection.prepareStatement(
                    selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery(); 
            while (resultSet.next()) {
                Address address = new Address(resultSet.getInt(1), 
                        resultSet.getString(2), resultSet.getString(3), 
                        resultSet.getString(4), resultSet.getString(5), 
                        resultSet.getString(6), resultSet.getString(7), 
                        resultSet.getInt(8));
                addressDetails.put(resultSet.getInt(1), address);
            }
            return addressDetails;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public boolean insertAddress(int employeeId, Address address) {
        try {
            String insertQuery  = "INSERT INTO address(employee_id, houseNumber,"
                    +"streetName, area, city, state, country," 
                    +"pinCode) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(
                    insertQuery);
            preparedStatement.setInt(1, employeeId);
            preparedStatement.setString(2, address.getHouseNumber());
            preparedStatement.setString(3, address.getStreetName());
            preparedStatement.setString(4, address.getArea());
            preparedStatement.setString(5, address.getCity());
            preparedStatement.setString(6, address.getState());
            preparedStatement.setString(7, address.getCountry());
            preparedStatement.setInt(8, address.getPinCode());
            preparedStatement.executeUpdate();
            return true;
            } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean deleteAddress(int employeeId) {
        try {
            Statement statement = connection.createStatement();
            int isDeleted = statement.executeUpdate(
                    "DELETE FROM address WHERE employee_id=" + employeeId);
            if(1 == isDeleted) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
        
    }
    
    /**
     * {@inheritDoc}
     */
    public Map<Integer, Address> getAddress(int employeeId) {
        Map<Integer, Address> addressDetails = new HashMap<Integer, Address>();
        try {
            String selectQuery = "SELECT * FROM address where employee_id ="
                    + employeeId;
            PreparedStatement preparedStatement = connection.prepareStatement(
                    selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery(); 
            while (resultSet.next()) {
                Address address = new Address(resultSet.getInt(1),
                        resultSet.getString(2), resultSet.getString(3), 
                        resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6), resultSet.getString(7),
                        resultSet.getInt(8));
                addressDetails.put(employeeId, address);
                
            }
            return addressDetails;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean updateAddress(int id, Address address) {
        Map<Integer, Address> employeeDetails = new HashMap<Integer,
                Address>();
        employeeDetails = getAddress(id);
        System.out.println(employeeDetails);
        if(employeeDetails.isEmpty()) {
            return false;
        } else {
            try {
                PreparedStatement preparedStatement = connection.
                        prepareStatement("UPDATE address SET housenumber = ?,"
                        +"streetname = ?, area = ?, city = ?, state = ?, country = ?, pincode = ? WHERE employee_id= "+id);
                preparedStatement.setString(1, address.getHouseNumber());
                preparedStatement.setString(2, address.getStreetName());
                preparedStatement.setString(3, address.getArea());
                preparedStatement.setString(4, address.getCity());
                preparedStatement.setString(5, address.getState());
                preparedStatement.setString(6, address.getCountry());
                preparedStatement.setInt(7, address.getPinCode());
                preparedStatement.executeUpdate();
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();    
            }
        }
    return false;
    }
}