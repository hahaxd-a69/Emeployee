package co.istad.ems;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EmployeeDatabase {

    private List<Employee> dataset;

    public EmployeeDatabase() {
        dataset = new ArrayList<>();

        Employee e1 = new Employee();
        e1.setEmpId("1001");
        e1.setName("Haha");
        e1.setGender("Male");
        e1.setPosition("IT Support");
        e1.setDepartment("IT");
        e1.setSalary(BigDecimal.valueOf(350));
        e1.setActive(true);

        Employee e2 = new Employee();
        e2.setEmpId("1002");
        e2.setName("Who");
        e2.setGender("Female");
        e2.setPosition("Manager");
        e2.setDepartment("HR");
        e2.setSalary(BigDecimal.valueOf(750));
        e2.setActive(false);

        dataset.add(e1);
        dataset.add(e2);
    }

    public List<Employee> getDataset() { return dataset; }

    public void insert(Employee newEmployee) {
        newEmployee.setEmpId(UUID.randomUUID().toString());
        dataset.add(newEmployee);
    }

    public void delete(String id) {
        dataset.removeIf(emp -> emp.getEmpId().equals(id));
    }

    public void update(String id, Employee newEmployee) {
        for (Employee emp : dataset) {
            if (emp.getEmpId().equals(id)) {
                emp.setName(newEmployee.getName());
                emp.setGender(newEmployee.getGender());
                emp.setPosition(newEmployee.getPosition());
                emp.setDepartment(newEmployee.getDepartment());
                emp.setSalary(newEmployee.getSalary());
            }
        }
    }
}
