package test;

public class CustomArrayImpl<T> implements CustomArray<T> {
    private T firstElement;
    private T secondElement;

    public CustomArrayImpl() {
    }



    @Override
    public void addElement(T element) {
        if(this.firstElement == null){
            this.firstElement = element;
        }else if(secondElement == null){
            this.secondElement = element;
        }else{
            throw new IllegalArgumentException("Some message");
        }

    }

    @Override
    public T getFirstElement() {
        return this.firstElement;
    }

    @Override
    public T getSecondElement() {
        return this.secondElement;
    }
}
