package src.main.java.clas.leadership;

import javafx.beans.property.SimpleStringProperty;
import java.util.TreeMap;


/*
 * Organization Object that stores information about the organizations into the database.
 */
public class Quality{
	
	//SimpleStringProperty is a javafx conversion that is taken in from the table and is require
	private SimpleStringProperty qualityCode;
	private SimpleStringProperty qualityTitle;
	private SimpleStringProperty qualityDes;
	private static TreeMap<String, Quality> qualMap = new TreeMap<String, Quality>();

	/*
	 * Create the Organization object to store the organization information into the database.
	 */
	public Quality(final String qualityCode, 
			 final String qualityTitle, final String qualityDes){
				//Convert to simple string property for table manipulation
				this.qualityCode = new SimpleStringProperty(qualityCode);
				this.qualityTitle = new SimpleStringProperty(qualityTitle);
				this.qualityDes = new SimpleStringProperty(qualityDes);

				Quality quality = qualMap.get(qualityCode);
		        //if not inmap, instantiate and add to map
		        if (quality == null) {
		        	qualMap.put(qualityCode, this);
		        }
	}//END Organization Constructor


	//Create getters and setters for modification later
	public final String getQualityCode(){
			return qualityCode.get();	
	}
	public final void setQualityCode(final String qualityCode){
			this.qualityCode.set(qualityCode);	
	}

	public final String getQualityTitle(){
			return qualityTitle.get(); 		
	}
	public final void setQualityTitle(final String qualityTitle){
			this.qualityTitle.set(qualityTitle);	
	}

	public final String getQualityDes(){
			return qualityDes.get(); 		
	}
	public final void setQualityDes(final String qualityDes){
			this.qualityDes.set(qualityDes);	
	}

	public static TreeMap<String, Quality> getQualMap(){
		return qualMap;
	}

	public static Quality getQuality (final String qualityCode){
		return qualMap.get(qualityCode);
	}
	
	public static void addMap(String key, Quality value){
		qualMap.put(key, value);
	}
	public static void removeMap(String key){
		qualMap.remove(key);
	}

	public static String lastCode(){
		return qualMap.lastKey();
	}
}



