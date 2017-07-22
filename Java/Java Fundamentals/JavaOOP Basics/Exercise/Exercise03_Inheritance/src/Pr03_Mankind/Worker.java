package Pr03_Mankind;

public class Worker extends Human {
    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay){
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    public double getWeekSalary() {
        return weekSalary;
    }

    public double getWorkHoursPerDay() {
        return workHoursPerDay;
    }

    @Override
    protected void setLastName(String lastName) {
        if(lastName == null  || lastName.trim().length() < 3){
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName ");
        }
        super.setLastName(lastName);
    }

    private void setWeekSalary(double salary){
        if(salary <= 10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = salary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay){
        if(workHoursPerDay < 1 || workHoursPerDay > 12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    private double getSalaryPerHour(){
        return this.getWeekSalary() / 7 / this.getWorkHoursPerDay();
    }

   public void printWorker(){
       System.out.println("First Name: " + this.getFirstName());
       System.out.println("Last Name: " + this.getLastName());
       System.out.printf("Week Salary: %.2f%n", this.getWeekSalary());
       System.out.printf("Hours per day: %.2f%n", this.getWorkHoursPerDay());
       System.out.printf("Salary per hour: %.2f", this.getSalaryPerHour());
   }
}
