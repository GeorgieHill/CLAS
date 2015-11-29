package src.main.java.clas.leadership;

import javafx.beans.property.SimpleStringProperty;
import java.util.TreeMap;


/*
 * Organization Object that stores information about the organizations into the database.
 */
public class Question{
	
	//SimpleStringProperty is a javafx conversion that is taken in from the table and is require
	private SimpleStringProperty questionCode;
	private SimpleStringProperty questionText;
	private SimpleStringProperty questionType;
	private static TreeMap<String, Question> quesMap = new TreeMap<String, Question>();

	/*
	 * Create the Organization object to store the organization information into the database.
	 */
	public Question(final String questionCode, 
			 final String questionText, final String questionType){
				//Convert to simple string property for table manipulation
				this.questionCode = new SimpleStringProperty(questionCode);
				this.questionText = new SimpleStringProperty(questionText);
				this.questionType = new SimpleStringProperty(questionType);

				Question question = quesMap.get(questionCode);
		        //if not inmap, instantiate and add to map
		        if (question == null) {
		        	quesMap.put(questionCode, this);
		        }
	}//END Organization Constructor


	//Create getters and setters for modification later
	public final String getQuestionCode(){
			return questionCode.get();	
	}
	public final void setQuestionCode(final String questionCode){
			this.questionCode.set(questionCode);	
	}

	public final String getQuestionText(){
			return questionText.get(); 		
	}
	public final void setQuestionText(final String questionText){
			this.questionText.set(questionText);	
	}

	public final String getQuestionType(){
			return questionType.get(); 		
	}
	public final void setQuestionType(final String questionType){
			this.questionType.set(questionType);	
	}

	public static TreeMap<String, Question> getQuesMap(){
		return quesMap;
	}

	public static Question getQuestion (final String quesCode){
		return quesMap.get(quesCode);
	}
	
	public static void addMap(String key, Question value){
		quesMap.put(key, value);
	}
	public static void removeMap(String key){
		quesMap.remove(key);
	}

	public static String lastCode(){
		return quesMap.lastKey();
	}
}



