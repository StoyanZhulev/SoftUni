package Pr01_Logger;

import Pr01_Logger.contracts.Logger;
import Pr01_Logger.controllers.CommandInterpreter;
import Pr01_Logger.controllers.loggers.MessageLogger;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Logger logger = new MessageLogger();
        CommandInterpreter cmdInterpreter = new CommandInterpreter(logger);
        cmdInterpreter.executeCommand();
    }
}
