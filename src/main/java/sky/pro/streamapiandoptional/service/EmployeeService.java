package sky.pro.streamapiandoptional.service;

import sky.pro.streamapiandoptional.base.Employee;
import sky.pro.streamapiandoptional.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {
    String addEmployee(String firstName, String lastName, int department, double salary);

    String removeEmployee(String firstName, String lastName);

    Employee searchEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    List<Employee> getEmployees();
}