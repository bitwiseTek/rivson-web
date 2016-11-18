package com.bitwise.manageme.rssson.util.search;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
public enum SearchTimeFilterMode {
	UNDEFINED	(0), 
	INCLUSIVE	(1), 
	EXCLUSIVE	(2);
	
	private SearchTimeFilterMode(int mode) {
		this.value = mode;
	}
	
	public static SearchTimeFilterMode getMode(Integer value) {
		if (value == null) {
			return UNDEFINED;
		}
		
		for (SearchTimeFilterMode mode : values()) {
			if (mode.getValue() == value.intValue()) {
				return mode;
			}
		}
		return UNDEFINED;
	}
	
	public int getValue() {
		return value;
	}
	
	int value;
}
