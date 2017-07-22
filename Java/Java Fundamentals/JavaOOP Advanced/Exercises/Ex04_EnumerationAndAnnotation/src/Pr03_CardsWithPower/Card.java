package Pr03_CardsWithPower;

public class Card implements Comparable<Card>{
    private CardRank cardRank;
    private CardSuit cardSuit;

    public Card(String cardRank, String cardSuit) {
        this.cardRank = CardRank.valueOf(cardRank.toUpperCase());
        this.cardSuit = CardSuit.valueOf(cardSuit.toUpperCase());
    }

    private int getCardPower(){
        return this.cardRank.getRankPower() + this.cardSuit.getSuitPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", this.cardRank.name(), this.cardSuit.name(), this.getCardPower());
    }

    @Override
    public int compareTo(Card card) {
        return this.getCardPower() - card.getCardPower();
    }
}
