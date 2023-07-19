package sky.pro.streamapiandoptional.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.streamapiandoptional.base.Employee;
import sky.pro.streamapiandoptional.exception.EmployeeNotFoundException;
import sky.pro.streamapiandoptional.service.DepartmentServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/min-salary")
    public Employee printEmployeeWithMinSalaryInDepartment(@RequestParam int departmentID) {
        try {
            return departmentService.getEmployeeWithMinSalaryInDepartment(departmentID);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/max-salary")
    public Employee printEmployeeWithMaxSalaryInDepartment(@RequestParam int departmentID) {
        try {
            return departmentService.getEmployeeWithMaxSalaryInDepartment(departmentID);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping(value = "/all", params = "departmentID")
    public List<Employee> printEmployeesFromDepartment(@RequestParam int departmentID) {
        return departmentService.getEmployeesFromDepartment(departmentID);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> printEmployeesByDepartment() {
        return departmentService.getEmployeesByDepartment();
    }
}
