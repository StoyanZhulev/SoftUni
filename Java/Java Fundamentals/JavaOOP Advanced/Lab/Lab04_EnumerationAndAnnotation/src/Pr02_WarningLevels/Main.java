package Pr02_WarningLevels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String loggerLevel = reader.readLine();

        Logger logger = new Logger(Importance.valueOf(loggerLevel));
        String command = reader.readLine();
        while (!"END".equals(command)) {
            int colonINdex = command.indexOf(":");
            String messageLevel = command.substring(0, colonINdex);
            String message = command.substring(colonINdex + 2);

            logger.record(new Message(Importance.valueOf(messageLevel), message));
            command = reader.readLine();
        }

        for (Message message : logger.getMessages()) {
            System.out.println(message);
        }
    }
}
