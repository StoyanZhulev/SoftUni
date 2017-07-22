package Pr02_Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String>{
    private List<String> strings;
    private int index;

    public ListyIterator(String... input){
        this.strings = Arrays.asList(input);
        index = 0;
    }

    public List<String> getStrings() {
        return strings;
    }

    public boolean move(){
        boolean isMoved = ++index <= strings.size() - 1;
        if(!isMoved){
            index--;
        }
        return isMoved;
    }

    public void print(){
        if(this.strings.isEmpty()){
            throw new IllegalArgumentException("Invalid Operation!");
        }

        System.out.println(this.strings.get(index));
    }

    public void printAll(){
        for (String string : this.strings) {
            System.out.print(string + " ");
        }

        System.out.println();
    }

    @Override
    public Iterator<String> iterator() {
        return new ListIterator();
    }

    @Override
    public void forEach(Consumer<? super String> action) {

    }

    @Override
    public Spliterator<String> spliterator() {
        return null;
    }

    private  final class ListIterator implements Iterator<String>{
        public ListIterator(){
        }
        @Override
        public boolean hasNext() {
            return index < strings.size() - 1;
        }

        @Override
        public String next() {
            return strings.get(index);
        }
    }
}
