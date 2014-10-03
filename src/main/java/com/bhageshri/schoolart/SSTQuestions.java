package com.bhageshri.schoolart;

import com.bhageshri.schoolart.domain.Exercise;
import com.bhageshri.schoolart.domain.Question;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class SSTQuestions {
	public static void main(String...args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			int totalMarks = 0;
			
			Exercise.initialize();
			
			Map<String, Question> questions = Exercise.getQuestions();
			
			for (String ques : questions.keySet()) {
				Question question = questions.get(ques);
				System.out.println(ques + " : " + question.getQuestion() + "?");
				String answer = reader.readLine();
				if (question.getAnswer().equalsIgnoreCase(answer)) {
					totalMarks += 2;
				}
			}
			
			System.out.println("Your total marks are: " + totalMarks);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
