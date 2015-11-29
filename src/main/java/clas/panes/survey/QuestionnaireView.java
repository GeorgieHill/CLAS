package src.main.java.clas.panes.survey;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import src.main.java.clas.leadership.Question;
import src.main.java.clas.panes.PaneController;
import src.main.java.clas.panes.PaneUI;
import src.main.java.clas.survey.MainMenu;

public class QuestionnaireView implements PaneUI {

			private static final String TITLE = "View Questionnaire";
			private final int VERTICAL_GAP = 15;
			private final int HORIZ_GAP = 10;
			//private final int MIN_WIDTH = 300;
			private VBox vbox;
			private VBox gp;
			private Label label;
			private String questionnaireCode;
			private ObservableList<Question> data;
			private QuestionnaireEdit qe;

			/**
 			* Constructor to create to access the GridPane created for adding organizations.
 			* @return Contstructs the GridPane.
 			*/
			public QuestionnaireView(ObservableList<Question> sentData){
					
					//PaneController.addMap(TITLE, this);

					//GridPane gp = new GridPane();
					questionnaireCode = "777";

					label = new Label("Questionnaire Code "+ questionnaireCode);
					label.setFont(Font.font("Verdana", FontWeight.BOLD, 18));				
					
					data = FXCollections.observableArrayList(sentData);	
			}
			
			public VBox getPane(){
					
					gp = new VBox(8);


					String ques;
					
		    		String[] radioText = {
						  		"Strongly Agree",
						  		"Agree",
						  		"Mildly Agree", 
						  		"Undecided",
						  		"Mildly Disagree",
						  		"Disagree",
						  		"Strongly Disagree"
						  		};

					int[] scores = {1,2,3,4,5,6,7};

					Label questionLbl = new Label();

					//RadioButton temp = new RadioButton();
		    		
					for (Question q : data) { 

							ArrayList<Label> quesLabels = new ArrayList<Label>();
						  	ques = q.getQuestionText(); 
						  	//quesLabels.add(new Label(ques));
						  	gp.getChildren().add(new Label(ques));
						  	//questionLbl.setText(ques);
						  	//gp.getChildren().add(questionLbl);
						  	ArrayList<RadioButton> radioButtons = new ArrayList<RadioButton>();
						  	ArrayList<ToggleGroup> toggleGroups = new ArrayList<ToggleGroup>();
						  	toggleGroups.add(new ToggleGroup());
							// create each by jsut assigning a name based on its index
							for ( int i = 0; i < radioText.length; i++ )
							{
							   	radioButtons.add(new RadioButton());
							   	RadioButton temp = radioButtons.get(i);
							   	radioButtons.get(i).setText(radioText[i]);
							   	radioButtons.get(i).setToggleGroup(toggleGroups.get(toggleGroups.size()-1));
							   	//top,right,bottom,left padding
							   	radioButtons.get(i).setPadding(new Insets(0,0,0,50));
								radioButtons.get(i).setOnAction(new EventHandler<ActionEvent>() {
					 				@Override
									 public void handle(ActionEvent actionEvent) {
					            		if (temp.isSelected()) {
					                    }  
					        		}
									});
								
								gp.getChildren().add(radioButtons.get(i));
						}//end each radio for loop

					} //end each question for loop
					
					//Button to add new questions
					Button addQuesButton = new Button("Submit Questionnaire");
					addQuesButton.setOnAction(new EventHandler<ActionEvent>() {
							 @Override
							public void handle(ActionEvent e){
			            		//if (addQuesButton.isSelected()) {
			            			//
									qe = new QuestionnaireEdit();
			            			MainMenu.changePane(qe.getPane());

								}
					});

					gp.getChildren().add(addQuesButton);

					ScrollPane scrollPane = new ScrollPane();
					//scrollPane.setStyle("-fx-background-color:transparent;");
					scrollPane.setStyle("-fx-background:transparent;");
					scrollPane.setContent(gp);

					//Create a vertical box that will display the table and search area
					vbox = new VBox();
					vbox.setSpacing(5);
			  		vbox.setPadding(new Insets(10, 0, 0, 10));
					vbox.getChildren().addAll(label, scrollPane);

					return vbox;
			}

				/**
			 	* Method to access this pane's label.
			 	* @return Returns the label for this pane.
			 	*/
				public Label getLabel(){
					return label;
				}

				/**
			 	* Method to set this pane's label.
			 	* @param label The new label for this object.
			 	*/
				public void setLabel (final Label label) {
					this.label=label;
				}

				/**
			 	* Method to access TITLE for this object.
			 	* @return Returns the TITLE.
			 	*/
				public static String getTitle() {
					return TITLE;
				}
			
}
