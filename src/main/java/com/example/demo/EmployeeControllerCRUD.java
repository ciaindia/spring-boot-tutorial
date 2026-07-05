package com.example.demo;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

class Employee {
    private int id;
    private String name;
    private String department;
    private int salary;

    public Employee(int id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
}


@RestController
public class EmployeeControllerCRUD {

    //GET to list array list employees
    //POST to add employees
    //PUT to update employees salary
    //DELETE to delete employees

    private ArrayList<Employee> employees = new ArrayList<>();


    @GetMapping("/employees")
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * {
     * "id": 1,
     * "name": "John Doe",
     * "department": "Engineering",
     * "salary": 100000
     * }
     * @param employee
     */
    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
    }

    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                e.setName(employee.getName());
                e.setDepartment(employee.getDepartment());
                e.setSalary(employee.getSalary());
                break;
            }
        }
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employees.removeIf(e -> e.getId() == id);
    }

    

}
