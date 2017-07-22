package app.waste_disposal.models.garbages;

import app.waste_disposal.annotations.Recyclable;

@Recyclable
public class RecyclableGarbage extends BaseGarbage {
    public RecyclableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
