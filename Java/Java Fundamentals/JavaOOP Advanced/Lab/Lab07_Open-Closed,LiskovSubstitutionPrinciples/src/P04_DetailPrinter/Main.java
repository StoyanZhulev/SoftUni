package P04_DetailPrinter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Pesho"));
        employees.add(new Employee("Venci"));
        employees.add(new Manager("Vanko", "docs"));
        employees.add(new Worker("Gosho", 10));

        DetailsPrinter printer = new DetailsPrinter(employees);

        printer.printDetails();
    }
}
