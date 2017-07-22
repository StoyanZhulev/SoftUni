package p03_employee_info.busines_layer;

import p03_employee_info.models.Employee;
import p03_employee_info.user_interface.Formatter;

public class ConsoleFormatter implements Formatter{

    @Override
    public String format(Iterable<?> employees) {
        StringBuilder sb = new StringBuilder();
        for (Object employee : employees) {
            sb.append(employee).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
