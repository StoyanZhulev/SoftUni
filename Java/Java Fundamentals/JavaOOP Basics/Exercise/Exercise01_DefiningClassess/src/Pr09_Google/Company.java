package Pr09_Google;

import java.text.DecimalFormat;

public class Company {
    private String companyName;
    private String department;
    private String salary;

    public Company(String name, String department, String salary){
        this.companyName = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        if(this.companyName.equals("")){
            return "Company: \n";
        }
        StringBuilder sb = new StringBuilder();
        DecimalFormat format = new DecimalFormat("0.00");
        sb.append("Company:\n");
        sb.append(this.companyName).append(" ").append(this.department).append(" ").append(format.format(Double.valueOf(this.salary))).append(System.lineSeparator());

        return sb.toString();
    }
}
