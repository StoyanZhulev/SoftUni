package Pr01_Weekdays;

public class Main {
    public static void main(String[] args) {
        WeeklyCalendar calendar = new WeeklyCalendar();
        calendar.addEntry("friday", "sleeping");
        calendar.addEntry("Monday", "sport");

        for (WeeklyEntry weeklyEntry : calendar.getWeeklySchedule()) {
            System.out.println(weeklyEntry);
        }
    }
}
