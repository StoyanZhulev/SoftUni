package Pr09_CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public class AddRemoveCollection implements AddableAndRemovable{
    private List<String> elements;

    public AddRemoveCollection() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int add(String element) {
        this.elements.add(0, element);
        return 0;
    }

    @Override
    public String remove() {
        return this.elements.remove(this.elements.size() - 1);
    }
}


