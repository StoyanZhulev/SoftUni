package P04_DetailPrinter;

public class Worker extends Employee{
    private int id;
    public Worker(String name, int id) {
        super(name);
        this.id = id;
    }

    @Override
    public String toString() {

        return super.toString() + " ID:" + this.id;
    }
}
