package Pr08_MilitaryElite;

import Pr08_MilitaryElite.classess.*;
import Pr08_MilitaryElite.exceptions.IllegalCorpArgument;
import Pr08_MilitaryElite.exceptions.IllegalMissionArgumen;
import Pr08_MilitaryElite.interfaces.ISoldier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String information = reader.readLine();

        Map<Integer,Private> privates = new LinkedHashMap<>();
        List<ISoldier> soldiers = new ArrayList<>();

        while (!"End".equals(information)){
            String[] info = information.split(" ");
            String soldierType = info[0];
            switch (soldierType){
                case "Private":
                    Private pr = new Private(Integer.parseInt(info[1]), info[2], info[3], Double.parseDouble(info[4]));
                    privates.put(Integer.parseInt(info[1]),pr);
                    System.out.println(pr.toString().trim());
                    soldiers.add(pr);
                    break;
                case "LeutenantGeneral":
                    LeutenantGeneral lg = new LeutenantGeneral(Integer.parseInt(info[1]), info[2], info[3], Double.parseDouble(info[4]));
                    for (int i = 5; i < info.length; i++) {
                        lg.addPrivates(privates.get(Integer.parseInt(info[i])));
                    }
                    System.out.println(lg.toString().trim());
                    soldiers.add(lg);

                    break;
                case "Engineer":
                    try{
                        Engineer en = new Engineer(Integer.parseInt(info[1]), info[2], info[3], Double.parseDouble(info[4]), info[5]);
                        for (int i = 6; i < info.length; i+=2) {
                            String partName = info[i];
                            int hours = Integer.parseInt(info[i + 1]);
                            Repair rep = new Repair(partName, hours);
                            en.addRepair(rep);
                        }
                        System.out.println(en.toString().trim());
                        soldiers.add(en);


                    }catch (IllegalCorpArgument ica){
                    }
                    break;
                case "Commando":
                    try{
                        Commando com = new Commando(Integer.parseInt(info[1]), info[2], info[3], Double.parseDouble(info[4]), info[5]);

                        for (int i = 6; i < info.length; i+=2) {
                            try{
                                String codeName = info[i];
                                String state = info[i + 1];
                                Mission mission = new Mission(codeName, state);
                                com.addMission(mission);
                            }catch (IllegalMissionArgumen ima){}
                        }
                        System.out.println(com.toString().trim());
                        soldiers.add(com);

                    }catch (IllegalCorpArgument ica){
                    }

                    break;
                case "Spy":
                    Spy spy = new Spy(Integer.parseInt(info[1]), info[2], info[3], Integer.parseInt(info[4]));
                    System.out.println(spy.toString());
                    soldiers.add(spy);
                    break;
                default:
                    break;
            }

            information = reader.readLine();
        }

//        for (ISoldier soldier : soldiers) {
//            System.out.println(soldier.toString());
//        }
    }
}
