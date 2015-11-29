package src.main.java.clas.panes.individual;

//For the table
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import src.main.java.clas.individual.Individual;
import src.main.java.clas.individual.IndividualTable;
import src.main.java.clas.panes.PaneUI;

public class PaneIndReport implements PaneUI {

	private final String TITLE = "Report Indiviuals";
	private VBox vbox;
	private IndividualTable indPane;
	private Label label;
	private GridPane searchGridPane;

	public PaneIndReport(ObservableList<Individual> data) {

		// Add this pane to the pane directory
		//PaneController.addMap(TITLE, this);

		// Set up label
		label = new Label("Individuals");
		label.setFont(Font.font("Verdana", FontWeight.BOLD, 18));

		// Set up table to hold individuals data
		indPane = new IndividualTable(data);
		indPane.createTable(data);

		// Set up gridPane to search data
		searchGridPane = indPane.searchGridPane(data);

		// Set up vBox and add label, table and search pane
		vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, indPane.getTable(), searchGridPane);
	}

	public String getTitle() {
		return TITLE;
	}

	/**
	 * Method to access label for this object.
	 * 
	 * @return Returns the label.
	 */
	public Label getLabel() {
		return this.label;
	}

	/**
	 * Method to set the label for this object.
	 * 
	 * @param label
	 *            The new label for this object.
	 */
	public void setLabel(final Label label) {
		this.label = label;
	}

	public VBox getPane() {
		indPane.refreshTable();
		return vbox;
	}

}
