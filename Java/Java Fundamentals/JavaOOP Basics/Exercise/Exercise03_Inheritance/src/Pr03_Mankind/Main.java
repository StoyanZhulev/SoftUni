package Pr03_Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] studentArgs = reader.readLine().trim().split(" ");
        String[] workerArgs = reader.readLine().trim().split(" ");

        try{
            String studentfirstName = studentArgs[0];
            String studentLastName = studentArgs[1];
            String facultyNumber = studentArgs[2];

            Student student = new Student(studentfirstName, studentLastName, facultyNumber);

            String workerFirstName = workerArgs[0];
            String workerLastName = workerArgs[1];
            double workerWeekSalary = Double.parseDouble(workerArgs[2]);
            double hoursPerDay = Double.parseDouble(workerArgs[3]);
            Worker worker = new Worker(workerFirstName, workerLastName, workerWeekSalary, hoursPerDay);


            System.out.println(student.toString());
            worker.printWorker();
        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }
}
