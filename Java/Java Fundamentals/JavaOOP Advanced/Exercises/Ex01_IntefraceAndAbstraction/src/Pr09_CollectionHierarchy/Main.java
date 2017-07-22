package Pr09_CollectionHierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Addable addCollection = new AddCollection();
        AddableAndRemovable addRemoveCollection = new AddRemoveCollection();
        MyList myList = new MyList();

        String[] elements = reader.readLine().split(" ");
        addElement(addCollection, elements);
        addElement(addRemoveCollection, elements);
        addElement(myList, elements);

        int removeOps = Integer.parseInt(reader.readLine());

        removeElements(addRemoveCollection, removeOps);
        removeElements(myList, removeOps);
    }

    private static void removeElements(AddableAndRemovable collection, int removeOps) {
        for (int i = 0; i < removeOps; i++) {
            System.out.printf("%s ", collection.remove());
        }
        System.out.println();
    }

    private static void addElement(Addable collection, String[] elements) {
        for (String element : elements) {
            System.out.printf("%s ", collection.add(element));
        }
        System.out.println();
    }
}
