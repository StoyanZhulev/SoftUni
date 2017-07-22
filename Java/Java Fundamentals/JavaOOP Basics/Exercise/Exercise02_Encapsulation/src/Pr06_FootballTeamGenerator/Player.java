package Pr06_FootballTeamGenerator;

public class Player {
    private String name;
    private double endurance;
    private double sprint;
    private double dribble;
    private double passing;
    private double shooting;
    private double overallSkill;

    public Player(String name, double endurance, double sprint, double dribble, double passing, double shooting){
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);

    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(double endurance) {
        if(!isValid(endurance)){
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
        this.endurance = endurance;
    }

    private void setSprint(double sprint) {
        if(!isValid(sprint)){
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
        this.sprint = sprint;
    }

    private void setDribble(double dribble) {
        if(!isValid(dribble)){
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        this.dribble = dribble;
    }


    private void setPassing(double passing) {
        if(!isValid(passing)){
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        this.passing = passing;
    }

    private void setShooting(double shooting) {
        if(!isValid(shooting)){
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.shooting = shooting;
    }

    public double getOverallSkill() {
        setOverallSkill();
        return overallSkill;
    }

    private void setOverallSkill() {

        this.overallSkill =(this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.0;
    }

    private boolean isValid(double skill){
        if(0 <= skill && skill <= 100){
            return true;
        }
        return false;
    }
}
