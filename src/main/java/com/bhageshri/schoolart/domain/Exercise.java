package com.bhageshri.schoolart.domain;

import com.bhageshri.schoolart.util.QuestionType;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Exercise {
	private static Map<QuestionType, List<Question>> questions = new EnumMap<QuestionType, ? extends List<Question>>();
	
	public static void initialize() {
		Question question1 = new Question("What helps us to know our past", "History");
		Question question2 = new Question("For which period are no records available", "Prehistory");
		Question question3 = new Question("What is the full for of AD", "Anno Domini");
		Question question4 = new Question("Which book tells us the exploits of Prithviraj Chauhan", "Prithviraj Raso");
		Question question5 = new Question("Name any one chinese traveller who visited india during the ancient period", "Fahein");
		
		questions.put("A.1", question1);
		questions.put("A.2", question2);
		questions.put("A.3", question3);
		questions.put("A.4", question4);
		questions.put("A.5", question5);
	}
	
	public static Map<String, Question> getQuestions() {
		return questions;
	}
}
