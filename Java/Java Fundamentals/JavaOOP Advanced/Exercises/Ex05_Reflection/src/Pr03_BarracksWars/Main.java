package Pr03_BarracksWars;


import Pr03_BarracksWars.contracts.Repository;
import Pr03_BarracksWars.contracts.UnitFactory;
import Pr03_BarracksWars.core.CommandInterpreter;
import Pr03_BarracksWars.core.Engine;
import Pr03_BarracksWars.core.factories.UnitFactoryImpl;
import Pr03_BarracksWars.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		CommandInterpreter cmdInterpreter = new CommandInterpreter();
		Runnable engine = new Engine(cmdInterpreter, repository, unitFactory);
		engine.run();
	}
}
