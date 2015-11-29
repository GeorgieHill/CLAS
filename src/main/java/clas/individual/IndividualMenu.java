package src.main.java.clas.individual;

import src.main.java.clas.panes.PaneControllerjp;
import src.main.java.clas.panes.individual.PaneIndAdd;
import src.main.java.clas.panes.individual.PaneIndReport;
import src.main.java.clas.ui.NavigationMain;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class IndividualMenu {
	private final int SIDEBAR_PADDING = 20;
	private final int SIDEBAR_SPACING = 8;
	private Stage IndividualMenu;
	private IndividualTable individualTable;
	private PaneIndAdd indAddPane;
	private PaneIndReport indReportPane;
	private ObservableList<Individual> data;
	private PaneControllerjp paneController;
	private BorderPane border;

	public IndividualMenu() {
		// Create a Stage which will allow the individual menu to load
		IndividualMenu = new Stage();
		IndividualMenu.setTitle("CLAS Indivdiual System");

		// Fill in individual data for indivdual menu
		data = FXCollections.observableArrayList(new Individual("1", "EFCNC",
				"Computer Science", "Jacob", "Smith", "888-888-888",
				"jacob.smith@example.com", "52 Wallaby Lane", "Dover", "NH",
				"00000", "USA", "HELLO12452"), new Individual("2", "EFCNC",
				"Rug", "ga", "sew", "999", "smith@example.com", "Wallaby Lane",
				"keene", "NH", "03435", "USA", "HELLO00123"));

		paneController = new PaneControllerjp();
		// create all the panes we will be using
		indAddPane = new PaneIndAdd(data);
		individualTable = new IndividualTable(data);
		indReportPane = new PaneIndReport(data);

		// Add them to controller hashmap
		paneController.addPane(indAddPane.getTitle(), indAddPane.getPane());
		paneController.addPane(individualTable.getTitle(),
				individualTable.getPane());
		paneController.addPane(indReportPane.getTitle(),
				indReportPane.getPane());

		// Create a border which will allow us to make a basic set pane of
		// top/right/center/left/bottom
		border = new BorderPane();
		// set the top/right/center/left/bottom panes to information
		border.setTop(addTopMenu(IndividualMenu));
		border.setLeft(addVBox());
		border.setCenter(indReportPane.getPane());
		border.setRight(bufferVBox());
		Group root = new Group();
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		Scene scene = new Scene(root, screenBounds.getWidth(),
				screenBounds.getHeight());
		individualTable.setBorderPane(border);
		scene.setRoot(border);
		IndividualMenu.setScene(scene);
		// Set up the style sheets for the login window to load in.
		scene.getStylesheets().add("/resources/css/Menu.css");
		IndividualMenu.show();

	}

	/**
	 * Creates a Horizontal box for head panel.
	 * 
	 * @param now
	 *            The current stage that is being displayed.
	 * @return the HBox that will be used for the top menu navigation.
	 */
	public final HBox addTopMenu(final Stage now) {
		NavigationMain nav = new NavigationMain(now);
		HBox topMenu = nav.getTopMenu();
		return topMenu;
	}

	/**
	 * Creates a VBox pane for sidebar navigation.
	 * 
	 * @return the VBox to be used for the sidebar menu navigation.
	 */
	public VBox addVBox() {

		VBox vbox = new VBox();
		vbox.setPadding(new Insets(SIDEBAR_PADDING));
		vbox.setSpacing(SIDEBAR_SPACING);
		vbox.setId("leftVBox");

		// Create the root treeView for all the leafs
		// Create TreeView Menu that changes scene in center of border
		TreeItem<String> root = new TreeItem<String>("CLAS Individual Tables");
		root.setExpanded(true);

		TreeItem<String> indNode = new TreeItem<String>("Individuals");
		TreeItem<String> evalNode = new TreeItem<String>(
				"Evaluation Instruments");
		TreeItem<String> rulesNode = new TreeItem<String>("Analysis Rules");
		TreeItem<String> sResNode = new TreeItem<String>(
				"Leadership Style Responses");
		TreeItem<String> qResNode = new TreeItem<String>(
				"Leadership Quality Responses");
		TreeItem<String> sAnNode = new TreeItem<String>(
				"Leadership Style Analysis");
		TreeItem<String> qAnNode = new TreeItem<String>(
				"Leadership Quality Analysis");
		root.getChildren().addAll(indNode, evalNode, rulesNode, sResNode,
				qResNode, sAnNode, qAnNode);

		TreeItem<String> indAdd = new TreeItem<String>(indAddPane.getTitle());
		TreeItem<String> indEdit = new TreeItem<String>(
				individualTable.getTitle());
		TreeItem<String> indReport = new TreeItem<String>(
				indReportPane.getTitle());
		indNode.getChildren().addAll(indAdd, indEdit, indReport);

		TreeItem<String> evalAdd = new TreeItem<String>(
				"Evaluation Instrument Add");
		TreeItem<String> evalEdit = new TreeItem<String>(
				"Evaluation Instrument Edit");
		TreeItem<String> evalReport = new TreeItem<String>(
				"Evaluation Instrument Reporting");
		evalNode.getChildren().addAll(evalAdd, evalEdit, evalReport);

		TreeItem<String> rulesAdd = new TreeItem<String>("Analysis Rules Add");
		TreeItem<String> rulesEdit = new TreeItem<String>("Anaysis Rules Edit");
		TreeItem<String> rulesReport = new TreeItem<String>(
				"Analysis Rules Reporting");
		rulesNode.getChildren().addAll(rulesAdd, rulesEdit, rulesReport);

		TreeItem<String> sResAdd = new TreeItem<String>("Style Response Add");
		TreeItem<String> sResEdit = new TreeItem<String>("Style Response Edit");
		TreeItem<String> sResReport = new TreeItem<String>(
				"Style Response Reporting");
		sResNode.getChildren().addAll(sResAdd, sResEdit, sResReport);

		TreeItem<String> qResAdd = new TreeItem<String>("Quality Response Add");
		TreeItem<String> qResEdit = new TreeItem<String>("Quality Response");
		TreeItem<String> qResReport = new TreeItem<String>(
				"Quality Response Reporting");
		qResNode.getChildren().addAll(qResAdd, qResEdit, qResReport);

		TreeItem<String> sAnAdd = new TreeItem<String>("Style Analysis Add");
		TreeItem<String> sAnEdit = new TreeItem<String>("Style Analysis Edit");
		TreeItem<String> sAnReport = new TreeItem<String>(
				"Style Analysis Reporting");
		sAnNode.getChildren().addAll(sAnAdd, sAnEdit, sAnReport);

		TreeItem<String> qAnAdd = new TreeItem<String>("Quality Analysis Add");
		TreeItem<String> qAnEdit = new TreeItem<String>("Quality Analysis Edit");
		TreeItem<String> qAnReport = new TreeItem<String>(
				"Quality Analysis Reporting");
		qAnNode.getChildren().addAll(qAnAdd, qAnEdit, qAnReport);

		TreeView<String> treeView = new TreeView<String>(root);
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
							border.setCenter(paneController
									.goToPane(selectedItem));
							individualTable.refreshTable();
						}
					}
				});

		vbox.getChildren().addAll(treeView);

		return vbox;
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

	public ObservableList<Individual> getData() {
		return data;
	}

}
