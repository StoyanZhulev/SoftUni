package p05_security_system;

public class PinCodeCheck extends SecurityCheck {

    private PinCodeUI securityUI;

    public PinCodeCheck(PinCodeUI securityUI) {
        this.securityUI = securityUI;
    }

    @Override
    public boolean validateUser() {
        int pin = securityUI.requestPinCode();
        return isValid(pin);
    }

    private boolean isValid(int pin) {
        return true;
    }
}
