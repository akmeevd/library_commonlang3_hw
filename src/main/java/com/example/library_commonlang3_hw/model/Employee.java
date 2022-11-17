package com.example.library_commonlang3_hw.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private int department;
    private int salary;
    private int id;
    private static int counter;


    public Employee(String firstName, String lastName, int department, int salary) {
        try {
            if (!StringUtils.isAlpha(firstName)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            } else {
                firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
                this.firstName = firstName;
            }
            if (!StringUtils.isAlpha(lastName)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            } else {
                lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
                this.lastName = lastName;
            }
            this.department = department;
            if (salary < 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            } else {
                this.salary = salary;
            }
            id = counter++;
        } catch (ResponseStatusException e) {
            System.out.println(e.getStatus());
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && id == employee.id && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, department, salary, id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }

}
