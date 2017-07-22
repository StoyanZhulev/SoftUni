package app.waste_disposal.io;

public class ConsoleWriter implements Writer {


    public ConsoleWriter() {
    }

    @Override
    public void writeLine(String message) {
        System.out.println(message);
    }
}
