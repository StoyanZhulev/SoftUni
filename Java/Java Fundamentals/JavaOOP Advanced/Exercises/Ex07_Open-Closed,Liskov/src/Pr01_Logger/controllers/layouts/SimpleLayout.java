package Pr01_Logger.controllers.layouts;

import Pr01_Logger.contracts.Layout;

public class SimpleLayout implements Layout {
    private String layoutFormat;

    public SimpleLayout() {
        this.layoutFormat = "%s - %s - %s";
    }

    @Override
    public String getLayoutFormat() {
        return this.layoutFormat;
    }
}
