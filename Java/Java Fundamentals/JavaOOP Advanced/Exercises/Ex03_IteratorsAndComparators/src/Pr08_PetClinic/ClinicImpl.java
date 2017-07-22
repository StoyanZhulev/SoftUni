package Pr08_PetClinic;

import java.util.Iterator;

public class ClinicImpl implements Clinic{
    private String name;
    private PetImpl[] pets;

    private ClinicImpl(String name, int rooms) {
        this.setName(name);
        this.setPets(rooms);
    }

    private void setPets(int rooms) {
        if(rooms % 2 == 0){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.pets = new PetImpl[rooms];
    }

    public static Clinic createClinic(String name, int rooms){
        return new ClinicImpl(name, rooms);
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean addPet(PetImpl pet) {
        PetAddIterator iterator = new PetAddIterator();

        while (iterator.hasNext()){
            int index = iterator.next();
            if(pets[index] == null){
                this.pets[index] = pet;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean release() {
        PetReleaseIterator iterator = new PetReleaseIterator();

        while (iterator.hasNext()){
            int index = iterator.next();
            if(pets[index] != null){
                pets[index] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasEmptyRooms() {
        for (PetImpl pet : pets) {
            if(pet == null){
                return true;
            }
        }

        return false;
    }

    @Override
    public String print() {
        StringBuilder out = new StringBuilder();
        for (PetImpl pet : pets) {
            if(pet == null){
                out.append("Room empty").append(System.lineSeparator());
            }else {
                out.append(pet.toString()).append(System.lineSeparator());
            }
        }

        return out.toString().trim();
    }

    @Override
    public String print(int roomIndex) {
        roomIndex--;
        if(pets[roomIndex] != null){
            return pets[roomIndex].toString();
        }else{
            return "Room empty";
        }
    }

    @Override
    public Iterator<PetImpl> iterator() {
        return new PetIterator();
    }

    private final class PetIterator implements Iterator<PetImpl>{
        private int index;

        public PetIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < pets.length;
        }

        @Override
        public PetImpl next() {
            return pets[index++];
        }
    }

    private final class PetAddIterator implements Iterator<Integer>{
        private int startRightIndex;
        private int startLeftIndex;
        private boolean isMovingLeft;

        public PetAddIterator() {
            this.startRightIndex = pets.length / 2;
            this.startLeftIndex = pets.length / 2 - 1;
            this.isMovingLeft = false;
        }

        @Override
        public boolean hasNext() {
            return this.startLeftIndex >= 0 || this.startRightIndex < pets.length;
        }

        @Override
        public Integer next() {
            if(this.isMovingLeft){
                this.isMovingLeft = false;
                return this.startLeftIndex--;
            }
            isMovingLeft = true;
            return this.startRightIndex++;
        }
    }

    private final class PetReleaseIterator implements Iterator<Integer>{
        private int index;
        private boolean isReset;

        public PetReleaseIterator() {
            this.index = pets.length / 2;
            this.isReset = false;
        }

        @Override
        public boolean hasNext() {
            return !(this.index == pets.length / 2 + 1 && isReset);
        }

        @Override
        public Integer next() {
            if (this.index >= pets.length){
                this.index = 0;
                this.isReset = true;
            }

            return index++;
        }
    }
}
