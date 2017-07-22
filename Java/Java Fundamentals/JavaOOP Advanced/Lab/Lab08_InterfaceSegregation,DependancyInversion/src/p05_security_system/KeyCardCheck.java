package p05_security_system;

public class KeyCardCheck extends SecurityCheck {

    private KeyCardUI securityUI;

    public KeyCardCheck(KeyCardUI securityUI) {
        this.securityUI = securityUI;
    }

    @Override
    public boolean validateUser() {
        String code = securityUI.requestKeyCard();
        return isValid(code);

    }

    private boolean isValid(String code) {
        return true;
    }
}
