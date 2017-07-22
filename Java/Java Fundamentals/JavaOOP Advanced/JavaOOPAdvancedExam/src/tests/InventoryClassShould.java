package tests;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class InventoryClassShould {

    private Inventory inventory;
    private Item commonItemMock;
    private Recipe recipeMock;
    private Item seconfitem;

    @Before
    public void initialize(){
        this.commonItemMock = Mockito.mock(Item.class);
        this.seconfitem = Mockito.mock(Item.class);
        this.recipeMock = Mockito.mock(Recipe.class);
        this.inventory = new HeroInventory();
    }

    @Test
    public void testGetStrengthMethod(){
        Mockito.when(this.commonItemMock.getStrengthBonus()).thenReturn(100);
        Assert.assertEquals(100, this.commonItemMock.getStrengthBonus());
    }
    @Test
    public void getStrengthBonus(){
        Mockito.when(this.commonItemMock.getStrengthBonus()).thenReturn(50);
        this.inventory.addCommonItem(this.commonItemMock);
        Assert.assertEquals(50, this.inventory.getTotalStrengthBonus());
    }
    @Test
    public void returnAgilityBonus(){
        Mockito.when(this.commonItemMock.getAgilityBonus()).thenReturn(50);
        this.inventory.addCommonItem(this.commonItemMock);
        Assert.assertEquals(50, this.inventory.getTotalAgilityBonus());
    }
    @Test
    public void getIntelligenceBonus(){
        Mockito.when(this.commonItemMock.getIntelligenceBonus()).thenReturn(50);
        this.inventory.addCommonItem(this.commonItemMock);
        Assert.assertEquals(50, this.inventory.getTotalIntelligenceBonus());
    }
    @Test
    public void getHitPointsBonus(){
        Mockito.when(this.commonItemMock.getHitPointsBonus()).thenReturn(50);
        this.inventory.addCommonItem(this.commonItemMock);
        Assert.assertEquals(50, this.inventory.getTotalHitPointsBonus());
    }
    @Test
    public void getDamageBonus(){
        Mockito.when(this.commonItemMock.getDamageBonus()).thenReturn(50);
        this.inventory.addCommonItem(this.commonItemMock);
        Assert.assertEquals(50, this.inventory.getTotalDamageBonus());
    }

    @Test
    public void addRecipe(){
        Mockito.when(this.commonItemMock.getStrengthBonus()).thenReturn(100);
        ArrayList<String> list = new ArrayList<>();
        list.add(this.commonItemMock.getName());
        Mockito.when(this.recipeMock.getRequiredItems()).thenReturn(list);
        Mockito.when(this.recipeMock.getStrengthBonus()).thenReturn(150);
        this.inventory.addCommonItem(this.commonItemMock);
        this.inventory.addRecipeItem(this.recipeMock);
        Assert.assertEquals(150, this.inventory.getTotalStrengthBonus());
    }

    @Test
    public void getStrengthBonusTwice(){
        Mockito.when(this.commonItemMock.getStrengthBonus()).thenReturn(50);
        Mockito.when(this.seconfitem.getStrengthBonus()).thenReturn(100);
        Mockito.when(this.seconfitem.getName()).thenReturn("sdf");
        this.inventory.addCommonItem(this.commonItemMock);
        this.inventory.addCommonItem(this.seconfitem);
        Assert.assertEquals(150, this.inventory.getTotalStrengthBonus());
    }


    @Test
    public void addRecipeTwice(){
        Mockito.when(this.commonItemMock.getStrengthBonus()).thenReturn(100);
        Mockito.when(this.seconfitem.getStrengthBonus()).thenReturn(100);
        Mockito.when(this.seconfitem.getName()).thenReturn("sdf");
        ArrayList<String> list = new ArrayList<>();
        list.add(this.commonItemMock.getName());

        Mockito.when(this.recipeMock.getRequiredItems()).thenReturn(list);
        Mockito.when(this.recipeMock.getStrengthBonus()).thenReturn(150);
        this.inventory.addCommonItem(this.commonItemMock);
        this.inventory.addCommonItem(this.seconfitem);
        this.inventory.addRecipeItem(this.recipeMock);
        Assert.assertEquals(250, this.inventory.getTotalStrengthBonus());
    }
}