package src.main.java.clas.panes.leadership;

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
import src.main.java.clas.leadership.Quality;
import src.main.java.clas.panes.PaneUI;

public class PaneQualityEdit implements PaneUI {
	
	private final String TITLE = "Edit Leadership Qualities";
	private TableView<Quality> table;
	private VBox vbox;
	private ObservableList<Quality> filteredData;
	private Label label;
	
	// For the table searching
	private TextField searchByCode;
	private TextField searchByTitle;
	private TextField searchByDes;

	private BorderPane border;

	public PaneQualityEdit(ObservableList<Quality> data) {
		label = new Label("Leadership Qualities");
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
	public void createTable(ObservableList<Quality> data) {
		table = new TableView<Quality>();
		table.setEditable(true);

		TableColumn<Quality, String> qualCode = new TableColumn<Quality, String>(
				"Code");
		qualCode.setMinWidth(50);
		qualCode.setCellValueFactory(new PropertyValueFactory<Quality, String>(
				"QualityCode"));

		TableColumn<Quality, String> qualTitle = new TableColumn<Quality, String>(
				"Title");
		qualTitle.setMinWidth(150);
		qualTitle
				.setCellValueFactory(new PropertyValueFactory<Quality, String>(
						"QualityTitle"));

		TableColumn<Quality, String> qualDes = new TableColumn<Quality, String>(
				"Description");
		qualDes.setMinWidth(500);
		qualDes.setCellValueFactory(new PropertyValueFactory<Quality, String>(
				"QualityDes"));

		// Set data items into table
		table.setItems(data);
		// Add data items into table view
		table.getColumns().addAll(qualCode, qualTitle, qualDes);
		table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}

	/**
	 * Method to create search area below table.
	 * 
	 * @param data
	 *            in which is stored in an ObservableList
	 * @return returns the GridPane in which the search area has been created.
	 */
	public GridPane modifyPane(ObservableList<Quality> data) {
		GridPane modifyPane = new GridPane();
		modifyPane.setVgap(15);
		modifyPane.setHgap(10);
		modifyPane.setPadding(new Insets(0, 10, 0, 10));

		final Button delButton = new Button("Delete");
		delButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Quality ind = table.getSelectionModel().getSelectedItem();
				if (ind != null) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("ALERT");
					alert.setHeaderText("Please confirm that you would like to delete\n"
							+ "Quality Name: " + ind.getQualityTitle());
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
				Quality ind = table.getSelectionModel().getSelectedItem();
				if (ind != null) {
					PaneQualityUpdate updatePane = new PaneQualityUpdate(ind,
							table, vbox, border, data);
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
	public GridPane searchGridPane(ObservableList<Quality> data) {
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
		searchByCode.setPromptText("Code");
		searchByCode.setMinWidth(50);

		searchByTitle = new TextField();
		searchByTitle.setPromptText("Title");
		searchByTitle.setMinWidth(50);

		searchByDes = new TextField();
		searchByDes.setPromptText("Description");
		searchByDes.setMinWidth(50);

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
					findPane.add(searchByTitle, 1, 1);
					findPane.add(searchByDes, 2, 1);
					findPane.add(searchButton, 3, 2);
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
					searchByTitle.clear();
					searchByDes.clear();

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
	public void filterData(ObservableList<Quality> data) {
		filteredData.removeAll(data);

		for (Quality i : data) {
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
	private boolean matchesFilters(Quality quality) {
		String filterID = searchByCode.getText().toLowerCase();
		String filterTitle = searchByTitle.getText().toLowerCase();
		String filterDes = searchByDes.getText().toLowerCase();

		// If data exists filter out
		if (quality.getQualityCode().toLowerCase().indexOf(filterID) != -1
				&& quality.getQualityTitle().toLowerCase().indexOf(filterTitle) != -1
				&& quality.getQualityDes().toLowerCase().indexOf(filterDes) != -1)
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

	public TableView<Quality> getTable() {
		return table;
	}

	public void setBorderPane(BorderPane border) {
		this.border = border;
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
}
