package Pr07_DeckOfCards;

public class Card implements Comparable<Card> {
    private CardRank cardRank;
    private CardSuit cardSuit;

    public Card(CardRank cardRank, CardSuit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    private int getCardPower() {
        return this.cardRank.getRankPower() + this.cardSuit.getSuitPower();
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.cardRank.name(), this.cardSuit.name());
    }

    @Override
    public int compareTo(Card card) {
        return this.getCardPower() - card.getCardPower();
    }
}
