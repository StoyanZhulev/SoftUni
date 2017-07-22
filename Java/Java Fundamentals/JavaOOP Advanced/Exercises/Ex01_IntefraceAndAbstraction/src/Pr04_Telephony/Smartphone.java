package Pr04_Telephony;

public class Smartphone implements Callable, Browseable{
    public Smartphone() {

    }

    @Override
    public String call() {
        return "Calling... ";
    }

    @Override
    public String browse() {
        return "Browsing: ";
    }
}
