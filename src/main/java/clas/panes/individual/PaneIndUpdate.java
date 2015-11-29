package src.main.java.clas.panes.individual;

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
import src.main.java.clas.individual.Individual;
import src.main.java.clas.individual.IndividualDao;
import src.main.java.clas.panes.PaneController;
import src.main.java.clas.panes.PaneUI;

public class PaneIndUpdate implements PaneUI {

	private final String TITLE = "Update Individuals";
	private final int VERTICAL_GAP = 15;
	private final int HORIZ_GAP = 10;
	private final int MIN_WIDTH = 300;
	private VBox vbox;
	private VBox tableVbox;
	private TableView<Individual> table;
	private BorderPane border;
	private ObservableList<Individual> data;
	private IndividualDao manager;
	private Label label;

	/**
	 * Constructor to create to access the GridPane created for adding
	 * organizations.
	 * 
	 * @return Constructs the GridPane.
	 */
	public PaneIndUpdate(Individual ind, TableView<Individual> table,
			VBox tableVbox, BorderPane border, ObservableList<Individual> data) {

		this.table = table;
		this.tableVbox = tableVbox;
		this.border = border;
		this.data = data;

		// Add this pane to the pane directory
		//PaneController.addMap(TITLE, this);

		manager = new IndividualDao();

		GridPane gp = new GridPane();
		vbox = new VBox();
		label = new Label("Update Individual");
		label.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		gp = setUpPane(gp, ind);
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, gp);

	}

	private GridPane setUpPane(GridPane gridPane, Individual ind) {
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
		Label updateID = new Label(ind.getID());

		TextField updateOrg = new TextField();
		updateOrg.setPromptText(ind.getOrganization());
		updateOrg.setMinWidth(MIN_WIDTH);

		TextField updateDept = new TextField();
		updateDept.setPromptText(ind.getDepartment());
		updateDept.setMinWidth(MIN_WIDTH);

		TextField updateFName = new TextField();
		updateFName.setPromptText(ind.getFirstName());
		updateFName.setMinWidth(MIN_WIDTH);

		TextField updateLName = new TextField();
		updateLName.setPromptText(ind.getLastName());
		updateLName.setMinWidth(MIN_WIDTH);

		TextField updatePhone = new TextField();
		updatePhone.setPromptText(ind.getPhone());
		updatePhone.setMinWidth(MIN_WIDTH);

		TextField updateEmail = new TextField();
		updateEmail.setPromptText(ind.getEmail());
		updateEmail.setMinWidth(MIN_WIDTH);

		TextField updateAddress = new TextField();
		updateAddress.setPromptText(ind.getAddress());
		updateAddress.setMinWidth(MIN_WIDTH);

		TextField updateCity = new TextField();
		updateCity.setPromptText(ind.getCityCode());
		updateCity.setMinWidth(MIN_WIDTH);

		TextField updateState = new TextField();
		updateState.setPromptText(ind.getStateCode());
		updateState.setMinWidth(MIN_WIDTH);

		TextField updateZipCode = new TextField();
		updateZipCode.setPromptText(ind.getZipCode());
		updateZipCode.setMinWidth(MIN_WIDTH);

		TextField updateCountry = new TextField();
		updateCountry.setPromptText(ind.getCountryCode());
		updateCountry.setMinWidth(MIN_WIDTH);

		TextField updatePassword = new TextField();
		updatePassword.setPromptText(ind.getPassword());
		updatePassword.setMinWidth(MIN_WIDTH);

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

				alert.showAndWait()
						.ifPresent(
								response -> {
									if (response == ButtonType.OK) {
										if (!updateOrg.getText().isEmpty())
											ind.setOrganization(updateOrg
													.getText());
										if (!updateDept.getText().isEmpty())
											ind.setDepartment(updateDept
													.getText());
										if (!updateFName.getText().isEmpty())
											ind.setFirstName(updateFName
													.getText());
										if (!updateLName.getText().isEmpty())
											ind.setLastName(updateLName
													.getText());
										if (!updateLName.getText().isEmpty())
											ind.setPhone(updatePhone
													.getText());
										if (!updateEmail.getText().isEmpty())
											ind.setEmail(updateEmail.getText());
										if (!updateAddress.getText().isEmpty())
											ind.setAddress(updateAddress
													.getText());
										if (!updateCity.getText().isEmpty())
											ind.setCityCode(updateCity
													.getText());
										if (!updateState.getText().isEmpty())
											ind.setStateCode(updateState
													.getText());
										if (!updateZipCode.getText().isEmpty())
											ind.setZipCode(updateZipCode
													.getText());
										if (!updateCountry.getText().isEmpty())
											ind.setCountryCode(updateCountry
													.getText());
										if (!updatePassword.getText().isEmpty())
											ind.setPassword(updatePassword
													.getText());

										try {
											manager.updateIndividual(ind.getID(),
													ind.getOrganization(),
													ind.getDepartment(),
													ind.getFirstName(),
													ind.getLastName(),
													ind.getPhone(),
													ind.getEmail(),
													ind.getAddress(),
													ind.getCityCode(),
													ind.getStateCode(),
													ind.getZipCode(),
													ind.getCountryCode(),
													ind.getPassword());
										} catch (Exception e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}

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

		gp.add(indIDLbl, 0, 0);
		gp.add(updateID, 1, 0);

		gp.add(indOrgLbl, 0, 1);
		gp.add(updateOrg, 1, 1);

		gp.add(indDeptLbl, 0, 2);
		gp.add(updateDept, 1, 2);

		gp.add(indFNameLbl, 0, 3);
		gp.add(updateFName, 1, 3);

		gp.add(indLNameLbl, 0, 4);
		gp.add(updateLName, 1, 4);

		gp.add(indPhoneLbl, 0, 5);
		gp.add(updatePhone, 1, 5);

		gp.add(indEmailLbl, 0, 6);
		gp.add(updateEmail, 1, 6);

		gp.add(indAddressLbl, 0, 7);
		gp.add(updateAddress, 1, 7);

		gp.add(indCityLbl, 0, 8);
		gp.add(updateCity, 1, 8);

		gp.add(indStateLbl, 0, 9);
		gp.add(updateState, 1, 9);

		gp.add(indZipLbl, 0, 10);
		gp.add(updateZipCode, 1, 10);

		gp.add(indCountryLbl, 0, 11);
		gp.add(updateCountry, 1, 11);

		gp.add(indPasswordLbl, 0, 12);
		gp.add(updatePassword, 1, 12);

		gp.add(updateButton, 1, 13);
		gp.add(closeButton, 0, 13);
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
