package app.waste_disposal.factories;

import app.waste_disposal.contracts.GarbageDisposalStrategy;

public interface StrategyFactory {
    GarbageDisposalStrategy createStrategy(String startegyType);
}
