package app.waste_disposal.factories;

import app.waste_disposal.contracts.Waste;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class GarbageFactory implements WasteFactory {
    private static final String GARBAGE_PATH = "app.waste_disposal.models.garbages.";
    private static final String GARBAGE_SUFFIX = "Garbage";

    @SuppressWarnings("unchecked")
    @Override
    public Waste makeGarbage(String[] params) {
        Waste garbage = null;
        String garbageName = params[1];
        double weight = Double.parseDouble(params[2]);
        double volumePerKg = Double.parseDouble(params[3]);
        String annotationTYpe = params[4];

        Class garbageClass = null;
        try {
            garbageClass = Class.forName(GARBAGE_PATH + annotationTYpe + GARBAGE_SUFFIX);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(garbageClass != null){
            Constructor<Waste> constr = null;
            try {
                constr = garbageClass.getDeclaredConstructor(String.class, double.class, double.class);
                garbage = constr.newInstance(garbageName, weight, volumePerKg);
            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return garbage;
    }

}
