package src.main.java.clas.individual;

import java.util.List;

public class IndividualService {

	private IndividualDao indDao;

	public IndividualService(IndividualDao indDao) {

		this.indDao = indDao;
	}

	/*public Individual addIndividual(String id, String indOrgCode, String indDeptCode,
			String indFirstName, String indLastName, String indPhone,
			String indEmail, String indAddress, String indCityCode,
			String indStateCode, String indZipCode, String indCountryCode,
			String indPassword) {

		Individual ind = new Individual(id, indOrgCode, indDeptCode,
				indFirstName, indLastName, indPhone, indEmail, indAddress,
				indCityCode, indStateCode, indZipCode, indCountryCode, indPassword);
		
		indDao.saveChange(ind);
		
		return ind;
	}
	
	public boolean updateIndividual(String id, String indOrgCode,
			String indDeptCode, String indFirstName, String indLastName,
			String indPhone, String indEmail, String indAddress,
			String indCityCode, String indStateCode, String indZipCode,
			String indCountryCode, String indPassword) {
		
		Individual ind = indDao.getByID(id);
		ind.setOrganization(indOrgCode);
		ind.setDepartment(indDeptCode);
		ind.setFirstName(indFirstName);
		ind.setLastName(indLastName);
		ind.setPhone(indPhone);
		ind.setEmail(indEmail);
		ind.setAddress(indAddress);
		ind.setCityCode(indCityCode);
		ind.setStateCode(indStateCode);
		ind.setZipCode(indZipCode);
		ind.setCountryCode(indCountryCode);
		ind.setPassword(indPassword);
		
		if (indDao.saveChange(ind))
			return true;
		else
			return false;
	}
	
    public boolean deleteIndividual(Individual ind) {
        
    	if(indDao.delete(ind))
    		return true;
    	else
    		return false;
    }

    
    public boolean deleteIndividual(String id) {
        
    	if(indDao.delete(indDao.getById(id)))
    		return true;
    	else 
    		return false;
    }

    
    public List<Individual> getIndividualsByCompany(String id) {
        
    	return indDao.getIndividualsByCompany(id);
    }

   
    public Individual getIndividualById(String id) {
        
    	return userDao.getById(id);
    }
    */
}
