package Pr11_Threeuple;

public class Threeuple <T, E, V>{
    private T item1;
    private E item2;
    private V item3;

    public Threeuple(T item1, E item2, V item3) {
        this.setItem1(item1);
        this.setItem2(item2);
        this.setItem3(item3);
    }

    private T getItem1() {
        return this.item1;
    }

    private void setItem1(T item1) {
        this.item1 = item1;
    }

    private E getItem2() {
        return this.item2;
    }

    private void setItem2(E item2) {
        this.item2 = item2;
    }

    private V getItem3() {
        return this.item3;
    }

    private void setItem3(V item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {

        return this.getItem1() + " -> " + this.getItem2() + " -> " + this.getItem3();
    }
}
