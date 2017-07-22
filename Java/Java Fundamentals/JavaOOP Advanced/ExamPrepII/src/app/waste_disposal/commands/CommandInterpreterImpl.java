package app.waste_disposal.commands;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter{
    private static final String COMMANDS_PACKAGE_PATH = "app.waste_disposal.commands.";
    public static final String COMMAND_SUFFIX = "Command";

    @SuppressWarnings("unchecked")
    @Override
    public Executable interpretCommand(String cmdType) {
        Executable executable = null;
        try {
            Class<Executable> cmdClass = (Class<Executable>) Class.forName(COMMANDS_PACKAGE_PATH + cmdType + COMMAND_SUFFIX);
            Constructor<Executable> constructor = cmdClass.getDeclaredConstructor();
            executable = constructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

        return executable;
    }
}
