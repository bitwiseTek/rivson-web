package com.bitwise.manageme.rssson.domain.base;

public enum VariableType {
	TEXT	(0), 
	NUMBER	(1), 
	DATE	(2), 
	BOOLEAN	(3);
	
	private VariableType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static VariableType getType(int value) {
		for (VariableType variableType : values()) {
			if (variableType.getValue() == value) {
				return variableType;
			}
		}
		return TEXT;
	}
	
	private int value; 

}
