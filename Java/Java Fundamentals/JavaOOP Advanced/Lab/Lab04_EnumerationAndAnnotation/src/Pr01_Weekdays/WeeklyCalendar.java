package Pr01_Weekdays;

import java.util.ArrayList;
import java.util.List;

public class WeeklyCalendar {
    private List<WeeklyEntry> entries;

    public WeeklyCalendar() {
        this.entries = new ArrayList<>();
    }

    public List<WeeklyEntry> getEntries() {
        return this.entries;
    }

    //not very good :D
    public void addEntry(String weekDay, String notes){
        WeeklyEntry entry = new WeeklyEntry(weekDay, notes);
        this.entries.add(entry);
    }

    //very good practice
    public Iterable<WeeklyEntry> getWeeklySchedule(){
      entries.sort(WeeklyEntry.BY_WEEKDAY);
        return entries;
    }
}
