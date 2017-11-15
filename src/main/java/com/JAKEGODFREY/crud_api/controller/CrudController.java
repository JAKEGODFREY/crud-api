package com.JAKEGODFREY.crud_api.controller;

import com.JAKEGODFREY.crud_api.domain.Employee;
import com.JAKEGODFREY.crud_api.CrudDirective;
import com.JAKEGODFREY.crud_api.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


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
        LOGGER.info("You have added " + firstName + " " + lastName);
        Employee employee = new Employee(getID(), firstName, lastName, age);
        repository.save(employee);
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
     * read all employees in the database
     * @param firstName
     * @param lastName
     * @param age
     * @return
     */
    @RequestMapping(value = "/api/read")
    public Iterable<Employee> readAllEmployees() {
        StringBuilder sb;
        Iterable<Employee> employeesIterable = repository.findAll();
//
//        for (Employee employee :employeesIterable) {
//            sb.append("")
//        }
        return employeesIterable;
    }

    @RequestMapping(value = "api/read/{userID}",
                    method = RequestMethod.GET)
    @ResponseBody
    public Employee readEmployeeByID(@PathVariable("userID") Long userID) {
        Employee employee = new Employee();
        try {
             employee = repository.findOne(userID);
        }catch(Exception e){

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
    @RequestMapping("/api/update/{userID}")
    public Employee updateEmployeeByID(@RequestParam("userID") long userID,
                                       @PathVariable("lastName") String firstName,
                                       @PathVariable("lastName") String lastName,
                                       @PathVariable("age") int age) {
        return new Employee(getID(), firstName, lastName, age );
    }


}
