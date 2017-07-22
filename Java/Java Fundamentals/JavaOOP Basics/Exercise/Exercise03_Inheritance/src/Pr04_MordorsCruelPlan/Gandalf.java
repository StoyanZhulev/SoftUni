package Pr04_MordorsCruelPlan;

public class Gandalf {
    int happiness;

    public int getHappiness(){
        return this.happiness;
    }



    public void setHappiness(String[] foods){
        int happyPoints = 0;
        for (String food : foods) {
            switch (food.toLowerCase()){
                case "cram":
                    happyPoints +=2;
                    break;
                case "lembas":
                    happyPoints += 3;
                    break;
                case  "apple":
                    happyPoints++;
                    break;
                case "honeycake":
                    happyPoints += 5;
                    break;
                case "melon":
                    happyPoints++;
                    break;
                case "mushrooms":
                    happyPoints -= 10;
                    break;
                default:
                    happyPoints--;

            }
        }

        this.happiness = happyPoints;
    }

    public String getMood(){
        if(this.getHappiness() < -5){
            return "Angry";
        }else if(this.getHappiness() >= -5 && this.getHappiness() < 0){
            return "Sad";
        }else if(0 <= this.happiness && this.happiness <= 15){
            return "Happy";
        }
        return "JavaScript";
    }
}
