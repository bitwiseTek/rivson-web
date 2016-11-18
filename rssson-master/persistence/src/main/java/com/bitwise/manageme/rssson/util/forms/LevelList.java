package com.bitwise.manageme.rssson.util.forms;

import java.util.Map;
import java.util.TreeMap;

public class LevelList {

private static Map<Integer, String> levels = new TreeMap<Integer, String>();
	
	public static Map<Integer, String> listOfLevels() {
		levels.put(100, "100");
		levels.put(200, "200");
		levels.put(300, "300");
		levels.put(400, "400");
		levels.put(500, "500");
		return levels;
	}
	
	public static Map<Integer, String> getLevels() {
		for (String level : listOfLevels().values()) {
			System.out.println(level);
		}
		return levels;
	}
}
