package p03_employee_info;

import p03_employee_info.busines_layer.ConsoleFormatter;
import p03_employee_info.busines_layer.EmployeeInfoProvider;
import p03_employee_info.user_interface.ConsoleClient;
import p03_employee_info.user_interface.Formatter;
import p03_employee_info.user_interface.InfoProvider;

public class Main {

    public static void main(String[] args) {
        InfoProvider employeeInfo = new EmployeeInfoProvider();
        Formatter formatter = new ConsoleFormatter();

        ConsoleClient consoleClient = new ConsoleClient(employeeInfo, formatter);


        System.out.println(consoleClient.getResult());
    }
}
