package Pr03_BarracksWars.core;

import Pr03_BarracksWars.contracts.Executable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter implements Pr03_BarracksWars.contracts.CommandInterpreter{
    private static final String COMMAND_PACKAGE = "Pr03_BarracksWars.core.commands.";
    private static final String COMMANDNAME_SUFFIX = "Command";

    public CommandInterpreter() {

    }


    @Override
    @SuppressWarnings("unchecked")
    public Executable interpretCommand(Object data, String commandName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        char cmdFirstLetter = commandName.toUpperCase().charAt(0);
        Class<Executable> cmdClass = (Class<Executable>) Class.forName(COMMAND_PACKAGE + cmdFirstLetter + commandName.substring(1) + COMMANDNAME_SUFFIX);
        Constructor<Executable> constructor = cmdClass.getDeclaredConstructor(String[].class);
        constructor.setAccessible(true);

        return constructor.newInstance(data);
    }
}
