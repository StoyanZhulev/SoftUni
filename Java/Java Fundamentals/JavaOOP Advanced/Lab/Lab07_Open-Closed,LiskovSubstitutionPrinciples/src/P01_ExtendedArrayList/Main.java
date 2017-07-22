package P01_ExtendedArrayList;

public class Main {
    public static void main(String[] args) {
        ExtendedArrayList<Integer> list = new ExtendedArrayList<>();
        list.add(1);
        list.add(5);
        list.add(27);
        list.add(6);
        list.add(6);

        System.out.println(list.max());
        System.out.println(list.min());


    }
}
