package com.JAKEGODFREY.crud_api.controller;

import com.JAKEGODFREY.crud_api.domain.Employee;
import com.JAKEGODFREY.crud_api.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CrudControllerTest {

    @Autowired
    CrudController controller;

    @Autowired
    EmployeeRepository repository;

    @Before
    public void createEmployee(){
        Employee employee = new Employee(controller.getID(),"John", "Smith", 37);
        repository.save(employee);
    }

    @Test
    public void addEmployeeTest(){
        controller.addEmployee("test", "employee", 5);

        long expectedID = 2L;

        Employee employee = repository.findOne(expectedID);
        assert employee.getFirstName()=="test";
        assert employee.getLastName() == "employee";
        assert employee.getAge() == 5;

    }
}
