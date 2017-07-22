package Pr01_Logger.controllers.appenders;

import Pr01_Logger.enumerations.ReportLevel;
import Pr01_Logger.constant.AddapterConstants;
import Pr01_Logger.contracts.Appender;
import Pr01_Logger.contracts.File;
import Pr01_Logger.contracts.Layout;

public class FileAppender implements Appender {


    private File file;
    private Layout simpleLayout;
    private ReportLevel reportLevel;
    private int messagesAappended;

    public FileAppender(Layout simpleLayout) {
        this.simpleLayout = simpleLayout;
        this.file = null;
        this.reportLevel = null;
        this.messagesAappended = AddapterConstants.INITIAL_MESSAGES_COUNT;
    }

    public void setFile(File file){
        this.file = file;
    }

    @Override
    public String getFormat() {
        return this.simpleLayout.getLayoutFormat();
    }

    @Override
    public void append(String timeAndDate, String message, String reportLevel) {
        file.write(String.format(this.getFormat(), timeAndDate, reportLevel, message));
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
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d, File size: %d", this.getClass().getSimpleName(), this.simpleLayout.getClass().getSimpleName(), this.reportLevel == null ? ReportLevel.values()[0].name(): this.reportLevel.name(), this.messagesAappended, this.file.getSize());
    }
}
