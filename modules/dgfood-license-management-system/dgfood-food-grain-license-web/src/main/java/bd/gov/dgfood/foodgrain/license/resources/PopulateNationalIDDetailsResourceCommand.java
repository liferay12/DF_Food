package bd.gov.dgfood.foodgrain.license.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;

import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.util.constants.AddressConstants;
import bd.gov.dgfood.common.util.constants.ParameterConstants;
import bd.gov.dgfood.common.util.validator.DataValidationException;
import bd.gov.dgfood.common.util.validator.FormValidator;
import bd.gov.dgfood.foodgrain.license.constants.FoodGrainLicensePortletKeys;
import bd.gov.dgfood.foodgrain.license.dto.Address;
import bd.gov.dgfood.foodgrain.license.dto.CityCorporationOrMuncipalty;
import bd.gov.dgfood.foodgrain.license.dto.CityMetropolis;
import bd.gov.dgfood.foodgrain.license.dto.District;
import bd.gov.dgfood.foodgrain.license.dto.NationalID;
import bd.gov.dgfood.foodgrain.license.dto.Region;
import bd.gov.dgfood.foodgrain.license.dto.Union;
import bd.gov.dgfood.foodgrain.license.dto.Upazila;

/**
 * 
 * @author Abhijit Ande
 *
 *This Resource class is used to fetch the NID Server Details to put in Food Grain License Application form on Button Click.
 */

@Component(immediate = true, property = {
		"javax.portlet.name=" + FoodGrainLicensePortletKeys.HOMESCREENFGLICENSE,
		"mvc.command.name=" + FoodGrainLicensePortletKeys.POPULATE_NATIONAL_ID_DETAILS_MVC_RESOURCE_COMMAND 
}, 
service = MVCResourceCommand.class)

public class PopulateNationalIDDetailsResourceCommand extends BaseMVCResourceCommand {

	
	/**
	 * This method is used to fetch the NID Server Details on send it to JSP. 
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 * @return void
	 */
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		//ObjectMapper instantiation
		ObjectMapper objectMapper = new ObjectMapper();
		
		String nationalId = ParamUtil.getString(resourceRequest, ParameterConstants.NATIONAL_ID);
		String mobileNumber = ParamUtil.getString(resourceRequest, ParameterConstants.MOBILE_NUMBER);
		String dateOfBirth = ParamUtil.getString(resourceRequest, ParameterConstants.DATE_OF_BIRTH);
		String sessionKey = ParameterConstants.FGL_SESSION_KEY + nationalId;

		resourceRequest.getPortletSession(true).removeAttribute(sessionKey, PortletSession.PORTLET_SCOPE);
		
		JSONObject populateBasicDetailsReponse = JSONFactoryUtil.createJSONObject();

		boolean isNationalIdValid = false;
		boolean isNationalIdDetailsValid = false;

		String sampleJson = "{\"applicantName\":\"David\",\"fatherName\":\"Mark\",\"motherName\":\"Lina\",\"gender\":\"1\",\"profileDocument\":\"data:image/gif;base64,R0lGODlhPQBEAPeoAJosM//AwO/AwHVYZ/z595kzAP/s7P+goOXMv8+fhw/v739/f+8PD98fH/8mJl+fn/9ZWb8/PzWlwv///6wWGbImAPgTEMImIN9gUFCEm/gDALULDN8PAD6atYdCTX9gUNKlj8wZAKUsAOzZz+UMAOsJAP/Z2ccMDA8PD/95eX5NWvsJCOVNQPtfX/8zM8+QePLl38MGBr8JCP+zs9myn/8GBqwpAP/GxgwJCPny78lzYLgjAJ8vAP9fX/+MjMUcAN8zM/9wcM8ZGcATEL+QePdZWf/29uc/P9cmJu9MTDImIN+/r7+/vz8/P8VNQGNugV8AAF9fX8swMNgTAFlDOICAgPNSUnNWSMQ5MBAQEJE3QPIGAM9AQMqGcG9vb6MhJsEdGM8vLx8fH98AANIWAMuQeL8fABkTEPPQ0OM5OSYdGFl5jo+Pj/+pqcsTE78wMFNGQLYmID4dGPvd3UBAQJmTkP+8vH9QUK+vr8ZWSHpzcJMmILdwcLOGcHRQUHxwcK9PT9DQ0O/v70w5MLypoG8wKOuwsP/g4P/Q0IcwKEswKMl8aJ9fX2xjdOtGRs/Pz+Dg4GImIP8gIH0sKEAwKKmTiKZ8aB/f39Wsl+LFt8dgUE9PT5x5aHBwcP+AgP+WltdgYMyZfyywz78AAAAAAAD///8AAP9mZv///wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACH5BAEAAKgALAAAAAA9AEQAAAj/AFEJHEiwoMGDCBMqXMiwocAbBww4nEhxoYkUpzJGrMixogkfGUNqlNixJEIDB0SqHGmyJSojM1bKZOmyop0gM3Oe2liTISKMOoPy7GnwY9CjIYcSRYm0aVKSLmE6nfq05QycVLPuhDrxBlCtYJUqNAq2bNWEBj6ZXRuyxZyDRtqwnXvkhACDV+euTeJm1Ki7A73qNWtFiF+/gA95Gly2CJLDhwEHMOUAAuOpLYDEgBxZ4GRTlC1fDnpkM+fOqD6DDj1aZpITp0dtGCDhr+fVuCu3zlg49ijaokTZTo27uG7Gjn2P+hI8+PDPERoUB318bWbfAJ5sUNFcuGRTYUqV/3ogfXp1rWlMc6awJjiAAd2fm4ogXjz56aypOoIde4OE5u/F9x199dlXnnGiHZWEYbGpsAEA3QXYnHwEFliKAgswgJ8LPeiUXGwedCAKABACCN+EA1pYIIYaFlcDhytd51sGAJbo3onOpajiihlO92KHGaUXGwWjUBChjSPiWJuOO/LYIm4v1tXfE6J4gCSJEZ7YgRYUNrkji9P55sF/ogxw5ZkSqIDaZBV6aSGYq/lGZplndkckZ98xoICbTcIJGQAZcNmdmUc210hs35nCyJ58fgmIKX5RQGOZowxaZwYA+JaoKQwswGijBV4C6SiTUmpphMspJx9unX4KaimjDv9aaXOEBteBqmuuxgEHoLX6Kqx+yXqqBANsgCtit4FWQAEkrNbpq7HSOmtwag5w57GrmlJBASEU18ADjUYb3ADTinIttsgSB1oJFfA63bduimuqKB1keqwUhoCSK374wbujvOSu4QG6UvxBRydcpKsav++Ca6G8A6Pr1x2kVMyHwsVxUALDq/krnrhPSOzXG1lUTIoffqGR7Goi2MAxbv6O2kEG56I7CSlRsEFKFVyovDJoIRTg7sugNRDGqCJzJgcKE0ywc0ELm6KBCCJo8DIPFeCWNGcyqNFE06ToAfV0HBRgxsvLThHn1oddQMrXj5DyAQgjEHSAJMWZwS3HPxT/QMbabI/iBCliMLEJKX2EEkomBAUCxRi42VDADxyTYDVogV+wSChqmKxEKCDAYFDFj4OmwbY7bDGdBhtrnTQYOigeChUmc1K3QTnAUfEgGFgAWt88hKA6aCRIXhxnQ1yg3BCayK44EWdkUQcBByEQChFXfCB776aQsG0BIlQgQgE8qO26X1h8cEUep8ngRBnOy74E9QgRgEAC8SvOfQkh7FDBDmS43PmGoIiKUUEGkMEC/PJHgxw0xH74yx/3XnaYRJgMB8obxQW6kL9QYEJ0FIFgByfIL7/IQAlvQwEpnAC7DtLNJCKUoO/w45c44GwCXiAFB/OXAATQryUxdN4LfFiwgjCNYg+kYMIEFkCKDs6PKAIJouyGWMS1FSKJOMRB/BoIxYJIUXFUxNwoIkEKPAgCBZSQHQ1A2EWDfDEUVLyADj5AChSIQW6gu10bE/JG2VnCZGfo4R4d0sdQoBAHhPjhIB94v/wRoRKQWGRHgrhGSQJxCS+0pCZbEhAAOw==\",\"address\":{\"region\":{\"key\":\"45089\",\"value\":\"RegionValue\"},\"district\":{\"key\":\"45114\",\"value\":\"DistrictValue\"},\"upazila\":{\"key\":\"45138\",\"value\":\"UpazilaValue\"},\"cityMetropolis\":{\"key\":\"45162\",\"value\":\"CityMetropolisValue\"},\"cityCorporationOrMuncipalty\":{\"key\":\"45903\",\"value\":\"CityCorporationOrMuncipaltyValue\"},\"union\":{\"key\":\"45907\",\"value\":\"UnionValue\"},\"ward\":\"WardValue\",\"zipCode\":\"10203\",\"postOffice\":\"PostOffice\",\"village\":\"VillageValue\",\"mouzaOrMoholla\":\"MouzaOrMohallaValue\",\"homeAddress\":\"HomeAddressValue\"}}";

		if(Validator.isNotNull(sampleJson)) {

			isNationalIdValid = true;

			try {

				// Deserialization into the `NationalID` class
				NationalID nationalIdObj = objectMapper.readValue(sampleJson, NationalID.class);

				Address address = nationalIdObj.getAddress();
				Region region = address.getRegion();
				District district = address.getDistrict();
				Upazila upazila = address.getUpazila();
				CityMetropolis cityMetropolis = address.getCityMetropolis();
				CityCorporationOrMuncipalty cityCorporationOrMuncipalty = address.getCityCorporationOrMuncipalty();
				Union union = address.getUnion();

				if (Validator.isNotNull(nationalIdObj) && Validator.isNotNull(address)) {

					try {

						FormValidator.validateNationalIdDetails(nationalIdObj.getApplicantName(), nationalIdObj.getFatherName(), nationalIdObj.getMotherName(), 
								Integer.parseInt(nationalIdObj.getGender()), Long.parseLong(region.getKey()), Long.parseLong(district.getKey()), Long.parseLong(upazila.getKey()), 
								Long.parseLong(cityMetropolis.getKey()), Long.parseLong(cityCorporationOrMuncipalty.getKey()), Long.parseLong(union.getKey()), address.getVillage(), 
								address.getWard(), address.getZipCode(), address.getPostOffice(), address.getMouzaOrMoholla(), address.getHomeAddress());

						isNationalIdDetailsValid = true;
						populateBasicDetailsReponse = objectToJSON(populateBasicDetailsReponse, nationalIdObj, address, region, district, upazila, cityMetropolis, cityCorporationOrMuncipalty, union);

						resourceRequest.getPortletSession(true).setAttribute(sessionKey, sampleJson, PortletSession.PORTLET_SCOPE);
						
					}catch(DataValidationException dataValidationException) {
						logger.error("Exception occured while validating mapped json object: " + dataValidationException.getMessage());
						if (logger.isDebugEnabled()) {
							dataValidationException.printStackTrace();
						}
					}
				}
			}catch(JsonProcessingException jsonException) {
				logger.error("Exception occured while mapping json to object: " + jsonException.getMessage());
				if (logger.isDebugEnabled()) {
					jsonException.printStackTrace();
				}
			}
		}

		try {
			populateBasicDetailsReponse.put("isNationalIdValid", isNationalIdValid);
			populateBasicDetailsReponse.put("isNationalIdDetailsValid", isNationalIdDetailsValid);
			resourceResponse.getWriter().write(populateBasicDetailsReponse.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private JSONObject objectToJSON(JSONObject populateBasicDetailsReponse, NationalID nationalIdObj, Address address, Region region, District district, Upazila upazila,
			CityMetropolis cityMetropolis, CityCorporationOrMuncipalty cityCorporationOrMuncipalty, Union union) {

		JSONObject basicDetailsReponse = JSONFactoryUtil.createJSONObject();
		JSONObject addressDetailsReponse = JSONFactoryUtil.createJSONObject();
		JSONObject addressDropdownReponse = JSONFactoryUtil.createJSONObject();
		JSONObject regionDropdownReponse = JSONFactoryUtil.createJSONObject();
		JSONObject districtDropdownReponse = JSONFactoryUtil.createJSONObject();
		JSONObject upazilaDropdownReponse = JSONFactoryUtil.createJSONObject();
		JSONObject cityMetropolisDropdownReponse = JSONFactoryUtil.createJSONObject();
		JSONObject cityCorporationMuncipaltyDropdownReponse = JSONFactoryUtil.createJSONObject();
		JSONObject unionDropdownReponse = JSONFactoryUtil.createJSONObject();

		JSONObject addressInputReponse = JSONFactoryUtil.createJSONObject();
		JSONObject profilePreviewReponse = JSONFactoryUtil.createJSONObject();
		JSONObject profileDocumentReponse = JSONFactoryUtil.createJSONObject();

		basicDetailsReponse.put(ParameterConstants.APPLICANT_NAME, nationalIdObj.getApplicantName());
		basicDetailsReponse.put(ParameterConstants.FATHER_NAME, nationalIdObj.getFatherName());
		basicDetailsReponse.put(ParameterConstants.MOTHER_NAME, nationalIdObj.getMotherName());
		basicDetailsReponse.put(ParameterConstants.GENDER, Integer.valueOf(nationalIdObj.getGender()));

		regionDropdownReponse.put(ParameterConstants.KEY, region.getKey());
		regionDropdownReponse.put(ParameterConstants.VALUE, region.getValue());
		addressDropdownReponse.put(AddressConstants.ADDRESS_PERMANENT + ParameterConstants.REGION, regionDropdownReponse);

		districtDropdownReponse.put(ParameterConstants.KEY, district.getKey());
		districtDropdownReponse.put(ParameterConstants.VALUE, district.getValue());
		addressDropdownReponse.put(AddressConstants.ADDRESS_PERMANENT + ParameterConstants.ZILLA, districtDropdownReponse);

		upazilaDropdownReponse.put(ParameterConstants.KEY, upazila.getKey());
		upazilaDropdownReponse.put(ParameterConstants.VALUE, upazila.getValue());
		addressDropdownReponse.put(AddressConstants.ADDRESS_PERMANENT + ParameterConstants.UPAZILA, upazilaDropdownReponse);

		cityMetropolisDropdownReponse.put(ParameterConstants.KEY, cityMetropolis.getKey());
		cityMetropolisDropdownReponse.put(ParameterConstants.VALUE, cityMetropolis.getValue());
		addressDropdownReponse.put(AddressConstants.ADDRESS_PERMANENT + ParameterConstants.CITY_METROPOLIS, cityMetropolisDropdownReponse);

		cityCorporationMuncipaltyDropdownReponse.put(ParameterConstants.KEY, cityCorporationOrMuncipalty.getKey());
		cityCorporationMuncipaltyDropdownReponse.put(ParameterConstants.VALUE, cityCorporationOrMuncipalty.getValue());
		addressDropdownReponse.put(AddressConstants.ADDRESS_PERMANENT + ParameterConstants.CITY_CORPORATION_OR_MUNICIPALITY, cityCorporationMuncipaltyDropdownReponse);

		unionDropdownReponse.put(ParameterConstants.KEY, union.getKey());
		unionDropdownReponse.put(ParameterConstants.VALUE, union.getValue());
		addressDropdownReponse.put(AddressConstants.ADDRESS_PERMANENT + ParameterConstants.UNION, unionDropdownReponse);

		addressDetailsReponse.put("dropdownDetails", addressDropdownReponse);

		addressInputReponse.put(AddressConstants.ADDRESS_PERMANENT + ParameterConstants.VILLAGE, address.getVillage());
		addressInputReponse.put(AddressConstants.ADDRESS_PERMANENT + ParameterConstants.WARD, address.getWard());
		addressInputReponse.put(AddressConstants.ADDRESS_PERMANENT + ParameterConstants.ZIP_CODE, address.getZipCode());
		addressInputReponse.put(AddressConstants.ADDRESS_PERMANENT + ParameterConstants.POST_OFFICE, address.getPostOffice());
		addressInputReponse.put(AddressConstants.ADDRESS_PERMANENT + ParameterConstants.MOUZA_OR_MOHOLLA, address.getMouzaOrMoholla());
		addressInputReponse.put(AddressConstants.ADDRESS_PERMANENT + ParameterConstants.HOUSE_ADDRESS, address.getHomeAddress());

		addressDetailsReponse.put("inputDetails", addressInputReponse);

		profilePreviewReponse.put(ParameterConstants.NID_PROFILE_PHOTOGRAPH, nationalIdObj.getProfileDocument());
		profileDocumentReponse.put(ParameterConstants.PROFILE_PHOTOGRAPH, nationalIdObj.getProfileDocument());

		populateBasicDetailsReponse.put("basicDetails", basicDetailsReponse);
		populateBasicDetailsReponse.put("addressDetails", addressDetailsReponse);
		populateBasicDetailsReponse.put("profilePreview", profilePreviewReponse);
		populateBasicDetailsReponse.put("profileDocument", profileDocumentReponse);

		return populateBasicDetailsReponse;
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());
}
