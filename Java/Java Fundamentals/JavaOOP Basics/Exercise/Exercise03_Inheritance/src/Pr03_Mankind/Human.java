package Pr03_Mankind;

public class Human {
    private String firstName;
    private String lastName;

    public Human(String firstName, String lastname){
        this.setFirstName(firstName);
        this.setLastName(lastname);
    }


    protected String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        if(firstName == null  || firstName.trim().length() < 4){
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }else if(!Character.isUpperCase(firstName.charAt(0))){
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    protected void setLastName(String lastName) {
        if(lastName == null  || lastName.trim().length() < 3){
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName ");
        }else if(!Character.isUpperCase(lastName.charAt(0))){
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }

        this.lastName = lastName;
    }
}
