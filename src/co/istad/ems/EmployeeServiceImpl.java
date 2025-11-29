package co.istad.ems;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDatabase db;

    public EmployeeServiceImpl() {
        db = new EmployeeDatabase();
    }

    @Override
    public void updateById(String id, Employee newEmployee) {
        db.update(id, newEmployee);
    }

    @Override
    public void deleteById(String id) {
        db.delete(id);
    }

    @Override
    public void addNew(Employee newEmployee) {
        newEmployee.setActive(true);
        db.insert(newEmployee);
    }

    @Override
    public List<Employee> findAll() {
        return db.getDataset();
    }

    @Override
    public Employee searchById(String id) {
        return db.getDataset()
                .stream()
                .filter(e -> e.getEmpId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Employee> searchByName(String name) {
        return db.getDataset()
                .stream()
                .filter(e -> e.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> searchByGender(String gender) {
        return db.getDataset()
                .stream()
                .filter(e -> e.getGender().equalsIgnoreCase(gender))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> searchByPosition(String position) {
        return db.getDataset()
                .stream()
                .filter(e -> e.getPosition().equalsIgnoreCase(position))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> searchByDepartment(String department) {
        return db.getDataset()
                .stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }

    @Override
    public void toggleActive(String id) {
        Employee emp = searchById(id);
        if (emp != null) {
            emp.setActive(!emp.getActive());
        }
    }

    @Override
    public List<Employee> findActiveEmployees() {
        return db.getDataset()
                .stream()
                .filter(Employee::getActive)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> findInactiveEmployees() {
        return db.getDataset()
                .stream()
                .filter(e -> !e.getActive())
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortByName() {
        return db.getDataset()
                .stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortBySalary() {
        return db.getDataset()
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortByDepartment() {
        return db.getDataset()
                .stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .collect(Collectors.toList());
    }
}
