package src.main.java.clas;

import src.main.java.clas.panes.PaneController;
import src.main.java.clas.panes.PaneFactory;
import src.main.java.clas.survey.MainMenu;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Login extends Application {
	
	/**
	 * Main method for limited JavaFX support.
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Start method to launch program.
	 */
	public void start(Stage primaryStage) {
		
		PaneController pc = new PaneController();
		
		primaryStage.setTitle("CLAS Login");
		
		// Create and format gridPane that will hold components of scene
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		// Load the CLAS logo and add to gridPane
		ImageView imageView = new ImageView(new Image(getClass()
				.getResourceAsStream("/resources/images/CLAS_LOGO.png"), 400,
				400, true, true));
		grid.add(imageView, 0, 0, 2, 1);

		// Create username label and text fields
		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);
		TextField userNameField = new TextField();
		
		// Add tooltip indicating required username format
		final Tooltip usrTooltip = new Tooltip();
		usrTooltip.setText("Your username must be \n"
				+ "in format AA-AAA-AAA\n");
		userNameField.setTooltip(usrTooltip);
		
		// Add username text field to gridPane
		grid.add(userNameField, 1, 1);

		// Create password label and text fields
		Label password = new Label("Password:");
		grid.add(password, 0, 2);
		PasswordField passwordField = new PasswordField();
		
		// Add tooltip indicating required password format
		final Tooltip pwdTooltip = new Tooltip();
		pwdTooltip.setText("Your password must be \n"
				+ "at least 8 characters in length\n");
		passwordField.setTooltip(pwdTooltip);
		
		//Add password textfield to gridPane
		grid.add(passwordField, 1, 2);

		// Create sign-in button with action event to allow login and add to gridPane
		Button btn = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);

		// Event handler to handle clicking of sign-in button
		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);
		actiontarget.setId("actiontarget");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			// ******* 
			// ADD validation here for later usage
			// *******
			@Override
			public void handle(ActionEvent e) {
				actiontarget.setFill(Color.FIREBRICK);
				actiontarget.setText("Sign in button pressed");
								
				// Open main menu
				MainMenu MainMenu = new MainMenu();
				primaryStage.close();
			}
		});

		// Create scene to hold gridPane, set to user screen size and add to stage
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		Scene scene = new Scene(grid, screenBounds.getWidth(),
				screenBounds.getHeight());
		primaryStage.setScene(scene);

		// Call css file to format scene
		scene.getStylesheets().add(
				Login.class.getResource("/resources/css/Login.css")
						.toExternalForm());

		primaryStage.show();
	}
}
