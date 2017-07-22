package Pr01_Logger.contracts;

import Pr01_Logger.enumerations.ReportLevel;

public interface Appender {
    String getFormat();

    void append(String timeAndDate, String message, String reportLevel);

    void setReportLevel(ReportLevel level);

    ReportLevel getReportLevel();
}
