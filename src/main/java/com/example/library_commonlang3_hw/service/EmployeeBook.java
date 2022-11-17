package com.example.library_commonlang3_hw.service;

import com.example.library_commonlang3_hw.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class EmployeeBook {

    private Employee[] employees = new Employee[10];
    private static int size;

    public Employee addEmployee(Employee employee) {
        employees[size] = employee;
        size++;
        return employee;
    }

    public void deleteEmployee(String firstName, String lastName, int id) {
        for (int i = 0; i < employees.length; i++) {
            if (firstName.equals(employees[i].getFirstName()) &&
                    lastName.equals(employees[i].getLastName()) &&
                    id == employees[i].getId()) {
                System.out.println("Сотрудник " + employees[i].getFirstName() + employees[i].getLastName() +
                        ". id - " + id + " " + "удален");
                employees[i] = null;
                size = i;
                return;
            }
        }
    }


    public void editEmployee(String firstName, String lastName, int department, int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && firstName.equals(employees[i].getFirstName())
                    && lastName.equals(employees[i].getLastName())) {
                employees[i].setSalary(salary);
                employees[i].setDepartment(department);
                return;
            }
        }
    }

    public void printEmployeesInDepartment() {
        int count = 0;
        int[] departments = {1, 2, 3, 4, 5};
        for (int i = departments[0]; i < departments.length; i++) {
            System.out.print("В отделе " + i + " cотрудники: ");
            for (int j = 0; j < employees.length; j++) {
                if (employees[j] != null && employees[j].getDepartment() == departments[i]) {
                    count++;
                    if (count >= 2) {
                        System.out.print(", ");
                    }
                    System.out.print(employees[j].getFirstName() + " " + employees[j].getLastName());

                }
            }
            if (count == 0) {
                System.out.print("нет");

            }
            count = 0;
            System.out.println();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBook that = (EmployeeBook) o;
        return Arrays.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(employees);
    }

    @Override
    public String toString() {
        return "EmployeeBook{" +
                "employees=" + Arrays.toString(employees) +
                '}';
    }
}
