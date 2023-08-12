package bd.gov.dgfood.taglib.servlet.taglib;

import java.util.Date;

public class NationalIdInformation {

	public String nationalId;
	public String emailAddress;
	public String mobileNumber;
	public Date dateOfBirth;

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public NationalIdInformation(String nationalId, String emailAddress, String mobileNumber, Date dateOfBirth) {
		super();
		this.nationalId = nationalId;
		this.emailAddress = emailAddress;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
	}
	
	public NationalIdInformation() {
		super();
	}

}
