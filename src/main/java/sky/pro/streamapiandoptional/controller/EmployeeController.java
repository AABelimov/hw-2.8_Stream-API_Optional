package sky.pro.streamapiandoptional.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.streamapiandoptional.base.Employee;
import sky.pro.streamapiandoptional.exception.EmployeeNotFoundException;
import sky.pro.streamapiandoptional.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam String firstName, @RequestParam String lastName,
                              @RequestParam int department, @RequestParam double salary) {
        return employeeService.addEmployee(firstName, lastName, department, salary);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/search")
    public Employee searchEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        try {
            return employeeService.searchEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}