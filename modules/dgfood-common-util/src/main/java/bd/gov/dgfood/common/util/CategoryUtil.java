package bd.gov.dgfood.common.util;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import bd.gov.dgfood.common.services.model.Address;

/**
 * The purpose of this class is to mention category related activities
 *
 * Accessibility : Throughout application
 *
 *
 * @author Ashish Singh
 * 
 */

public class CategoryUtil {

	/**
	 * Returns the List of Categories on the basis of Vocabulary Id
	 * 
	 * @param vocabularyId
	 * @return
	 */
	public static List<AssetCategory> fetchCategoriesbyVocabularyId(long vocabularyId) {
		if (Validator.isNotNull(vocabularyId)) {
			AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil.fetchAssetVocabulary(vocabularyId);
			return assetVocabulary.getCategories();
		}
		return null;
	}

	/**
	 * Returns the List of Categories on the basis of Vocabulary Name
	 * 
	 * @param themeDisplay
	 * @param vocabularyName
	 * @return
	 * @throws PortalException
	 */
	public static List<AssetCategory> fetchCategoriesbyVocabularyName(ThemeDisplay themeDisplay, String vocabularyName)
			throws PortalException {
		if (Validator.isNotNull(vocabularyName)) {
			AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil
					.getGroupVocabulary(themeDisplay.getScopeGroupId(), vocabularyName);
			return assetVocabulary.getCategories();
		}
		return null;
	}

	/**
	 * Returns the List of Categories on the basis of Category Id which behaves as
	 * we parent id & vocabulary name.
	 * 
	 * @param themeDisplay
	 * @param vocabularyName
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public static List<AssetCategory> fetchCategoriesbyVocabularyNameAndParentId(ThemeDisplay themeDisplay,
			String vocabularyName, long parentId) throws Exception {
		if (Validator.isNotNull(vocabularyName)) {
			AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil
					.getGroupVocabulary(themeDisplay.getScopeGroupId(), vocabularyName);
			return AssetCategoryLocalServiceUtil.getVocabularyCategories(parentId, assetVocabulary.getVocabularyId(),
					-1, -1, null);
		}
		return null;
	}

	/**
	 * Returns the List of Categories on the basis of Category Id which behaves as
	 * we parent id.
	 * 
	 * @param categoryId
	 * @return
	 * @throws Exception
	 */
	public static List<AssetCategory> fetchCategoriesbyCategoryId(long categoryId) throws Exception {
		if (Validator.isNotNull(categoryId)) {
			AssetCategory category = AssetCategoryLocalServiceUtil.fetchAssetCategory(categoryId);
			return AssetCategoryLocalServiceUtil.getVocabularyCategories(categoryId, category.getVocabularyId(), -1, -1,
					null);
		}
		return null;
	}

	public static String fetchCategoryNamebyCategoryId(long categoryId, Locale locale) {
		AssetCategory assetCategory = AssetCategoryLocalServiceUtil.fetchAssetCategory(categoryId);
		return assetCategory.getTitle(locale);
	}

	/**
	 * Return the List of Asset category for the given list of Asset Category Ids
	 * 
	 * @param categoriesIdList
	 * @return List<AssetCategory>
	 */
	public static List<AssetCategory> fetchCategoriesList(List<Long> categoriesIdList) {
		DynamicQuery categoriesDynamicQuery = AssetCategoryLocalServiceUtil.dynamicQuery()
				.add(RestrictionsFactoryUtil.in("categoryId", categoriesIdList));
		return AssetCategoryLocalServiceUtil.dynamicQuery(categoriesDynamicQuery);
	}

	/**
	 * To get the Localized naems for the given Asset Category List
	 * 
	 * @param assetCategoriesList
	 * @return Map<Long, JSONObject>
	 */
	public static Map<Long, JSONObject> getAssetCategoryLocalizedNames(List<AssetCategory> assetCategoriesList) {
		Map<Long, JSONObject> addressCategoryLocalizedNames = new HashMap<>();

		assetCategoriesList.forEach((addressCategory) -> {

			JSONObject addressLocalizedNames = JSONFactoryUtil.createJSONObject();
			addressLocalizedNames.put("en_US", addressCategory.getTitle("en_US"));
			addressLocalizedNames.put("bn_BD", addressCategory.getTitle("bn_BD"));

			addressCategoryLocalizedNames.put(addressCategory.getCategoryId(), addressLocalizedNames);
		});

		return addressCategoryLocalizedNames;
	}

	/**
	 * Get the Asset Categories map for the given lit of addresses Asset Category Id
	 * is the key for the map entry
	 * 
	 * @param addressList
	 * @return
	 */
	public static Map<Long, AssetCategory> getAddressCategories(List<Address> addressList) {
		Map<Long, AssetCategory> assetCategoriesMap = new HashMap<>();
		if (Validator.isNull(addressList)) {
			return assetCategoriesMap;
		}

		List<Long> addressAssetCategoryIdsList = new ArrayList<>();
		for (Address address : addressList) {
			addressAssetCategoryIdsList.addAll(Arrays.asList(address.getRegion(), address.getDistrict(),
					address.getUpazilla(), address.getCityCorporationOrMunicipality(), address.getUnionOrWard()));
		}

		List<AssetCategory> addressCategories = CategoryUtil.fetchCategoriesList(addressAssetCategoryIdsList);

		if (Validator.isNotNull(addressCategories)) {
			addressCategories.forEach((addressCategory) -> {
				assetCategoriesMap.put(addressCategory.getCategoryId(), addressCategory);
			});
		}

		return assetCategoriesMap;
	}
}
