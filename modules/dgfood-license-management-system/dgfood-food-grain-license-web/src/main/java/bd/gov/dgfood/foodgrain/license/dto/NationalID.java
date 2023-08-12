package bd.gov.dgfood.foodgrain.license.dto;

/**
 * 
 * @author Abhijit Ande
 *
 *This Class is used to Map NID Server NationalID JSON Object.
 */
public class NationalID {

	private String applicantName;
	private String fatherName;
	private String motherName;
	private String gender;
	private Address address;
	private String profileDocument;
	
	public String getApplicantName() {
		return applicantName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public String getGender() {
		return gender;
	}
	public Address getAddress() {
		return address;
	}
	public String getProfileDocument() {
		return profileDocument;
	}
}
