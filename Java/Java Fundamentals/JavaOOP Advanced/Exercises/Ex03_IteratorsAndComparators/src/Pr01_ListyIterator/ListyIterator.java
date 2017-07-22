package Pr01_ListyIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterator<String>{
    private List<String> strings;
    private int index;

    public ListyIterator(String... input){
        this.strings = Arrays.asList(input);
        index = 0;
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
            throw new UnsupportedOperationException("Invalid Operation!");
        }

        System.out.println(this.strings.get(index));
    }

    @Override
    public boolean hasNext() {
        return index < strings.size() - 1;
    }

    @Override
    public String next() {
        return null;
    }
}
