package Pr03_BarracksWars.contracts;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	String removeUnit(String unitType);
}
