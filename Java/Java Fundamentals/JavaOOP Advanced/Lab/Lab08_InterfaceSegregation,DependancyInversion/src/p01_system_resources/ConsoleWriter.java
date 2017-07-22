package p01_system_resources;

public class ConsoleWriter implements Writer{

    @Override
    public void writeln(String message) {
        System.out.println(message);
    }
}
