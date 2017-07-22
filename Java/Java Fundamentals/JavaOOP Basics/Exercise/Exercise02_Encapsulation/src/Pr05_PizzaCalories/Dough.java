package Pr05_PizzaCalories;

public class Dough {
    private final double doughInitialCalories = 2.0;

    private String flourType;
    private String backingTechnique;
    private double doughCalories;
    private double weight;

    public Dough(String flourType, String backingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBackingTechnique(backingTechnique);
        this.setWeight(weight);
        this.setDoughCalories(flourType, backingTechnique, weight);
    }

    private void setFlourType(String flourType) {
        if (!"White".equalsIgnoreCase(flourType) && !"Wholegrain".equalsIgnoreCase(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;

    }

    private void setBackingTechnique(String backingTechnique) {
        if (!"Crispy".equalsIgnoreCase(backingTechnique) && !"Chewy".equalsIgnoreCase(backingTechnique) && !"Homemade".equalsIgnoreCase(backingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.backingTechnique = backingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setDoughCalories(String flourType, String backingTechnique, double weight) {

        double flourCalories = 0.0;
        double techniqueCalories = 0.0;
        switch (flourType.toLowerCase()) {
            case "white":
                flourCalories = 1.5;
                break;
            case "wholegrain":
                flourCalories = 1.0;
        }

        switch (backingTechnique.toLowerCase()) {
            case "crispy":
                techniqueCalories = 0.9;
                break;
            case "chewy":
                techniqueCalories = 1.1;
                break;
            case "homemade":
                techniqueCalories = 1.0;
                break;
        }

        this.doughCalories = doughInitialCalories * flourCalories * techniqueCalories * weight;
    }

    public double getDoughCalories() {
        return doughCalories;
    }
}
