package needForSpeed.races;

import needForSpeed.cars.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DriftRace extends Race {
    public DriftRace(int lenght, String route, int prizePool) {
        super(lenght, route, prizePool);
    }


    @Override
    protected List<Car> getWinners() {
        if(super.getParticipants().isEmpty()){
            List<Car> win = new ArrayList<>();
            return win;
        }
        List<Car> winners = super.getParticipants().stream()
                .sorted((p1, p2) -> Integer.compare(p2.getSuspensionPerformance(), p1.getSuspensionPerformance()))
                .limit(3)
                .collect(Collectors.toList());

        return winners;
    }

    @Override
    public String toString() {
        List<Car> winners = this.getWinners();
        StringBuilder sb = new StringBuilder();

        if(winners != null) {
            int firstPrize = this.getPrizePool() * 50 / 100;
            int secondPrize = this.getPrizePool() * 30 / 100;
            int thirdPrize = this.getPrizePool() * 20 / 100;

            if (winners.size() == 3) {
                Car first = winners.get(0);
                Car second = winners.get(1);
                Car third = winners.get(2);

                sb.append(this.getRoute()).append(" - ").append(this.getLength());
                sb.append("\n");
                sb.append("1. ").append(first.getBrand()).append(" ").append(first.getModel()).append(" ").append(first.getSuspensionPerformance()).append("PP - $").append(firstPrize);
                sb.append("\n");
                sb.append("2. ").append(second.getBrand()).append(" ").append(second.getModel()).append(" ").append(second.getSuspensionPerformance()).append("PP - $").append(secondPrize);
                sb.append("\n");
                sb.append("3. ").append(third.getBrand()).append(" ").append(third.getModel()).append(" ").append(third.getSuspensionPerformance()).append("PP - $").append(thirdPrize);
            } else if (winners.size() == 2) {
                Car first = winners.get(0);
                Car second = winners.get(1);

                sb.append(this.getRoute()).append(" - ").append(this.getLength());
                sb.append("\n");
                sb.append("1. ").append(first.getBrand()).append(" ").append(first.getModel()).append(" ").append(first.getSuspensionPerformance()).append("PP - $").append(firstPrize);
                sb.append("\n");
                sb.append("2. ").append(second.getBrand()).append(" ").append(second.getModel()).append(" ").append(second.getSuspensionPerformance()).append("PP - $").append(secondPrize);
            } else if (winners.size() == 1) {
                Car first = winners.get(0);
                sb.append(this.getRoute()).append(" - ").append(this.getLength());
                sb.append("\n");
                sb.append("1. ").append(first.getBrand()).append(" ").append(first.getModel()).append(" ").append(first.getSuspensionPerformance()).append("PP - $").append(firstPrize);
            } else {
                return "Cannot start the race with zero participants.";
            }
        }
        return sb.toString();
    }
}
