package src.main.java.clas.panes.individual;

import java.sql.SQLException;

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
import src.main.java.clas.individual.Individual;
import src.main.java.clas.individual.IndividualDao;
import src.main.java.clas.panes.PaneUI;

public class PaneIndAdd implements PaneUI {

	private final String TITLE = "Add New Individuals";
	private final int VERTICAL_GAP = 15;
	private final int HORIZ_GAP = 10;
	private final int MIN_WIDTH = 300;
	private VBox vbox;
	private Label label;
	private IndividualDao manager;
	private GridPane gp;

	/**
	 * Constructor to create to access the GridPane created for adding
	 * organizations.
	 * 
	 * @return Contstructs the GridPane.
	 */
	public PaneIndAdd(ObservableList<?> data) {

		// Add this pane to the pane directory
		//PaneController.addMap(TITLE, this);

		// call IndividualManager to access db
		manager = new IndividualDao();

		// Pane label
		label = new Label("Individuals");
		label.setFont(Font.font("Verdana", FontWeight.BOLD, 18));

		// Set up gridPane to hold object add fields
		gp = new GridPane();
		gp = setUpPane(gp, data);

		// Set up vbox and add label and gridPane
		vbox = new VBox();
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
		Label indIDLbl = new Label("ID:");
		Label indOrgLbl = new Label("Organization:");
		Label indDeptLbl = new Label("Department:");
		Label indFNameLbl = new Label("First Name:");
		Label indLNameLbl = new Label("Last Name:");
		Label indPhoneLbl = new Label("Telephone:");
		Label indEmailLbl = new Label("Email:");
		Label indAddressLbl = new Label("Address:");
		Label indCityLbl = new Label("City:");
		Label indStateLbl = new Label("State:");
		Label indZipLbl = new Label("Zip Code:");
		Label indCountryLbl = new Label("Country:");
		Label indPasswordLbl = new Label("Password:");
		
		// Create all text fields for adding an individual
		TextField addID = new TextField();
		addID.setPromptText("ID");
		addID.setMinWidth(MIN_WIDTH);

		TextField addOrg = new TextField();
		addOrg.setPromptText("Organization");
		addOrg.setMinWidth(MIN_WIDTH);

		TextField addDept = new TextField();
		addDept.setPromptText("Department");
		addDept.setMinWidth(MIN_WIDTH);

		TextField addFirstName = new TextField();
		addFirstName.setPromptText("First Name");
		addFirstName.setMinWidth(MIN_WIDTH);

		TextField addLastName = new TextField();
		addLastName.setPromptText("Last Name");
		addLastName.setMinWidth(MIN_WIDTH);

		TextField addPhone = new TextField();
		addPhone.setPromptText("Telephone");
		addPhone.setMinWidth(MIN_WIDTH);

		TextField addEmail = new TextField();
		addEmail.setPromptText("Email");
		addEmail.setMinWidth(MIN_WIDTH);

		TextField addAddress = new TextField();
		addAddress.setPromptText("Address");
		addAddress.setMinWidth(MIN_WIDTH);

		TextField addCity = new TextField();
		addCity.setPromptText("City");
		addCity.setMinWidth(MIN_WIDTH);

		TextField addState = new TextField();
		addState.setPromptText("State");
		addState.setMinWidth(MIN_WIDTH);

		TextField addZipCode = new TextField();
		addZipCode.setPromptText("Zip Code");
		addZipCode.setMinWidth(MIN_WIDTH);

		TextField addCountry = new TextField();
		addCountry.setPromptText("Country");
		addCountry.setMinWidth(MIN_WIDTH);

		TextField addPassword = new TextField();
		addPassword.setPromptText("Password");
		addPassword.setMinWidth(MIN_WIDTH);

		// Make the button add functionality
		Button addButton = new Button("Add");
		gp.setHalignment(addButton, HPos.RIGHT);
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("adding into table");
				try {
					manager.addIndividual(addID.getText(), addOrg.getText(),
							addDept.getText(), addFirstName.getText(),
							addLastName.getText(), addPhone.getText(),
							addEmail.getText(), addAddress.getText(),
							addCity.getText(), addState.getText(),
							addZipCode.getText(), addCountry.getText(),
							addPassword.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				data.add(new Individual(addID.getText(), addOrg.getText(),
						addDept.getText(), addFirstName.getText(), addLastName
								.getText(), addPhone.getText(), addEmail
								.getText(), addAddress.getText(), addCity
								.getText(), addState.getText(), addZipCode
								.getText(), addCountry.getText(), addPassword
								.getText()));
				addID.clear();
				addOrg.clear();
				addDept.clear();
				addFirstName.clear();
				addLastName.clear();
				addPhone.clear();
				addEmail.clear();
				addAddress.clear();
				addCity.clear();
				addState.clear();
				addZipCode.clear();
				addCountry.clear();
				addPassword.clear();
			}
		});

		gp.add(indIDLbl, 0, 0);
		gp.add(addID, 1, 0);

		gp.add(indOrgLbl, 0, 1);
		gp.add(addOrg, 1, 1);

		gp.add(indDeptLbl, 0, 2);
		gp.add(addDept, 1, 2);

		gp.add(indFNameLbl, 0, 3);
		gp.add(addFirstName, 1, 3);

		gp.add(indLNameLbl, 0, 4);
		gp.add(addLastName, 1, 4);

		gp.add(indPhoneLbl, 0, 5);
		gp.add(addPhone, 1, 5);

		gp.add(indEmailLbl, 0, 6);
		gp.add(addEmail, 1, 6);

		gp.add(indAddressLbl, 0, 7);
		gp.add(addAddress, 1, 7);

		gp.add(indCityLbl, 0, 8);
		gp.add(addCity, 1, 8);

		gp.add(indStateLbl, 0, 9);
		gp.add(addState, 1, 9);

		gp.add(indZipLbl, 0, 10);
		gp.add(addZipCode, 1, 10);

		gp.add(indCountryLbl, 0, 11);
		gp.add(addCountry, 1, 11);

		gp.add(indPasswordLbl, 0, 12);
		gp.add(addPassword, 1, 12);

		gp.add(addButton, 1, 13);

		return gp;
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
		return vbox;
	}
}
