package Pr02_BlackBoxInteger;

public abstract class BlackBoxInt {
    private int innerValue;

    public BlackBoxInt() {
        this.innerValue = 0;
    }

    private void add(int added){
        this.innerValue += added;
    }

    private void subtract(int subtrahend){
        this.innerValue -= subtrahend;
    }

    private void multiply(int multiplier){
        this.innerValue *= multiplier;
    }

    private void divide(int divider){
        this.innerValue /= divider;
    }

    private void leftShift(int shifter){
        this.innerValue <<= shifter;
    }

    private void rightShift(int shifter){
        this.innerValue >>= shifter;
    }
}
