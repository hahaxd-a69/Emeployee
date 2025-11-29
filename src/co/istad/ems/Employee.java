package co.istad.ems;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {

    private String empId;
    private String name;
    private String gender;
    private String position;
    private String department;
    private BigDecimal salary;
    private Boolean isActive;

    public Employee() {}

    public Employee(String name, String gender, String position,
                    String department, BigDecimal salary) {
        this.name = name;
        this.gender = gender;
        this.position = position;
        this.department = department;
        this.salary = salary;
        this.isActive = true;
    }

    public Employee(String empId, String name, String gender, String position,
                    String department, BigDecimal salary, Boolean isActive) {
        this.empId = empId;
        this.name = name;
        this.gender = gender;
        this.position = position;
        this.department = department;
        this.salary = salary;
        this.isActive = isActive;
    }

    public String getEmpId() { return empId; }
    public void setEmpId(String empId) { this.empId = empId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public BigDecimal getSalary() { return salary; }
    public void setSalary(BigDecimal salary) { this.salary = salary; }

    public Boolean getActive() { return isActive; }
    public void setActive(Boolean active) { isActive = active; }

    @Override
    public String toString() {
        return empId + " | " + name + " | " +
                department + " | " + position + " | " +
                salary + " | Active:" + isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee e = (Employee) o;
        return Objects.equals(empId, e.empId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId);
    }
}
