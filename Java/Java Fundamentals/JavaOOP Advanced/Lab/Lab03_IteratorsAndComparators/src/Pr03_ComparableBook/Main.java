package Pr03_ComparableBook;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        if (bookTwo.compareTo(bookThree) > 0) {
            System.out.println(String.format("%s is before %s", bookThree, bookTwo));
        } else if (bookTwo.compareTo(bookThree) < 0) {
            System.out.println(String.format("%s is before %s", bookTwo, bookThree));
        } else {
            System.out.println("Books are equal");
        }

    }

}
