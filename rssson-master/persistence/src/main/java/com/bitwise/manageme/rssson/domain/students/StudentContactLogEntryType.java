package com.bitwise.manageme.rssson.domain.students;
/**
 *  
 * @author Sika Kay
 * @date 15/06/16
 *
 */
public enum StudentContactLogEntryType {
	OTHER	(0), 
	LETTER	(1), 
	EMAIL	(2), 
	PHONE	(3), 
	CHATLOG	(4), 
	SKYPE	(5), 
	FACE2FACE	(6), 
	ABSENCE	(7);
	
	private StudentContactLogEntryType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static StudentContactLogEntryType getType(int value) {
		for (StudentContactLogEntryType types : values()) {
			if (types.getValue() == value) {
				return types;
			}
		}
		return null;
	}
	
	private int value;
}
