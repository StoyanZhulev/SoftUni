package Pr01_Logger.controllers.appenders;

import Pr01_Logger.enumerations.ReportLevel;
import Pr01_Logger.constant.AddapterConstants;
import Pr01_Logger.contracts.Appender;
import Pr01_Logger.contracts.Layout;

public class ConsoleAppender implements Appender {

    private Layout simpleLayout;
    private ReportLevel reportLevel;
    private int messagesAappended;

    public ConsoleAppender(Layout layout) {
        this.simpleLayout = layout;
        this.reportLevel = null;
        this.messagesAappended = AddapterConstants.INITIAL_MESSAGES_COUNT;
    }

    @Override
    public String getFormat() {
        return this.simpleLayout.getLayoutFormat().trim();
    }

    @Override
    public void append(String timeAndDate, String message, String reportLevel) {
        System.out.println(String.format(this.getFormat(), timeAndDate, reportLevel, message));
        this.messagesAappended++;
    }

    @Override
    public void setReportLevel(ReportLevel level) {
        this.reportLevel = level;
    }

    @Override
    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d", this.getClass().getSimpleName(), this.simpleLayout.getClass().getSimpleName(), this.reportLevel.name(), this.messagesAappended);
    }
}
