package p01_system_resources;

import java.time.LocalTime;

public class LocalTimeProvider implements TimeProvider{
    private LocalTime time;

    @Override
    public int getHour() {
        return LocalTime.now().getHour();
    }
}
