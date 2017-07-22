package Pr08_PetClinic;

public interface Clinic extends Iterable<PetImpl> {


    boolean addPet(PetImpl pet);

    boolean release();

    boolean hasEmptyRooms();

    String print();

    String print(int roomIndex);
}
