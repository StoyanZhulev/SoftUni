package Pr09_CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public class MyList implements IMyList{
    private List<String> elements;

    public MyList() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int add(String element) {
        this.elements.add(0, element);
        return 0;
    }

    @Override
    public int getUsed() {
        return this.elements.size();
    }

    @Override
    public String remove() {
        return this.elements.remove(0);
    }
}
