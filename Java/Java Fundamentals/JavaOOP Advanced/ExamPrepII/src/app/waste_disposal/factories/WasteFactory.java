package app.waste_disposal.factories;

import app.waste_disposal.contracts.Waste;

public interface WasteFactory {
    Waste makeGarbage(String[] params);
}
