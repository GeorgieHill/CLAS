package src.main.java.clas.organization;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import src.main.java.clas.panes.PaneController;
import src.main.java.clas.panes.location.PaneCityAdd;
import src.main.java.clas.panes.location.PaneCityEdit;
import src.main.java.clas.panes.location.PaneCountryAdd;
import src.main.java.clas.panes.location.PaneCountryEdit;
import src.main.java.clas.panes.location.PaneStateAdd;
import src.main.java.clas.panes.location.PaneStateEdit;
import src.main.java.clas.panes.organization.PaneOrgAdd;
import src.main.java.clas.panes.organization.PaneOrgEdit;
import src.main.java.clas.panes.organization.PaneOrgReport;
import src.main.java.clas.ui.NavigationMain;

/**
 * GUI Menu for Organization manipulation.
 */
public class OrganizationMenu {

	//private boolean changingPage = false;
	private Stage organization;
	private static BorderPane border;
	private HBox topMenu;
	private VBox sideMenu;
	private Group root;
	private Rectangle2D screenBounds;
	private Scene scene;
	private static final int SIDEBAR_PADDING = 20;
	private static final int SIDEBAR_SPACING = 8;
	private ObservableList<Organization> data;
	private PaneController paneController;


	//private String test = "test";
	/*private Organization org = new Organization(
		test,test,test,test,test,test,test,test,test,test,test,test);
	private PaneOrgAdd orgAddPane;
	private PaneOrgEdit orgEditPane;
	//private PaneOrgUpdate orgUpdatePane = new PaneOrgUpdate(org);
	private PaneOrgReport orgReport;
	private PaneDeptAdd deptAddPane = new PaneDeptAdd();
	private PaneDeptEdit deptEditPane = new PaneDeptEdit();
	private PaneDeptUpdate deptUpdatePane = new PaneDeptUpdate(org);
	private PaneCityAdd cityAddPane = new PaneCityAdd();
	private PaneCityEdit cityEditPane = new PaneCityEdit();
	private PaneCityUpdate cityUpdatePane = new PaneCityUpdate(org);
	private PaneStateAdd stateAddPane = new PaneStateAdd();
	private PaneStateEdit stateEditPane = new PaneStateEdit();
	private PaneStateUpdate stateUpdatePane = new PaneStateUpdate(org);
	private PaneCountryAdd countryAddPane = new PaneCountryAdd();
	private PaneCountryEdit countryEditPane = new PaneCountryEdit();
	private PaneCountryUpdate countryUpdatePane = new PaneCountryUpdate(org);
	private PaneOrgQuesAdd quesAddPane = new PaneOrgQuesAdd();
	private PaneOrgQuesEdit quesEditPane = new PaneOrgQuesEdit();
	private PaneOrgQuesUpdate quesUpdatePane = new PaneOrgQuesUpdate(org);
	private PaneOrgRulesAdd rulesAddPane = new PaneOrgRulesAdd();
	private PaneOrgRulesEdit rulesEditPane = new PaneOrgRulesEdit();
	private PaneOrgRulesUpdate rulesUpdatePane = new PaneOrgRulesUpdate(org);
	private PaneOrgSResponseAdd sResAddPane = new PaneOrgSResponseAdd();
	private PaneOrgSResponseEdit sResEditPane = new PaneOrgSResponseEdit();
	private PaneOrgSResponseUpdate sResUpdatePane = new PaneOrgSResponseUpdate(org);
	private PaneOrgQResponseAdd qResAddPane = new PaneOrgQResponseAdd();
	private PaneOrgQResponseEdit qResEditPane = new PaneOrgQResponseEdit();
	private PaneOrgQResponseUpdate qResUpdatePane = new PaneOrgQResponseUpdate(org);
	private PaneOrgSAnalysisAdd sAnAddPane = new PaneOrgSAnalysisAdd();
	private PaneOrgSAnalysisEdit sAnEditPane = new PaneOrgSAnalysisEdit();
	private PaneOrgSAnalysisUpdate sAnUpdatePane = new PaneOrgSAnalysisUpdate(org);
	private PaneOrgQAnalysisAdd qAnAddPane = new PaneOrgQAnalysisAdd();
	private PaneOrgQAnalysisEdit qAnEditPane = new PaneOrgQAnalysisEdit();
	private PaneOrgQAnalysisUpdate qAnUpdatePane = new PaneOrgQAnalysisUpdate(org);
	*/

	public OrganizationMenu() {
		
		//Create a Stage which will allow the scenes to load
		organization = new Stage();
		organization.setTitle("CLAS Organization System");
		
		data = FXCollections.observableArrayList(
					new Organization("111","EFCNC","888-878-2224","info@efcnc.com","121 Sample Street",
					"03100","123","03257","USA","John Miller","603-763-2345","jd@efc.com"),
					new Organization("213","Mills and Co.","529-444-88","info@millis.com","423 Brown Avenue",
					"53534","222","03257","USA","James Millis","888-888-6767","jd@millis.com"),
					new Organization("222","Teller Inc.","777-123-4323","info@teller.com","44 Taylor Street",
					"22343","434","43555","USA","Phillip Michaels","201-555-6767","jd@teller.com"),
					new Organization("546","Smith and Sons","201-787-9978","info@smith.com","774 Scott Street",
					"54264","545","3455","USA","Deborah Smith","888-567-8769","jd@smith.com"),
					new Organization("567","NextEra","888-675-3453","info@nextera.com","4314 Filmore Avenue",
					"76457","343","03257","Canada","Gerald Jones","888-897-3321","jd@nextera.com"),
					new Organization("654","CNC Inc.","788-345-2323","info@cnc.com","7767 Candid Street",
					"56476","323","54545","USA","Vanessa McNay","201-676-9898","jd@cnc.com"),
					new Organization("659","System Analysis Professionals","888-123-7676","info@sap.com","77 Main Street",
					"34245","212","03257","USA","Clarity Rocha","766-873-3456","jd@sap.com"),
					new Organization("777","Clark and Co.","888-878-9326","info@clark.com","65464 Park Street",
					"63633","343","54545","USA","Romy Farland","777-454-8765","jd@clark.com"),
					new Organization("787","BFG Systems Design","234-567-8756","info@bfg.com","54 Teller Lane",
					"13464","464","03257","USA","Mary Brown","123-555-6545","jd@bfg.com"),
					new Organization("789","Sheff Company","234-878-4454","info@sheff.com","34 Mung Street",
					"73633","567","54545","USA","Sheila Webb","557-234-7654","jd@sheff.com"),
					new Organization("799","Scott and Co.","565-345-7676","info@scott.com","76 North Road",
					"37356","765","03257","USA","Rick Buteau","234-677-8787","jd@scott.com"),
					new Organization("811","TMH LLC","343-343-5456","info@tmh.com","766 Lake Street",
					"35653","756","76767","USA","Missy Gillespie","343-777-8787","jd@tmh.com"),
					new Organization("823","Cardinal One","234-876-9898","info@cardinal.com","878 Priority Avenue",
					"74564","656","03257","USA","Amanda Cleaver","345-111-8754","jd@cardinal.com"),
					new Organization("834","Bean's","987-644-3454","info@bean.com","98 14th Street",
					"57458","756","76767","USA","Sarah Brae","444-878-8880","jd@bean.com"),
					new Organization("854","Monument","232-444-6565","info@monument.com","3434 Maynard Street",
					"85785","754","87546","USA","Bill Ricci","232-987-6675","jd@monument.com"),
					new Organization("877","Joe Hill Company","454-775-9986","info@hillco.com","2322 Phillip Lane",
					"24235","756","76767","Canada","Terrance Smith","343-888-8880","jd@hillco.com"),
					new Organization("899","Simplicity","343-888-5333","info@simp.com","34 Narnia Way",
					"74562","787","03257","USA","Andrew Smith","888-888-6576","jd@simp.com"),
					new Organization("901","Taylor Design","878-888-8676","info@taylord.com","423 Old Turnpike",
					"73563","565","76767","USA","Martha Doe","878-888-5252","jd@taylord.com"),
					new Organization("927","Mint Street Inc.","878-888-5454","info@mint.com","312 Little Street",
					"52345","565","87978","USA","Betty Smith","878-888-9796","jd@mint.com")
					);
	
		/*paneController = new PaneControllerjp();

		orgAddPane = new PaneOrgAdd(data);
		orgEditPane = new PaneOrgEdit(data);
		//orgUpdatePane = new PaneOrgUpdate(data);
		orgReport = new PaneOrgReport(data);
		
		//Add them to controller hashmap


		paneController.addPane(orgAddPane.getTitle(), orgAddPane.getPane());
		paneController.addPane(orgEditPane.getTitle(), orgEditPane.getPane());
		paneController.addPane(orgReport.getTitle(), orgReport.getPane());

		paneController.addPane(deptAddPane.getTitle(), deptAddPane.getPane());
		paneController.addPane(deptEditPane.getTitle(), deptEditPane.getPane());
		paneController.addPane(deptUpdatePane.getTitle(), deptUpdatePane.getPane());
		paneController.addPane(cityAddPane.getTitle(), cityAddPane.getPane());
		paneController.addPane(cityEditPane.getTitle(), cityEditPane.getPane());
		paneController.addPane(cityUpdatePane.getTitle(), cityUpdatePane.getPane());

		paneController.addPane(stateAddPane.getTitle(), stateAddPane.getPane());
		paneController.addPane(stateEditPane.getTitle(), stateEditPane.getPane());
		paneController.addPane(stateUpdatePane.getTitle(), stateUpdatePane.getPane());
		paneController.addPane(countryAddPane.getTitle(), countryAddPane.getPane());
		paneController.addPane(countryEditPane.getTitle(), countryEditPane.getPane());
		paneController.addPane(countryUpdatePane.getTitle(), countryUpdatePane.getPane());

		paneController.addPane(quesAddPane.getTitle(), quesAddPane.getPane());
		paneController.addPane(quesEditPane.getTitle(), quesEditPane.getPane());
		paneController.addPane(quesUpdatePane.getTitle(), quesUpdatePane.getPane());
		paneController.addPane(rulesAddPane.getTitle(), rulesAddPane.getPane());
		paneController.addPane(rulesEditPane.getTitle(), rulesEditPane.getPane());
		paneController.addPane(rulesUpdatePane.getTitle(), rulesUpdatePane.getPane());

		paneController.addPane(sResAddPane.getTitle(), sResAddPane.getPane());
		paneController.addPane(sResEditPane.getTitle(), sResEditPane.getPane());
		paneController.addPane(sResUpdatePane.getTitle(), sResUpdatePane.getPane());
		paneController.addPane(qResAddPane.getTitle(), qResAddPane.getPane());
		paneController.addPane(qResEditPane.getTitle(), qResEditPane.getPane());
		paneController.addPane(qResUpdatePane.getTitle(), qResUpdatePane.getPane());

paneController.addPane(sAnAddPane.getTitle(), sAnAddPane.getPane());
		paneController.addPane(sAnEditPane.getTitle(), sAnEditPane.getPane());
		paneController.addPane(sAnUpdatePane.getTitle(), sAnUpdatePane.getPane());
		paneController.addPane(qAnAddPane.getTitle(), qAnAddPane.getPane());
		paneController.addPane(qAnEditPane.getTitle(), qAnEditPane.getPane());
		paneController.addPane(qAnUpdatePane.getTitle(), qAnUpdatePane.getPane());
	*/

		//Create a border which will hold components of stage
		border = new BorderPane();
		//Add a horizontal box for the head panel
		topMenu = addTopMenu(organization);
		sideMenu = addVBox();

		//set the top/right/center/left/bottom panes to information
		border.setTop(topMenu);
		border.setLeft(sideMenu);
		
		border.setCenter(paneController.goToPane("Edit/Delete Organizations")); 

		//empty VBox to act as buffer on right side of screen
		border.setRight(bufferVBox());

 		root = new Group();
 		//scene to screen size
 		screenBounds = Screen.getPrimary().getVisualBounds();
		scene = new Scene(root, screenBounds.getWidth(), screenBounds.getHeight());
		//orgEditPane.setBorderPane(border);
		scene.setRoot(border);
		organization.setScene(scene);

		//add style sheet
		scene.getStylesheets().add("/resources/css/Menu.css");
		organization.show();
	}

	/**
 	 * Creates a Horizontal box for head panel.
 	 * @param now The current stage that is being displayed.
 	 * @return the HBox that will be used for the top menu navigation.
 	 */
	public final HBox addTopMenu(final Stage now) {
		NavigationMain nav = new NavigationMain(now);
		HBox topMenu = nav.getTopMenu();
		return topMenu;
	}

	/*public VBox addSideMenu(){
		NavigationSideOrg nav = new NavigationSideOrg();
		VBox sidebar = nav.getSideMenu();
		return sidebar;
	}*/

	/**
 	 * Creates a VBox pane for sidebar navigation.
 	 * @return the VBox to be used for the sidebar menu navigation.
 	 */
	public final VBox addVBox() {
		
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(SIDEBAR_PADDING));
		vbox.setSpacing(SIDEBAR_SPACING);
		vbox.setId("leftVBox");
		
		//Create TreeView Menu that changes scene in center of border
        TreeItem<String> root = new TreeItem<String>("CLAS Organization Tables");
        root.setExpanded(true);
        
        TreeItem<String> orgNode = new TreeItem<String>("Organizations");
        TreeItem<String> deptNode = new TreeItem<String>("Departments");
        TreeItem<String> locNode = new TreeItem<String>("Location Data");
        TreeItem<String> quesNode = new TreeItem<String>("Questionnaires");
        TreeItem<String> rulesNode = new TreeItem<String>("Analysis Rules");
        TreeItem<String> sResNode = new TreeItem<String>("Leadership Style Responses");
        TreeItem<String> qResNode = new TreeItem<String>("Leadership Quality Responses");
        TreeItem<String> sAnNode = new TreeItem<String>("Leadership Style Analysis");
        TreeItem<String> qAnNode = new TreeItem<String>("Leadership Quality Analysis");
        root.getChildren().addAll(orgNode, deptNode, locNode, quesNode, rulesNode,
        		sResNode, qResNode, sAnNode, qAnNode);
		
		TreeItem<String> orgAdd = new TreeItem<String>(PaneOrgAdd.getTitle());
		TreeItem<String> orgEdit = new TreeItem<String>(PaneOrgEdit.getTitle()); 
		TreeItem<String> orgReports = new TreeItem<String>(PaneOrgReport.getTitle()); 
		orgNode.getChildren().addAll(orgAdd, orgEdit, orgReports);

		TreeItem<String> deptAdd = new TreeItem<String>("Department TEST"); 
		TreeItem<String> deptEdit = new TreeItem<String>("Department TESTING");
		TreeItem<String> deptReport = new TreeItem<String>("Department Reporting"); 
		deptNode.getChildren().addAll(deptAdd, deptEdit, deptReport);

		TreeItem<String> locNode1 = new TreeItem<String>("Cities"); 
		TreeItem<String> locNode2 = new TreeItem<String>("States");
		TreeItem<String> locNode3 = new TreeItem<String>("Countries"); 
		locNode.getChildren().addAll(locNode1, locNode2, locNode3);

			TreeItem<String> cityAdd = new TreeItem<String>(PaneCityAdd.getTitle()); 
			TreeItem<String> cityEdit = new TreeItem<String>(PaneCityEdit.getTitle());
			TreeItem<String> cityReport = new TreeItem<String>("City Reporting"); 
			locNode1.getChildren().addAll(cityAdd, cityEdit, cityReport);

			TreeItem<String> stateAdd = new TreeItem<String>(PaneStateAdd.getTitle()); 
			TreeItem<String> stateEdit = new TreeItem<String>(PaneStateEdit.getTitle());
			TreeItem<String> stateReport = new TreeItem<String>("State Reporting"); 
			locNode2.getChildren().addAll(stateAdd, stateEdit, stateReport);

			TreeItem<String> countryAdd = new TreeItem<String>(PaneCountryAdd.getTitle()); 
			TreeItem<String> countryEdit = new TreeItem<String>(PaneCountryEdit.getTitle());
			TreeItem<String> countryReport = new TreeItem<String>("Country Reporting"); 
			locNode3.getChildren().addAll(countryAdd, countryEdit, countryReport);

		TreeItem<String> quesAdd = new TreeItem<String>("Questionnaire Reporting"); 
		TreeItem<String> quesEdit = new TreeItem<String>("Questionnaire Reporting");
		TreeItem<String> quesReport = new TreeItem<String>("Questionnaire Reporting"); 
		quesNode.getChildren().addAll(quesAdd, quesEdit, quesReport);

		TreeItem<String> rulesAdd = new TreeItem<String>("Questionnaire Reporting"); 
		TreeItem<String> rulesEdit = new TreeItem<String>("Questionnaire Reporting");
		TreeItem<String> rulesReport = new TreeItem<String>("Analysis Rules Reporting"); 
		rulesNode.getChildren().addAll(rulesAdd, rulesEdit, rulesReport);

		TreeItem<String> sResAdd = new TreeItem<String>("Questionnaire Reporting"); 
		TreeItem<String> sResEdit = new TreeItem<String>("Questionnaire Reporting");
		TreeItem<String> sResReport = new TreeItem<String>("Style Response Reporting"); 
		sResNode.getChildren().addAll(sResAdd, sResEdit, sResReport);

		TreeItem<String> qResAdd = new TreeItem<String>("Questionnaire Reporting"); 
		TreeItem<String> qResEdit = new TreeItem<String>("Questionnaire Reporting");
		TreeItem<String> qResReport = new TreeItem<String>("Quality Response Reporting"); 
		qResNode.getChildren().addAll(qResAdd, qResEdit, qResReport);

		TreeItem<String> sAnAdd = new TreeItem<String>("Questionnaire Reporting"); 
		TreeItem<String> sAnEdit = new TreeItem<String>("Questionnaire Reporting");
		TreeItem<String> sAnReport = new TreeItem<String>("Style Analysis Reporting"); 
		sAnNode.getChildren().addAll(sAnAdd, sAnEdit, sAnReport);

		TreeItem<String> qAnAdd = new TreeItem<String>("Questionnaire Reporting"); 
		TreeItem<String> qAnEdit = new TreeItem<String>("Questionnaire Reporting");
		TreeItem<String> qAnReport = new TreeItem<String>("Quality Analysis Reporting"); 
		qAnNode.getChildren().addAll(qAnAdd, qAnEdit, qAnReport);

		TreeView<String> treeView = new TreeView<String>(root);
		treeView.getStyleClass().add("menuTree");

		//Event listener for user's selection of a tree item
		treeView.getSelectionModel().selectedItemProperty()
            .addListener(new ChangeListener<TreeItem<String>>() {

                @Override
                public void changed(
                        ObservableValue<? extends TreeItem<String>> observable,
                        TreeItem<String> old_val, TreeItem<String> new_val) {
                    //determine if selected value is a pane to be load (is a leaf)
                    if(new_val.isLeaf()) {
                    	//holds the selected value
	                    String selectedItem = new_val.getValue();
	                    
	                    //Changes the center pane based on user choice
	                    border.setCenter(paneController.goToPane(selectedItem));
	                    
	                    //****************add this back in!!!!!!!!
	                    //orgEditPane.refreshTable();
	                    //************
	                }
                }
            });

        //add TreeView to the VBox    
		vbox.getChildren().addAll(treeView);

		return vbox;
	}

	/**
 	 * Empty VBox to act as buffer (used on right side of scene).
 	 * @return the VBox that will be used as a buffer.
 	 */
	public final VBox bufferVBox() {
		VBox buffer = new VBox();
		buffer.setMinWidth(30);
		return buffer;
	}

	public static void changePane(final VBox newPane){
		border.setCenter(newPane);
	}
	public Stage getStage(){
			return organization;		
	}
}
