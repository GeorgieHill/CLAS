package src.main.java.clas.panes.organization;

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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import src.main.java.clas.organization.Organization;
import src.main.java.clas.panes.PaneUI;

/**
 * Creates scene for update Organization records.
 */
public class PaneOrgUpdate implements PaneUI {

	private GridPane gp;
	private VBox vbox;
	private Label label;
	private Label updateOrg;
	private TextField updatePhone;
	private TextField updateEmail;
	private TextField updateAddress;
	private TextField updateCity;
	private TextField updateState;
	private TextField updateZipCode;
	private TextField updateCountry;
	private TextField updateContact;
	private TextField updateContactPhone;
	private TextField updateContactEmail;
	private Button updateButton;
	private PaneOrgEdit editPane;
	private static final String TITLE = "Update Organization";;
	private static final int VERTICAL_GAP = 15;
	private static final int HORIZ_GAP = 10;
	private static final int MIN_WIDTH = 300;
	private Organization org;
	private TableView<Organization> table;
	private BorderPane border;
	private VBox tableVbox;
	private ObservableList<Organization> data;

	public PaneOrgUpdate() {

		//Add this pane to the pane directory
		//PaneController.addMap(TITLE, this);

		//this.org=org;
		this.table = table;
		this.tableVbox  = tableVbox;
		this.border = border;
		this.data = data;

		//Header label
		label = new Label("Update Organization Record");
		label.setFont(Font.font("System", FontWeight.BOLD, 18));

		GridPane gp = new GridPane();
		vbox = new VBox();
		gp = setUpPane(gp, org);										
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, gp);
	}

	/**
 	* Method to access the GridPane created for updating organizations.
 	* @return Returns the GridPane.
 	*/
	public GridPane setUpPane(GridPane gridPane, Organization org) {
		//Creates the containers for this pane
		GridPane gp = gridPane;

		gp.setVgap(VERTICAL_GAP);
		gp.setHgap(HORIZ_GAP);
		gp.setPadding(new Insets(10, 0, 0, 10));

		//TextField Labels
		Label orgNameLbl = new Label("Organization Name:");
		Label orgPhoneLbl = new Label("Phone:");
		Label orgEmailLbl = new Label("Email:");
		Label orgAddressLbl = new Label("Address:");
		Label orgCityLbl = new Label("City Code:");
		Label orgStateLbl = new Label("State Code:");
		Label orgZipLbl = new Label("Zip Code:");
		Label orgCountryLbl = new Label("Country Code:");
		Label orgContLbl = new Label("Contact Person:");
		Label orgContPhoneLbl = new Label("Contact Person's Phone:");
		Label orgContEmailLbl = new Label("Contact Person's Email:");

		//Create all the text fields to update an organization
		updateOrg = new Label(org.getID());


		updatePhone = new TextField();
		updatePhone.setPromptText(org.getOrgName());
		updatePhone.setMinWidth(MIN_WIDTH);

		updateEmail = new TextField();
		updateEmail.setPromptText(org.getEmail());
		updateEmail.setMinWidth(MIN_WIDTH);

		updateAddress = new TextField();
		updateAddress.setPromptText(org.getAddress());
		updateAddress.setMinWidth(MIN_WIDTH);
	
		updateCity = new TextField();
		updateCity.setPromptText(org.getCityCode());
		updateCity.setMinWidth(MIN_WIDTH);

		updateState = new TextField();
		updateState.setPromptText(org.getStateCode());
		updateState.setMinWidth(MIN_WIDTH);
		
		updateZipCode = new TextField();
		updateZipCode.setPromptText(org.getZip());
		updateZipCode.setMinWidth(MIN_WIDTH);
	
		updateCountry = new TextField();
		updateCountry.setPromptText(org.getCountryCode());
		updateCountry.setMinWidth(MIN_WIDTH);
		
		updateContact = new TextField();
		updateContact.setPromptText(org.getContactName());
		updateContact.setMinWidth(MIN_WIDTH);

		updateContactPhone = new TextField();
		updateContactPhone.setPromptText(org.getContactPhone());
		updateContactPhone.setMinWidth(MIN_WIDTH);
	
		updateContactEmail = new TextField();
		updateContactEmail.setPromptText(org.getContactEmail());
		updateContactEmail.setMinWidth(MIN_WIDTH);

		//Make the button update functionality	
		updateButton = new Button("Update");
		gp.setHalignment(updateButton, HPos.RIGHT);
		updateButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e){

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Confirmation");
					alert.setHeaderText("Please confirm that you would like to make this change");
					//alert.setContentText("Are you ok with this?");

					ButtonType buttonTypeOne = new ButtonType("Cancel");
					ButtonType buttonTypeTwo = new ButtonType("OK");

					alert.showAndWait().ifPresent(response -> {
						if (response == ButtonType.OK){
							if(!updateOrg.getText().isEmpty())
						    org.setOrgName(updateOrg.getText());

							if(!updatePhone.getText().isEmpty())
							org.setPhone(updatePhone.getText());
							
							if(!updateEmail.getText().isEmpty())
							org.setEmail(updateEmail.getText());

							if(!updateAddress.getText().isEmpty())
							org.setAddress(updateAddress.getText());

							if(!updateCity.getText().isEmpty())
							org.setCityCode(updateCity.getText());

							if(!updateState.getText().isEmpty())
							org.setStateCode(updateState.getText());

							if(!updateZipCode.getText().isEmpty())
							org.setZip(updateZipCode.getText());

							if(!updateCountry.getText().isEmpty())
							org.setCountryCode(updateCountry.getText());

							if(!updateContact.getText().isEmpty())
							org.setContactName(updateContact.getText());

							if(!updateContactPhone.getText().isEmpty())
							org.setContactPhone(updateContactPhone.getText());

							if(!updateContactEmail.getText().isEmpty())
							org.setContactEmail(updateContactEmail.getText());

							//editPane = new PaneOrgEdit();
							//OrganizationMenu.changePane(editPane.getPane());
							} 
						else {
						    return;
						}
					});
				}
			});

			Button closeButton = new Button("Close");
					gp.setHalignment(closeButton, HPos.RIGHT);
					closeButton.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e){
								ObservableList<Organization> updatedData = FXCollections.observableArrayList();
								updatedData.clear();
								for(Organization i : data){
									updatedData.add(i);
								}
								table.setItems(updatedData);
								border.setCenter(tableVbox);
							}
			});
		
		gp.add(orgNameLbl,0,0);
		gp.add(updateOrg,1,0); 

		gp.add(orgPhoneLbl,0,1);
		gp.add(updatePhone,1,1);

		gp.add(orgEmailLbl,0,2); 
		gp.add(updateEmail,1,2); 

		gp.add(orgAddressLbl,0,3);
		gp.add(updateAddress,1,3);

		gp.add(orgCityLbl,0,4);
		gp.add(updateCity,1,4);

		gp.add(orgStateLbl,0,5); 
		gp.add(updateState,1,5);

		gp.add(orgZipLbl,0,6); 
		gp.add(updateZipCode,1,6);

		gp.add(orgCountryLbl,0,7);
		gp.add(updateCountry,1,7);

		gp.add(orgContLbl,0,8); 
		gp.add(updateContact,1,8);

		gp.add(orgContPhoneLbl,0,9); 
		gp.add(updateContactPhone,1,9); 

		gp.add(orgContEmailLbl,0,10);
		gp.add(updateContactEmail,1,10); 

		gp.add(updateButton,1,11);
		gp.add(closeButton,1,12);


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

	/**
 	* Method to access TITLE for this object.
 	* @return Returns the TITLE for this pane.
 	*/
	public static String getTitle() {
		return TITLE;
	}

	public VBox getPane(){
		return vbox;				
	}
}
