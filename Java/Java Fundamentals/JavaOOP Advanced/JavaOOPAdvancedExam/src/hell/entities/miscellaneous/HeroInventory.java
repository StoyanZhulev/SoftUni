package hell.entities.miscellaneous;

import hell.entities.items.CommonItem;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.util.*;

public class HeroInventory implements Inventory {

    @ItemCollection
    private Map<String, Item> commonItems;

    private Map<String, Recipe> recipeItems;

    private Map<String, List<String>> reqItemsRemoved = new HashMap<>();

    public HeroInventory() {
        this.commonItems = new LinkedHashMap<>();
        this.recipeItems = new LinkedHashMap<>();
    }

    public HeroInventory(Map<String, Item> commonItems, Map<String, Recipe> requiredItems) {
        this.commonItems = commonItems;
        this.recipeItems = requiredItems;
    }

    @Override
    public long getTotalStrengthBonus() {
        return this.commonItems.entrySet().stream().mapToLong((x) -> x.getValue().getStrengthBonus()).sum();
    }

    @Override
    public long getTotalAgilityBonus() {
        return this.commonItems.entrySet().stream().mapToLong((x) -> x.getValue().getAgilityBonus()).sum();
    }

    @Override
    public long getTotalIntelligenceBonus() {
        return this.commonItems.entrySet().stream().mapToLong((x) -> x.getValue().getIntelligenceBonus()).sum();
    }

    @Override
    public long getTotalHitPointsBonus() {
        return this.commonItems.entrySet().stream().mapToLong((x) -> x.getValue().getHitPointsBonus()).sum();
    }

    @Override
    public long getTotalDamageBonus() {
        return this.commonItems.entrySet().stream().mapToLong((x) -> x.getValue().getDamageBonus()).sum();
    }

    @Override
    public void addCommonItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        this.commonItems.putIfAbsent(item.getName(), item);
        this.checkRecipes();
    }

    @Override
    public void addRecipeItem(Recipe recipe) {
        if (recipe == null) {
            throw new IllegalArgumentException();
        }

        this.recipeItems.putIfAbsent(recipe.getName(), recipe);
        this.checkRecipes();
    }

    private void checkRecipes() {
        for (Recipe recipe : this.recipeItems.values()) {
            reqItemsRemoved.putIfAbsent(recipe.getName(), new ArrayList<>());
            List<String> requiredItems = new ArrayList<String>(recipe.getRequiredItems());
            for (Item item : this.commonItems.values()) {
                if (requiredItems.contains(item.getName())) {
                    requiredItems.remove(item.getName());
                    reqItemsRemoved.get(recipe.getName()).add(item.getName());
                }
            }

            if (requiredItems.isEmpty()) {
                this.combineRecipe(recipe);
            }
        }
    }

    private void combineRecipe(Recipe recipe) {
        for (int i = 0; i < recipe.getRequiredItems().size(); i++) {
            String item = recipe.getRequiredItems().get(i);
            this.commonItems.remove(item);
        }

        for (int i = 0; i < reqItemsRemoved.get(recipe.getName()).size(); i++) {
            String item = reqItemsRemoved.get(recipe.getName()).get(i);
            this.commonItems.remove(item);
        }

//        TODO: Initialize the newItem variable, with an object of the CommonItem class.
//        TODO: Initialize the newItem variable, with the stat bonuses of the "recipe" parameter.
        int strengthBonus = recipe.getStrengthBonus();
        int agilityBonus = recipe.getAgilityBonus();
        int intelligenceBonus = recipe.getIntelligenceBonus();
        int hitPointsBonus = recipe.getHitPointsBonus();
        int damageBonus = recipe.getDamageBonus();

        Item newItem = new CommonItem(recipe.getName(), strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.commonItems.put(newItem.getName(), newItem);
    }
}