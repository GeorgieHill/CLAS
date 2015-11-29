package src.main.java.clas.panes;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public interface PaneUI {

	/**
 	* Method to access the VBox created.
 	* @return Returns the vbox.
 	*/
	public VBox getPane();
	
	/**
 	* Method to access label for this object.
 	*/
	public Label getLabel();

	/**
 	* Method to set the label for this object.
 	* @param label The new label for this object.
 	*/
	public void setLabel (final Label label);
	
	/**
 	* Method to access Title for this object.
 	*/
	public static String getTitle(){
		
		return "";
	}

}
