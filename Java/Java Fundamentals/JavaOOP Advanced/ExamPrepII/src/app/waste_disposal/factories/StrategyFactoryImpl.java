package app.waste_disposal.factories;

import app.waste_disposal.contracts.GarbageDisposalStrategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class StrategyFactoryImpl implements StrategyFactory{
    private static final String STRATEGY_PATH = "app.waste_disposal.models.strategies.";
    private static final String STRATEGY_SUFFIX = "Strategy";

    @SuppressWarnings("unchecked")
    @Override
    public GarbageDisposalStrategy createStrategy(String startegyType) {
        GarbageDisposalStrategy strategy = null;
        Class strategyClass = null;
        try {
            strategyClass = Class.forName(STRATEGY_PATH + startegyType + STRATEGY_SUFFIX);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(strategyClass != null){
            Constructor<GarbageDisposalStrategy> constr = null;
            try {
                constr = strategyClass.getDeclaredConstructor();
                strategy = constr.newInstance();
            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return strategy;
    }
}
