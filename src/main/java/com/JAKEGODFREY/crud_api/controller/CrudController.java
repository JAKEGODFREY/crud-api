package com.JAKEGODFREY.crud_api.controller;

import com.JAKEGODFREY.crud_api.domain.Employee;
import com.JAKEGODFREY.crud_api.CrudDirective;
import com.JAKEGODFREY.crud_api.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CrudController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CrudController.class);

    private CrudDirective directive;

    @Autowired
    private EmployeeRepository repository;


    @RequestMapping("/api/getid")
    public Long getID() {
        directive = new CrudDirective();
        return directive.addUserID(repository.count());
    }
    /**
     * Add a new employee
     * @param firstName
     * @param lastName
     * @param age
     * @return
     */
    @RequestMapping(value = "/api/add",
            params = {"firstName", "lastName", "age"},
            method = RequestMethod.GET)
    @ResponseBody
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("age") int age) {
        Employee employee = new Employee(getID(), firstName, lastName, age);
        try {
            repository.save(employee);
            LOGGER.info("You have added " + firstName + " " + lastName + "ID: " + employee.getUserID() + "\n HTTP_CODE: " + HttpStatus.OK);
        }catch(Exception e){
            LOGGER.error("Failed to save " + firstName + " " + lastName + "\n HTTP_CODE " + HttpStatus.BAD_REQUEST);
        }
        return employee;
    }

    /**
     *
     * @param userID
     * @return
     */
    @RequestMapping(value = "/api/delete/{userID}",
                    method = RequestMethod.GET)
    @ResponseBody
    public String deleteEmployeeByID(@PathVariable("userID") long userID) {
        String response;
        try {
            repository.delete(userID);
            response = "You have successfuly removed " + userID + ".\n"
                    + "HTTP_CODE: "+ HttpStatus.OK;
        } catch(Exception e){
            response = "The user with the ID of " + userID + " could not be found, please try another ID.\n"
                    + "HTTP_CODE: "+ HttpStatus.BAD_REQUEST;
        }
        return response;
    }

    /**
     * read all the Employees
     * @return Employees
     */
    @RequestMapping(value = "/api/read")
    public Iterable<Employee> readAllEmployees() {
        Iterable<Employee> employeesIterable = repository.findAll();
        return employeesIterable;
    }

    @RequestMapping(value = "api/read/{userID}",
                    method = RequestMethod.GET)
    @ResponseBody
    public Employee readEmployeeByID(@PathVariable("userID") Long userID) {
        Employee employee;
        try {
            employee = repository.findOne(userID);
            LOGGER.info("Sucessfully read entry for ID: " + userID);
        }catch(Exception e){
            employee = new Employee();
            LOGGER.error("Unable to read employee with ID: " + userID);
        }
        return employee;
    }

    /**
     * update an employee by ID
     * @param firstName
     * @param lastName
     * @param age
     * @return
     */
    @RequestMapping(value = "/api/update/{userID}", params = {"firstName", "lastName", "age"})
    public Employee updateEmployeeByID(@PathVariable("userID") long userID,
                                       @RequestParam("firstName") String firstName,
                                       @RequestParam("lastName") String lastName,
                                       @RequestParam("age") int age) {
        Employee employee;
        try {
            employee = repository.findOne(userID);
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setAge(age);
            repository.save(employee);
            LOGGER.info("Employee " + firstName + " " + lastName + "Has been updated");
        }catch (Exception e){
            LOGGER.error("The user you're searching for could not be found");
            employee = new Employee();
        }
        return employee;
    }


}
