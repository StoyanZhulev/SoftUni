package Pr06_BirthdayCelebrations;

public class Person implements Identificatable {

    private String birthDate;

    public Person(String date) {
        this.birthDate = date;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }
}
