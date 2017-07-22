package Pr01_Logger.controllers.layouts;

import Pr01_Logger.contracts.Layout;

public class XmlLayout implements Layout {
    private String layoutFormat;

    public XmlLayout() {
        this.layoutFormat = "<log>\n" +
                "\t<date>%s</date>\n" +
                "\t<level>%s</level>\n" +
                "\t<message>%s</message>\n" +
                "</log>";
    }

    @Override
    public String getLayoutFormat() {
        return this.layoutFormat;
    }
}
