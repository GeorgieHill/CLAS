package src.main.java.clas.panes.leadership;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import src.main.java.clas.leadership.Quality;
import src.main.java.clas.panes.PaneUI;

public class PaneQualityAdd implements PaneUI {
	
	private final String TITLE = "Add New Leadership Quality";
	private final int VERTICAL_GAP = 15;
	private final int HORIZ_GAP = 10;
	private final int MIN_WIDTH = 300;
	private VBox vbox;
	private Label label;

	// private IndividualManager manager;
	/**
	 * Constructor to create to access the GridPane created for adding
	 * organizations.
	 * 
	 * @return Contstructs the GridPane.
	 */
	public PaneQualityAdd (ObservableList<?> data) {
		GridPane gp = new GridPane();
		vbox = new VBox();
		label = new Label("Qualities");
		// manager = new IndividualManager();

		label.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		gp = setUpPane(gp, data);
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, gp);
	}

	private GridPane setUpPane(GridPane gridPane, ObservableList data) {
		GridPane gp = gridPane;
		gp.setVgap(VERTICAL_GAP);
		gp.setHgap(HORIZ_GAP);
		gp.setPadding(new Insets(10, 0, 0, 10));

		// TextField Labels
		Label qualCode = new Label("Code:");
		Label qualTitle = new Label("Title:");
		Label qualDes = new Label("Description:");

		// Create all text fields for adding an individual
		TextField addCode = new TextField();
		// addCode.setPromptText("ID");
		addCode.setMinWidth(MIN_WIDTH);

		TextField addTitle = new TextField();
		// addOrg.setPromptText("Organization");
		addTitle.setMinWidth(MIN_WIDTH);

		TextField addDes = new TextField();
		// addDept.setPromptText("Department");
		addDes.setMinWidth(MIN_WIDTH);

		// Make the button add functionality
		Button addButton = new Button("Add");
		gp.setHalignment(addButton, HPos.RIGHT);
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("adding into table");
				// manager.addIndividual(
				// addCode.getText(),
				// addTitle.getText(),
				// addDes.getText());
				data.add(new Quality(addCode.getText(), addTitle.getText(),
						addDes.getText()));
				addCode.clear();
				addTitle.clear();
				addDes.clear();
			}
		});

		gp.add(qualCode, 0, 0);
		gp.add(addCode, 1, 0);

		gp.add(qualTitle, 0, 1);
		gp.add(addTitle, 1, 1);

		gp.add(qualDes, 0, 2);
		gp.add(addDes, 1, 2);

		gp.add(addButton, 1, 3);

		return gp;
	}

	/**
 	* Method to access label for this object.
 	* @return Returns the label.
 	*/
	public Label getLabel() {
		return this.label;
	}

	/**
 	* Method to set the label for this object.
 	* @param label The new label for this object.
 	*/
	public void setLabel (final Label label) {
		this.label = label;
	}
	
	public String getTitle() {
		return TITLE;
	}

	public VBox getPane() {
		return vbox;
	}
}
