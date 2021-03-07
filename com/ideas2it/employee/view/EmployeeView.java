/** 
 * Package com.ideas2it.employee.view contains EmployeeView Class
 * All interactions with the user are done here.
 */ 
package com.ideas2it.employee.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.Date;
import java.util.regex.*;

import com.ideas2it.employee.controller.EmployeeController;

/** 
 * Class EmployeeView gets input from user.
 * In order to perform create,delete,display,update on EmployeeDetails
 * @author EzhilMathi.M 
 * @created 01.03.2021
 */
public class EmployeeView {
    BufferedReader reader = new BufferedReader(new 
            InputStreamReader(System.in));
    EmployeeController employeeController = new EmployeeController();

    /**
     * Method getChoice gets choice and performs operations on EmployeeDetails
     * Create, Delete, Update, Display are called in this method 
     */
    public void getChoice() throws IOException {
        int choice;
        String startStatement = "EMPLOYEE MANAGEMENT:\n1.Create\n2.Delete"
                +"\n3.Display\n4.DisplayAll\n5.Update\n6.Exit";
        String choiceStatement = "Enter your choice";
        do {
            System.out.println(startStatement);
            System.out.println(choiceStatement);
            choice = Integer.parseInt(reader.readLine());
            switch(choice) {
                case 1:
                    createEmployee();
                    break;
                case 2:
                    deleteEmployee();
                    break;
                case 3:
                    displayEmployee();
                    break;
                case 4:
                    displayAllEmployees();
                    break;
                case 5:
                    updateEmployee();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while(6 != choice);
    }
 
    /**
     * Method createEmployee gets input from user to create employee record.
     * Passes it to EmployeeController Class
     * name, address, salary, designation are read from the user
     */   
    private void createEmployee() throws IOException {  		
        System.out.println("Enter Name: ");
        String name = reader.readLine();
        System.out.println("Enter ContactNumber: ");
        long contactNumber = validateContactNumber(reader.readLine());
        System.out.println("Enter Salary: ");
        long salary = Long.parseLong(reader.readLine());
        System.out.println("Enter Designation: ");
        String designation = reader.readLine();
        System.out.println("Enter your date of birth(yyyy-MM-dd): ");
        Date dateOfBirth = Date.valueOf(validateDate(reader.readLine()));
        int employeeId = employeeController.createEmployee(name, contactNumber,
                salary, designation, dateOfBirth);
        System.out.println("Enter Total number of Address : ");
        int totalNumberOfAddresses = Integer.parseInt(reader.readLine());
        for (int addressNumber = 1; addressNumber <= totalNumberOfAddresses;
                addressNumber++) {
            System.out.println("Enter House Number");
            String houseNumber = reader.readLine();
            System.out.println("Enter Street Name");
            String streetName = reader.readLine();
            System.out.println("Enter Area");
            String area = reader.readLine();
            System.out.println("Enter City");
            String city = reader.readLine();
            System.out.println("Enter State");
            String state = reader.readLine();
            System.out.println("Enter Country");
            String country = reader.readLine();
            System.out.println("Enter pinCode");
            int pincode = Integer.parseInt(reader.readLine());
            employeeController.createAddress(employeeId, houseNumber,
                    streetName, area, city, state, country, pincode);
        }
        if (-1 != employeeId) {
            System.out.println("Created successfully");
            System.out.println("Employee id :" + employeeId);
        } else {
            System.out.println("Error creating record!!!");
        }
    }

    /**
     * Method displayEmployee gets id from user to display Employee details
     * Prints the corresponding Employee details
     */
    private void displayEmployee() throws IOException {
        System.out.println("Enter id:");
        int id = Integer.parseInt(reader.readLine());
        if(null != employeeController.getEmployee(id)) {
            System.out.println(employeeController.getEmployee(id));
            displayAddress(id);
        } else {
            System.out.println("No Records Found");
        } 
    }

    /**
     * Method deleteEmployee gets id from user to delete Employee details
     * Prints whether the employee detail is deleted 
     */
    private void deleteEmployee() throws IOException {
        System.out.println("Enter id");
        int id = Integer.parseInt(reader.readLine());
        if (true == employeeController.deleteEmployee(id)) {
            deleteAddress(id);
            System.out.println("Deletion successfull");
            deleteAddress(id);
        } else {
            System.out.println("Record not found !!!");
        }
    }

    /**
     * Method displayAllEmployees displays all EmployeeDetails
     * Displays All employee details passed from Controller class
     */
    private void displayAllEmployees() throws IOException {
        System.out.println(employeeController.getAllEmployees());
        displayAllAddresses();
    }

    /**
     * Method updateDetails gets id from user to update Employee details
     * passes field to be updated to EmployeeController class
     */
    private void updateEmployee() throws IOException {
        String updatedValue = "";
        int choice = 0;
        System.out.println("Enter Id to update");
        int id = Integer.parseInt(reader.readLine());
        if(false == employeeController.updateEmployee(id, choice,
                updatedValue)) {
            System.out.println("No Records found...Updation failed!!!");
        } else {
            System.out.println("Enter your choice \n1. Name\n2. ContactNumber"
                    +"\n3. Salary\n4. Designation\n5. Address\n");
            choice = Integer.parseInt(reader.readLine());
            switch (choice) {
                case 1:
                    System.out.print("Enter name ");
                    updatedValue = reader.readLine();
                    employeeController.updateEmployee(id, choice,
                            updatedValue);
                    break;
                case 2:
                    System.out.print("Enter contact number ");
                    long updatedContactNumber = Long.valueOf(reader.
                            readLine());
                    updatedValue = String.valueOf(updatedContactNumber);
                    employeeController.updateEmployee(id, choice,
                            updatedValue);
                    break;
                case 3:
                    System.out.print("Enter salary ");
                    long updatedSalary = Long.valueOf(reader.readLine());
                    updatedValue = String.valueOf(updatedSalary);
                    employeeController.updateEmployee(id, choice,
                            updatedValue);
                    break;
                case 4:
                    System.out.print("Enter designation ");
                    updatedValue = reader.readLine();
                    employeeController.updateEmployee(id, choice,
                            updatedValue);
                    break;
                case 5:
                    System.out.println("Enter Address");
                    updateAddress(id);
                    break;
                case 6:
                    System.out.print("Enter your new date of birth: ");
                    Date dateOfBirth = Date.valueOf(reader.readLine());
                    updatedValue = String.valueOf(dateOfBirth);
                    employeeController.updateEmployee(id, choice,
                            updatedValue);
                    break;
                default:
                    System.out.println("Invalid Choice!!!");
                    break;
            }
        }
    }

    /**
     * Method displayAddress gets id displayEmployee method
     * Prints the corresponding Address details returned from controller class
     */
    private void displayAddress(int employeeId) throws IOException {
        if(null != employeeController.getAddress(employeeId)) {
            System.out.println(employeeController.getAddress(employeeId));
        } else {
            System.out.println("No address Records Found");
        } 
    }

    /**
     * Method displayAllAddresses displays all EmployeeDetails
     * Displays All employee's address details passed from Controller class
     */
    private void displayAllAddresses() throws IOException {
        System.out.println(employeeController.getAllAddresses());
    }
   
    /**
     * Method deleteAddress gets id from deleteEmployee method and passes it to controller class
     * Prints whether details are deleted based on values returned from controller class
     * @param employeeId
     *        id of employee to be deleted
     */
    private void deleteAddress(int employeeId) throws IOException {
        if (true == employeeController.deleteAddress(employeeId)) {
            System.out.println("Deletion successfull");
        } else {
            System.out.println("No address records not found !!!");
        }
    }

    /**
     * Method updateAddress updates Employee's address details based on choice entered
     * passes field to be updated ,choice, employeeId to EmployeeController class
     * @param employeeId
     *        id of employee whose address is to be updated.
     */
    private void updateAddress(int employeeId) throws IOException {
        String updatedValue = "";
        int choice = 0;
        if(false == employeeController.updateEmployee(employeeId, choice,
                updatedValue)) {
            System.out.println("No Address Records found...Updation failed!!!");
        } else {
            System.out.println("Enter your choice \n1. HouseNumber\n2. StreetName"
                    +"\n3. Area\n4. City\n5. State. \n6.Country \n7. PinCode\n");
            choice = Integer.parseInt(reader.readLine());
            switch (choice) {
                case 1:
                    System.out.print("Enter HouseNumber ");
                    updatedValue = reader.readLine();
                    employeeController.updateAddress(employeeId, choice,
                    updatedValue);
                    break;
                case 2:
                    System.out.print("Enter StreetName ");
                    updatedValue = reader.readLine();
                    employeeController.updateAddress(employeeId, choice,
                    updatedValue);
                    break;
                case 3:
                    System.out.print("Enter Area ");
                    updatedValue = reader.readLine();
                    employeeController.updateAddress(employeeId, choice,
                    updatedValue);
                    break;
                case 4:
                    System.out.print("Enter City ");
                    updatedValue = reader.readLine();
                    employeeController.updateAddress(employeeId, choice,
                    updatedValue);
                    break;
                case 5:
                    System.out.print("Enter State ");
                    updatedValue = reader.readLine();
                    employeeController.updateAddress(employeeId, choice,
                    updatedValue);
                    break;
                case 6:
                    System.out.print("Enter Country ");
                    updatedValue = reader.readLine();
                    employeeController.updateAddress(employeeId, choice,
                    updatedValue);
                    break;
                case 7:
                    System.out.print("Enter PinCode");
                    int updatedField = Integer.parseInt(reader.readLine());
                    updatedValue = String.valueOf(updatedField);
                    employeeController.updateAddress(employeeId, choice,
                    updatedValue);
                    break;
                default:
                    System.out.println("Invalid Choice!!!");
                    break;
            }
        }
    }

     /**
     * Method validateContactNumber passes the contact number to controller 
     * returns validation results and asks user to renter if it is invalid
     * @param contactNumber
     *        contactNumber entered by the user
     * @return contactNumber
     *         valid contactNumber
     */
    private long validateContactNumber(String contactNumber)
            throws IOException {
        while(!employeeController.validateContactNumber(contactNumber)) {
            System.out.println("Invalid contact number!Enter a valid number: ");
            contactNumber = reader.readLine();
        }   	
        return Long.parseLong(contactNumber);	
    }	
	
    /**
     * Method validateDate passes the date to controller 
     * returns validation results and asks user to renter if it is invalid
     * @return dateOfBirth
     *         valid dateOfBirth
     */
    private String validateDate(String dateOfBirth) throws IOException {
        while(!employeeController.validateDate(dateOfBirth)) {
            System.out.println("Invalid Date!Enter a valid date(yyyy-MM-dd): ");
            dateOfBirth = reader.readLine();			
        }    
        return dateOfBirth;		
    }
}