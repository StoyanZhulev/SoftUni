package p03_employee_info.busines_layer;

import p03_employee_info.models.Employee;

import java.util.List;

public interface Database {
    List<Employee> readEmployees();
}
