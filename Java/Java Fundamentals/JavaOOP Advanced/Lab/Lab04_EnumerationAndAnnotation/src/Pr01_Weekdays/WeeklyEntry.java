package Pr01_Weekdays;

import java.util.Comparator;

public class WeeklyEntry {
    public static final Comparator<WeeklyEntry> BY_WEEKDAY = getComparatorByWeekDay();

    private Weekday weekday;

    private String notes;

    public WeeklyEntry(String day, String notes) {
        this.weekday = Weekday.valueOf(day.toUpperCase());
        this.notes = notes;
    }

    @Override
    public String toString() {
        return this.weekday + " - " + this.notes;
    }

    private static Comparator<WeeklyEntry> getComparatorByWeekDay() {
        return Comparator.comparingInt(e -> e.weekday.ordinal());
    }
}
