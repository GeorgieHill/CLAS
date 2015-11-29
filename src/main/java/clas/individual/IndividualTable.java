package src.main.java.clas.individual;

//For the table
import src.main.java.clas.panes.individual.PaneIndUpdate;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class IndividualTable {
	private final String TITLE = "Edit Individuals";
	private TableView<Individual> table;
	private VBox vbox;
	private ObservableList<Individual> filteredData;

	// For the table searching
	private TextField searchByCode;
	private TextField searchByOrg;
	private TextField searchByDept;
	private TextField searchByFName;
	private TextField searchByLName;
	private TextField searchByPhone;
	private TextField searchByEmail;
	private TextField searchByAddress;
	private TextField searchByCity;
	private TextField searchByState;
	private TextField searchByZip;
	private TextField searchByCountry;
	private TextField searchByPassword;
	private BorderPane border;

	public IndividualTable(ObservableList<Individual> data) {
		final Label label = new Label("Individuals");
		label.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		createTable(data);
		GridPane searchFunction = searchGridPane(data);
		GridPane modifyPane = modifyPane(data);
		vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table, modifyPane, searchFunction);
	}// END CONSTRUCTOR

	/**
	 * Method to create table.
	 * 
	 * @param the
	 *            list of data
	 * @return null.
	 */
	public void createTable(ObservableList<Individual> data) {
		table = new TableView<Individual>();
		table.setEditable(true);

		TableColumn<Individual, String> indID = new TableColumn<Individual, String>(
				"ID");
		indID.setMinWidth(50);
		indID.setCellValueFactory(new PropertyValueFactory<Individual, String>(
				"ID"));

		TableColumn<Individual, String> indOrgCode = new TableColumn<Individual, String>(
				"Organization");
		indOrgCode.setMinWidth(150);
		indOrgCode
				.setCellValueFactory(new PropertyValueFactory<Individual, String>(
						"Organization"));

		TableColumn<Individual, String> indDeptCode = new TableColumn<Individual, String>(
				"Department");
		indDeptCode.setMinWidth(100);
		indDeptCode
				.setCellValueFactory(new PropertyValueFactory<Individual, String>(
						"Department"));

		TableColumn<Individual, String> indFirstName = new TableColumn<Individual, String>(
				"First Name");
		indFirstName.setMinWidth(150);
		indFirstName
				.setCellValueFactory(new PropertyValueFactory<Individual, String>(
						"FirstName"));

		TableColumn<Individual, String> indLastName = new TableColumn<Individual, String>(
				"Last Name");
		indLastName.setMinWidth(150);
		indLastName
				.setCellValueFactory(new PropertyValueFactory<Individual, String>(
						"LastName"));

		TableColumn<Individual, String> indPhone = new TableColumn<Individual, String>(
				"Telephone");
		indPhone.setMinWidth(50);
		indPhone.setCellValueFactory(new PropertyValueFactory<Individual, String>(
				"Telephone"));

		TableColumn<Individual, String> indEmail = new TableColumn<Individual, String>(
				"Email");
		indEmail.setMinWidth(50);
		indEmail.setCellValueFactory(new PropertyValueFactory<Individual, String>(
				"Email"));

		TableColumn<Individual, String> indAddress = new TableColumn<Individual, String>(
				"Address");
		indAddress.setMinWidth(50);
		indAddress
				.setCellValueFactory(new PropertyValueFactory<Individual, String>(
						"Address"));

		TableColumn<Individual, String> indCityCode = new TableColumn<Individual, String>(
				"City");
		indCityCode.setMinWidth(50);
		indCityCode
				.setCellValueFactory(new PropertyValueFactory<Individual, String>(
						"CityCode"));

		TableColumn<Individual, String> indStateCode = new TableColumn<Individual, String>(
				"State/Province");
		indStateCode.setMinWidth(150);
		indStateCode
				.setCellValueFactory(new PropertyValueFactory<Individual, String>(
						"StateCode"));

		TableColumn<Individual, String> indZipCode = new TableColumn<Individual, String>(
				"Zip Code");
		indZipCode.setMinWidth(100);
		indZipCode
				.setCellValueFactory(new PropertyValueFactory<Individual, String>(
						"ZipCode"));

		TableColumn<Individual, String> indCountry = new TableColumn<Individual, String>(
				"Country");
		indCountry.setMinWidth(100);
		indCountry
				.setCellValueFactory(new PropertyValueFactory<Individual, String>(
						"CountryCode"));

		TableColumn<Individual, String> indPassword = new TableColumn<Individual, String>(
				"Password");
		indPassword.setMinWidth(100);
		indPassword
				.setCellValueFactory(new PropertyValueFactory<Individual, String>(
						"Password"));

		// Set data items into table
		table.setItems(data);
		// Add data items into table view
		table.getColumns().addAll(indID, indOrgCode, indDeptCode, indFirstName,
				indLastName, indPhone, indEmail, indAddress, indCityCode,
				indStateCode, indZipCode, indCountry, indPassword);
		table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}

	/**
	 * Method to create search area below table.
	 * 
	 * @param data
	 *            in which is stored in an ObservableList
	 * @return returns the GridPane in which the search area has been created.
	 */
	public GridPane modifyPane(ObservableList<Individual> data) {
		GridPane modifyPane = new GridPane();
		modifyPane.setVgap(15);
		modifyPane.setHgap(10);
		modifyPane.setPadding(new Insets(0, 10, 0, 10));

		final Button delButton = new Button("Delete");
		delButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Individual ind = table.getSelectionModel().getSelectedItem();
				if (ind != null) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("ALERT");
					alert.setHeaderText("Please confirm that you would like to delete\n"
							+ "First Name: "
							+ ind.getFirstName()
							+ "\n"
							+ "Last Name: " + ind.getLastName());
					ButtonType buttonTypeOne = new ButtonType("Cancel");
					ButtonType buttonTypeTwo = new ButtonType("OK");

					alert.showAndWait().ifPresent(response -> {
						if (response == ButtonType.OK) {
							data.remove(ind);
							table.getSelectionModel().clearSelection();
						} else {
							return;
						}

					});

				}
			}
		});

		final Button updateButton = new Button("Update");
		updateButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Individual ind = table.getSelectionModel().getSelectedItem();
				if (ind != null) {
					PaneIndUpdate updatePane = new PaneIndUpdate(ind, table,
							vbox, border, data);
					border.setCenter(updatePane.getPane());
				}// END IF

			}// END Handle

		});
		// for initial page load: just show radio buttons
		modifyPane.add(delButton, 1, 0);
		modifyPane.add(updateButton, 0, 0);

		return modifyPane;
	}

	/**
	 * Method to create search area below table.
	 * 
	 * @param data
	 *            in which is stored in data
	 * @return returns the GridPane in which the search area has been created.
	 */
	public GridPane searchGridPane(ObservableList<Individual> data) {
		// Create the horizontal box for formatting
		GridPane findPane = new GridPane();
		findPane.setVgap(15);
		findPane.setHgap(10);
		findPane.setPadding(new Insets(0, 10, 0, 10));
		// findPane.setGridLinesVisible(true);

		// Create radio buttons to change between record-display content
		ToggleGroup group = new ToggleGroup();
		RadioButton showAllButton = new RadioButton("Show All Records");
		showAllButton.setToggleGroup(group);
		showAllButton.setSelected(true);

		RadioButton showSomeButton = new RadioButton("Search Records");
		showSomeButton.setToggleGroup(group);

		// Create all the text fields to search an organization
		searchByCode = new TextField();
		searchByCode.setPromptText("ID");
		searchByCode.setMinWidth(50);

		searchByOrg = new TextField();
		searchByOrg.setPromptText("Organization");
		searchByOrg.setMinWidth(50);

		searchByDept = new TextField();
		searchByDept.setPromptText("Department");
		searchByDept.setMinWidth(50);

		searchByFName = new TextField();
		searchByFName.setPromptText("First Name");
		searchByFName.setMinWidth(50);

		searchByLName = new TextField();
		searchByLName.setPromptText("Last Name");
		searchByLName.setMinWidth(50);

		searchByPhone = new TextField();
		searchByPhone.setPromptText("Telephone");
		searchByPhone.setMinWidth(50);

		searchByEmail = new TextField();
		searchByEmail.setPromptText("Email");
		searchByEmail.setMinWidth(50);

		searchByAddress = new TextField();
		searchByAddress.setPromptText("Address");
		searchByAddress.setMinWidth(50);

		searchByCity = new TextField();
		searchByCity.setPromptText("City");
		searchByCity.setMinWidth(50);

		searchByState = new TextField();
		searchByState.setPromptText("State");
		searchByState.setMinWidth(50);

		searchByZip = new TextField();
		searchByZip.setPromptText("Zip Code");
		searchByZip.setMinWidth(100);

		searchByCountry = new TextField();
		searchByCountry.setPromptText("Country");
		searchByCountry.setMinWidth(50);

		searchByPassword = new TextField();
		searchByPassword.setPromptText("Password");
		searchByPassword.setMinWidth(50);

		// create a filtered list to filter the data
		filteredData = FXCollections.observableArrayList();
		// add the original data to the new filtered list
		filteredData.addAll(data);

		// Make the button search functionality
		Button searchButton = new Button("Search");
		findPane.setHalignment(searchButton, HPos.RIGHT);
		searchButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// If the button is clicked filter the data
				filterData(data);
			}
		});

		// for initial page load: just show radio buttons
		findPane.add(showAllButton, 0, 0);
		findPane.add(showSomeButton, 1, 0);
		filterData(data);

		// event handler for changing of radio buttons to allow table search:
		showSomeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				if (showSomeButton.isSelected()) {
					// Clear so duplicates do not get added when previously
					// selected
					findPane.getChildren().clear();
					// for initial page load: just show radio buttons
					findPane.add(showAllButton, 0, 0);
					findPane.add(showSomeButton, 1, 0);
					findPane.add(searchByCode, 0, 1);
					findPane.add(searchByOrg, 1, 1);
					findPane.add(searchByDept, 2, 1);
					findPane.add(searchByFName, 3, 1);
					findPane.add(searchByLName, 4, 1);
					findPane.add(searchByPhone, 5, 1);
					findPane.add(searchByAddress, 0, 2);
					findPane.add(searchByCity, 1, 2);
					findPane.add(searchByState, 2, 2);
					findPane.add(searchByZip, 3, 2);
					findPane.add(searchByCountry, 4, 2);
					findPane.add(searchByEmail, 5, 2);
					findPane.add(searchByPassword, 0, 3);
					findPane.add(searchButton, 5, 3);
					filterData(data);
				}
			}
		});

		showAllButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				if (showAllButton.isSelected()) {
					// remove search fields and button
					findPane.getChildren().clear();
					// display only the radio buttons
					findPane.add(showAllButton, 0, 0);
					findPane.add(showSomeButton, 1, 0);
					searchByCode.clear();
					searchByOrg.clear();
					searchByDept.clear();
					searchByFName.clear();
					searchByLName.clear();
					searchByPhone.clear();
					searchByEmail.clear();
					searchByAddress.clear();
					searchByCity.clear();
					searchByState.clear();
					searchByZip.clear();
					searchByCountry.clear();
					searchByPassword.clear();
					filterData(data);

				}
			}
		});
		return findPane;
	}

	/**
	 * Method to filter data in table.
	 * 
	 * @param take
	 *            in data to filter
	 * @return void.
	 */
	public void filterData(ObservableList<Individual> data) {
		filteredData.removeAll(data);

		for (Individual i : data) {
			if (matchesFilters(i)) {
				filteredData.add(i);
			}
		}
		table.setItems(filteredData);
		// QUICK REFRESH FOR TABLE
		table.getColumns().get(0).setVisible(false);
		table.getColumns().get(0).setVisible(true);

	}

	/**
	 * Method to check if data matches filter
	 * 
	 * @param take
	 *            in individual object to test
	 * @return true if matches false otherwise.
	 */
	private boolean matchesFilters(Individual individual) {
		String filterID = searchByCode.getText().toLowerCase();
		String filterOrg = searchByOrg.getText().toLowerCase();
		String filterDept = searchByDept.getText().toLowerCase();
		String filterFName = searchByFName.getText().toLowerCase();
		String filterLName = searchByLName.getText().toLowerCase();
		String filterPhone = searchByPhone.getText().toLowerCase();
		String filterEmail = searchByEmail.getText().toLowerCase();
		String filterAddress = searchByAddress.getText().toLowerCase();
		String filterCity = searchByCity.getText().toLowerCase();
		String filterState = searchByState.getText().toLowerCase();
		String filterZip = searchByZip.getText().toLowerCase();
		String filterCountry = searchByCountry.getText().toLowerCase();
		String filterPassword = searchByPassword.getText().toLowerCase();

		// If data exists filter out
		if (individual.getID().toLowerCase().indexOf(filterID) != -1
				&& individual.getOrganization().toLowerCase()
						.indexOf(filterOrg) != -1
				&& individual.getDepartment().toLowerCase().indexOf(filterDept) != -1
				&& individual.getFirstName().toLowerCase().indexOf(filterFName) != -1
				&& individual.getLastName().toLowerCase().indexOf(filterLName) != -1
				&& individual.getPhone().toLowerCase().indexOf(filterPhone) != -1
				&& individual.getEmail().toLowerCase().indexOf(filterEmail) != -1
				&& individual.getEmail().toLowerCase().indexOf(filterEmail) != -1
				&& individual.getAddress().toLowerCase().indexOf(filterAddress) != -1
				&& individual.getCityCode().toLowerCase().indexOf(filterCity) != -1
				&& individual.getStateCode().toLowerCase().indexOf(filterState) != -1
				&& individual.getZipCode().toLowerCase().indexOf(filterZip) != -1
				&& individual.getCountryCode().toLowerCase()
						.indexOf(filterCountry) != -1
				&& individual.getPassword().toLowerCase()
						.indexOf(filterPassword) != -1)
			return true;

		// return false otherwise
		return false;
	}// END matchesFilters

	public void refreshTable() {
		table.setItems(filteredData);
		// QUICK REFRESH FOR TABLE
		table.getColumns().get(0).setVisible(false);
		table.getColumns().get(0).setVisible(true);
	}

	public String getTitle() {
		return TITLE;
	}

	public VBox getPane() {
		return vbox;
	}

	public TableView<Individual> getTable() {
		return table;
	}

	public void setBorderPane(BorderPane border) {
		this.border = border;
	}

}
