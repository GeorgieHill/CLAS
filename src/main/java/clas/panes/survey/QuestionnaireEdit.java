package src.main.java.clas.panes.survey;

import java.util.Map;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;
import src.main.java.clas.leadership.Question;
import src.main.java.clas.panes.PaneUI;
import src.main.java.clas.survey.MainMenu;


public class QuestionnaireEdit implements PaneUI {

			private static final String TITLE = "Edit Questionnaire";
			private final int VERTICAL_GAP = 15;
			private final int HORIZ_GAP = 10;
			//private final int MIN_WIDTH = 300;
			private VBox vbox;
			private GridPane gp;
			private Label label;
			private String questionnaireCode;
			ObservableList<Question> data;
			QuestionnaireView qv;
			String key;
			TableView<Question>table;

			/**
 			* Constructor to create to access the GridPane created for adding organizations.
 			* @return Contstructs the GridPane.
 			*/
			public QuestionnaireEdit(){
					
					this.key = key;

					//PaneController.addMap(TITLE, this);

					//GridPane gp = new GridPane();
					questionnaireCode = "777";

					label = new Label("Edit Questionnaire");
					label.setFont(Font.font("Verdana", FontWeight.BOLD, 18));

					data = FXCollections.observableArrayList();					
			}
			
			public VBox getPane(){
					gp = new GridPane();
					gp.setVgap(VERTICAL_GAP);
					gp.setHgap(HORIZ_GAP);
					gp.setPadding(new Insets(10, 0, 0, 10));	

					Question ques1 = new Question(
						"144",
						"In most situations, workers prefer little input from the leader",
						"Style Type B");

					Question ques2 = new Question(
						"232",
						"Effective leaders give orders and clarify procedures",
						"Quality Type A");

					Question ques3 = new Question(
						"723",
						"In general, it is best to leave subordinates alone",
						"Quality Type A");

					Question ques4 = new Question(
						"989",
						"It is the leaders jobs to help subordinates find their 'passion'",
						"Style Type B");

					ObservableList<Question> samp = FXCollections.observableArrayList();
					samp.add(ques1);
					samp.add(ques2);
					samp.add(ques3);
					samp.add(ques4);

					MainMenu.addMap("377865", samp);


					ComboBox<String> questionnaires = new ComboBox<String>();

					//to display existing questions in system:
				    questionnaires.getItems().add("Select a Questionnaire:");
				    questionnaires.setValue("Select a Questionnaire:");

					for(Map.Entry<String,ObservableList<Question>> entry : MainMenu.getQuesMap().entrySet()) {
					  String key = entry.getKey();

					  questionnaires.getItems().add(key);
					}

					questionnaires.valueProperty().addListener(new ChangeListener<String>() {
				        @Override public void changed(ObservableValue ov, String t, String t1) {
				            data.clear();
				            for (Question q : MainMenu.getQuestions(t1)) {
								data.add(q);
								table.setItems(data);
							}
				        }    
				    });

					Label quesName = new Label("Add a New Question:");
					quesName.setFont(Font.font("System", FontWeight.BOLD, 14));				

					String lastCode = Question.lastCode();
					int nextCode = Integer.parseInt(lastCode) +1;
					final String newCode = Integer.toString(nextCode);
					Label qName = new Label("Code: " + newCode);
					//qName.setPromptText("Code");
					qName.setMinWidth(50);


					TextField newQuestion = new TextField();
					newQuestion.setPromptText("Question Text");
					newQuestion.setMinWidth(350);

					//later to be a cell factory
					ComboBox<String> typeCombo = new ComboBox<String>();
				    typeCombo.getItems().addAll(
				    	"Quality A",
				        "Quality B",
				        "Style A",
				        "Style B");
				    typeCombo.setValue("Quality A");

					//Button to add new questions
					Button addQuesButton = new Button("Add Question");
					gp.setHalignment(addQuesButton, HPos.RIGHT);
					addQuesButton.setOnAction(new EventHandler<ActionEvent>() {
							 @Override
							public void handle(ActionEvent e){
			            		//if (addQuesButton.isSelected()) {
			            			//
			            			data.add(new Question(
				            			newCode,
										newQuestion.getText(),
										typeCombo.getValue()));

										//qName.clear();
										newQuestion.clear();
										typeCombo.setValue("Quality A");

								}
					});


					gp.add(questionnaires,0,0);
					gp.add(quesName,0,1);
					gp.add(qName,1,1); 

					gp.add(newQuestion,2,1);
					gp.add(typeCombo,3,1); 
					gp.add(addQuesButton,5,1);

	
					//Create a table with columns to display Organization information
					table = new TableView<Question>();
					table.setEditable(true);

					TableColumn<Question, String> actionDelete = new TableColumn<Question, String>("Remove");
					actionDelete.setCellValueFactory(
							new PropertyValueFactory<Question, String>("OrgCode"));

					//Create button to delete records
					Callback<TableColumn<Question, String>, TableCell<Question, String>> deleteColumnCellFactory = 
			                new Callback<TableColumn<Question, String>, TableCell<Question, String>>() {

			            @Override
			            public TableCell call(final TableColumn param) {
			                final TableCell cell = new TableCell() {

			                    @Override
			                    public void updateItem(Object item, boolean empty) {
			                        super.updateItem(item, empty);
			                        if (empty) {
			                            setText(null);
			                            setGraphic(null);
			                        } else {
			                            final Button deleteButton = new Button("Remove");
			                            deleteButton.setOnAction(new EventHandler<ActionEvent>() {

			                                @Override
			                                public void handle(ActionEvent event) {
			                                    param.getTableView().getSelectionModel().select(getIndex());
			                                    
			                                    Question item = table.getSelectionModel().getSelectedItem();
			                                    
			                                    //if (orgCode != null) {
			                                        //Confirmation of record deletion
			                                        Alert alert = new Alert(AlertType.CONFIRMATION);
													alert.setTitle("ALERT");
													alert.setHeaderText("Please confirm that you would like to delete this record");
													//alert.setContentText("Are you ok with this?");

													ButtonType buttonTypeOne = new ButtonType("Cancel");
													ButtonType buttonTypeTwo = new ButtonType("OK");

													alert.showAndWait().ifPresent(response -> {
														if (response == ButtonType.OK){
														    //code to delete record
																data.remove(item);
		            											table.getSelectionModel().clearSelection();
															} 
														else {
														    return;
														}
													});
			                                    //}
			                                }
			                            });
			                            setGraphic(deleteButton);
			                            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
			                        }
			                    }
			                };
			                return cell;
			            }
			        };
			        //Add delete button to table cell
			        actionDelete.setCellFactory(deleteColumnCellFactory);

					TableColumn<Question, String> quesCode = new TableColumn<Question, String>("Code");
					quesCode.setMinWidth(50);
			        quesCode.setCellValueFactory(
			                new PropertyValueFactory<Question, String>("questionCode"));

					TableColumn<Question, String> quesText = new TableColumn<Question, String>("Text");
					quesText.setMinWidth(600);
			        quesText.setCellValueFactory(
			                new PropertyValueFactory<Question, String>("questionText"));

			        TableColumn<Question, String> quesType = new TableColumn<Question, String>("Type");
					quesType.setMinWidth(150);
			        quesType.setCellValueFactory(
			                new PropertyValueFactory<Question, String>("questionType"));

			        //Set the items from the ArrayList into the table
					table.setItems(data);
					table.getColumns().addAll(actionDelete, quesCode, quesText, quesType);
					table.setVisible(true);

					Button showQuestionnaire = new Button("Show This Questionnaire");
					gp.setHalignment(showQuestionnaire, HPos.RIGHT);
					showQuestionnaire.setOnAction(new EventHandler<ActionEvent>() {
							 @Override
							public void handle(ActionEvent e){
			            			//
									qv = new QuestionnaireView(data);
			            			MainMenu.changePane(qv.getPane());
								}
					});

					//Create a vertical box that will display the table and search area
					vbox = new VBox();
					vbox.setSpacing(5);
			  		vbox.setPadding(new Insets(10, 0, 0, 10));
					vbox.getChildren().addAll(label, gp, table, showQuestionnaire);

					
					
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
