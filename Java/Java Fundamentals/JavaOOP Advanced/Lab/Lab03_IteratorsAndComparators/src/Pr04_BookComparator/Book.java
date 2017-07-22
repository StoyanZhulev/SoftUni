package Pr04_BookComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return Collections.unmodifiableList(authors);
    }

    private void setAuthors(String... authors) {
//        this.authors = new ArrayList<>();
//        Collections.addAll(this.authors, authors);
        this.authors = Arrays.asList(authors);
    }

    @Override
    public int compareTo(Book book) {
        if (this.getTitle().compareTo(book.getTitle()) == 0) {
//            if(this.getYear() > book.getYear()){
//                return 1;
//            }else if(this.getYear() < book.getYear()){
//                return -1;
//            }else{
//                return 0;
//            }

            return this.getYear() - book.getYear();
        } else {
            return this.getTitle().compareTo(book.getTitle());
        }
    }

    public int compareTo(String titel) {
        return this.getTitle().compareTo(titel);
    }

    @Override
    public String toString() {
        return this.getTitle() + " " + this.getYear();
    }
}
