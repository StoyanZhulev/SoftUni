package Pr03_BarracksWars.core.factories;

import Pr03_BarracksWars.contracts.Unit;
import Pr03_BarracksWars.contracts.UnitFactory;
import Pr03_BarracksWars.models.units.AbstractUnit;

import java.lang.reflect.Constructor;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"Pr03_BarracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ReflectiveOperationException{
		Class currClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
		Constructor<AbstractUnit> constr = currClass.getDeclaredConstructor();
		constr.setAccessible(true);
		return  constr.newInstance();

	}
}
