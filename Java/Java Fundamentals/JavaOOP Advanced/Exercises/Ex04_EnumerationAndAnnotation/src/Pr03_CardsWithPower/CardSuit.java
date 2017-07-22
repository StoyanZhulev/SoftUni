package Pr03_CardsWithPower;

@CardAnnotation(type = "Enumeration",
        category = "Suit",
        description = "Provides suit constants for a Card class.")
public enum CardSuit {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    private int suitPOwer;

    CardSuit(int suitPower) {
        this.suitPOwer = suitPower;
    }

    public int getSuitPower() {
        return this.suitPOwer;
    }
}
