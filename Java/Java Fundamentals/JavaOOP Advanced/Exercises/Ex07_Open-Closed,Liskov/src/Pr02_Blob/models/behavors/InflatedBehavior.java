package Pr02_Blob.models.behavors;

import Pr02_Blob.models.Blob;

public class InflatedBehavior extends AbstractBehavior{
    private static final int INFALATED_HEALTH_DECREMENT = 10;
    private static final int HEALTH_INCREASANT = 50;
    private int initialDamage;
    public InflatedBehavior() {
        super();
    }

    @Override
    public void trigger(Blob source) {
        this.initialDamage = source.getDamage();
        super.setIsTriggered(true);
        this.applyTriggerEffect(source);
    }

    @Override
    public void applyRecurrentEffect(Blob source) {
        if (super.toDelayRecurrentEffect()) {
            super.setToDelayRecurrentEffect(false);
        } else {
            source.setDamage(source.getHealth() - INFALATED_HEALTH_DECREMENT);
        }
    }

    private void applyTriggerEffect(Blob source) {
        source.setHealth(source.getHealth()+ HEALTH_INCREASANT);
    }
}
