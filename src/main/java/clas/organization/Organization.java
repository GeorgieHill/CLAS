package src.main.java.clas.organization;

import javafx.beans.property.SimpleStringProperty;
import src.main.java.clas.Entity;

/*
 * Organization Object that stores information about the organizations into the database.
 */
public class Organization extends Entity {

	// Organization object properties
	private SimpleStringProperty id;
	private SimpleStringProperty orgName;
	private SimpleStringProperty orgPhone;
	private SimpleStringProperty orgEmail;
	private SimpleStringProperty orgAddress;
	private SimpleStringProperty orgCityCode;
	private SimpleStringProperty orgStateCode;
	private SimpleStringProperty orgZip;
	private SimpleStringProperty orgCountryCode;
	private SimpleStringProperty orgContact;
	private SimpleStringProperty orgContactPhone;
	private SimpleStringProperty orgContactEmail;

	/*
	 * Create the Organization object to store the organization information into
	 * the database.
	 */
	public Organization(final String id, final String orgName,
			final String orgPhone, final String orgEmail,
			final String orgAddress, final String orgCityCode,
			final String orgStateCode, final String orgZip,
			final String orgCountryCode, final String orgContact,
			final String orgContactPhone, final String orgContactEmail) {
		
		// Convert to simple string property for table manipulation
		this.id = new SimpleStringProperty(id);
		this.orgName = new SimpleStringProperty(orgName);
		this.orgPhone = new SimpleStringProperty(orgPhone);
		this.orgEmail = new SimpleStringProperty(orgEmail);
		this.orgAddress = new SimpleStringProperty(orgAddress);
		this.orgCityCode = new SimpleStringProperty(orgCityCode);
		this.orgStateCode = new SimpleStringProperty(orgStateCode);
		this.orgZip = new SimpleStringProperty(orgZip);
		this.orgCountryCode = new SimpleStringProperty(orgCountryCode);
		this.orgContact = new SimpleStringProperty(orgContact);
		this.orgContactPhone = new SimpleStringProperty(orgContactPhone);
		this.orgContactEmail = new SimpleStringProperty(orgEmail);
		
	}// END Organization Constructor

	// Create getters and setters for modification later
	
	/*included in Entity.java
	 * public final String getOrgCode() {
		return orgCode.get();
	}

	public final void setOrgCode(final String orgCode) {
		this.orgCode.set(orgCode);
	}
	*/

	public final String getOrgName() {
		return orgName.get();
	}

	public final void setOrgName(final String orgName) {
		this.orgName.set(orgName);
	}

	public final String getPhone() {
		return orgPhone.get();
	}

	public final void setPhone(final String orgPhone) {
		this.orgPhone.set(orgPhone);
	}

	public final String getEmail() {
		return orgEmail.get();
	}

	public final void setEmail(final String orgEmail) {
		this.orgEmail.set(orgEmail);
	}

	public final String getAddress() {
		return orgAddress.get();
	}

	public final void setAddress(final String orgAddress) {
		this.orgAddress.set(orgAddress);
	}

	public final String getCityCode() {
		return orgCityCode.get();
	}

	public final void setCityCode(final String orgCityCode) {
		this.orgCityCode.set(orgCityCode);
	}

	public final String getStateCode() {
		return orgStateCode.get();
	}

	public final void setStateCode(final String orgStateCode) {
		this.orgStateCode.set(orgStateCode);
	}

	public final String getZip() {
		return orgZip.get();
	}

	public final void setZip(final String orgZip) {
		this.orgZip.set(orgZip);
	}

	public final String getCountryCode() {
		return orgCountryCode.get();
	}

	public final void setCountryCode(final String orgCountryCode) {
		this.orgCountryCode.set(orgCountryCode);
	}

	public final String getContactName() {
		return orgContact.get();
	}

	public final void setContactName(final String orgContact) {
		this.orgContact.set(orgContact);
	}

	public final String getContactPhone() {
		return orgContactPhone.get();
	}

	public final void setContactPhone(final String orgContactPhone) {
		this.orgContactPhone.set(orgContactPhone);
	}

	public final String getContactEmail() {
		return orgContactEmail.get();
	}

	public final void setContactEmail(final String orgContactEmail) {
		this.orgContactEmail.set(orgContactEmail);
	}
}
