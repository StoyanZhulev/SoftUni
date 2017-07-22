package Pr08_MilitaryElite.classess;

import Pr08_MilitaryElite.interfaces.IPrivate;

public class Private extends Soldier implements IPrivate{
    private double salary;

    public Private(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        String s = super.toString();
        String out = s + " Salary: "
                +String.format("%.2f", this.getSalary());
        return out;
    }
}
