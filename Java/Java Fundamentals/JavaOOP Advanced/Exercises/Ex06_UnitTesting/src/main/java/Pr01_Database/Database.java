package Pr01_Database;

import javax.naming.OperationNotSupportedException;

public class Database<T extends Integer> {
    private Integer[] integers;

    public Database(Integer... integers) throws OperationNotSupportedException {
        this.setIntegers(integers);
    }


    public void setIntegers(Integer... integers) throws OperationNotSupportedException {
        if(integers.length != 16){
            throw new OperationNotSupportedException("Length must be 16");
        }
        this.integers = integers;
    }

    public int getLength(){
        return this.integers.length;
    }

    public Integer add(Integer integer){
        if(integer == null){
            throw new IllegalStateException("Integer must not be null.");
        }
        for (int i = 0; i < this.integers.length; i++) {
            if(this.integers[i] == null){
                this.integers[i] = integer;
                break;
            }
        }
        return integer;
    }

    public void remove() throws OperationNotSupportedException {
        if (this.integers[0] == null){
            throw new OperationNotSupportedException("Empty Database.");
        }

        for (int i = this.integers.length - 1; i >= 0; i++) {
            if(this.integers[i] != null){
                this.integers[i] = null;
                break;
            }
        }
    }

    public Integer[] fetch(){
        return this.integers;
    }

}
