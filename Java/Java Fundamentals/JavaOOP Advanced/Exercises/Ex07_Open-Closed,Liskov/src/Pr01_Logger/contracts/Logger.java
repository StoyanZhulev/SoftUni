package Pr01_Logger.contracts;

import Pr01_Logger.enumerations.ReportLevel;

public interface Logger {
    ReportLevel logError();

    ReportLevel logInfo();

    ReportLevel logWarning();

    ReportLevel logCritical();

    ReportLevel logFatal();

    void addAppender(Appender appender);

    Iterable<Appender> getAppenders();
}
