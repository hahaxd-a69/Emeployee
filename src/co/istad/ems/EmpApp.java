package co.istad.ems;

import java.math.BigDecimal;
import java.util.List;

public class EmpApp {

    private final EmployeeService employeeService;

    public EmpApp() {
        employeeService = new EmployeeServiceImpl();
    }

    public static void main(String[] args) {
        new EmpApp().start();
    }

    private void start() {
        DisplayUtil.printAppName();
        while (true) {
            DisplayUtil.printAppMenu();
            int opt = InputUtil.getInteger("Enter option");

            switch (opt) {
                case 1 -> DisplayUtil.printEmployeeList(employeeService.findAll());
                case 2 -> searchMenu();
                case 3 -> addNew();
                case 4 -> updateById();
                case 5 -> deleteById();
                case 6 -> sortMenu();
                case 7 -> toggleActive();
                case 8 -> DisplayUtil.printEmployeeList(employeeService.findActiveEmployees());
                case 9 -> DisplayUtil.printEmployeeList(employeeService.findInactiveEmployees());
                case 0 -> System.exit(0);
                default -> DisplayUtil.print("Invalid option!", true);
            }
        }
    }

    private void addNew() {
        String name = InputUtil.getText("Name");
        String gender = InputUtil.getText("Gender");
        String position = InputUtil.getText("Position");
        String department = InputUtil.getText("Department");
        BigDecimal salary = InputUtil.getMoney("Salary");

        Employee emp = new Employee(name, gender, position, department, salary);
        employeeService.addNew(emp);

        DisplayUtil.printMessage("New employee added!");
    }

    private void updateById() {
        String id = InputUtil.getText("Employee ID");

        String name = InputUtil.getText("New Name");
        String gender = InputUtil.getText("New Gender");
        String position = InputUtil.getText("New Position");
        String department = InputUtil.getText("New Department");
        BigDecimal salary = InputUtil.getMoney("New Salary");

        employeeService.updateById(id, new Employee(name, gender, position, department, salary));
        DisplayUtil.printMessage("Employee updated!");
    }

    private void deleteById() {
        String id = InputUtil.getText("ID");
        employeeService.deleteById(id);
        DisplayUtil.printMessage("Employee deleted.");
    }

    private void toggleActive() {
        String id = InputUtil.getText("Employee ID");
        employeeService.toggleActive(id);
        DisplayUtil.printMessage("Status changed!");
    }

    private void searchMenu() {
        DisplayUtil.print("1. Search by ID", true);
        DisplayUtil.print("2. Search by Name", true);
        DisplayUtil.print("3. Search by Gender", true);
        DisplayUtil.print("4. Search by Position", true);
        DisplayUtil.print("5. Search by Department", true);

        int opt = InputUtil.getInteger("Choose");

        switch (opt) {
            case 1 -> {
                String id = InputUtil.getText("ID");
                Employee emp = employeeService.searchById(id);
                DisplayUtil.printEmployeeList(List.of(emp));
            }
            case 2 -> {
                String name = InputUtil.getText("Name");
                DisplayUtil.printEmployeeList(employeeService.searchByName(name));
            }
            case 3 -> {
                String gender = InputUtil.getText("Gender");
                DisplayUtil.printEmployeeList(employeeService.searchByGender(gender));
            }
            case 4 -> {
                String pos = InputUtil.getText("Position");
                DisplayUtil.printEmployeeList(employeeService.searchByPosition(pos));
            }
            case 5 -> {
                String dept = InputUtil.getText("Department");
                DisplayUtil.printEmployeeList(employeeService.searchByDepartment(dept));
            }
        }
    }

    private void sortMenu() {
        DisplayUtil.print("1. Sort by Name", true);
        DisplayUtil.print("2. Sort by Salary", true);
        DisplayUtil.print("3. Sort by Department", true);

        int opt = InputUtil.getInteger("Choose");

        switch (opt) {
            case 1 -> DisplayUtil.printEmployeeList(employeeService.sortByName());
            case 2 -> DisplayUtil.printEmployeeList(employeeService.sortBySalary());
            case 3 -> DisplayUtil.printEmployeeList(employeeService.sortByDepartment());
        }
    }
}
