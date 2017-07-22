package Pr03_CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String classType = reader.readLine();

        Class<?> cardClass = null;
        switch (classType){
            case "Rank":
                cardClass = CardRank.class;
                break;
            case "Suit":
                cardClass = CardSuit.class;
                break;
        }

        if (cardClass != null) {
            CardAnnotation annotation = cardClass.getAnnotation(CardAnnotation.class);
            System.out.println(String.format("Type = %s, Description = %s", annotation.type(), annotation.description()));
        }
    }
}
