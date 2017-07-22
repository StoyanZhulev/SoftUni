package Pr08_CardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Card> player1Cards = new TreeSet<>();
        TreeSet<Card> player2Cards = new TreeSet<>();

        String player1 = reader.readLine();
        String player2 = reader.readLine();

        giveCardsToPlayer(reader, player1Cards, player2Cards);
        giveCardsToPlayer(reader, player2Cards, player1Cards);

        Card player1MaxCard = player1Cards.stream().sorted((c1, c2) -> Integer.compare(c2.getCardPower(), c1.getCardPower())).collect(Collectors.toList()).get(0);
        Card player2MaxCard = player2Cards.stream().sorted((c1, c2) -> Integer.compare(c2.getCardPower(), c1.getCardPower())).collect(Collectors.toList()).get(0);

        if (player1MaxCard.compareTo(player2MaxCard) > 0) {
            System.out.println(String.format("%s wins with %s.", player1, player1MaxCard));
        } else {
            System.out.println(String.format("%s wins with %s.", player2, player2MaxCard));
        }
    }

    private static void giveCardsToPlayer(BufferedReader reader, TreeSet<Card> playerToAdd, TreeSet<Card> player2Cards) throws IOException {
        while (playerToAdd.size() < 5) {
            String[] cardArdgs = reader.readLine().split(" ");
            String cardRank = cardArdgs[0];
            String cardSuit = cardArdgs[2];
            try {
                CardRank rank = CardRank.valueOf(cardRank);
                CardSuit suit = CardSuit.valueOf(cardSuit);
                Card card = new Card(rank, suit);

//                boolean isInDeck = true;
//                for (Card card1 : playerToAdd) {
//                    if (card1.compareTo(card) == 0) {
//                        System.out.println("Card is not in the deck.");
//                        isInDeck = false;
//                    }
//                }
//                if(isInDeck){
//                    for (Card card1 : player2Cards) {
//                        if (card1.compareTo(card) == 0) {
//                            System.out.println("Card is not in the deck.");
//                            isInDeck = false;
//                        }
//                    }
//                }
//                if (isInDeck) {
//                    playerToAdd.add(card);
//
//                }

                if (playerToAdd.contains(card) || player2Cards.contains(card)) {
                    System.out.println("Card is not in the deck.");
                }else {
                    playerToAdd.add(card);
                }
            } catch (Exception e) {
                System.out.println("No such card exists.");
            }
        }
    }
}
