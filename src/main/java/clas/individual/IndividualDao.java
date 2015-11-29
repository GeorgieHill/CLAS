package src.main.java.clas.individual;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import src.main.java.clas.DaoManager;
import src.main.java.clas.database.DbConnectionFactory;
import src.main.java.clas.database.DbUtil;

public class IndividualDao extends DaoManager {

		private Connection connection;
		private Statement statement;

	public IndividualDao() {
	}

	public void addIndividual(String IndCode, String IndOrgCode,
			String IndDeptCode, String IndFirstName, String IndLastName,
			String IndPhone, String IndEmail, String IndAddress,
			String IndCityCode, String IndStateCode, String IndZipCode,
			String IndCountryCode, String IndPassword) throws SQLException {
		
		String sql = "INSERT INTO CL_Individuals_BR " + "VALUES('" + IndCode
				+ "','" + IndOrgCode + "','" + IndDeptCode + "','"
				+ IndFirstName + "','" + IndLastName + "','" + IndPhone + "','"
				+ IndEmail + "','" + IndAddress + "','" + IndCityCode + "','"
				+ IndStateCode + "','" + IndZipCode + "','" + IndCountryCode
				+ "','" + IndPassword + "')";
		
		statement=connection.createStatement();
		statement.executeUpdate(sql);
	}

	public boolean updateIndividual(String IndCode, String IndOrgCode,
			String IndDeptCode, String IndFirstName, String IndLastName,
			String IndPhone, String IndEmail, String IndAddress,
			String IndCityCode, String IndStateCode, String IndZipCode,
			String IndCountryCode, String IndPassword) throws SQLException {
		
		String query = "UPDATE CL_Individuals_BR " + "SET IndOrgCode = '"
				+ IndOrgCode + "', IndDeptCode = '" + IndDeptCode
				+ "', IndFirstName = '" + IndFirstName + "', IndLastName = '"
				+ IndLastName + "', IndPhone = '" + IndPhone
				+ "', IndEmail = '" + IndEmail + "', IndAddress = '"
				+ IndAddress + "', IndCityCode = '" + IndCityCode
				+ "', IndStateCode = '" + IndStateCode + "', IndZipCode = '"
				+ IndZipCode + "', IndCountryCode = '" + IndCountryCode
				+ "', IndPassword = '" + IndPassword + "' WHERE IndCode = '"
				+ IndCode + "'";
		
		ResultSet rs = null;
		Individual ind = null;
		
		try {
			connection = DbConnectionFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		
		// add true false validation of update
		return true;

	}

	/*
	public boolean deleteIndividual() {
		// Implement delete individual here
		// Return true on success, false on failure
		return true;
	}

	public Individual findIndividual() {
		// Implement find an individual here using supplied
		// argument values as search criteria
		// Return a Transfer Object if found,
		// return null on error or if not found
	}

	public Collection selectIndividualsTO() {
		// implement search inds here using the
		// supplied criteria.
		// Alternatively, implement to return a Collection
		// of Transfer Objects.
	}
	*/

}
