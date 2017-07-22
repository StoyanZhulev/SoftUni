package app;

import app.core.Engine;
import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.DefaultStrategyHolder;
import app.waste_disposal.StatusContainer;
import app.waste_disposal.commands.CommandInterpreter;
import app.waste_disposal.commands.CommandInterpreterImpl;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.StrategyHolder;
import app.waste_disposal.factories.GarbageFactory;
import app.waste_disposal.factories.StrategyFactory;
import app.waste_disposal.factories.StrategyFactoryImpl;
import app.waste_disposal.factories.WasteFactory;
import app.waste_disposal.io.ConsoleReader;
import app.waste_disposal.io.ConsoleWriter;
import app.waste_disposal.io.Reader;
import app.waste_disposal.io.Writer;
import app.waste_disposal.models.ManagementRequirement;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StrategyHolder strategyHolder = new DefaultStrategyHolder();
        GarbageProcessor garbageProcessor = new DefaultGarbageProcessor(strategyHolder);
        WasteFactory factory = new GarbageFactory();
        StrategyFactory strategyFactory = new StrategyFactoryImpl();
        StatusContainer statusContainer = new StatusContainer();
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        CommandInterpreter cmdInt = new CommandInterpreterImpl();
        ManagementRequirement managementRequirement = new ManagementRequirement();

        Runnable engine = new Engine(garbageProcessor, factory, strategyFactory, statusContainer, reader, writer, cmdInt, managementRequirement);


        engine.run();
    }
}
