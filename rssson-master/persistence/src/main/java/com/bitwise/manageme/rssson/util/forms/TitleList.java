package com.bitwise.manageme.rssson.util.forms;

import java.util.Map;
import java.util.TreeMap;

public class TitleList {

private static Map<String, String> titles = new TreeMap<String, String>();
	
	public static Map<String, String> listOfTitles() {
		titles.put("MR", "Mr");
		titles.put("MS", "Mrs");
		titles.put("MI", "Miss");
		titles.put("DR", "Dr");
		titles.put("EG", "Engr");
		titles.put("BR", "Barr");
		titles.put("PR", "Prof");
		return titles;
	}
	
	public static Map<String, String> getTitles() {
		for (String title : listOfTitles().values()) {
			System.out.println(title);
		}
		return titles;
	}
}
