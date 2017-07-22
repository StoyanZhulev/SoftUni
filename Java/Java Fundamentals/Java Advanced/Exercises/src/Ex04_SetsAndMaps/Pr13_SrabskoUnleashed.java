package Ex04_SetsAndMaps;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Pr13_SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^(?:[\\w]+ )+@(?:[a-zA-Z]+ )+[\\d]+ [\\d]+";
        String secondRegex = "((?:[a-zA-Z]+ )+)([\\d]+) ([\\d]+)";

        Pattern pattern1 = Pattern.compile(regex);
        Pattern pattern2 = Pattern.compile(secondRegex);

        LinkedHashMap<String, LinkedHashMap<String, Long>> venuesAndSingers = new LinkedHashMap<>();
        String line = scanner.nextLine();
        while (!"End".equals(line)) {
            Matcher matcher1 = pattern1.matcher(line);

            if (matcher1.find()) {
                String[] lineArgs = line.split("@");
                String singer = lineArgs[0];

                Matcher matcher2 = pattern2.matcher(lineArgs[1]);

                matcher2.find();
                String venue = matcher2.group(1);
                long ticketPrice = Long.parseLong(matcher2.group(2));
                long ticketsCount = Long.parseLong(matcher2.group(3));

                if (!venuesAndSingers.containsKey(venue)) {
                    venuesAndSingers.put(venue, new LinkedHashMap<>());
                    venuesAndSingers.get(venue).put(singer, ticketPrice * ticketsCount);
                } else {
                    if (!venuesAndSingers.get(venue).containsKey(singer)) {
                        venuesAndSingers.get(venue).put(singer, ticketPrice * ticketsCount);
                    } else {
                        venuesAndSingers.get(venue).put(singer, venuesAndSingers.get(venue).get(singer) + (ticketPrice * ticketsCount));
                    }
                }
            }

            line = scanner.nextLine();
        }

        //for (Map.Entry<String, LinkedHashMap<String, Long>> venue : venuesAndSingers.entrySet()) {
        //    System.out.println(venue.getKey());
        //    for (Map.Entry singer : venue.getValue().entrySet()
        //            .stream()
        //            .sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))
        //            .collect(Collectors.toList())) {

        //        System.out.printf("#  %s-> %s%n", singer.getKey(), singer.getValue());
        //    }
        //}

        for (Map.Entry<String, LinkedHashMap<String, Long>> venue : venuesAndSingers.entrySet()) {
            System.out.println(venue.getKey());
            venue.getValue().entrySet()
                    .stream()
                    .sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))
                    .forEach(singer -> {

                        System.out.printf("#  %s-> %s%n", singer.getKey(), singer.getValue());

                    });
        }

        //for (Map.Entry<String, LinkedHashMap<String, Long>> venue : venuesAndSingers.entrySet()) {
        //    System.out.println(venue.getKey());
        //    venue.getValue().entrySet()
        //            .stream()
        //            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        //            .forEach(singer -> {

        //                System.out.printf("#  %s-> %s%n", singer.getKey(), singer.getValue());

        //            });
        //}

        //for (Map.Entry<String, LinkedHashMap<String, Long>> venue : venuesAndSingers.entrySet()) {
        //    System.out.println(venue.getKey());
        //    venue.getValue().entrySet()
        //            .stream()
        //            .sorted(Map.Entry.comparingByValue(((a, b) -> b.compareTo(a))))
        //            .forEach(singer -> {

        //                System.out.printf("#  %s-> %s%n", singer.getKey(), singer.getValue());

        //            });
        //}

    }
}
