package Pr07_CustomList;

public class CommandInterpreter<T extends Comparable<T>> {
    private CustomList<T> custom;

    public CommandInterpreter() {
        this.custom = new CustomList<T>();
    }

    public void add(T element){
        this.custom.add(element);
    }

    public T remove(int index){
       return this.custom.remove(index);
    }

    public boolean contains(T element){
        return this.custom.contains(element);
    }

    public void swap(int index, int index1){
        this.custom.swap(index, index1);
    }

    public int countGreaterThat(T element){
        return this.custom.countGreaterThat(element);
    }

    public T getMax(){
        return this.custom.getMax();
    }

   public T getMin(){
        return this.custom.getMin();
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        for (T t : this.custom.getColl()) {
            sb.append(t).append("\n");
        }

        return sb.toString().trim();
    }

    public void sort(){
        this.custom.sorter();
    }
}
