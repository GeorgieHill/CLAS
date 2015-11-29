package src.main.java.clas.panes.survey;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

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

public class QuestionnaireAdd implements PaneUI {

	private static final String TITLE = "Add New Questionnaire";
	private final int VERTICAL_GAP = 8;
	private final int HORIZ_GAP = 10;
	private VBox vbox;
	private GridPane gp;
	private Label label;
	private String questionnaireCode;
	private QuestionnaireView qv;
	private ObservableList<Question> data;

	/**
	 * Constructor to create to access the GridPane created for adding
	 * organizations.
	 */
	public QuestionnaireAdd() {

		// PaneController.addMap(TITLE, this);

		// GridPane gp = new GridPane();

		label = new Label("Create a New Questionnaire");
		label.setFont(Font.font("Verdana", FontWeight.BOLD, 18));

	}

	public VBox getPane() {
		gp = new GridPane();
		gp.setVgap(VERTICAL_GAP);
		gp.setHgap(HORIZ_GAP);
		gp.setPadding(new Insets(0, 0, 3, 0));

		Random rand = new Random();
		questionnaireCode = Integer.toString(rand.nextInt());

		// hard coded questions for example
		Question ques1 = new Question(
				"111",
				"Employees need to be supervised closely or they are not likely to do their work",
				"Quality Type A");

		Question ques2 = new Question(
				"202",
				"Providing guidance without pressure it they key to being a good leader",
				"Quality Type B");

		Question ques3 = new Question(
				"097",
				"Most workers want frequent and supportive communication from their leaders",
				"Style Type A");

		Question ques4 = new Question("125",
				"People are basically competent and do a good job",
				"Style Type B");

		Question ques5 = new Question(
				"222",
				"Most workers want frequent and supportive communication from their leaders",
				"Quality Type A");

		Question ques6 = new Question("021",
				"Most employees feel insecure about their work", "Style Type A");

		Question ques7 = new Question(
				"435",
				"The leader is the chief judge of the achievements of the group",
				"Style Type A");

		Question ques8 = new Question("544",
				"Leaders should allow subordinates to appraise their own work",
				"Quality Type B");

		Question ques9 = new Question("787",
				"Employees must be part of the decision-making process",
				"Style Type B");

		data = FXCollections.observableArrayList();

		// Add a new question
		Label quesName = new Label("New Question:");

		String lastCode = Question.lastCode();
		int nextCode = Integer.parseInt(lastCode) + 1;
		final String newCode = Integer.toString(nextCode);

		TextField newQuestion = new TextField();
		newQuestion.setPromptText("Question Text");
		newQuestion.setMinWidth(350);

		// later to be a cell factory
		ComboBox<String> typeCombo = new ComboBox<String>();
		typeCombo.getItems().addAll("Quality A", "Quality B", "Style A",
				"Style B");
		typeCombo.setPromptText("Question Type:");

		// Button to add new questions
		Button addQuesButton = new Button("Add Question");
		gp.setHalignment(addQuesButton, HPos.RIGHT);
		addQuesButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// if (addQuesButton.isSelected()) {
				//
				data.add(new Question(newCode, newQuestion.getText(), typeCombo
						.getValue()));

				// qName.clear();
				newQuestion.clear();

			}
		});

		Label quesChoose = new Label("Select a Question:");

		// choose question in db
		ComboBox<String> quesCombo = new ComboBox<String>();

		// to display existing questions in system:
		quesCombo.setPromptText("Existing Questions:");

		TreeMap<String, Question> questionMap = new TreeMap<String, Question>();

		for (Map.Entry<String, Question> entry : Question.getQuesMap()
				.entrySet()) {
			String key = entry.getKey();
			Question value = entry.getValue();

			questionMap.put(entry.getValue().getQuestionText(), value);

			String question = value.getQuestionText();
			quesCombo.getItems().add(question);
		}

		// to create a new question
		Button chooseQues = new Button("Add Question");
		gp.setHalignment(chooseQues, HPos.RIGHT);
		chooseQues.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				//

				data.add(questionMap.get(quesCombo.getValue()));

				// reset combo box
				// quesCombo.setPromptText("Existing Questions:");

			}
		});

		Label or = new Label("OR");

		gp.add(quesName, 0, 0);
		gp.add(newQuestion, 1, 0);
		gp.add(typeCombo, 2, 0);
		gp.add(addQuesButton, 3, 0);
		gp.add(or, 0, 1);

		gp.add(quesChoose, 0, 2);
		gp.add(quesCombo, 1, 2);
		gp.add(chooseQues, 3, 2);

		// Create a table with columns to display Organization information
		TableView<Question> table = new TableView<Question>();
		table.setEditable(true);

		TableColumn<Question, String> actionDelete = new TableColumn<Question, String>(
				"Remove");
		actionDelete
				.setCellValueFactory(new PropertyValueFactory<Question, String>(
						"OrgCode"));

		// Create button to delete records
		Callback<TableColumn<Question, String>, TableCell<Question, String>> deleteColumnCellFactory = new Callback<TableColumn<Question, String>, TableCell<Question, String>>() {

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
							deleteButton
									.setOnAction(new EventHandler<ActionEvent>() {

										@Override
										public void handle(ActionEvent event) {
											param.getTableView()
													.getSelectionModel()
													.select(getIndex());

											Question item = table
													.getSelectionModel()
													.getSelectedItem();

											// if (orgCode != null) {
											// Confirmation of record deletion
											Alert alert = new Alert(
													AlertType.CONFIRMATION);
											alert.setTitle("ALERT");
											alert.setHeaderText("Please confirm that you would like to delete this record");
											// alert.setContentText("Are you ok with this?");

											ButtonType buttonTypeOne = new ButtonType(
													"Cancel");
											ButtonType buttonTypeTwo = new ButtonType(
													"OK");

											alert.showAndWait()
													.ifPresent(
															response -> {
																if (response == ButtonType.OK) {
																	// code to
																	// delete
																	// record
																	data.remove(item);
																	table.getSelectionModel()
																			.clearSelection();
																} else {
																	return;
																}
															});
											// }
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
		// Add delete button to table cell
		actionDelete.setCellFactory(deleteColumnCellFactory);

		TableColumn<Question, String> quesCode = new TableColumn<Question, String>(
				"Code");
		quesCode.setMinWidth(50);
		quesCode.setCellValueFactory(new PropertyValueFactory<Question, String>(
				"questionCode"));

		TableColumn<Question, String> quesText = new TableColumn<Question, String>(
				"Text");
		quesText.setMinWidth(600);
		quesText.setCellValueFactory(new PropertyValueFactory<Question, String>(
				"questionText"));

		TableColumn<Question, String> quesType = new TableColumn<Question, String>(
				"Type");
		quesType.setMinWidth(150);
		quesType.setCellValueFactory(new PropertyValueFactory<Question, String>(
				"questionType"));

		// Set the items from the ArrayList into the table
		table.setItems(data);
		table.getColumns().addAll(actionDelete, quesCode, quesText, quesType);
		table.setVisible(true);

		Button showQuestionnaire = new Button(
				"Save This Questionnaire and View");
		gp.setHalignment(showQuestionnaire, HPos.RIGHT);
		showQuestionnaire.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				//
				MainMenu.addMap(questionnaireCode, data);
				qv = new QuestionnaireView(data);
				MainMenu.changePane(qv.getPane());
			}
		});

		// Create a vertical box that will display the table and search area
		vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, gp, table, showQuestionnaire);

		return vbox;
	}

	/**
	 * Method to access this pane's label.
	 * 
	 * @return Returns the label for this pane.
	 */
	public Label getLabel() {
		return label;
	}

	/**
	 * Method to set this pane's label.
	 * 
	 * @param label
	 *            The new label for this object.
	 */
	public void setLabel(final Label label) {
		this.label = label;
	}

	/**
	 * Method to access TITLE for this object.
	 * 
	 * @return Returns the TITLE.
	 */
	public static String getTitle() {
		return TITLE;
	}

}
