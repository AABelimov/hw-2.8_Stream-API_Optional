package sky.pro.streamapiandoptional.service;

import sky.pro.streamapiandoptional.base.Employee;
import sky.pro.streamapiandoptional.exception.EmployeeNotFoundException;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    // Возвращает сотрудника с минимальной зарплатой в отделе
    Employee getEmployeeWithMinSalaryInDepartment(int department) throws EmployeeNotFoundException;

    // Возвращает сотрудника с максимальной зарплатой в отделе
    Employee getEmployeeWithMaxSalaryInDepartment(int department) throws EmployeeNotFoundException;

    // Возвращает список сотрудников отдела
    List<Employee> getEmployeesFromDepartment(int department);

    // Возвращает массив сотрудников по отделам
    Map<Integer, List<Employee>> getEmployeesByDepartment();

    // Возвращает сумму зарплат отдела
    double sumSalaryInDepartment(int department);

    // Возвращает среднюю зарплату по отделу
    double calculateAverageSalaryInDepartment(int department);

    // Индексирует зарплату отдела
    void riseSalaryInDepartment(int department, int percent);
}