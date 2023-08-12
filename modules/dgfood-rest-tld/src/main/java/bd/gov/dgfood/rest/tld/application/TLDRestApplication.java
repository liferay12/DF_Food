package bd.gov.dgfood.rest.tld.application;

import com.liferay.asset.kernel.exception.NoSuchCategoryException;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import bd.gov.dgfood.common.util.CategoryUtil;
import bd.gov.dgfood.common.util.validator.DataValidationException;
import bd.gov.dgfood.license.management.system.model.FGLicenseInfo;

/**
 * @author Liferay
 */
@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/tld",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=TLD.Rest" }, service = Application.class)
public class TLDRestApplication extends Application {

	@Override
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Path("/get-nid-details")
	@Produces("text/plain")
	public String validateAndGetNIDDetails(@QueryParam("nationalId") String nationalId,
			@QueryParam("dateOfBirth") String dateOfBirth, @QueryParam("mobileNumber") String mobileNumber) {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		try {

			if (Validator.isNull(nationalId)) {
				throw new DataValidationException("nationalId Cannot be Blank");
			}

			int nidLen = String.valueOf(nationalId).length();

			if (Validator.isNotNull(nidLen)) {
				if (nidLen < 10) {
					throw new DataValidationException("nationalId Cannot be Less than 10");
				}
				if (nidLen > 17) {
					throw new DataValidationException("nationalId Cannot be Greater than 17");
				}
			}

			jsonObject.put("isNationalIdValid", StringPool.TRUE);

			// To Do:
			// Need to check logic as per new understanding
			// FGLicense fgLicense =
			// FGLicenseLocalServiceUtil.getFGLicenseForNationalId(nationalId);
			FGLicenseInfo fgLicenseInfo = null;

			if (Validator.isNotNull(fgLicenseInfo)) {
				jsonObject.put("isDbPresent", StringPool.TRUE);
				jsonObject.put("message", "NID Number is already present in the Database.");
			} else {

				JSONObject obj = JSONFactoryUtil.createJSONObject();

				obj.put("applicantName", "");
				obj.put("fatherName", "");
				obj.put("motherName", "");
				obj.put("permanentRegion", "");
				obj.put("permanentZilla", "");
				obj.put("permanentUpazilla", "");
				obj.put("permanentVillage", "");
				obj.put("permanentUnion", "");
				obj.put("permanentWard", "");
				obj.put("permanentZipcode", "");

				jsonArray.put(obj);

				jsonObject.put("details", jsonArray);
			}
		} catch (

		Exception exception) {
			jsonObject.put("isNationalIdValid", StringPool.FALSE);
			jsonObject.put("message", exception.getMessage());
		}
		return jsonObject.toString();
	}

	@GET
	@Path("/get-all-categories")
	@Produces("text/plain")
	public String getAllCategories(@QueryParam("categoryId") long categoryId,
			@QueryParam("languageId") String languageId) {

		List<AssetCategory> categories = new ArrayList<>();

		JSONArray categoryArray = JSONFactoryUtil.createJSONArray();
		JSONObject categoryObject = JSONFactoryUtil.createJSONObject();

		try {

			if (Validator.isNull(categoryId)) {
				throw new DataValidationException("categoryId Cannot be Blank");
			}

			Locale locale = null;

			if (Validator.isNotNull(languageId)) {
				locale = LocaleUtil.fromLanguageId(languageId);
			} else {
				locale = LocaleUtil.fromLanguageId("en_US");
			}

			// Service call using query to get all the matching categories.
			categories = CategoryUtil.fetchCategoriesbyCategoryId(categoryId);

			logger.info("Category Size - " + categories.size());

			for (AssetCategory assetCategory : categories) {

				JSONObject obj = JSONFactoryUtil.createJSONObject();

				obj.put("id", assetCategory.getCategoryId());
				obj.put("name", assetCategory.getTitle(locale));

				categoryArray.put(obj);
			}

			categoryObject.put("isCategoryIdValid", StringPool.TRUE);
			categoryObject.put("options", categoryArray);

		} catch (NoSuchCategoryException nscException) {

			nscException.printStackTrace();
			categoryObject.put("isCategoryIdValid", StringPool.FALSE);
			categoryObject.put("message", nscException.getMessage());

		} catch (Exception exception) {

			exception.printStackTrace();
			categoryObject.put("isCategoryIdValid", StringPool.FALSE);
			categoryObject.put("message", exception.getMessage());
		}

		return categoryObject.toString();
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());

}