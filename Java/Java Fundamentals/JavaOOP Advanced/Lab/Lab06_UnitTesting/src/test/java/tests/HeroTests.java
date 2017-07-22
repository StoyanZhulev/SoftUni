package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;
import rpg_lab.RandomProvider;
import rpg_lab.Target;
import rpg_lab.Weapon;

public class HeroTests {


    private static final int ATTACK = 10;
    private static final int DURABILITY = 10;
    private static final int TARGET_XP = 10;
    private static final String HERO_NAME = "Hero";

    private Hero hero;
    private Target targetMock;
    private RandomProvider rnd;
    private Weapon weaponMock;

    @Before
    public void createObject() {
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Hero hero = new Hero(HERO_NAME, weaponMock);
        Target targetMock = Mockito.mock(Target.class);
        RandomProvider rndMOck = Mockito.mock(RandomProvider.class);
    }

    @Test
    public void heroGainsXPWhenTargetDies() {


        Mockito.when(this.targetMock.isDead()).thenReturn(true);
        Mockito.when(this.targetMock.giveExperience()).thenReturn(TARGET_XP);


        this.hero.attack(targetMock, new RandomProvider.Implementation());
        Assert.assertEquals(TARGET_XP, this.hero.getExperience());
    }

    @Test
    public void HeroShouldGetWeaponAfterKillingTarget() {
        Mockito.when(this.targetMock.isDead()).thenReturn(true);
        Mockito.when(this.targetMock.giveWeapon(this.rnd)).thenReturn(this.weaponMock);

        this.hero.attack(this.targetMock, this.rnd);
        Assert.assertSame(this.weaponMock, this.hero.getInventory().iterator().next());
    }
}
