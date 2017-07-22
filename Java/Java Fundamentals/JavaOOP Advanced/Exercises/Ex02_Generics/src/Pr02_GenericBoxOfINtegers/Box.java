package Pr02_GenericBoxOfINtegers;

public class Box<T> {
    @Override
    public String toString() {
        return "";
    }

    public String print(T text) {
        return (text.getClass() + ": " + text);
    }
}
