package tests;

import app.waste_disposal.DefaultStrategyHolder;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.StrategyHolder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tests.fake.DisposableAnnotation;
import tests.fake.NonDisposableAnnotation;

import java.util.Map;

public class StrategyHolderShould {
    private StrategyHolder strategyHolder;
    private GarbageDisposalStrategy strategyMock;
    private Class disposableAnnotationClass;
    private Class nonDisposableAnnotationClass;

    @Before
    public void initialize(){
        this.strategyHolder = new DefaultStrategyHolder();
        this.strategyMock = Mockito.mock(GarbageDisposalStrategy.class);
        this.disposableAnnotationClass = DisposableAnnotation.class;
        this.nonDisposableAnnotationClass = NonDisposableAnnotation.class;
    }

    @Test(expected = UnsupportedOperationException.class)
    public void returnReadOnlyCopy(){
        Map<Class, GarbageDisposalStrategy> disposalStrategies = this.strategyHolder.getDisposalStrategies();
        disposalStrategies.put(this.disposableAnnotationClass, this.strategyMock);
    }

    @Test
    public void returnEmptyMapAfterInitialization(){
        Map<Class, GarbageDisposalStrategy> disposalStrategies = this.strategyHolder.getDisposalStrategies();
        Assert.assertEquals(0, disposalStrategies.size());
    }

    @Test
    public void addCorrectlyPassedStrategy(){
        this.strategyHolder.addStrategy(this.disposableAnnotationClass, this.strategyMock);
        Assert.assertEquals(1, this.strategyHolder.getDisposalStrategies().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenNullAnnotationClassIsPassed(){
        this.strategyHolder.addStrategy(null, this.strategyMock);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenNullStrategyIsPassed(){
        this.strategyHolder.addStrategy(disposableAnnotationClass, null);
    }

    @Test
    public void returnFalseIfStrategiesContainsThisStrategy(){
        this.strategyHolder.addStrategy(disposableAnnotationClass, this.strategyMock);
        boolean result = this.strategyHolder.addStrategy(disposableAnnotationClass, this.strategyMock);

        Assert.assertEquals(false, result);
    }

    @Test
    public void returnTrueIfAnnotationStrategyIsPut(){
        boolean result = this.strategyHolder.addStrategy(this.disposableAnnotationClass, this.strategyMock);
        Assert.assertEquals(true, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenRemovingNullAnnotationClass(){
        boolean result = this.strategyHolder.removeStrategy(null);
    }

    @Test
    public void returnFalseIfAnnotationClassIsNotPresent(){
        this.strategyHolder.removeStrategy(this.disposableAnnotationClass);
    }

    @Test
    public void returnTrueIfObjectIsRemoved(){
        this.strategyHolder.addStrategy(disposableAnnotationClass, this.strategyMock);
        boolean result = this.strategyHolder.removeStrategy(disposableAnnotationClass);
        Assert.assertEquals(true, result);
    }

    @Test
    public void returnStrategyWhenCorrectAnnotationClassIsPassed(){
        this.strategyHolder.addStrategy(this.disposableAnnotationClass, this.strategyMock);
        GarbageDisposalStrategy garbageDisposalStrategy = this.strategyHolder.getDisposalStrategies().get(this.disposableAnnotationClass);
        Assert.assertEquals(this.strategyMock, garbageDisposalStrategy);
    }

    @Test
    public void returnFalseWhenRemovingFromEmptyMap(){
        boolean result = this.strategyHolder.removeStrategy(this.disposableAnnotationClass);
        Assert.assertEquals(false, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenRemovingNonDisposable() {
        this.strategyHolder.removeStrategy(this.nonDisposableAnnotationClass);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwIfNonDisposableAnnotationIsPassed() {
        this.strategyHolder.addStrategy(this.nonDisposableAnnotationClass, this.strategyMock);
    }
}
