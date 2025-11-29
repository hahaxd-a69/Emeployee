package co.istad.ems;

import java.util.List;

public interface EmployeeService {

    void updateById(String id, Employee newEmployee);

    void deleteById(String id);

    void addNew(Employee newEmployee);

    List<Employee> findAll();

    Employee searchById(String id);

    List<Employee> searchByName(String name);

    List<Employee> searchByGender(String gender);

    List<Employee> searchByPosition(String position);

    List<Employee> searchByDepartment(String department);

    void toggleActive(String id);

    List<Employee> findActiveEmployees();

    List<Employee> findInactiveEmployees();

    List<Employee> sortByName();

    List<Employee> sortBySalary();

    List<Employee> sortByDepartment();
}
