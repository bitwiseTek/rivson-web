package com.bitwise.manageme.rssson.util.forms;

import java.util.Map;
import java.util.TreeMap;

public class UnitList {

private static Map<Integer, String> units = new TreeMap<Integer, String>();
	
	public static Map<Integer, String> listOfUnits() {
		units.put(1, "1");
		units.put(2, "2");
		units.put(3, "3");
		units.put(4, "4");
		units.put(5, "5");
		units.put(6, "6");
		return units;
	}
	
	public static Map<Integer, String> getUnits() {
		for (String unit : listOfUnits().values()) {
			System.out.println(unit);
		}
		return units;
	}
}
