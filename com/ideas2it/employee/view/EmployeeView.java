/** 
 * Package com.ideas2it.employee.view contains EmployeeView Class
 * All interactions with the user are done here.
 */ 
package com.ideas2it.employee.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import com.ideas2it.employee.controller.EmployeeController;

/** 
 * Class EmployeeView gets input from user.
 * In order to perform create,delete,display,update on EmployeeDetails
 * @author EzhilMathi.M 
 * @created 24.02.2021
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
                +"\n3.Display\n4.DisplayAll\n5.Update";
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
                    updateEmployeeDetails();
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
        System.out.println("Enter Full name ");
        String name = reader.readLine();
        System.out.println("Enter Address");
        String address = reader.readLine();
        System.out.println("Enter Salary ");
        long salary = Long.parseLong(reader.readLine());
        System.out.println("Enter Designation");
        String designation = reader.readLine();
        boolean isCreated = employeeController.createEmployee(name, 
                address,salary,designation);
        if(isCreated) {
            System.out.println("Created successfully");
        } else {
            System.out.println("Unsuccessfull");
        }
    }

    /**
     * Method displayEmployee gets id from user to display Employee details
     * Prints the corresponding Employee details
     */
    private void displayEmployee() throws IOException {
        System.out.println("Enter id:");
        int employeeId = Integer.parseInt(reader.readLine());
        if(null == employeeController.displayEmployee(employeeId)) {
            System.out.println("No Records Found");
        } else {
            System.out.println(employeeController.displayEmployee(employeeId));
        } 
    }

    /**
     * Method deleteEmployee gets id from user to delete Employee details
     * Prints whether the employee detail is deleted 
     */
    private void deleteEmployee() throws IOException {
        System.out.println("Enter id");
        int employeeId = Integer.parseInt(reader.readLine());
        if (true == employeeController.deleteEmployee(employeeId)) {
            System.out.println("Deletion successfull");
        } else {
            System.out.println("Deletion unsuccessfull");
        }
    }

    /**
     * Method displayAllEmployees displays all EmployeeDetails
     * Displays All employee details passed from Controller class
     */
    private void displayAllEmployees() throws IOException {
        System.out.print("Employee Id:");
        System.out.println(employeeController.displayAllEmployees());
    }

    /**
     * Method updateDetails gets id from user to update Employee details
     * passes field to be updated to EmployeeController class
     */
    private void updateEmployeeDetails() throws IOException {
        String updateOption = "\n1.Name\n2.address\n3.salary" 
                +"\n4.designation\nEnter Choice";
        System.out.println("enter id");
        int employeeId = Integer.parseInt(reader.readLine());
        System.out.println("Updation");
        if(false == employeeController.searchEmployee(employeeId)) {
            System.out.println("No Record Found !!!");
        } else {
            System.out.println(updateOption);
            int choice = Integer.parseInt(reader.readLine());
            switch(choice) {
                case 1 :
                    System.out.println("Enter name");
                    String updatedName = reader.readLine();
                    employeeController.updateEmployee(employeeId, choice, 
                            updatedName);
                    break;
                case 2 :
                    System.out.println("Enter address");
                    String updatedAddress = reader.readLine();
                    employeeController.updateEmployee(employeeId, choice,
                            updatedAddress);
                    break;
                case 3 :
                    System.out.println("Enter salary");
                    long updatedSalary = Long.parseLong(reader.readLine());
                    String updatedIncome = Long.toString(updatedSalary);
                    employeeController.updateEmployee(employeeId, choice, 
                            updatedIncome);
                    break;
                case 4 :
                    System.out.println("Enter designation");
                    String updatedDesignation = reader.readLine();
                    employeeController.updateEmployee(employeeId, choice, 
                            updatedDesignation);
                    break;
                default :
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}