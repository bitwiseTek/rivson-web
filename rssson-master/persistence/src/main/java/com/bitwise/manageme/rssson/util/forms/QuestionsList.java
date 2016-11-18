package com.bitwise.manageme.rssson.util.forms;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import java.util.Map;
import java.util.TreeMap;

public class QuestionsList {

private static Map<String, String> questions = new TreeMap<String, String>();
	
	public static Map<String, String> listOfQuestions() {
		questions.put("Q1", "What is your mother's maiden name?");
		questions.put("Q2", "What is the name of your first dog?");
		questions.put("Q3", "What is the color of your building?");
		questions.put("Q4", "What is your favorite dish?");
		questions.put("Q5", "At what age did you graduate secondary school?");
		
		return questions;
	}
	
	public static Map<String, String> getQuestions() {
		for (String question : listOfQuestions().values()) {
			System.out.println(question);
		}
		return questions;
	}
}
