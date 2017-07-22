package hell;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.entities.items.CommonItem;
import hell.entities.items.RecipeItem;
import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.*;
import hell.io.Reader;
import hell.io.Writer;

import java.util.*;

public class Main {
    private static  Map<String, Hero> heroes = new LinkedHashMap<>();
   private static InputReader reader = new Reader();
    private static OutputWriter writer = new Writer();
    private static int index = 1;
    public static void main(String[] args) {

        String line = reader.readLine();



        while (!"Quit".equals(line)){
            String[] lineArgs = line.split(" ");
            switch (lineArgs[0]){
                case "Hero":
                    executeHeroCommand(lineArgs);
                    break;
                case "Item":
                    executeItemCommand(lineArgs);
                    break;
                case "Recipe":
                    executeRecipeCommand(lineArgs);
                    break;
                case "Inspect":
                   writer.writeLine(heroes.get(lineArgs[1]).toString());
                   break;
                   default:
                       break;
            }

            line = reader.readLine();
        }


        heroes.entrySet().stream().sorted((h1, h2) -> {
            Hero hero1 = h1.getValue();
            long hero1Stats = hero1.getStrength() + hero1.getAgility() + hero1.getIntelligence();

            Hero hero2 = h2.getValue();

            long hero2Stats = hero2.getStrength() + hero2.getAgility() + hero2.getIntelligence();

            if(hero1Stats == hero2Stats){
                long hero1Demege = hero1.getHitPoints() + hero1.getDamage();
                long hero2Damage = hero2.getHitPoints() + hero2.getDamage();
                return Long.compare(hero2Damage, hero1Demege);
            }else{
                return Long.compare(hero2Stats, hero1Stats);
            }
        }).forEach(h -> {
            Hero hero = h.getValue();
            StringBuilder out = new StringBuilder();
            out.append(index).append(". ").append(hero.getClass().getSimpleName()).append(": ").append(hero.getName());
            out.append(System.lineSeparator());
            out.append("###HitPoints: ").append(hero.getHitPoints());
            out.append(System.lineSeparator());
            out.append("###Damage: ").append(hero.getDamage());
            out.append(System.lineSeparator());
            out.append("###Strength: ").append(hero.getStrength());
            out.append(System.lineSeparator());
            out.append("###Agility: ").append(hero.getAgility());
            out.append(System.lineSeparator());
            out.append("###Intelligence: ").append(hero.getIntelligence());
            out.append(System.lineSeparator());
            out.append("###Items: ");
            if(hero.getItems().isEmpty()){
                out.append("None").append(System.lineSeparator());
            }else{
                for (Item item : hero.getItems()) {
                    out.append(item.getName()).append(", ");
                }
                out.delete(out.length() - 2, out.length());
            }
            out.append(System.lineSeparator());

            index++;
            writer.writeLine(out.toString().trim());
        });
    }

    private static void executeRecipeCommand(String[] lineArgs) {
        String recipeName = lineArgs[1];
        String heroName = lineArgs[2];

        int strengthBonus = Integer.parseInt(lineArgs[3]);
        int agilityBonus = Integer.parseInt(lineArgs[4]);
        int intelligenceBonus = Integer.parseInt(lineArgs[5]);
        int hitpointsBonus = Integer.parseInt(lineArgs[6]);
        int damageBonus = Integer.parseInt(lineArgs[7]);

        List<String> requiredItems = new ArrayList<>();
        requiredItems.addAll(Arrays.asList(lineArgs).subList(8, lineArgs.length));
        String[] reqItems = new String[requiredItems.size()];
        for (int i = 0; i < requiredItems.size(); i++) {
            reqItems[i] = requiredItems.get(i);
        }

        Recipe recipe = new RecipeItem(recipeName, strengthBonus, agilityBonus, intelligenceBonus, hitpointsBonus, damageBonus, reqItems);
        heroes.get(heroName).addRecipe(recipe);
        writer.writeLine("Added recipe - " + recipeName + " to Hero - " + heroName);

    }

    private static void executeItemCommand(String[] lineArgs) {
        String itemName = lineArgs[1];
        String heroName = lineArgs[2];

        int strengthBonus = Integer.parseInt(lineArgs[3]);
        int agilityBonus = Integer.parseInt(lineArgs[4]);
        int intelligenceBonus = Integer.parseInt(lineArgs[5]);
        int hitpointsBonus = Integer.parseInt(lineArgs[6]);
        int damageBonus = Integer.parseInt(lineArgs[7]);

        Item item = new CommonItem(itemName, strengthBonus, agilityBonus, intelligenceBonus, hitpointsBonus, damageBonus);

        heroes.get(heroName).addItem(item);
        writer.writeLine("Added item - " + itemName + " to Hero - " + heroName);
    }

    private static void executeHeroCommand(String[] lineArgs) {
        String name = lineArgs[1];
        String type = lineArgs[2];

        Map<String, Item> commonItems = new LinkedHashMap<>();
        Map<String, Recipe> recipeItems = new LinkedHashMap<>();

        Hero hero = null;
        switch (type){
            case "Barbarian":
                 hero = new Barbarian(name, new HeroInventory(commonItems, recipeItems));
                heroes.put(name, hero);
                writer.writeLine("Created Barbarian - " + name);
                break;
            case "Assassin":
                 hero = new Assassin(name, new HeroInventory(commonItems, recipeItems));
                heroes.put(name, hero);
                writer.writeLine("Created Assassin - " + name);

                break;
            case "Wizard":
                hero = new Wizard(name, new HeroInventory(commonItems, recipeItems));
                heroes.put(name, hero);
                writer.writeLine("Created Wizard - " + name);
                break;
                default:
                    break;
        }
    }
}