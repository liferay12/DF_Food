package bd.gov.dgfood.foodgrain.license.dto;

/**
 * 
 * @author Abhijit Ande
 *
 *This Class is used to Map NID Server Address JSON Object.
 */
public class Address {

	private Region region;
	private District district;
	private Upazila upazila;
	private CityMetropolis cityMetropolis;
	private CityCorporationOrMuncipalty cityCorporationOrMuncipalty;
	private String ward;
	private Union union;
	private int zipCode;
	private String postOffice;
	private String village;
	private String mouzaOrMoholla;
	private String homeAddress;
	
	public Region getRegion() {
		return region;
	}
	public District getDistrict() {
		return district;
	}
	public Upazila getUpazila() {
		return upazila;
	}
	public CityMetropolis getCityMetropolis() {
		return cityMetropolis;
	}
	public CityCorporationOrMuncipalty getCityCorporationOrMuncipalty() {
		return cityCorporationOrMuncipalty;
	}
	public Union getUnion() {
		return union;
	}
	public String getWard() {
		return ward;
	}
	public int getZipCode() {
		return zipCode;
	}
	public String getPostOffice() {
		return postOffice;
	}
	public String getVillage() {
		return village;
	}
	public String getMouzaOrMoholla() {
		return mouzaOrMoholla;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
}
