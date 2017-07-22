package Pr03_BarracksWars.core;

import Pr03_BarracksWars.annotations.Inject;
import Pr03_BarracksWars.contracts.Executable;
import Pr03_BarracksWars.contracts.Repository;
import Pr03_BarracksWars.contracts.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;


public class Engine implements Runnable {
    private static final String COMMAND_PACKAGE = "Pr03_BarracksWars.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;
    private CommandInterpreter cmdInterpreter;

    public Engine(CommandInterpreter cmdInterpreter, Repository repository, UnitFactory unitFactory) {
        this.cmdInterpreter = cmdInterpreter;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];

                Executable executable = cmdInterpreter.interpretCommand(data, commandName);

                Class<?> cmdClass = executable.getClass();
                Field[] fields = cmdClass.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Inject.class)){
                        field.setAccessible(true);

                        Field[] engineFields = Engine.class.getDeclaredFields();
                        for (Field engineField : engineFields) {
                            if (!field.getType().equals(engineField.getType())){
                                continue;
                            }
                            engineField.setAccessible(true);
                            field.set(executable, engineField.get(this));
                        }
                    }
                }

                String result = executable.execute();
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | ReflectiveOperationException e) {
                e.printStackTrace();
            }
        }
    }

}
