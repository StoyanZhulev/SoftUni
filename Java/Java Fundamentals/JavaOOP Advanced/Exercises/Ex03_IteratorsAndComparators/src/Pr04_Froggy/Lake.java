package Pr04_Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{
   private List<Integer> integers;


    public Lake(List<Integer> nums){
        this.setIntegers(nums);
    }

    private void setIntegers(List<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<Integer>{
        private int index;

        private Frog(){
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            if(index >= integers.size() && index % 2 ==0){
                index = 1;
            }
            return index + 2 <= integers.size() + 1;
        }

        @Override
        public Integer next() {
            int toReturn = integers.get(index);
            index += 2;
            return toReturn;
        }
    }
}
