package Pr01_JarOfT;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {

    private Deque<T> contents;

    public Jar() {
        this.contents = new ArrayDeque<>();
    }

    public void add(T e){
        this.contents.push(e);
    }

    public T remove(){
        return this.contents.pop();
    }

}
