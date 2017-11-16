CRUD-API

This repo will have a REST API which can handle crud operations via CURL/HTTP calls.
The server will run on localhost on port 9000, this can be changed via the application.properties

--------------------------------
        PRE_REQUISITS
--------------------------------
Java version 1.8+
Maven installed and setup


Example calls will look like these.
--------------------------------
        ADD AN EMPLOYEE
--------------------------------
http://localhost:9000/api/add?firstName=john&lastName=Smith&age=20


--------------------------------
        VIEW EMPLOYEE'S
--------------------------------
http://localhost:9000/api/read
http://localhost:9000/api/read/<EmployeeID>


--------------------------------
        DELETE EMPLOYEE'S
--------------------------------
http://localhost:9000/api/delete/<EmployeeID>


--------------------------------
        UPDATE EMPLOYEE'S
--------------------------------
http://localhost:9000/api/update/<EmployeeID>?firstName=jake&lastName=godfrey&age=12