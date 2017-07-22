package Pr06_StrategyPattern;

import java.util.Comparator;

public class PeopleNameComparator implements Comparator<Person>{
    @Override
    public int compare(Person p1, Person p2) {
        if(p1.getName().length() == p2.getName().length()){
            return  (Character.compare(p1.getName().toLowerCase().charAt(0),(p2.getName().toLowerCase().charAt(0))));
        }else{
            return p1.getName().length() - p2.getName().length();
        }
    }
}
