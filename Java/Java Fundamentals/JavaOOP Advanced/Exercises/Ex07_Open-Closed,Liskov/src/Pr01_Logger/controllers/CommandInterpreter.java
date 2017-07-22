package Pr01_Logger.controllers;

import Pr01_Logger.enumerations.ReportLevel;
import Pr01_Logger.contracts.Appender;
import Pr01_Logger.contracts.Layout;
import Pr01_Logger.contracts.Logger;
import Pr01_Logger.controllers.appenders.FileAppender;
import Pr01_Logger.controllers.files.LogFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CommandInterpreter {
    private static final String LAYOUTS_PACKAGE = "Pr01_Logger.controllers.layouts.";
    private static final String APPENDERS_PACKAGE = "Pr01_Logger.controllers.appenders.";
    private static final String FILE_APPENDER_NAME_PREFIX = "File";
    private static final String METHOD_PREFIX = "log";
    private static final String END_COMMAND = "END";

    private Logger logger;

    public CommandInterpreter(Logger logger) {
        this.logger = logger;
    }

    @SuppressWarnings("unchecked")
    public void executeCommand() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] lineArgs = reader.readLine().split(" ");
            String appType = lineArgs[0];
            String layoutType = lineArgs[1];
            ReportLevel level = ReportLevel.values()[0];
            if (lineArgs.length > 2) {
                level = ReportLevel.valueOf(lineArgs[2].toUpperCase());
            }

            Class<Layout> layoutClass = (Class<Layout>) Class.forName(LAYOUTS_PACKAGE + layoutType);
            Constructor layoutConstr = layoutClass.getDeclaredConstructor();
            Layout layout = (Layout) layoutConstr.newInstance();

            Class<Appender> appenderClass = (Class<Appender>) Class.forName(APPENDERS_PACKAGE + appType);
            Constructor appenderConstr = appenderClass.getDeclaredConstructor(Layout.class);
            Appender appender = (Appender) appenderConstr.newInstance(layout);

            if (appenderClass.getSimpleName().startsWith(FILE_APPENDER_NAME_PREFIX)){
                ((FileAppender) appender).setFile(new LogFile(new StringBuilder()));
            }
            appender.setReportLevel(level);

            this.logger.addAppender(appender);
        }

        String line = reader.readLine();

        Class loggerClass = this.logger.getClass();
        //Method[] declaredMethods = loggerClass.getDeclaredMethods();

        while (!END_COMMAND.equals(line)) {

            String[] lineArgs = line.split("\\|");
            String reportLevel = lineArgs[0];
            String time = lineArgs[1];
            String message = lineArgs[2];

            String methodName = METHOD_PREFIX + reportLevel.toUpperCase().charAt(0) + reportLevel.substring(1).toLowerCase();
            Method method = loggerClass.getDeclaredMethod(methodName);
                //for (Method method : declaredMethods) {
                    for (Appender appender : this.logger.getAppenders()) {
                        if (method.getName().equals(methodName)) {
                            ReportLevel level = (ReportLevel) method.invoke(logger);
                            if (appender.getReportLevel().ordinal() <= level.ordinal()) {
                                appender.append(time, message, level.name());
                            }
                        }
                    }
                //}

            line = reader.readLine();
        }

        System.out.println(this.logger);
    }
}

