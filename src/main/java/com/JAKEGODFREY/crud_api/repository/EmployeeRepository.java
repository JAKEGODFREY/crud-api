package com.JAKEGODFREY.crud_api.repository;

import com.JAKEGODFREY.crud_api.domain.Employee;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.CrudRepository;

@RepositoryRestResource
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
}
