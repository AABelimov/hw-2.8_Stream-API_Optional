package sky.pro.streamapiandoptional.service;

import org.springframework.stereotype.Service;
import sky.pro.streamapiandoptional.base.Employee;
import sky.pro.streamapiandoptional.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees =
            new ArrayList<>(List.of(new Employee("Ivan", "Ivanov", 1, 70000),
                    new Employee("Roman", "Romanov", 2, 65000),
                    new Employee("Petr", "Petrov", 1, 75000)));

    @Override
    public String addEmployee(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);

        if (employees.contains(employee)) {
            return "Employee already added";
        } else {
            employees.add(employee);
            return "Employee " + firstName + ' ' + lastName + " has been added";
        }
    }

    @Override
    public String removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employees.remove(employee)) {
            return "Employee " + firstName + ' ' + lastName + " has been removed";
        } else {
            return "Employee " + firstName + ' ' + lastName + " not found";
        }
    }

    @Override
    public Employee searchEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        int key = employees.indexOf(employee);

        if (key != -1) {
            return employees.get(key);
        } else {
            throw new EmployeeNotFoundException("Employee not found");
        }
    }

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }
}