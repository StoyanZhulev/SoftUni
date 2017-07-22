package Pr03_StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack implements Iterable<Integer>{
    private List<Integer> integers;

    public Stack(){
        this.integers = new ArrayList<>();
    }

    public void push(int element){
        this.integers.add(element);
    }

    public int pop(){
        if(this.integers.isEmpty()){
            throw new IllegalArgumentException("No elements");
        }
        return this.integers.remove(this.integers.size() - 1);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator();
    }

    private final class StackIterator implements Iterator<Integer>{
        private int index;

        public StackIterator(){
            this.index = integers.size() - 1;
        }


        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public Integer next() {
            return integers.get(index--);
        }
    }

}
