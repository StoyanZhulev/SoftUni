package tests;

import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.StrategyHolder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tests.fake.DisposableAnnotation;
import tests.fake.DisposableWaste;
import tests.fake.NonAnnotatedWaste;
import tests.fake.NonDisposableWaste;

import java.util.LinkedHashMap;
import java.util.Map;

public class GarbageProcessorShould {
    private final Map<Class, GarbageDisposalStrategy> strategies = new LinkedHashMap<>();
    private StrategyHolder strategyHolderMock;
    private GarbageProcessor garbageProcessor;
    private ProcessingData processingDataMock;
    private GarbageDisposalStrategy garbageDisposalStrategyMock;

    @Before
    public void initialize(){
        this.strategyHolderMock = Mockito.mock(StrategyHolder.class);
        this.garbageProcessor = new DefaultGarbageProcessor(this.strategyHolderMock);
        this.processingDataMock = Mockito.mock(ProcessingData.class);
        this.garbageDisposalStrategyMock  = Mockito.mock(GarbageDisposalStrategy.class);
        this.strategies.put(DisposableAnnotation.class, this.garbageDisposalStrategyMock);
    }

    @Test
    public void returnStrategyHolder(){
        Assert.assertEquals(this.strategyHolderMock, this.garbageProcessor.getStrategyHolder());
    }


    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenWasteWithNonDisposableAnnotationIsProcessed(){
        this.garbageProcessor.processWaste(new NonDisposableWaste());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenNonAnnotatedWasteIsProcessed(){
        this.garbageProcessor.processWaste(new NonAnnotatedWaste());
    }

    @Test
    public void returnProcessingDataWhenDisposableWasteIsPassed(){
        Mockito.when(this.garbageDisposalStrategyMock.processGarbage(Mockito.isA(DisposableWaste.class))).thenReturn(this.processingDataMock);
        Mockito.when(this.strategyHolderMock.getDisposalStrategies()).thenReturn(this.strategies);

        ProcessingData result = this.garbageProcessor.processWaste(new DisposableWaste());

        Assert.assertEquals(this.processingDataMock, result);
    }
}
