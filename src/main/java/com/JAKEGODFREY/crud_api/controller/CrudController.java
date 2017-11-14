package com.JAKEGODFREY.crud_api.controller;

import com.JAKEGODFREY.crud_api.domain.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class CrudController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CrudController.class);

    private final AtomicInteger counter = new AtomicInteger();

    @RequestMapping("/add/employee")
    public Employee addEmployee(@RequestParam(value="firstName", defaultValue="Jake") String firstName,
                                @RequestParam(value = "lastName", defaultValue = "Godfrey") String lastName,
                                @RequestParam(value="age", defaultValue = "22") int age) {
        return new Employee(counter.incrementAndGet(), firstName, lastName, age );
    }


}
