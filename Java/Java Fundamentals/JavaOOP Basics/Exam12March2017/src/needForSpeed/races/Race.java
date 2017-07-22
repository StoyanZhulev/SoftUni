package needForSpeed.races;

import needForSpeed.cars.Car;

import java.util.ArrayList;
import java.util.List;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    public Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    protected int getLength() {
        return length;
    }

    protected String getRoute() {
        return route;
    }

    protected int getPrizePool() {
        return prizePool;
    }

    public List<Car> getParticipants() {
        return participants;
    }

    public void addParticipant(Car car){
        this.participants.add(car);
    }

    protected abstract List<Car> getWinners();

}
