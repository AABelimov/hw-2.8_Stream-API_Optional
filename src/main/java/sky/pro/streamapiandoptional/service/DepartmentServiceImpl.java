package sky.pro.streamapiandoptional.service;

import org.springframework.stereotype.Service;
import sky.pro.streamapiandoptional.base.Employee;
import sky.pro.streamapiandoptional.exception.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    // Возвращает сотрудника с минимальной зарплатой в отделе
    @Override
    public Employee getEmployeeWithMinSalaryInDepartment(int department) throws EmployeeNotFoundException {
        return employeeService.getEmployees().stream().filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("No employees in this department"));
    }

    // Возвращает сотрудника с максимальной зарплатой в отделе
    @Override
    public Employee getEmployeeWithMaxSalaryInDepartment(int department) throws EmployeeNotFoundException {
        return employeeService.getEmployees().stream().filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("No employees in this department"));
    }

    // Возвращает список сотрудников отдела
    @Override
    public List<Employee> getEmployeesFromDepartment(int department) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepartment() == department).collect(Collectors.toList());
    }

    // Возвращает массив сотрудников по отделам
    @Override
    public Map<Integer, List<Employee>> getEmployeesByDepartment() {
        return employeeService.getEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }

    // Возвращает сумму зарплат отдела
    @Override
    public double sumSalaryInDepartment(int department) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    // Возвращает среднюю зарплату по отделу
    @Override
    public double calculateAverageSalaryInDepartment(int department) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }

    // Индексирует зарплату отдела
    @Override
    public void riseSalaryInDepartment(int department, int percent) {
        employeeService.getEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .forEach(e -> e.setSalary(e.getSalary() + percent * 0.01 * e.getSalary()));
    }
}
