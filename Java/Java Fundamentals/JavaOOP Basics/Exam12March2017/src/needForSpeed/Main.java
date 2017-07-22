package needForSpeed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final CarManager carManager = new CarManager();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String command = reader.readLine();

        while (!"Cops Are Here".equals(command)) {
            String[] comArgs = command.split(" ");
            switch (comArgs[0]) {
                case "register":
                    carManager.register(Integer.parseInt(comArgs[1]), comArgs[2], comArgs[3], comArgs[4], Integer.parseInt(comArgs[5]), Integer.parseInt(comArgs[6]), Integer.parseInt(comArgs[7]), Integer.parseInt(comArgs[8]), Integer.parseInt(comArgs[9]));
                    break;
                case "check":
                    System.out.println(carManager.check(Integer.parseInt(comArgs[1])));
                    break;
                case "open":
                    if (comArgs.length == 6) {
                        carManager.open(Integer.parseInt(comArgs[1]), comArgs[2], Integer.parseInt(comArgs[3]), comArgs[4], Integer.parseInt(comArgs[5]));
                        break;
                    } else {
                        carManager.open(Integer.parseInt(comArgs[1]), comArgs[2], Integer.parseInt(comArgs[3]), comArgs[4], Integer.parseInt(comArgs[5]), Integer.parseInt(comArgs[6]));
                        break;
                    }
                case "participate":
                    carManager.participate(Integer.parseInt(comArgs[1]), Integer.parseInt(comArgs[2]));
                    break;
                case "start":
                    String s = carManager.start(Integer.parseInt(comArgs[1]));
                    if(!"".equals(s)){
                        System.out.println(s);
                    }
                    break;
                case "park":
                    carManager.park(Integer.parseInt(comArgs[1]));
                    break;
                case "unpark":
                    carManager.unpark(Integer.parseInt(comArgs[1]));
                    break;
                case "tune":
                    carManager.tune(Integer.parseInt(comArgs[1]), comArgs[2]);
                    break;

            }

            command = reader.readLine();
        }
    }
}
