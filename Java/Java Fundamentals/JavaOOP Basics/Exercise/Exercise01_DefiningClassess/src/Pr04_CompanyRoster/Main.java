package Pr04_CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, ArrayList<Employee>> departmentEmployees = new LinkedHashMap<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] personArgs = reader.readLine().split(" ");
             makeEmployee(personArgs, departmentEmployees);
        }

        departmentEmployees.entrySet().stream()
                .sorted((d1, d2) -> {
                    double salary1 = 0.0;
                    for (Employee employee : d1.getValue()) {
                        salary1+= employee.getSalary();
                    }

                    double salary2 = 0.0;
                    for (Employee employee : d2.getValue()) {
                        salary2+= employee.getSalary();
                    }

                    return Double.compare(salary2 / d2.getValue().size(), salary1 / d1.getValue().size());
                }).limit(1)
                .forEach(d -> {
                    System.out.println("Highest Average Salary: " + d.getKey());
                    d.getValue().stream().sorted((d1, d2) -> Double.compare(d2.getSalary(), d1.getSalary()))
                            .forEach(System.out::println);
                });
    }

    private static void makeEmployee(String[] personArgs, LinkedHashMap<String, ArrayList<Employee>> departmentEmployees) {
        String name = personArgs[0];
        double salary = Double.parseDouble(personArgs[1]);
        String position = personArgs[2];
        String department = personArgs[3];
        switch (personArgs.length){
            case 4:
                Employee employee = new Employee(name, salary, position, department);
                addEmployeeToMap(employee, departmentEmployees);
                break;
            case 5:
                try{
                    int age = Integer.parseInt(personArgs[4]);
                    employee = new Employee(name, salary, position, department, age);
                }catch (NumberFormatException nfe){
                    String email = personArgs[4];
                    employee = new Employee(name, salary, position, department, email);
                }
                addEmployeeToMap(employee, departmentEmployees);
                break;
            case 6:
                String email = personArgs[4];
                int age = Integer.parseInt(personArgs[5]);
                employee = new Employee(name, salary, position, department, email, age);

                addEmployeeToMap(employee, departmentEmployees);
                break;
        }
    }

    private static void addEmployeeToMap(Employee employee, LinkedHashMap<String, ArrayList<Employee>> departmentEmployees) {
        if(!departmentEmployees.containsKey(employee.getDepartment())){
            departmentEmployees.put(employee.getDepartment(), new ArrayList<>());
        }

        departmentEmployees.get(employee.getDepartment()).add(employee);
    }


}
