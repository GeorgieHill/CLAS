package src.main.java.clas.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import src.main.java.clas.individual.IndividualMenu;
import src.main.java.clas.leadership.LeadershipMenu;
import src.main.java.clas.organization.OrganizationMenu;
import src.main.java.clas.survey.MainMenu;

/**
 * Class to define main navigation menu at top of screens.
 */
public class NavigationMain {

	private static HBox hbox;
	private Button homeBtn;
	private Button leadershipBtn;
	private Button individualBtn;
	private Button organizationalBtn;
	private MainMenu mainMenu;
	private LeadershipMenu leadershipMenu;
	private OrganizationMenu orgMenu;
	private IndividualMenu indMenu;

	public NavigationMain(final Stage currentStage) {

		// Set up the HBox that will hold the navigation menus
		hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);

		// setId for css
		hbox.setId("topHBox");

		// Set up the button that takes user to main menu
		homeBtn = new Button("Home");
		homeBtn.setPrefSize(120, 20);
		homeBtn.setOnAction(new EventHandler<ActionEvent>() {
			// ADD validation here for later usage
			@Override
			public void handle(ActionEvent e) {

				mainMenu = new MainMenu();
				currentStage.close();
			}
		});

		// Set up the button that takes user to leadership menu
		leadershipBtn = new Button("Leadership");
		leadershipBtn.setPrefSize(120, 20);
		leadershipBtn.setOnAction(new EventHandler<ActionEvent>() {
			// ADD validation here for later usage
			@Override
			public void handle(ActionEvent e) {

				leadershipMenu = new LeadershipMenu();
				currentStage.close();
			}
		});

		// Set up the button that takes user to organization menu
		organizationalBtn = new Button("Organization");
		organizationalBtn.setPrefSize(120, 20);
		organizationalBtn.setOnAction(new EventHandler<ActionEvent>() {
			// ADD validation here for later usage
			@Override
			public void handle(ActionEvent e) {

				orgMenu = new OrganizationMenu();
				currentStage.close();
			}
		});

		// Set up the button that takes user to individual menu
		individualBtn = new Button("Individual");
		individualBtn.setPrefSize(120, 20);
		individualBtn.setOnAction(new EventHandler<ActionEvent>() {
			// *******
			// ADD validation here for later usage
			// *******
			@Override
			public void handle(ActionEvent e) {

				indMenu = new IndividualMenu();
				currentStage.close();
			}
		});

		// Add all navigation buttons to HBox
		hbox.getChildren().addAll(homeBtn, leadershipBtn, organizationalBtn,
				individualBtn);

		// Add help icon to navigation menu
		addStackPane(hbox);
	}

	/**
	 * Method to return top menu HBox.
	 * 
	 * @return Returns the HBox containing the top menu created in this class.
	 */
	public final HBox getTopMenu() {
		return hbox;
	}

	/**
	 * StackPane and help logo are created to be displayed on top menu.
	 * 
	 * @param hb The HBox into which the help logo will be placed.
	 */
	public final void addStackPane(final HBox hb) {
		
		// Create StackPane
		StackPane stack = new StackPane();
		
		//Create icon and stylize
		Rectangle helpIcon = new Rectangle(30.0, 25.0);
		// Fills the icon with colors
		helpIcon.setFill(new LinearGradient(0, 0, 0, 1, true,
				CycleMethod.NO_CYCLE, new Stop[] {
						new Stop(0, Color.web("#4977A3")),
						new Stop(0.5, Color.web("#B0C6DA")),
						new Stop(1, Color.web("#9CB6CF")), }));
		helpIcon.setStroke(Color.web("#D0E6FA"));
		helpIcon.setArcHeight(3.5);
		helpIcon.setArcWidth(3.5);

		// Set a question mark as the text
		Text helpText = new Text("?");
		helpText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		helpText.setFill(Color.WHITE);
		helpText.setStroke(Color.web("#7080A0"));

		// Add icon and ? mark into the StackPane
		stack.getChildren().addAll(helpIcon, helpText);
		stack.setAlignment(Pos.CENTER_RIGHT); // Right-justify nodes in stack
		StackPane.setMargin(helpText, new Insets(0, 10, 0, 0)); // Center "?"

		// Add stackPane to the hBox containing the navigation menu items
		hb.getChildren().add(stack);
		
		// Give stack extra space as needed
		HBox.setHgrow(stack, Priority.ALWAYS);
	}

}