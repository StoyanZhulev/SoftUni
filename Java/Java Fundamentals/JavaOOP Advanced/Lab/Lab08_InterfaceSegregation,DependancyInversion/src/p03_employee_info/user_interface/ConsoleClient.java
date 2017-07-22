package p03_employee_info.user_interface;

import p03_employee_info.models.Employee;

import java.util.Comparator;

public class ConsoleClient {


    private InfoProvider infoProvider;
    private Formatter formatter;

    public ConsoleClient(InfoProvider infoProvider, Formatter formatter) {
        this.infoProvider = infoProvider;
        this.formatter = formatter;
    }

    public String getResult(){
        return this.formatter.format(this.infoProvider.getEmployeesBy(Comparator.comparing(Employee::getName)));
    }
}
