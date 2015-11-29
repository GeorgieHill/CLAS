package src.main.java.clas.organization;

//For the table
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
import src.main.java.clas.panes.organization.PaneOrgUpdate;

public class OrganizationTable {

	private final String TITLE = "Edit Organizations";
	private TableView<Organization> table;
	private VBox vbox;
	private ObservableList<Organization> filteredData;

	// For the table searching
	private TextField searchByCode;
	private TextField searchByOrg;
	private TextField searchByPhone;
	private TextField searchByEmail;
	private TextField searchByAddress;
	private TextField searchByCity;
	private TextField searchByState;
	private TextField searchByZip;
	private TextField searchByCountry;
	private TextField searchByContact;
	private TextField searchByCPhone;
	private TextField searchByCEmail;
	private BorderPane border;
	private GridPane findPane;

	public OrganizationTable(ObservableList<Organization> data) {
		
		final Label label = new Label("Organization");
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
	public void createTable(ObservableList<Organization> data) {

		// Create a table with columns to display Organization information
		table = new TableView<Organization>();
		table.setEditable(true);

		// Create the columns

		TableColumn<Organization, String> orgCode = new TableColumn<>("Code");
		orgCode.setMinWidth(50);
		orgCode.setCellValueFactory(new PropertyValueFactory<Organization, String>(
				"OrgCode"));

		TableColumn<Organization, String> orgName = new TableColumn<>("Organization");
		orgName.setMinWidth(150);
		orgName.setCellValueFactory(new PropertyValueFactory<Organization, String>(
				"OrgName"));

		TableColumn<Organization, String> orgPhone = new TableColumn<>("Phone");
		orgPhone.setMinWidth(100);
		orgPhone.setCellValueFactory(new PropertyValueFactory<Organization, String>(
				"Phone"));

		TableColumn<Organization, String> orgEmail = new TableColumn<>("Email");
		orgEmail.setMinWidth(150);
		orgEmail.setCellValueFactory(new PropertyValueFactory<Organization, String>(
				"Email"));

		TableColumn<Organization, String> orgAddress = new TableColumn<>("Address");
		orgAddress.setMinWidth(150);
		orgAddress
				.setCellValueFactory(new PropertyValueFactory<Organization, String>(
						"Address"));

		TableColumn<Organization, String> orgCityCode = new TableColumn<>("City Code");
		orgCityCode.setMinWidth(50);
		orgCityCode
				.setCellValueFactory(new PropertyValueFactory<Organization, String>(
						"CityCode"));

		TableColumn<Organization, String> orgStateCode = new TableColumn<>("State Code");
		orgStateCode.setMinWidth(50);
		orgStateCode
				.setCellValueFactory(new PropertyValueFactory<Organization, String>(
						"StateCode"));

		TableColumn<Organization, String> orgZipCode = new TableColumn<>("ZipCode");
		orgZipCode.setMinWidth(50);
		orgZipCode
				.setCellValueFactory(new PropertyValueFactory<Organization, String>(
						"Zip"));

		TableColumn<Organization, String> orgCountryCode = new TableColumn<>("Country Code");
		orgCountryCode.setMinWidth(50);
		orgCountryCode
				.setCellValueFactory(new PropertyValueFactory<Organization, String>(
						"CountryCode"));

		TableColumn<Organization, String> orgContact = new TableColumn<>("Contact Person");
		orgContact.setMinWidth(150);
		orgContact
				.setCellValueFactory(new PropertyValueFactory<Organization, String>(
						"ContactName"));

		TableColumn<Organization, String> orgContactPhone = new TableColumn<>("Contact Phone");
		orgContactPhone.setMinWidth(100);
		orgContactPhone
				.setCellValueFactory(new PropertyValueFactory<Organization, String>(
						"ContactPhone"));

		TableColumn<Organization, String> orgContactEmail = new TableColumn<>("Contact Email");
		orgContactEmail.setMinWidth(100);
		orgContactEmail
				.setCellValueFactory(new PropertyValueFactory<Organization, String>(
						"ContactEmail"));

		// Set the items from the ArrayList into the table
		table.setItems(data);
		table.getColumns().addAll(orgCode, orgName, orgPhone, orgEmail,
				orgAddress, orgCityCode, orgStateCode, orgZipCode,
				orgCountryCode, orgContact, orgContactPhone, orgContactEmail);
		table.setVisible(true);
		table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}

	/**
	 * Method to create search area below table.
	 * 
	 * @param data
	 *            in which is stored in an ObservableList
	 * @return returns the GridPane in which the search area has been created.
	 */
	public GridPane modifyPane(ObservableList<Organization> data) {

		GridPane modifyPane = new GridPane();
		modifyPane.setVgap(15);
		modifyPane.setHgap(10);
		modifyPane.setPadding(new Insets(0, 10, 0, 10));

		;

		final Button delButton = new Button("Delete");
		delButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Organization org = table.getSelectionModel().getSelectedItem();
				if (org != null) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("ALERT");
					alert.setHeaderText("Please confirm that you would like to delete\n"
							+ "Organization: " + org.getOrgName());
					ButtonType buttonTypeOne = new ButtonType("Cancel");
					ButtonType buttonTypeTwo = new ButtonType("OK");

					alert.showAndWait().ifPresent(response -> {
						if (response == ButtonType.OK) {
							data.remove(org);
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
				Organization org = table.getSelectionModel().getSelectedItem();
				if (org != null) {
					// PaneOrgUpdate updatePane = new PaneOrgUpdate(org, table,
					// vbox, border, data);
					// /fix this!!!
					// *********
					PaneOrgUpdate updatePane = new PaneOrgUpdate();

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
	public GridPane searchGridPane(ObservableList<Organization> data) {
		
		//Create the horizontal box for formatting
		findPane = new GridPane();
		findPane.setVgap(15);
		findPane.setHgap(10);
		findPane.setPadding(new Insets(0,10,0,10));
		//findPane.setGridLinesVisible(true);

		//Create radio buttons to change between record-display content
		ToggleGroup group = new ToggleGroup();
		RadioButton showAllButton = new RadioButton("Show All Records");
		showAllButton.setToggleGroup(group);
		showAllButton.setSelected(true);
		RadioButton showSomeButton = new RadioButton("Search Records");
		showSomeButton.setToggleGroup(group);

		//Create all the text fields to search an organization
		searchByCode = new TextField();
		searchByCode.setPromptText("Code");
		searchByCode.setMinWidth(50);

		searchByOrg = new TextField();
		searchByOrg.setPromptText("Organization");
		searchByOrg.setMinWidth(50);

		searchByPhone = new TextField();
		searchByPhone.setPromptText("Phone");
		searchByPhone.setMinWidth(50);

		searchByEmail = new TextField();
		searchByEmail.setPromptText("Email");
		searchByEmail.setMinWidth(50);

		searchByAddress = new TextField();
		searchByAddress.setPromptText("Address");
		searchByAddress.setMinWidth(50);
	
		searchByCity = new TextField();
		searchByCity.setPromptText("City Code");
		searchByCity.setMinWidth(50);

		searchByState = new TextField();
		searchByState.setPromptText("State Code");
		searchByState.setMinWidth(50);
		
		searchByZip = new TextField();
		searchByZip.setPromptText("Zip Code");
		searchByZip.setMinWidth(50);
	
		searchByCountry = new TextField();
		searchByCountry.setPromptText("Country Code");
		searchByCountry.setMinWidth(50);
		
		searchByContact = new TextField();
		searchByContact.setPromptText("Contact");
		searchByContact.setMinWidth(50);

		searchByCPhone = new TextField();
		searchByCPhone.setPromptText("Contact Phone");
		searchByCPhone.setMinWidth(100);
	
		searchByCEmail = new TextField();
		searchByCEmail.setPromptText("Contact Email");
		searchByCEmail.setMinWidth(50);

		//create a filtered list to filter the data
		filteredData = FXCollections.observableArrayList();
		//add the original data to the new filtered list
		filteredData.addAll(data);

		//Make the button search functionality	
		Button searchButton = new Button("Search");
		GridPane.setHalignment(searchButton, HPos.RIGHT);
		searchButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
				//create code to display matching records	
				filterData(data);				
				}
		});
		
		//for initial page load: just show radio buttons
		findPane.add(showAllButton, 0,0);
		findPane.add(showSomeButton, 1,0);

		//event handler for changing of radio buttons to allow table search:
		showSomeButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
			 public void handle(ActionEvent actionEvent) {
        		if (showSomeButton.isSelected()) {
        			//add search fields and button to display
        			findPane.add(searchByCode,0,1);
        			findPane.add(searchByOrg,1,1); 
        			findPane.add(searchByPhone,2,1); 
        			findPane.add(searchByEmail,3,1); 
        			findPane.add(searchByAddress,4,1);
        			findPane.add(searchByCity,5,1); 
        			findPane.add(searchByState,0,2); 
        			findPane.add(searchByZip,1,2);
        			findPane.add(searchByCountry,2,2); 
        			findPane.add(searchByContact,3,2); 
        			findPane.add(searchByCPhone,4,2); 
        			findPane.add(searchByCEmail,5,2); 
        			findPane.add(searchButton,5,3);       			
                }  
    		}
		});
		
		showAllButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
			 public void handle(ActionEvent actionEvent) {
        		if (showAllButton.isSelected()) {
        			//remove search fields and button
        			findPane.getChildren().clear();
        			//display only the radio buttons
        			findPane.add(showAllButton, 0,0);
					findPane.add(showSomeButton, 1,0);

					table.setItems(data);
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
	public void filterData(ObservableList<Organization> data) {
		
		filteredData.removeAll(data);

		for (Organization o : data) {
			if (matchesFilters(o)) {
				filteredData.add(o);
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
	private boolean matchesFilters(Organization organization) {
		String filterID = searchByCode.getText().toLowerCase();
		String filterOrg = searchByOrg.getText().toLowerCase();
		String filterPhone = searchByPhone.getText().toLowerCase();
		String filterEmail = searchByEmail.getText().toLowerCase();
		String filterAddress = searchByAddress.getText().toLowerCase();
		String filterCity = searchByCity.getText().toLowerCase();
		String filterState = searchByState.getText().toLowerCase();
		String filterZip = searchByZip.getText().toLowerCase();
		String filterCountry = searchByCountry.getText().toLowerCase();
		String filterContact = searchByContact.getText().toLowerCase();
		String filterCPhone = searchByCPhone.getText().toLowerCase();
		String filterCEmail = searchByCEmail.getText().toLowerCase();
		
		//If data exists filter out
		if(organization.getID().toLowerCase().indexOf(filterID) != -1 &&
		organization.getOrgName().toLowerCase().indexOf(filterOrg) != -1 &&
		organization.getPhone().toLowerCase().indexOf(filterPhone) != -1 &&
		organization.getEmail().toLowerCase().indexOf(filterEmail) != -1 &&
		organization.getAddress().toLowerCase().indexOf(filterAddress) != -1 && 
		organization.getCityCode().toLowerCase().indexOf(filterCity) != -1 &&
		organization.getStateCode().toLowerCase().indexOf(filterState) != -1 &&
		organization.getZip().toLowerCase().indexOf(filterZip) != -1 &&
		organization.getCountryCode().toLowerCase().indexOf(filterCountry) != -1 &&
		organization.getContactName().toLowerCase().indexOf(filterContact) != -1 &&
		organization.getContactPhone().toLowerCase().indexOf(filterCPhone) != -1 &&
		organization.getContactEmail().toLowerCase().indexOf(filterCEmail) != -1)
			return true;
		
		//return false otherwise
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

	public TableView<Organization> getTable() {
		return table;
	}

	public void setBorderPane(BorderPane border) {
		this.border = border;
	}

}
