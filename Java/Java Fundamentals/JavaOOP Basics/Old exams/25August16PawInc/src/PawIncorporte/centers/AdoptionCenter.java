package PawIncorporte.centers;

import PawIncorporte.Paw;

public class AdoptionCenter extends Center{
    public AdoptionCenter(String name){
        super(name);
    }

    public void sendForCleansing(CleansingCenter cleansingCenter){
        for (int i = 0; i < this.getAnimals().size(); i++) {
            if(this.getAnimals().get(i).getCleansingStatus().equals("uncleansed")){
                cleansingCenter.registerAnimal(this.getAnimals().get(i));
                this.getAnimals().remove(i);
                i--;
            }
        }

    }

    public void adoptAnimal(Paw pawInc){
        for (int i = 0; i < this.getAnimals().size(); i++) {
            if(this.getAnimals().get(i).getCleansingStatus().equals("cleansed")){
                pawInc.adoptedAnimal(this.getAnimals().get(i).getName());
                this.getAnimals().remove(i);
                i--;
            }
        }
    }

}
