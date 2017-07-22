package Pr10_InfernoInfinity;

@ClassInformation(author = "Pesho",
        revision = 3,
        description = "Used for Java OOP Advanced course - Enumerations and Annotations.",
        reviewers = {"Pesho", "Svetlio"})
public class Weapon implements WeaponInterface, Comparable<Weapon> {
    private String name;
    private WeaponType type;
    private GemType[] gems;

    public Weapon(String name, WeaponType type) {
        this.name = name;
        this.type = type;
        this.gems = new GemType[type.getSockets()];

    }


    private String getName() {
        return this.name;
    }

    public WeaponType getType() {
        return this.type;
    }

    private GemType[] getGems() {
        return this.gems;
    }

    private int getMinDamage() {
        int minDamage = this.type.getMinDamage();
        for (GemType gem : this.getGems()) {
            if (gem != null) {
                minDamage += gem.getStrength() * 2;
                minDamage += gem.getAgility();
            }
        }
        return minDamage;
    }

    private int getMaxDamage() {
        int maxDamage = this.type.getMaxDamage();
        for (GemType gem : this.getGems()) {
            if (gem != null) {
                maxDamage += gem.getStrength() * 3;
                maxDamage += gem.getAgility() * 4;
            }
        }
        return maxDamage;
    }

    private int getStrength() {
        int strength = 0;
        for (GemType gem : this.getGems()) {
            if (gem != null) {
                strength += gem.getStrength();
            }
        }
        return strength;
    }

    private int getAgility() {
        int agility = 0;
        for (GemType gem : this.getGems()) {
            if (gem != null) {
                agility += gem.getAgility();
            }
        }
        return agility;
    }

    private int getVitality() {
        int vitality = 0;
        for (GemType gem : this.getGems()) {
            if (gem != null) {
                vitality += gem.getVitality();
            }
        }
        return vitality;
    }

    private double getItemLevel() {
        double itemLevel = 0.0;
        itemLevel += ((this.getMinDamage() + this.getMaxDamage()) / 2.0) + this.getStrength() + this.getAgility() + this.getVitality();

        return itemLevel;
    }

    public String print() {
        return String.format("%s (Item Level: %.1f)", this.toString(), this.getItemLevel());
    }

    @Override
    public void addGem(int index, GemType type) {
        if (index < 0 || this.gems.length <= index) {
            throw new IllegalArgumentException("Invalid index!");
        }

        this.gems[index] = type;
    }

    @Override
    public void removeGem(int index) {
        if (index < 0 || this.gems.length <= index) {
            throw new IllegalArgumentException("Invalid index!");
        }

        this.gems[index] = null;
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.getName(),
                this.getMinDamage(),
                this.getMaxDamage(),
                this.getStrength(),
                this.getAgility(),
                this.getVitality());
    }

    @Override
    public int compareTo(Weapon w) {
        return Double.compare(this.getItemLevel(), w.getItemLevel());
    }
}
