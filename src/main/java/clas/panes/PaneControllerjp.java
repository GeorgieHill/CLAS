package src.main.java.clas.panes;

import java.util.HashMap;
import java.util.Stack;

import javafx.scene.layout.VBox;

public class PaneControllerjp{
	
		private HashMap<String, VBox> paneMap;
	
		public PaneControllerjp(){
				paneMap = new HashMap<String, VBox>();
		}
		
		/**
 		* Method to get a new pane using Pane parameter.
 		* @param title(key in the paneMap) that will be returned after getting it
 		* @return Returns the content of the key pane.
 		*/
		public VBox goToPane(String key){
				return paneMap.get(key);
		}
		/**
	 	* Method to add a record to the hashmap of panes.
	 	* @param key The title of the pane to be added to the map.
	 	* @param value The pane being added to the map.
	 	*/
		public void addPane(String key, VBox value){
				paneMap.put(key,value);
		}

		/**
	 	* Method to remove a record from the hashmap of panes.
	 	* @param key The title of the pane to be removed from the map.
	 	*/
		public void removePane(String key){
				paneMap.remove(key);
		}		




}
