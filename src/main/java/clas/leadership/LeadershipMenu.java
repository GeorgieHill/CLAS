package src.main.java.clas.leadership;

import src.main.java.clas.panes.PaneControllerjp;
import src.main.java.clas.panes.leadership.PaneQualityAdd;
import src.main.java.clas.panes.leadership.PaneQualityEdit;
import src.main.java.clas.panes.leadership.PaneQualityReport;
import src.main.java.clas.ui.NavigationMain;
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



public class LeadershipMenu{
	private final int SIDEBAR_PADDING = 20;
	private final int SIDEBAR_SPACING = 8;
	private Stage LeadershipMenu;

	private ObservableList<Quality> qualityData;
	
	private PaneControllerjp paneController;
	private BorderPane border;

	private PaneQualityAdd qualAddPane;
	private PaneQualityEdit qualEditPane;
	private PaneQualityReport qualReportPane;

	/*
	private PaneQualQuesAdd qualQuesAddPane;
	private PaneQualQuesEdit qualQuesEditPane;
	private PaneQualQuesReport qualQuesReportPane;

	private PaneStyleAdd styleAddPane;
	private PaneStyleEdit styleEditPane;
	private PaneStyleReport styleReportPane;

	private PaneStyleQuesAdd styleQuesAddPane;
	private PaneStyleQuesEdit styleQuesEditPane;
	private PaneStyleQuesReport styleQuesReportPane;
	*/
	
	public LeadershipMenu(){
		//Create a Stage which will allow the individual menu to load
		LeadershipMenu = new Stage();
		LeadershipMenu.setTitle("CLAS Leadership System");
		
		//Fill in individual data for indivdual menu
		qualityData = FXCollections.observableArrayList(
				new Quality("001", "Flexible","Adapts to new surrounding and situations"),
				new Quality("002", "Communication","Conveys ideas clearly"),
				new Quality("003", "Confidence","Believes in oneself and ability to accomplish goals"),
				new Quality("004", "Ability to Inspire","Makes others want to work")
				);

		paneController = new PaneControllerjp();

		/*
		//create all the panes we will be using
		qualAddPane = new PaneQualityAdd();
		qualEditPane = new PaneQualityEdit();
		qualReportPane = new PaneQualityReport();

		qualQuesAddPane = new PaneQualQuesAdd(qualityData);
		qualQuesEditPane = new PaneQualQuesEdit(qualityData);
		qualQuesReportPane = new PaneQualQuesReport(qualityData);

		styleAddPane = new PaneStyleAdd(qualityData);
		styleEditPane = new PaneStyleEdit(qualityData);
		styleReportPane = new PaneStyleReport(qualityData);

		styleQuesAddPane = new PaneStyleQuesAdd(qualityData);
		styleQuesEditPane = new PaneStyleQuesEdit(qualityData);
		styleQuesReportPane = new PaneStyleQuesReport(qualityData);
		
		//Add them to controller hashmap
		paneController.addPane(qualAddPane.getTitle(), qualAddPane.getPane());
		paneController.addPane(qualEditPane.getTitle(), qualEditPane.getPane());
		paneController.addPane(qualReportPane.getTitle(), qualReportPane.getPane());
		*/

		//Create a border which will allow us to make a basic set pane of top/right/center/left/bottom
		border = new BorderPane();
		//set the top/right/center/left/bottom panes to information
		border.setTop(addTopMenu(LeadershipMenu));
		border.setLeft(addVBox());
		border.setCenter(qualEditPane.getPane());
		border.setRight(bufferVBox());
 		Group root = new Group();
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		Scene scene = new Scene(root, screenBounds.getWidth(), screenBounds.getHeight());
		qualEditPane.setBorderPane(border);
		scene.setRoot(border);
		LeadershipMenu.setScene(scene);
		//Set up the style sheets for the login window to load in.
		scene.getStylesheets().add("/resources/css/Menu.css");
        LeadershipMenu.show();

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



	 /**
 	 * Creates a VBox pane for sidebar navigation.
 	 * @return the VBox to be used for the sidebar menu navigation.
 	 */
	public VBox addVBox(){
		
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(SIDEBAR_PADDING));
		vbox.setSpacing(SIDEBAR_SPACING);
		vbox.setId("leftVBox");

		//Create the root treeView for all the leafs
		//Create TreeView Menu that changes scene in center of border
        TreeItem<String> root = new TreeItem<String>("CLAS Leadership Tables");
        root.setExpanded(true);

		TreeItem<String> qualNode = new TreeItem<String>("Leadership Qualities");
        TreeItem<String> styleNode = new TreeItem<String>("Leadership Styles");
        TreeItem<String> qualQuestionNode = new TreeItem<String>("Quality Questions");
        TreeItem<String> styleQuestionNode = new TreeItem<String>("Style Questions");		
		root.getChildren().addAll(qualNode, styleNode, qualQuestionNode, styleQuestionNode);
		
		TreeItem<String> qualAdd = new TreeItem<String>(qualAddPane.getTitle());
		TreeItem<String> qualEdit = new TreeItem<String>(qualEditPane.getTitle());
		TreeItem<String> qualReport = new TreeItem<String>(qualReportPane.getTitle());
		qualNode.getChildren().addAll(qualAdd, qualEdit, qualReport);

		TreeItem<String> styleAdd = new TreeItem<String>("Add Leadership Style");
		TreeItem<String> styleEdit = new TreeItem<String>("Edit Leadership Styles");
		TreeItem<String> styleReport = new TreeItem<String>("Leadership Style Report");
		styleNode.getChildren().addAll(styleAdd, styleEdit, styleReport);

		TreeItem<String> qualQuestionAdd = new TreeItem<String>("Add Quality Question");
		TreeItem<String> qualQuestionEdit = new TreeItem<String>("Edit Quality Questions");
		TreeItem<String> qualQuestionReport = new TreeItem<String>("Quality Question Report");
		qualQuestionNode.getChildren().addAll(qualQuestionAdd, qualQuestionEdit, qualQuestionReport);

		TreeItem<String> styleQuestionAdd = new TreeItem<String>("Add Style Question");
		TreeItem<String> styleQuestionEdit = new TreeItem<String>("Edit Style Questions");
		TreeItem<String> styleQuestionReport = new TreeItem<String>("Style Question Report");
		styleQuestionNode.getChildren().addAll(styleQuestionAdd, styleQuestionEdit, styleQuestionReport);

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
						qualEditPane.refreshTable();
	                }
                }
            });
		
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

	public ObservableList<Quality> getQualityData(){
			return qualityData;
	}


}
