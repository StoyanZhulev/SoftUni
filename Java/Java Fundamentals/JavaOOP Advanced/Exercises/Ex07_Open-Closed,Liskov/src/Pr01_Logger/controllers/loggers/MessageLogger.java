package Pr01_Logger.controllers.loggers;

import Pr01_Logger.enumerations.ReportLevel;
import Pr01_Logger.contracts.Appender;
import Pr01_Logger.contracts.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MessageLogger implements Logger {
    private List<Appender> consoleAppender;

    public MessageLogger(Appender... consoleAppender) {
        this.consoleAppender = new ArrayList<>(Arrays.asList(consoleAppender));
    }

    @Override
    public void addAppender(Appender appender){
        this.consoleAppender.add(appender);
    }

    @Override
    public Iterable<Appender> getAppenders() {
        return this.consoleAppender;
    }

//    private void log(String timeAndDate, String message, ReportLevel level) {
//        for (Appender appender : this.consoleAppender) {
//            if(appender.getReportLevel() == null || appender.getReportLevel().ordinal() <= level.ordinal()){
//                appender.append(timeAndDate, message, level.name());
//            }
//        }
//    }

    @Override
    public ReportLevel logError() {
       // log(timeAndDate, message, ReportLevel.ERROR);
        return ReportLevel.ERROR;
    }

    @Override
    public ReportLevel logInfo() {
       // log(timeAndDate, message, ReportLevel.INFO);
        return ReportLevel.INFO;
    }

    @Override
    public ReportLevel logWarning() {
       // log(timeAndDate, message, ReportLevel.WARNING);
        return ReportLevel.WARNING;
    }

    @Override
    public ReportLevel logCritical() {
       // log(timeAndDate, message, ReportLevel.CRITICAL);
        return ReportLevel.CRITICAL;
    }

    @Override
    public ReportLevel logFatal() {
      //  log(timeAndDate, message, ReportLevel.FATAL);
        return ReportLevel.FATAL;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("Logger info").append(System.lineSeparator());
        for (Appender appender : consoleAppender) {
            out.append(appender.toString().trim()).append(System.lineSeparator());
        }
        return out.toString().trim();
    }
}
