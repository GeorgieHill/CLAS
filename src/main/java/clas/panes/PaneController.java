package src.main.java.clas.panes;

import java.util.HashMap;

import javafx.scene.layout.VBox;

/**
 * Abstract super class of pane objects. 
 * Also maintains the hashmap directory of all panes.
 */
 public class PaneController {
	
	private HashMap<String, PaneUI> paneMap;
	private PaneFactory paneFactory;	
	
	public PaneController() {

		// Initial panes so they will be added to the paneMap
		paneFactory = new PaneFactory();
		paneMap = new HashMap<>(paneFactory.initializePanes());
		
	}
	
	/**
 	* Method to get a new pane using a String parameter.
 	* @param pane The title of the new pane that is to be loaded.
 	* @return Returns the content of the new pane.
 	*/
	public VBox goToPane (final String pane){
		return paneMap.get(pane).getPane();

	}

	/**
 	* Method to get a new pane using Pane parameter.
 	* @param pane The new pane that is to be loaded.
 	* @return Returns the content of the new pane.
 	*/
	public VBox goToPane (final PaneUI pane){
		return pane.getPane();
	}

	/**
 	* Method to view the hashmap of panes.
 	* @return Returns the hashmap containing the pane directory.
 	*/
	public HashMap<String, PaneUI> getPaneMap(){
		return paneMap;
	}

	/**
 	* Method to add a record to the hashmap of panes.
 	* @param key The title of the pane to be added to the map.
 	* @param value The pane being added to the map.
 	*/
	public void addMap(String key, PaneUI value){
		paneMap.put(key, value);
	}

	/**
 	* Method to add a record to the hashmap of panes.
 	* @param key The title of the pane to be removed from the map.
 	*/
	public void removeMap(String key){
		paneMap.remove(key);
	}


	//add these: ******************
	//public static void getPaneKey
	//public static void hasKey

}
