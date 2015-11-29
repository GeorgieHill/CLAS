package src.main.java.clas.survey;

import java.util.HashMap;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import src.main.java.clas.leadership.Question;
import src.main.java.clas.panes.PaneController;
import src.main.java.clas.panes.survey.QuestionnaireAdd;
import src.main.java.clas.panes.survey.QuestionnaireEdit;
import src.main.java.clas.panes.survey.QuestionnaireView;
import src.main.java.clas.ui.NavigationMain;

public class MainMenu {

	private NavigationMain nav;
	private Stage MainMenu;
	private HBox topMenu;
	private VBox sideMenu;
	private static BorderPane border;
	private Group root;
	private Rectangle2D screenBounds;
	private Scene scene;
	private final int SIDEBAR_PADDING = 20;
	private final int SIDEBAR_SPACING = 8;
	private PaneController paneController;
	private static ObservableList<Question> data = FXCollections
			.observableArrayList();
	String test = "";
	QuestionnaireAdd qa = new QuestionnaireAdd();
	QuestionnaireEdit qe = new QuestionnaireEdit();
	QuestionnaireView qv = new QuestionnaireView(data);
	protected static HashMap<String, ObservableList<Question>> quesMap = new HashMap<String, ObservableList<Question>>();

	public MainMenu() {
		
		// Create a Stage which will allow the scenes to load
		MainMenu = new Stage();
		MainMenu.setTitle("CLAS Home");
		
		// Create a border which will hold components of stage
		border = new BorderPane();
		
		// Call for navigation menu at top of borderPane
		nav = new NavigationMain(MainMenu);
		border.setTop(nav.getTopMenu());
		
		// Set regions of the borderPane to contain components
		border.setLeft(addVBox());
		border.setCenter(addGridPane());

		// Empty VBox to act as buffer on right side of screen
		border.setRight(bufferVBox());

		// Set scene to fill user's computer screen and add to MainMenu
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		Scene scene = new Scene(border, screenBounds.getWidth(),
				screenBounds.getHeight());
		MainMenu.setScene(scene);

		// Call css to format the scene
		scene.getStylesheets().add(
				MainMenu.class.getResource("/resources/css/Menu.css")
						.toExternalForm());

		// Load MainMenu
		MainMenu.show();
	}

	/**
	 * Creates a VBox pane for sidebar navigation.
	 * 
	 * @return the VBox to be used for the sidebar menu navigation.
	 */
	public final VBox addVBox() {

		VBox vbox = new VBox();
		vbox.setPadding(new Insets(SIDEBAR_PADDING));
		vbox.setSpacing(SIDEBAR_SPACING);
		vbox.setId("leftVBox");

		// Create TreeView Menu that changes scene in center of border
		TreeItem<String> root1 = new TreeItem<String>("CLAS");
		root1.setExpanded(true);

		TreeItem<String> quesNode = new TreeItem<String>(
				"Leadership Questionnaires");
		TreeItem<String> analyticsNode = new TreeItem<String>(
				"Explore Analytics");
		TreeItem<String> testNode = new TreeItem<String>("Take Test");
		TreeItem<String> resultNode = new TreeItem<String>(
				"Review Your Results");

		root1.getChildren().addAll(quesNode, analyticsNode, testNode,
				resultNode);

		TreeItem<String> node1 = new TreeItem<String>("Add New Questionnaire");
		TreeItem<String> node2 = new TreeItem<String>("Edit Questionnaire");
		quesNode.getChildren().addAll(node1, node2);

		TreeItem<String> node4 = new TreeItem<String>("Test A");
		TreeItem<String> node5 = new TreeItem<String>("Test B");
		TreeItem<String> node6 = new TreeItem<String>("Test C");
		testNode.getChildren().addAll(node4, node5, node6);

		TreeItem<String> node7 = new TreeItem<String>("Report A");
		TreeItem<String> node8 = new TreeItem<String>("Report B");
		TreeItem<String> node9 = new TreeItem<String>("Report C");
		resultNode.getChildren().addAll(node7, node8, node9);

		TreeItem<String> node11 = new TreeItem<String>("Organization");
		TreeItem<String> node21 = new TreeItem<String>("Departments");
		TreeItem<String> node31 = new TreeItem<String>("Individuals");
		analyticsNode.getChildren().addAll(node11, node21, node31);

		TreeView<String> treeView = new TreeView<String>(root1);
		treeView.getStyleClass().add("menuTree");

		// Event listener for user's selection of a tree item
		treeView.getSelectionModel().selectedItemProperty()
				.addListener(new ChangeListener<TreeItem<String>>() {

					@Override
					public void changed(
							ObservableValue<? extends TreeItem<String>> observable,
							TreeItem<String> old_val, TreeItem<String> new_val) {
						// determine if selected value is a pane to be load (is
						// a leaf)
						if (new_val.isLeaf()) {
							// holds the selected value
							String selectedItem = new_val.getValue();

							// Changes the center pane based on user choice
							border.setCenter(paneController.goToPane(selectedItem));
						}
					}
				});

		// add TreeView to the VBox
		vbox.getChildren().addAll(treeView);

		return vbox;
	}

	public GridPane addGridPane() {
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(0, 10, 0, 10));

		Text welcome = new Text(
				"Welcome to Cognitive Leadership Analysis System");
		welcome.setFont(Font.font("Cambria", FontWeight.BOLD, 20));
		grid.add(welcome, 1, 0);

		ImageView imageView = new ImageView(new Image(getClass()
				.getResourceAsStream("/resources/images/CLAS_LOGO.png"), 700, 700, true, true));
		grid.add(imageView, 1, 2, 2, 1);

		return grid;
	}

	public static void changePane(final VBox newVBox) {
		border.setCenter(newVBox);
	}

	/**
	 * Empty VBox to act as buffer (used on right side of scene).
	 * 
	 * @return the VBox that will be used as a buffer.
	 */
	public final VBox bufferVBox() {
		VBox buffer = new VBox();
		buffer.setMinWidth(30);
		return buffer;
	}

	/**
	 * Method to view the hashmap of panes.
	 * 
	 * @return Returns the hashmap containing the pane directory.
	 */
	public static HashMap<String, ObservableList<Question>> getQuesMap() {
		return quesMap;
	}

	/**
	 * Method to add a record to the hashmap of panes.
	 * 
	 * @param key
	 *            The title of the pane to be added to the map.
	 * @param value
	 *            The pane being added to the map.
	 */
	public static void addMap(String key, ObservableList<Question> value) {
		quesMap.put(key, value);
	}

	/**
	 * Method to add a record to the hashmap of panes.
	 * 
	 * @param key
	 *            The title of the pane to be removed from the map.
	 */
	public static void removeMap(String key) {
		quesMap.remove(key);
	}

	public static ObservableList<Question> getQuestions(String key) {
		return quesMap.get(key);
	}
}
