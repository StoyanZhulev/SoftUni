package Pr07_CustomList;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable<T>> implements Iterable<T>{
        private List<T> coll;

    public CustomList() {
        this.coll = new ArrayList<T>();
    }

    public List<T> getColl() {
        return Collections.unmodifiableList(coll);
    }

    public void add(T element){
        this.coll.add(element);
    }

    public T remove(int index){
        return this.coll.remove(index);
    }

    public boolean contains(T element){
        return this.coll.contains(element);
    }

    public void swap(int index1, int index2){
        T el = this.coll.get(index1);
        this.coll.set(index1, this.coll.get(index2));
        this.coll.set(index2, el);
    }

    @SuppressWarnings("unchecked")
    public int countGreaterThat(T element){
        int count = 0;
        for (T t : coll) {
            if(element.compareTo(t) < 0){
                count++;
            }
        }

        return count;
    }

    @SuppressWarnings("unchecked")
    public T getMax(){
       // Collections.max(coll);
        T max = this.coll.get(0);
        for (int i = 1; i < this.coll.size(); i++) {
            if(max.compareTo(this.coll.get(i)) < 0){
                max = this.coll.get(i);
            }
        }

        return max;
    }

    public T getMin(){
        //Collections.min(coll);
        T min = this.coll.get(0);
        for (int i = 1; i < this.coll.size(); i++) {
            if(min.compareTo(this.coll.get(i)) > 0){
                min = this.coll.get(i);
            }
        }

        return min;
    }

    public void sorter(){
        this.coll = this.coll.stream().sorted().collect(Collectors.toList());
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < coll.size();
            }

            @Override
            public T next() {
                return coll.get(currentIndex++);
            }
        };
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }
}
