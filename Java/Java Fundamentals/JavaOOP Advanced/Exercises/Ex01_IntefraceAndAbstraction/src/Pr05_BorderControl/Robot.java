package Pr05_BorderControl;

/**
 * Created by User on 15/3/2017.
 */
public class Robot implements Identifiable {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
