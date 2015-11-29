package src.main.java.clas.panes.organization;

import java.util.Random;

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
import src.main.java.clas.organization.Organization;
import src.main.java.clas.panes.PaneUI;

/**
 * Creates scene for add Organization records.
 */
public class PaneOrgAdd implements PaneUI {

	private GridPane gp;
	private VBox vbox;
	private Label label;
	private Label orgNameLbl;
	private Label orgPhoneLbl;
	private Label orgEmailLbl;
	private Label orgAddressLbl;
	private Label orgCityLbl;
	private Label orgStateLbl;
	private Label orgZipLbl;
	private Label orgCountryLbl;
	private Label orgContLbl;
	private Label orgContPhoneLbl;
	private Label orgContEmailLbl;
	private TextField addOrg;
	private TextField addPhone;
	private TextField addEmail;
	private TextField addAddress;
	private TextField addCity;
	private TextField addState;
	private TextField addZipCode;
	private TextField addCountry;
	private TextField addContact;
	private TextField addContactPhone;
	private TextField addContactEmail;
	private Button addButton;
	private static final String TITLE = "Add New Organization";;
	private final int VERTICAL_GAP = 15;
	private final int HORIZ_GAP = 10;
	private final int MIN_WIDTH = 300;

	public PaneOrgAdd() {

		// Header label
		label = new Label("Organizations");
		label.setFont(Font.font("System", FontWeight.BOLD, 18));

	}

	/**
	 * Method to access the GridPane created for adding organizations.
	 * 
	 * @return Returns the GridPane.
	 */
	public VBox setUpPane(ObservableList data) {
		// Creates the containers for this pane
		gp = new GridPane();
		vbox = new VBox();

		gp.setVgap(VERTICAL_GAP);
		gp.setHgap(HORIZ_GAP);
		gp.setPadding(new Insets(10, 0, 0, 10));

		// TextField Labels
		orgNameLbl = new Label("Organization Name:");
		orgPhoneLbl = new Label("Phone:");
		orgEmailLbl = new Label("Email:");
		orgAddressLbl = new Label("Address:");
		orgCityLbl = new Label("City Code:");
		orgStateLbl = new Label("State Code:");
		orgZipLbl = new Label("Zip Code:");
		orgCountryLbl = new Label("Country Code:");
		orgContLbl = new Label("Contact Person:");
		orgContPhoneLbl = new Label("Contact Person's Phone:");
		orgContEmailLbl = new Label("Contact Person's Email:");

		// Create all the text fields to add an organization
		addOrg = new TextField();
		// addOrg.setPromptText("Organization Name");
		addOrg.setMinWidth(MIN_WIDTH);

		addPhone = new TextField();
		// addPhone.setPromptText("Phone");
		addPhone.setMinWidth(MIN_WIDTH);

		addEmail = new TextField();
		// addEmail.setPromptText("Email");
		addEmail.setMinWidth(MIN_WIDTH);

		addAddress = new TextField();
		// addAddress.setPromptText("Address");
		addAddress.setMinWidth(MIN_WIDTH);

		addCity = new TextField();
		// addCity.setPromptText("City Code");
		addCity.setMinWidth(MIN_WIDTH);

		addState = new TextField();
		// addState.setPromptText("State Code");
		addState.setMinWidth(MIN_WIDTH);

		addZipCode = new TextField();
		// addZipCode.setPromptText("Zip Code");
		addZipCode.setMinWidth(MIN_WIDTH);

		addCountry = new TextField();
		// addCountry.setPromptText("Country Code");
		addCountry.setMinWidth(MIN_WIDTH);

		addContact = new TextField();
		// addContact.setPromptText("Contact");
		addContact.setMinWidth(MIN_WIDTH);

		addContactPhone = new TextField();
		// addContactPhone.setPromptText("Contact Phone");
		addContactPhone.setMinWidth(MIN_WIDTH);

		addContactEmail = new TextField();
		// addContactEmail.setPromptText("Contact Email");
		addContactEmail.setMinWidth(MIN_WIDTH);

		// Make the button add functionality
		addButton = new Button("Add");
		GridPane.setHalignment(addButton, HPos.RIGHT);
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Random rand = new Random();
				String orgId = Integer.toString(rand.nextInt());
				data.add(new Organization(orgId, addOrg.getText(), addPhone
						.getText(), addEmail.getText(), addAddress.getText(),
						addCity.getText(), addState.getText(), addZipCode
								.getText(), addCountry.getText(), addContact
								.getText(), addContactPhone.getText(),
						addContactEmail.getText()));
				addOrg.clear();
				addPhone.clear();
				addEmail.clear();
				addAddress.clear();
				addCity.clear();
				addState.clear();
				addZipCode.clear();
				addCountry.clear();
				addContact.clear();
				addContactPhone.clear();
				addContactEmail.clear();
			}

		});

		gp.add(orgNameLbl, 0, 0);
		gp.add(addOrg, 1, 0);

		gp.add(orgPhoneLbl, 0, 1);
		gp.add(addPhone, 1, 1);

		gp.add(orgEmailLbl, 0, 2);
		gp.add(addEmail, 1, 2);

		gp.add(orgAddressLbl, 0, 3);
		gp.add(addAddress, 1, 3);

		gp.add(orgCityLbl, 0, 4);
		gp.add(addCity, 1, 4);

		gp.add(orgStateLbl, 0, 5);
		gp.add(addState, 1, 5);

		gp.add(orgZipLbl, 0, 6);
		gp.add(addZipCode, 1, 6);

		gp.add(orgCountryLbl, 0, 7);
		gp.add(addCountry, 1, 7);

		gp.add(orgContLbl, 0, 8);
		gp.add(addContact, 1, 8);

		gp.add(orgContPhoneLbl, 0, 9);
		gp.add(addContactPhone, 1, 9);

		gp.add(orgContEmailLbl, 0, 10);
		gp.add(addContactEmail, 1, 10);

		gp.add(addButton, 1, 11);

		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, gp);

		return vbox;
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

	/**
	 * Method to access TITLE for this object.
	 * 
	 * @return Returns the TITLE for this pane.
	 */
	public static String getTitle() {
		return TITLE;
	}

	/**
	 * Method to access the VBox created.
	 * 
	 * @return Returns the vbox.
	 */
	public VBox getPane() {
		return vbox;
	}
}
