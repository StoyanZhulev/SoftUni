package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Dummy;
import rpg_lab.Weapon;

import java.util.ArrayList;

public class DummyTests {


    private static final int HEALTH = 10;
    private static final int EXPERIENCE = 10;
    private static final int ATTACK_POINTS = 10;
    private static final String WRONG_HEALTH_ERROR_MESSAGE = "Wrong health";
    private static final String WRONG_EXPIRIENCE_ERROR_MESSAGE = "Wrong Expirience";


    private Dummy dummy;
    @Before
    public void createDummt(){
        this.dummy = new Dummy(HEALTH, EXPERIENCE);
    }

    @Test
    public void testDummyHealthWhenAttacked(){
        this.dummy.takeAttack(ATTACK_POINTS);
        Assert.assertEquals(WRONG_HEALTH_ERROR_MESSAGE,HEALTH - ATTACK_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyWhenAttacked(){

            this.dummy.takeAttack(ATTACK_POINTS);
            this.dummy.takeAttack(ATTACK_POINTS);

    }

    @Test
    public void testDeadDummyGivesXPWhenKilled(){
        this.dummy.takeAttack(ATTACK_POINTS);
        Assert.assertEquals(WRONG_EXPIRIENCE_ERROR_MESSAGE, EXPERIENCE, this.dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyNotGiveXP(){
        this.dummy.giveExperience();
    }
}
