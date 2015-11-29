package src.main.java.clas.panes.leadership;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import src.main.java.clas.leadership.Quality;
import src.main.java.clas.panes.PaneUI;

public class PaneQualityUpdate implements PaneUI {
	
	private final String TITLE = "Update Qualities";
	private final int VERTICAL_GAP = 15;
	private final int HORIZ_GAP = 10;
	private final int MIN_WIDTH = 300;
	private VBox vbox;
	private VBox tableVbox;
	private TableView<Quality> table;
	private BorderPane border;
	private ObservableList<Quality> data;
	private Label label;

	// private IndividualManager manager;

	/**
	 * Constructor to create to access the GridPane created for adding
	 * organizations.
	 * 
	 * @return Contstructs the GridPane.
	 */
	public PaneQualityUpdate(Quality ind, TableView<Quality> table,
			VBox tableVbox, BorderPane border, ObservableList<Quality> data) {

		this.table = table;
		this.tableVbox = tableVbox;
		this.border = border;
		this.data = data;

		// manager = new IndividualManager();

		GridPane gp = new GridPane();
		vbox = new VBox();
		label = new Label("Update Leadership Qualities");
		label.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		gp = setUpPane(gp, ind);
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, gp);

	}

	private GridPane setUpPane(GridPane gridPane, Quality ind) {
		GridPane gp = gridPane;
		gp.setVgap(VERTICAL_GAP);
		gp.setHgap(HORIZ_GAP);
		gp.setPadding(new Insets(10, 0, 0, 10));

		// TextField Labels
		Label qualIDLbl = new Label("Code:");
		Label qualTitleLbl = new Label("Title:");
		Label qualDesLbl = new Label("Description:");

		// Create all text fields for adding an individual
		Label updateID = new Label(ind.getQualityCode());
		// updateID.setPromptText(ind.getID());
		// updateID.setMinWidth(MIN_WIDTH);

		TextField updateTitle = new TextField();
		updateTitle.setPromptText(ind.getQualityTitle());
		updateTitle.setMinWidth(MIN_WIDTH);

		TextField updateDes = new TextField();
		updateDes.setPromptText(ind.getQualityDes());
		updateDes.setMinWidth(MIN_WIDTH);

		// Make the button add functionality
		Button updateButton = new Button("Update");
		gp.setHalignment(updateButton, HPos.LEFT);
		updateButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation");
				alert.setHeaderText("Please confirm you would like to make this change");

				ButtonType buttonTypeOne = new ButtonType("Cancel");
				ButtonType buttonTypeTwo = new ButtonType("OK");

				alert.showAndWait().ifPresent(response -> {
					if (response == ButtonType.OK) {

						if (!updateTitle.getText().isEmpty())
							ind.setQualityTitle(updateTitle.getText());
						if (!updateButton.getText().isEmpty())
							ind.setQualityDes(updateButton.getText());

						/*
						 * manager.updateIndividual(ind.getID(),
						 * ind.getOrganization(), ind.getDepartment(),
						 * ind.getFirstName(), ind.getLastName(),
						 * ind.getTelephone(), ind.getEmail(), ind.getAddress(),
						 * ind.getCityCode(), ind.getStateCode(),
						 * ind.getZipCode(), ind.getCountryCode(),
						 * ind.getPassword());
						 */

					} else {
						return;
					}
				});
			}
		});

		// Make the button add functionality
		Button closeButton = new Button("Close");
		gp.setHalignment(closeButton, HPos.RIGHT);
		closeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// Force refresh any table information if updated
				table.getColumns().get(0).setVisible(false);
				table.getColumns().get(0).setVisible(true);
				border.setCenter(tableVbox);
			}
		});

		gp.add(qualIDLbl, 0, 0);
		gp.add(updateID, 1, 0);

		gp.add(qualTitleLbl, 0, 1);
		gp.add(updateTitle, 1, 1);

		gp.add(qualDesLbl, 0, 2);
		gp.add(updateDes, 1, 2);

		gp.add(updateButton, 1, 3);
		gp.add(closeButton, 1, 4);
		return gp;
	}

	public String getTitle() {
		return TITLE;
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

	public VBox getPane() {
		return vbox;
	}
}
