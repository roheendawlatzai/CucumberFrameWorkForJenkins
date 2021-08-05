Feature: Syntax HRMS API Workflow

  Background:
    Given a JWT token is generated


  @APIWorkFlow
  Scenario: Creating an Employee
    Given a request is prepared to create an employee
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    And the employee created contains key "Message" and value "Employee Created"
    And the employeeID "Employee.employee_id" is stored as a global variable to be used for other calls

  @APIWorkFlow
  Scenario: Retrieving created employee
    Given a request is prepared ot retrieve the created employee
    When a GET call is made to retrieve the created employee
    Then the status code for retrieving the created employee is 200
    And the retrieved employee ID "employee.employee_id" matched the globally stored employee ID
    And the retrieved data at "employee" matches the data used to create an employee with employee ID "employee.employee_id"
      | emp_firstname | emp_middle_name | emp_lastname | emp_birthday | emp_gender | emp_job_title | emp_status |
      | 24145A        | Accesss         | Allow        | Control     | 1990-07-10 | Healer        | Employee   |
