import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr03_RoyalFlush {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(reader.readLine());
        }

        Pattern pattern = Pattern.compile("([\\d]+|J|Q|A|K|])(s|d|h|c)");
        Matcher matcher = pattern.matcher(sb);

        StringBuilder clubs = new StringBuilder();
        StringBuilder diamonds = new StringBuilder();
        StringBuilder hearts = new StringBuilder();
        StringBuilder spades = new StringBuilder();

        Pattern clubsPattern = Pattern.compile("10cJcQcKcAc");
        Pattern diamondsPattern = Pattern.compile("10dJdQdKdAd");
        Pattern heartsPattern = Pattern.compile("10hJhQhKhAh");
        Pattern spadesPattern = Pattern.compile("10sJsQsKsAs");

        Matcher clubsMatcher = clubsPattern.matcher(clubs);
        Matcher diamondsMatcher = diamondsPattern.matcher(diamonds);
        Matcher heartsMatcher = heartsPattern.matcher(hearts);
        Matcher spadesMatcher = spadesPattern.matcher(spades);

        int flushesCount = 0;
        while (matcher.find()){
            String suit = matcher.group(2);

            switch (suit){
                case "c":
                    clubs.append(matcher.group());
                    while(clubsMatcher.find(0)){
                        System.out.println("Royal Flush Found - Clubs");
                        flushesCount++;
                        clubs.delete(0, clubs.length());
                    }
                    break;
                case "d":
                    if(matcher.group().length() > 2 && matcher.group().charAt(0) != '1'){
                        diamonds.delete(0, diamonds.length());
                        break;
                    }
                    diamonds.append(matcher.group());
                    while (diamondsMatcher.find(0)){
                        System.out.println("Royal Flush Found - Diamonds");
                        flushesCount++;
                        diamonds.delete(0, diamonds.length());
                    }
                    break;
                case "h":
                    hearts.append(matcher.group());
                    while(heartsMatcher.find(0)){
                        System.out.println("Royal Flush Found - Hearts");
                        flushesCount++;
                        hearts.delete(0, hearts.length());
                    }
                    break;
                case "s":
                    spades.append(matcher.group());
                    while(spadesMatcher.find(0)){
                        System.out.println("Royal Flush Found - Spades");
                        flushesCount++;
                        spades.delete(0, spades.length());
                    }
                    break;
                default:
                    break;
            }
        }

        System.out.println("Royal's Royal Flushes - " + flushesCount + ".");
    }
}
