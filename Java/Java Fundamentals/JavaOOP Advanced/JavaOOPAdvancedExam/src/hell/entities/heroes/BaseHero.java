package hell.entities.heroes;

import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public abstract class BaseHero implements Hero{

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;

    private Inventory inventory;

    protected BaseHero(String name) {
        this.name = name;
    }

    protected BaseHero(String name, int strength, int agility, int intelligence, int hitPoints, int damage, Inventory inventory) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = inventory;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.inventory.getTotalStrengthBonus() + this.strength;
    }

    @Override
    public long getAgility() {
        return this.inventory.getTotalAgilityBonus() + this.agility;
    }

    @Override
    public long getIntelligence() {
        return this.inventory.getTotalIntelligenceBonus() + this.intelligence;
    }

    @Override
    public long getHitPoints() {
        return this.inventory.getTotalHitPointsBonus() + this.hitPoints;
    }

    @Override
    public long getDamage() {
        return this.inventory.getTotalDamageBonus() + this.damage;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<Item> getItems() {
        Class inventoryClass = this.inventory.getClass();
        try {
            Field items = inventoryClass.getDeclaredField("commonItems");
            items.setAccessible(true);
            Map<String, Item> value = (Map<String, Item>) items.get(this.inventory);
            Collection<Item> c = value.values();
            return Collections.unmodifiableCollection(c);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        out.append("Hero: ").append(this.name).append(", Class: ").append(this.getClass().getSimpleName());
        out.append(System.lineSeparator());
        out.append("HitPoints: ").append(this.getHitPoints()).append(", Damage: ").append(this.getDamage());
        out.append(System.lineSeparator());
        out.append("Strength: ").append(this.getStrength());
        out.append(System.lineSeparator());
        out.append("Agility: ").append(this.getAgility());
        out.append(System.lineSeparator());
        out.append("Intelligence: ").append(this.getIntelligence());
        out.append(System.lineSeparator());
        out.append("Items: ");
        if(this.getItems().isEmpty()){
            out.append("None");
        }else{
            Collection<Item> items = this.getItems();
            for (Item item : items) {
                out.append(System.lineSeparator());
                out.append("###Item: ").append(item.getName());
                out.append(System.lineSeparator());
                out.append("###+").append(item.getStrengthBonus()).append(" Strength");
                out.append(System.lineSeparator());
                out.append("###+").append(item.getAgilityBonus()).append(" Agility");
                out.append(System.lineSeparator());
                out.append("###+").append(item.getIntelligenceBonus()).append(" Intelligence");
                out.append(System.lineSeparator());
                out.append("###+").append(item.getHitPointsBonus()).append(" HitPoints");
                out.append(System.lineSeparator());
                out.append("###+").append(item.getDamageBonus()).append(" Damage");
            }
        }

        return out.toString();
    }
}
