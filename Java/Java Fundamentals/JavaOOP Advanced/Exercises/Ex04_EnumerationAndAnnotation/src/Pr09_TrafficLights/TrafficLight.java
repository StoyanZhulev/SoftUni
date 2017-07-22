package Pr09_TrafficLights;

public class TrafficLight {
    private TrafficLightSignal signal;

    public TrafficLight(String signal) {
        this.signal = TrafficLightSignal.valueOf(signal.toUpperCase());
    }

    public String updateSignal() {
        if(this.signal.ordinal() == TrafficLightSignal.values().length - 1){
            this.signal = TrafficLightSignal.values()[0];
        }else{
            this.signal = TrafficLightSignal.values()[this.signal.ordinal() + 1];
        }
        return this.signal.name();
    }

    @Override
    public String toString() {
        return this.signal.name();
    }
}
