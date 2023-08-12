package bd.gov.dgfood.taglib.servlet.taglib;

import com.liferay.asset.kernel.model.AssetCategory;

import java.util.Map;

import bd.gov.dgfood.common.services.model.Address;

public class BasicInformation {

	public String applicantName;
	public String fatherName;
	public String mothername;
	public int gender;
	public int maritalStatus;
	public Address address; 
	public Map<Long, AssetCategory> addressCategories;

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMothername() {
		return mothername;
	}

	public void setMothername(String mothername) {
		this.mothername = mothername;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(int maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Map<Long, AssetCategory> getAddressCategories() {
		return addressCategories;
	}

	public void setAddressCategories(Map<Long, AssetCategory> addressCategories) {
		this.addressCategories = addressCategories;
	}

	public BasicInformation(String applicantName, String fatherName, String mothername, int gender, int maritalStatus) {
		super();
		this.applicantName = applicantName;
		this.fatherName = fatherName;
		this.mothername = mothername;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
	}
	
	public BasicInformation(Address address, Map<Long, AssetCategory> addressCategories)
	{
		super();
		this.address=address;
		this.addressCategories=addressCategories;
	}
	
	public BasicInformation() {
		super();
	}

}
