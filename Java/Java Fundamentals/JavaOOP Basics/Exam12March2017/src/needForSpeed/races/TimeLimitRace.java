package needForSpeed.races;

import needForSpeed.cars.Car;

import java.util.List;

public class TimeLimitRace extends Race{

    private int goldTime;

    public TimeLimitRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    public TimeLimitRace(int length, String route, int prizePool, int goldTime){
        super(length, route, prizePool);
        this.goldTime = goldTime;
    }

    private int getTimePerformance(){
        return this.getLength() *((this.getParticipants().get(0).getHorsePower() / 100) * this.getParticipants().get(0).getAcceleration());
    }


    @Override
    public String toString() {

        if(this.getParticipants().isEmpty()){
            return "Cannot start the race with zero participants.";
        }
        String out = this.getRoute() + " - " + this.getLength()
                + "\n"
                + this.getParticipants().get(0).getBrand() + " " + this.getParticipants().get(0).getModel()
                + " - " + this.getTimePerformance() + " s." + "\n";
        StringBuilder sb = new StringBuilder(out);
        if(this.getTimePerformance() <= goldTime){
            sb.append("Gold Time, $").append(this.getPrizePool()).append(".");
            return sb.toString();
        }else if(this.getTimePerformance() <= goldTime + 15){
            sb.append("Silver Time, $").append(this.getPrizePool() * 50 / 100).append(".");
            return sb.toString();
        }else {
            sb.append("Bronze Time, $").append(this.getPrizePool() * 30 / 100).append(".");
            return sb.toString();
        }
    }

    @Override
    public List<Car> getWinners() {
        return null;
    }
}
