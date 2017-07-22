package Lab04_SetsAndMaps;

import java.util.*;

public class Pr02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //ArrayList<String> numbers = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        HashSet<String> regular = new HashSet<>();
        TreeSet<String> vip = new TreeSet<>();

        while (true){
            String input = scanner.nextLine();

            if("PARTY".equals(input)){
                break;
            }

            if(Character.isDigit(input.charAt(0))){
                vip.add(input);
            }else{
                regular.add(input);
            }
        }

        while(true){
            String guestComming = scanner.nextLine();
            if("END".equals(guestComming)){ //number.contains(input.charAt(0)
                break;
            }

            if(vip.contains(guestComming)){ // numbers.contains(guestComming.charAt(0);
                vip.remove(guestComming);
            }else{
                regular.remove(guestComming);
            }
        }

        vip.addAll(regular);

        System.out.println(vip.size());
        for (String s : vip) {
            System.out.println(s);
        }
    }
}
