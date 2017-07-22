package needForSpeed.races;

import needForSpeed.cars.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CircuitRace extends Race{
    private int laps;

    public CircuitRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    public CircuitRace(int length, String route, int prizePool, int laps){
        super(length, route, prizePool);
        this.laps = laps;
    }

    private void decreaseDurability(){
        for (int i = 0; i < laps; i++) {
            for (Car car : this.getParticipants()) {
                car.setDurability(car.getDurability() - (this.getLength() * this.getLength()));
            }
        }
    }

    @Override
    public String toString() {
        this.decreaseDurability();
        List<Car> winners = this.getWinners();
        StringBuilder sb = new StringBuilder();

        int firstPrize = this.getPrizePool()*40 / 100;
        int secondPrize = this.getPrizePool()*30 / 100;
        int thirdPrize = this.getPrizePool() * 20 / 100;
        int fourthPrize = this.getPrizePool() * 10 / 100;

        if(winners.size() == 4){
            Car first = winners.get(0);
            Car second = winners.get(1);
            Car third = winners.get(2);
            Car fourth = winners.get(3);

            sb.append(this.getRoute()).append(" - ").append(this.getLength() * this.laps);
            sb.append("\n");
            sb.append("1. ").append(first.getBrand()).append(" ").append(first.getModel()).append(" ").append(first.getOverallPerformance()).append("PP - $").append(firstPrize);
            sb.append("\n");
            sb.append("2. ").append(second.getBrand()).append(" ").append(second.getModel()).append(" ").append(second.getOverallPerformance()).append("PP - $").append(secondPrize);
            sb.append("\n");
            sb.append("3. ").append(third.getBrand()).append(" ").append(third.getModel()).append(" ").append(third.getOverallPerformance()).append("PP - $").append(thirdPrize);
            sb.append("\n");
            sb.append("4. ").append(fourth.getBrand()).append(" ").append(fourth.getModel()).append(" ").append(fourth.getOverallPerformance()).append("PP - $").append(fourthPrize);
        } else if(winners.size() == 3){
            Car first = winners.get(0);
            Car second = winners.get(1);
            Car third = winners.get(2);

            sb.append(this.getRoute()).append(" - ").append(this.getLength() * this.laps);
            sb.append("\n");
            sb.append("1. ").append(first.getBrand()).append(" ").append(first.getModel()).append(" ").append(first.getOverallPerformance()).append("PP - $").append(firstPrize);
            sb.append("\n");
            sb.append("2. ").append(second.getBrand()).append(" ").append(second.getModel()).append(" ").append(second.getOverallPerformance()).append("PP - $").append(secondPrize);
            sb.append("\n");
            sb.append("3. ").append(third.getBrand()).append(" ").append(third.getModel()).append(" ").append(third.getOverallPerformance()).append("PP - $").append(thirdPrize);
        }else if (winners.size() == 2){
            Car first = winners.get(0);
            Car second = winners.get(1);

            sb.append(this.getRoute()).append(" - ").append(this.getLength() * this.laps);
            sb.append("\n");
            sb.append("1. ").append(first.getBrand()).append(" ").append(first.getModel()).append(" ").append(first.getOverallPerformance()).append("PP - $").append(firstPrize);
            sb.append("\n");
            sb.append("2. ").append(second.getBrand()).append(" ").append(second.getModel()).append(" ").append(second.getOverallPerformance()).append("PP - $").append(secondPrize);
        }else if(winners.size() == 1){
            Car first = winners.get(0);
            sb.append(this.getRoute()).append(" - ").append(this.getLength() * this.laps);
            sb.append("\n");
            sb.append("1. ").append(first.getBrand()).append(" ").append(first.getModel()).append(" ").append(first.getOverallPerformance()).append("PP - $").append(firstPrize);
        }else{
            return "Cannot start the race with zero participants.";
        }
        return sb.toString();
    }

    @Override
    public List<Car> getWinners() {
        if(super.getParticipants().isEmpty()){
            List<Car> win = new ArrayList<>();
            return win;
        }
        List<Car> winners = super.getParticipants().stream()
                .sorted((p1, p2) -> Integer.compare(p2.getOverallPerformance(), p1.getOverallPerformance()))
                .limit(4)
                .collect(Collectors.toList());

        return winners;
    }
}
