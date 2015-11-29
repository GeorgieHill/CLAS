package src.main.java.clas.individual;

import javafx.beans.property.SimpleStringProperty;
import src.main.java.clas.Entity;

/*
Individual Object that stores information about the individuals into the database
*/
public class Individual extends Entity {
	
	//SimpleStringProperty required for table
	
	private SimpleStringProperty id;
	private SimpleStringProperty indOrgCode;
	private SimpleStringProperty indDeptCode;
	private SimpleStringProperty indFirstName;
	private SimpleStringProperty indLastName;
	private SimpleStringProperty indPhone;
	private SimpleStringProperty indEmail;
	private SimpleStringProperty indAddress;
	private SimpleStringProperty indCityCode;
	private SimpleStringProperty indStateCode;
	private SimpleStringProperty indZipCode;
	private SimpleStringProperty indCountryCode;
	private SimpleStringProperty indPassword;

	//Create the Individual object to store the individual information into the database
	public Individual(String id, String indOrgCode, String indDeptCode, 
					   String indFirstName, String indLastName, String indPhone, 
					   String indEmail, String indAddress, String indCityCode, 
					   String indStateCode, String indZipCode, String indCountryCode, 
					   String indPassword){
				//Convert to simple string property for table manipulation
				this.id = new SimpleStringProperty(id);
				this.indOrgCode = new SimpleStringProperty(indOrgCode);
				this.indDeptCode = new SimpleStringProperty(indDeptCode);
				this.indFirstName = new SimpleStringProperty(indFirstName);
				this.indLastName = new SimpleStringProperty(indLastName);
				this.indPhone = new SimpleStringProperty(indPhone);
				this.indEmail = new SimpleStringProperty(indEmail);
				this.indAddress = new SimpleStringProperty(indAddress);
				this.indCityCode = new SimpleStringProperty(indCityCode);
				this.indStateCode = new SimpleStringProperty(indStateCode);
				this.indZipCode = new SimpleStringProperty(indZipCode);
				this.indCountryCode = new SimpleStringProperty(indCountryCode);
				this.indPassword = new SimpleStringProperty(indPassword);
	}//END Individual Constructor

	//Create getters and setters for modification later
	/*included in Entity.java
	  public String getID(){
	 
			return id.get();	
	}
	public void setID(String id){
			this.id.set(id);	
	}
	*/

	public String getOrganization(){
			return indOrgCode.get();	
	}
	public void setOrganization(String indOrgCode){
			this.indOrgCode.set(indOrgCode);
	}

	public String getDepartment(){
			return indDeptCode.get(); 		
	}
	public void setDepartment(String indDeptCode){
			this.indDeptCode.set(indDeptCode);	
	}

	public String getFirstName(){
			return indFirstName.get();
	}
	public void setFirstName(String indFirstName){
			this.indFirstName.set(indFirstName);
	}

	public String getLastName(){
			return indLastName.get();	
	}
	public void setLastName(String indLastName){
			this.indLastName.set(indLastName);	
	}

	public String getPhone(){
			return indPhone.get();	
	}
	public void setPhone(String indPhone){
			this.indPhone.set(indPhone);	
	}

	public String getEmail(){
			return indEmail.get();	
	}
	public void setEmail(String indEmail){
			this.indEmail.set(indEmail);	
	}

	public String getAddress(){
			return indAddress.get();
	}
	public void setAddress(String indAddress){
			this.indAddress.set(indAddress);
	}

	public String getCityCode(){
			return indCityCode.get();
	}
	public void setCityCode(String indCityCode){
			this.indCityCode.set(indCityCode);
	}

	public String getStateCode(){
			return indStateCode.get();
	}
	public void setStateCode(String indStateCode){
			this.indStateCode.set(indStateCode);		
	}

	public String getZipCode(){
			return indZipCode.get();
	}
	public void setZipCode(String indZipCode){
			this.indZipCode.set(indZipCode);
	}

	public String getCountryCode(){
			return indCountryCode.get();		
	}
	public void setCountryCode(String indCountryCode){
			this.indCountryCode.set(indCountryCode);
	}

	public String getPassword(){
			return indPassword.get();		
	}
	public void setPassword(String indPassword){
			this.indPassword.set(indPassword);		
	}
}
