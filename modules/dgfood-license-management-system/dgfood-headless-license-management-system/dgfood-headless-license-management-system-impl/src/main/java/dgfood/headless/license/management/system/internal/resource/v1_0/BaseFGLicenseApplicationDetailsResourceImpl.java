package dgfood.headless.license.management.system.internal.resource.v1_0;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ResourceActionLocalService;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.filter.ExpressionConvert;
import com.liferay.portal.odata.filter.FilterParser;
import com.liferay.portal.odata.filter.FilterParserProvider;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.batch.engine.VulcanBatchEngineTaskItemDelegate;
import com.liferay.portal.vulcan.batch.engine.resource.VulcanBatchEngineImportTaskResource;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.portal.vulcan.util.ActionUtil;
import com.liferay.portal.vulcan.util.TransformUtil;

import dgfood.headless.license.management.system.dto.v1_0.FGLicenseApplicationDetails;
import dgfood.headless.license.management.system.dto.v1_0.FGLicenseApplicationStatus;
import dgfood.headless.license.management.system.dto.v1_0.FGLicenses;
import dgfood.headless.license.management.system.dto.v1_0.NewFGLicenseApplication;
import dgfood.headless.license.management.system.dto.v1_0.RenewalDuplicateFGLicenseApplication;
import dgfood.headless.license.management.system.dto.v1_0.ResponseDetails;
import dgfood.headless.license.management.system.dto.v1_0.ReviewFGLicenseApplication;
import dgfood.headless.license.management.system.dto.v1_0.TransitionFGLicenseApplication;
import dgfood.headless.license.management.system.dto.v1_0.UpdateFGLicenseApplication;
import dgfood.headless.license.management.system.dto.v1_0.UploadChallanFGLicenseApplication;
import dgfood.headless.license.management.system.resource.v1_0.FGLicenseApplicationDetailsResource;

import java.io.Serializable;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

/**
 * @author Liferay
 * @generated
 */
@Generated("")
@javax.ws.rs.Path("/v1.0")
public abstract class BaseFGLicenseApplicationDetailsResourceImpl
	implements EntityModelResource, FGLicenseApplicationDetailsResource,
			   VulcanBatchEngineTaskItemDelegate<FGLicenseApplicationDetails> {

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/dgfood-headless-license-management-system/v1.0/fglicense-applications'  -u 'test@liferay.com:test'
	 */
	@io.swagger.v3.oas.annotations.Operation(
		description = "Retrieves the fglicenses. Results can be paginated, filtered, and searched."
	)
	@io.swagger.v3.oas.annotations.Parameters(
		value = {
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY,
				name = "keywords"
			),
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY,
				name = "filter"
			),
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY,
				name = "page"
			),
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY,
				name = "pageSize"
			),
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY,
				name = "sort"
			)
		}
	)
	@io.swagger.v3.oas.annotations.tags.Tags(
		value = {
			@io.swagger.v3.oas.annotations.tags.Tag(
				name = "FGLicenseApplicationDetails"
			)
		}
	)
	@javax.ws.rs.GET
	@javax.ws.rs.Path("/fglicense-applications")
	@javax.ws.rs.Produces({"application/json", "application/xml"})
	@Override
	public Page<FGLicenseApplicationDetails> getFglicenseAccountsPage(
			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
			@javax.ws.rs.QueryParam("keywords")
			String keywords,
			@javax.ws.rs.core.Context Filter filter,
			@javax.ws.rs.core.Context Pagination pagination,
			@javax.ws.rs.core.Context Sort[] sorts)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'POST' 'http://localhost:8080/o/dgfood-headless-license-management-system/v1.0/fglicense-applications' -d $'{"acknowledge": ___, "applicantFathersName": ___, "applicantGender": ___, "applicantMobileNumber": ___, "applicantMothersName": ___, "applicantName": ___, "applicantNationalId": ___, "businessAddress": ___, "businessIdentificationNo": ___, "businessName": ___, "businessType": ___, "dateOfBirth": ___, "emailAddress": ___, "maritalStatus": ___, "password": ___, "permanentAddress": ___, "presentAddress": ___, "retypedPassword": ___, "sameAsPermanentAddress": ___, "taxIdentificationNo": ___, "tradeLicenseExpiry": ___, "tradeLicenseIssueCity": ___, "tradeLicenseIssuerCode": ___, "tradeLicenseNumber": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@io.swagger.v3.oas.annotations.Operation(
		description = "Creates a new fg license"
	)
	@io.swagger.v3.oas.annotations.tags.Tags(
		value = {
			@io.swagger.v3.oas.annotations.tags.Tag(
				name = "FGLicenseApplicationDetails"
			)
		}
	)
	@javax.ws.rs.Consumes({"application/json", "application/xml"})
	@javax.ws.rs.Path("/fglicense-applications")
	@javax.ws.rs.POST
	@javax.ws.rs.Produces({"application/json", "application/xml"})
	@Override
	public ResponseDetails postFglicenseApplication(
			NewFGLicenseApplication newFGLicenseApplication)
		throws Exception {

		return new ResponseDetails();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/dgfood-headless-license-management-system/v1.0/fglicense-applications/{nationalId}'  -u 'test@liferay.com:test'
	 */
	@io.swagger.v3.oas.annotations.Operation(
		description = "Retrieves the approved fglicense list based on national id"
	)
	@io.swagger.v3.oas.annotations.Parameters(
		value = {
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.PATH,
				name = "nationalId"
			),
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY,
				name = "foodGrainLicenseNumber"
			)
		}
	)
	@io.swagger.v3.oas.annotations.tags.Tags(
		value = {
			@io.swagger.v3.oas.annotations.tags.Tag(
				name = "FGLicenseApplicationDetails"
			)
		}
	)
	@javax.ws.rs.GET
	@javax.ws.rs.Path("/fglicense-applications/{nationalId}")
	@javax.ws.rs.Produces({"application/json", "application/xml"})
	@Override
	public FGLicenses getFglicenseApplicationsByNationalId(
			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
			@javax.validation.constraints.NotNull
			@javax.ws.rs.PathParam("nationalId")
			String nationalId,
			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
			@javax.ws.rs.QueryParam("foodGrainLicenseNumber")
			String foodGrainLicenseNumber)
		throws Exception {

		return new FGLicenses();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/dgfood-headless-license-management-system/v1.0/fglicense-application'  -u 'test@liferay.com:test'
	 */
	@io.swagger.v3.oas.annotations.Operation(
		description = "Retrieves the fglicense details"
	)
	@io.swagger.v3.oas.annotations.Parameters(
		value = {
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY,
				name = "applicationNumber"
			),
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY,
				name = "foodGrainLicenseNumber"
			),
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY,
				name = "tradeLicenseNumber"
			),
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY,
				name = "applicationType"
			)
		}
	)
	@io.swagger.v3.oas.annotations.tags.Tags(
		value = {
			@io.swagger.v3.oas.annotations.tags.Tag(
				name = "FGLicenseApplicationDetails"
			)
		}
	)
	@javax.ws.rs.GET
	@javax.ws.rs.Path("/fglicense-application")
	@javax.ws.rs.Produces({"application/json", "application/xml"})
	@Override
	public ResponseDetails getFglicenseApplication(
			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
			@javax.validation.constraints.NotNull
			@javax.ws.rs.QueryParam("applicationNumber")
			String applicationNumber,
			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
			@javax.ws.rs.QueryParam("foodGrainLicenseNumber")
			String foodGrainLicenseNumber,
			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
			@javax.ws.rs.QueryParam("tradeLicenseNumber")
			String tradeLicenseNumber,
			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
			@javax.validation.constraints.NotNull
			@javax.ws.rs.QueryParam("applicationType")
			String applicationType)
		throws Exception {

		return new ResponseDetails();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/dgfood-headless-license-management-system/v1.0/fglicense-application/status'  -u 'test@liferay.com:test'
	 */
	@io.swagger.v3.oas.annotations.Operation(
		description = "Retrieves the fglicense status"
	)
	@io.swagger.v3.oas.annotations.Parameters(
		value = {
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY,
				name = "nationalId"
			),
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY,
				name = "applicationNumber"
			),
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY,
				name = "dateOfBirth"
			)
		}
	)
	@io.swagger.v3.oas.annotations.tags.Tags(
		value = {
			@io.swagger.v3.oas.annotations.tags.Tag(
				name = "FGLicenseApplicationDetails"
			)
		}
	)
	@javax.ws.rs.GET
	@javax.ws.rs.Path("/fglicense-application/status")
	@javax.ws.rs.Produces({"application/json", "application/xml"})
	@Override
	public FGLicenseApplicationStatus getFglicenseApplicationStatus(
			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
			@javax.validation.constraints.NotNull
			@javax.ws.rs.QueryParam("nationalId")
			String nationalId,
			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
			@javax.validation.constraints.NotNull
			@javax.ws.rs.QueryParam("applicationNumber")
			String applicationNumber,
			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
			@javax.validation.constraints.NotNull
			@javax.ws.rs.QueryParam("dateOfBirth")
			String dateOfBirth)
		throws Exception {

		return new FGLicenseApplicationStatus();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/dgfood-headless-license-management-system/v1.0/fglicense-application/recent'  -u 'test@liferay.com:test'
	 */
	@io.swagger.v3.oas.annotations.Operation(
		description = "Retrieves the status of most recent fglicense application"
	)
	@io.swagger.v3.oas.annotations.Parameters(
		value = {
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY,
				name = "foodGrainLicenseNumber"
			),
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY,
				name = "applicationType"
			)
		}
	)
	@io.swagger.v3.oas.annotations.tags.Tags(
		value = {
			@io.swagger.v3.oas.annotations.tags.Tag(
				name = "FGLicenseApplicationDetails"
			)
		}
	)
	@javax.ws.rs.GET
	@javax.ws.rs.Path("/fglicense-application/recent")
	@javax.ws.rs.Produces({"application/json", "application/xml"})
	@Override
	public FGLicenseApplicationStatus getFglicenseRecentApplicationStatus(
			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
			@javax.validation.constraints.NotNull
			@javax.ws.rs.QueryParam("foodGrainLicenseNumber")
			String foodGrainLicenseNumber,
			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
			@javax.validation.constraints.NotNull
			@javax.ws.rs.QueryParam("applicationType")
			String applicationType)
		throws Exception {

		return new FGLicenseApplicationStatus();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PUT' 'http://localhost:8080/o/dgfood-headless-license-management-system/v1.0/fglicense-application/{foodGrainLicenseNumber}/update' -d $'{"acknowledge": ___, "applicantGender": ___, "applicantMobileNumber": ___, "maritalStatus": ___, "presentAddress": ___, "sameAsPermanentAddress": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@io.swagger.v3.oas.annotations.Operation(
		description = "Update the fglicense details with information sent in the request body as a new version. Any missing fields are deleted unless they are required."
	)
	@io.swagger.v3.oas.annotations.Parameters(
		value = {
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.PATH,
				name = "foodGrainLicenseNumber"
			)
		}
	)
	@io.swagger.v3.oas.annotations.tags.Tags(
		value = {
			@io.swagger.v3.oas.annotations.tags.Tag(
				name = "FGLicenseApplicationDetails"
			)
		}
	)
	@javax.ws.rs.Consumes({"application/json", "application/xml"})
	@javax.ws.rs.Path("/fglicense-application/{foodGrainLicenseNumber}/update")
	@javax.ws.rs.Produces({"application/json", "application/xml"})
	@javax.ws.rs.PUT
	@Override
	public FGLicenseApplicationDetails putFglicenseApplicationUpdate(
			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
			@javax.validation.constraints.NotNull
			@javax.ws.rs.PathParam("foodGrainLicenseNumber")
			String foodGrainLicenseNumber,
			UpdateFGLicenseApplication updateFGLicenseApplication)
		throws Exception {

		return new FGLicenseApplicationDetails();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PUT' 'http://localhost:8080/o/dgfood-headless-license-management-system/v1.0/fglicense-application/{applicationNumber}/upload-challan' -d $'{"challanDocument": ___, "transactionNumber": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@io.swagger.v3.oas.annotations.Operation(
		description = "Update the fglicense details with information sent in the request body as a new version. Any missing fields are deleted unless they are required."
	)
	@io.swagger.v3.oas.annotations.Parameters(
		value = {
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.PATH,
				name = "applicationNumber"
			)
		}
	)
	@io.swagger.v3.oas.annotations.tags.Tags(
		value = {
			@io.swagger.v3.oas.annotations.tags.Tag(
				name = "FGLicenseApplicationDetails"
			)
		}
	)
	@javax.ws.rs.Consumes({"application/json", "application/xml"})
	@javax.ws.rs.Path(
		"/fglicense-application/{applicationNumber}/upload-challan"
	)
	@javax.ws.rs.Produces({"application/json", "application/xml"})
	@javax.ws.rs.PUT
	@Override
	public FGLicenseApplicationDetails putFglicenseApplicationUploadChallan(
			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
			@javax.validation.constraints.NotNull
			@javax.ws.rs.PathParam("applicationNumber")
			String applicationNumber,
			UploadChallanFGLicenseApplication uploadChallanFGLicenseApplication)
		throws Exception {

		return new FGLicenseApplicationDetails();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PUT' 'http://localhost:8080/o/dgfood-headless-license-management-system/v1.0/fglicense-application/{applicationNumber}/review' -d $'{"comment": ___, "licenseType": ___, "transitionName": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@io.swagger.v3.oas.annotations.Operation(
		description = "Review fglicense request information sent in the request body."
	)
	@io.swagger.v3.oas.annotations.Parameters(
		value = {
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.PATH,
				name = "applicationNumber"
			)
		}
	)
	@io.swagger.v3.oas.annotations.tags.Tags(
		value = {
			@io.swagger.v3.oas.annotations.tags.Tag(
				name = "FGLicenseApplicationDetails"
			)
		}
	)
	@javax.ws.rs.Consumes({"application/json", "application/xml"})
	@javax.ws.rs.Path("/fglicense-application/{applicationNumber}/review")
	@javax.ws.rs.Produces({"application/json", "application/xml"})
	@javax.ws.rs.PUT
	@Override
	public FGLicenseApplicationDetails putFglicenseApplicationReview(
			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
			@javax.validation.constraints.NotNull
			@javax.ws.rs.PathParam("applicationNumber")
			String applicationNumber,
			ReviewFGLicenseApplication reviewFGLicenseApplication)
		throws Exception {

		return new FGLicenseApplicationDetails();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PUT' 'http://localhost:8080/o/dgfood-headless-license-management-system/v1.0/fglicense-application/{foodGrainLicenseNumber}/renewal-duplicate' -d $'{"acknowledge": ___, "comments": ___, "licenseType": ___, "reason": ___, "tradeLicenseNumber": ___, "tradeLicenseNumberPhotocopy": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@io.swagger.v3.oas.annotations.Operation(
		description = "Submit renewal fglicense request with trade license & food grain license details. information sent in the request body as a new version. Any missing fields are deleted unless they are required."
	)
	@io.swagger.v3.oas.annotations.Parameters(
		value = {
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.PATH,
				name = "foodGrainLicenseNumber"
			)
		}
	)
	@io.swagger.v3.oas.annotations.tags.Tags(
		value = {
			@io.swagger.v3.oas.annotations.tags.Tag(
				name = "FGLicenseApplicationDetails"
			)
		}
	)
	@javax.ws.rs.Consumes({"application/json", "application/xml"})
	@javax.ws.rs.Path(
		"/fglicense-application/{foodGrainLicenseNumber}/renewal-duplicate"
	)
	@javax.ws.rs.Produces({"application/json", "application/xml"})
	@javax.ws.rs.PUT
	@Override
	public FGLicenseApplicationDetails putFglicenseApplicationRenewalDuplicate(
			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
			@javax.validation.constraints.NotNull
			@javax.ws.rs.PathParam("foodGrainLicenseNumber")
			String foodGrainLicenseNumber,
			RenewalDuplicateFGLicenseApplication
				renewalDuplicateFGLicenseApplication)
		throws Exception {

		return new FGLicenseApplicationDetails();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/dgfood-headless-license-management-system/v1.0/fglicense-accounts/{applicationNumber}/transition/{licenseType}'  -u 'test@liferay.com:test'
	 */
	@io.swagger.v3.oas.annotations.Operation(
		description = "Retrieves the fglicense transition details"
	)
	@io.swagger.v3.oas.annotations.Parameters(
		value = {
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.PATH,
				name = "licenseType"
			),
			@io.swagger.v3.oas.annotations.Parameter(
				in = io.swagger.v3.oas.annotations.enums.ParameterIn.PATH,
				name = "applicationNumber"
			)
		}
	)
	@io.swagger.v3.oas.annotations.tags.Tags(
		value = {
			@io.swagger.v3.oas.annotations.tags.Tag(
				name = "FGLicenseApplicationDetails"
			)
		}
	)
	@javax.ws.rs.GET
	@javax.ws.rs.Path(
		"/fglicense-accounts/{applicationNumber}/transition/{licenseType}"
	)
	@javax.ws.rs.Produces({"application/json", "application/xml"})
	@Override
	public TransitionFGLicenseApplication getFglicenseApplicationTransition(
			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
			@javax.validation.constraints.NotNull
			@javax.ws.rs.PathParam("licenseType")
			String licenseType,
			@io.swagger.v3.oas.annotations.Parameter(hidden = true)
			@javax.validation.constraints.NotNull
			@javax.ws.rs.PathParam("applicationNumber")
			String applicationNumber)
		throws Exception {

		return new TransitionFGLicenseApplication();
	}

	@Override
	@SuppressWarnings("PMD.UnusedLocalVariable")
	public void create(
			java.util.Collection<FGLicenseApplicationDetails>
				fgLicenseApplicationDetailses,
			Map<String, Serializable> parameters)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Override
	public void delete(
			java.util.Collection<FGLicenseApplicationDetails>
				fgLicenseApplicationDetailses,
			Map<String, Serializable> parameters)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	public Set<String> getAvailableCreateStrategies() {
		return SetUtil.fromArray();
	}

	public Set<String> getAvailableUpdateStrategies() {
		return SetUtil.fromArray();
	}

	@Override
	public EntityModel getEntityModel(Map<String, List<String>> multivaluedMap)
		throws Exception {

		return getEntityModel(
			new MultivaluedHashMap<String, Object>(multivaluedMap));
	}

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap)
		throws Exception {

		return null;
	}

	public String getVersion() {
		return "v1.0";
	}

	@Override
	public Page<FGLicenseApplicationDetails> read(
			Filter filter, Pagination pagination, Sort[] sorts,
			Map<String, Serializable> parameters, String search)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Override
	public void setLanguageId(String languageId) {
		this.contextAcceptLanguage = new AcceptLanguage() {

			@Override
			public List<Locale> getLocales() {
				return null;
			}

			@Override
			public String getPreferredLanguageId() {
				return languageId;
			}

			@Override
			public Locale getPreferredLocale() {
				return LocaleUtil.fromLanguageId(languageId);
			}

		};
	}

	@Override
	public void update(
			java.util.Collection<FGLicenseApplicationDetails>
				fgLicenseApplicationDetailses,
			Map<String, Serializable> parameters)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	public void setContextAcceptLanguage(AcceptLanguage contextAcceptLanguage) {
		this.contextAcceptLanguage = contextAcceptLanguage;
	}

	public void setContextBatchUnsafeConsumer(
		UnsafeBiConsumer
			<java.util.Collection<FGLicenseApplicationDetails>,
			 UnsafeConsumer<FGLicenseApplicationDetails, Exception>, Exception>
				contextBatchUnsafeConsumer) {

		this.contextBatchUnsafeConsumer = contextBatchUnsafeConsumer;
	}

	public void setContextCompany(
		com.liferay.portal.kernel.model.Company contextCompany) {

		this.contextCompany = contextCompany;
	}

	public void setContextHttpServletRequest(
		HttpServletRequest contextHttpServletRequest) {

		this.contextHttpServletRequest = contextHttpServletRequest;
	}

	public void setContextHttpServletResponse(
		HttpServletResponse contextHttpServletResponse) {

		this.contextHttpServletResponse = contextHttpServletResponse;
	}

	public void setContextUriInfo(UriInfo contextUriInfo) {
		this.contextUriInfo = contextUriInfo;
	}

	public void setContextUser(
		com.liferay.portal.kernel.model.User contextUser) {

		this.contextUser = contextUser;
	}

	public void setExpressionConvert(
		ExpressionConvert<Filter> expressionConvert) {

		this.expressionConvert = expressionConvert;
	}

	public void setFilterParserProvider(
		FilterParserProvider filterParserProvider) {

		this.filterParserProvider = filterParserProvider;
	}

	public void setGroupLocalService(GroupLocalService groupLocalService) {
		this.groupLocalService = groupLocalService;
	}

	public void setResourceActionLocalService(
		ResourceActionLocalService resourceActionLocalService) {

		this.resourceActionLocalService = resourceActionLocalService;
	}

	public void setResourcePermissionLocalService(
		ResourcePermissionLocalService resourcePermissionLocalService) {

		this.resourcePermissionLocalService = resourcePermissionLocalService;
	}

	public void setRoleLocalService(RoleLocalService roleLocalService) {
		this.roleLocalService = roleLocalService;
	}

	public void setVulcanBatchEngineImportTaskResource(
		VulcanBatchEngineImportTaskResource
			vulcanBatchEngineImportTaskResource) {

		this.vulcanBatchEngineImportTaskResource =
			vulcanBatchEngineImportTaskResource;
	}

	@Override
	public Filter toFilter(
		String filterString, Map<String, List<String>> multivaluedMap) {

		try {
			EntityModel entityModel = getEntityModel(multivaluedMap);

			FilterParser filterParser = filterParserProvider.provide(
				entityModel);

			com.liferay.portal.odata.filter.Filter oDataFilter =
				new com.liferay.portal.odata.filter.Filter(
					filterParser.parse(filterString));

			return expressionConvert.convert(
				oDataFilter.getExpression(),
				contextAcceptLanguage.getPreferredLocale(), entityModel);
		}
		catch (Exception exception) {
			_log.error("Invalid filter " + filterString, exception);
		}

		return null;
	}

	protected Map<String, String> addAction(
		String actionName, GroupedModel groupedModel, String methodName) {

		return ActionUtil.addAction(
			actionName, getClass(), groupedModel, methodName,
			contextScopeChecker, contextUriInfo);
	}

	protected Map<String, String> addAction(
		String actionName, Long id, String methodName, Long ownerId,
		String permissionName, Long siteId) {

		return ActionUtil.addAction(
			actionName, getClass(), id, methodName, contextScopeChecker,
			ownerId, permissionName, siteId, contextUriInfo);
	}

	protected Map<String, String> addAction(
		String actionName, Long id, String methodName,
		ModelResourcePermission modelResourcePermission) {

		return ActionUtil.addAction(
			actionName, getClass(), id, methodName, contextScopeChecker,
			modelResourcePermission, contextUriInfo);
	}

	protected Map<String, String> addAction(
		String actionName, String methodName, String permissionName,
		Long siteId) {

		return addAction(
			actionName, siteId, methodName, null, permissionName, siteId);
	}

	protected <T, R, E extends Throwable> List<R> transform(
		java.util.Collection<T> collection,
		UnsafeFunction<T, R, E> unsafeFunction) {

		return TransformUtil.transform(collection, unsafeFunction);
	}

	protected <T, R, E extends Throwable> R[] transform(
		T[] array, UnsafeFunction<T, R, E> unsafeFunction, Class<?> clazz) {

		return TransformUtil.transform(array, unsafeFunction, clazz);
	}

	protected <T, R, E extends Throwable> R[] transformToArray(
		java.util.Collection<T> collection,
		UnsafeFunction<T, R, E> unsafeFunction, Class<?> clazz) {

		return TransformUtil.transformToArray(
			collection, unsafeFunction, clazz);
	}

	protected <T, R, E extends Throwable> List<R> transformToList(
		T[] array, UnsafeFunction<T, R, E> unsafeFunction) {

		return TransformUtil.transformToList(array, unsafeFunction);
	}

	protected <T, R, E extends Throwable> List<R> unsafeTransform(
			java.util.Collection<T> collection,
			UnsafeFunction<T, R, E> unsafeFunction)
		throws E {

		return TransformUtil.unsafeTransform(collection, unsafeFunction);
	}

	protected <T, R, E extends Throwable> R[] unsafeTransform(
			T[] array, UnsafeFunction<T, R, E> unsafeFunction, Class<?> clazz)
		throws E {

		return TransformUtil.unsafeTransform(array, unsafeFunction, clazz);
	}

	protected <T, R, E extends Throwable> R[] unsafeTransformToArray(
			java.util.Collection<T> collection,
			UnsafeFunction<T, R, E> unsafeFunction, Class<?> clazz)
		throws E {

		return TransformUtil.unsafeTransformToArray(
			collection, unsafeFunction, clazz);
	}

	protected <T, R, E extends Throwable> List<R> unsafeTransformToList(
			T[] array, UnsafeFunction<T, R, E> unsafeFunction)
		throws E {

		return TransformUtil.unsafeTransformToList(array, unsafeFunction);
	}

	protected AcceptLanguage contextAcceptLanguage;
	protected UnsafeBiConsumer
		<java.util.Collection<FGLicenseApplicationDetails>,
		 UnsafeConsumer<FGLicenseApplicationDetails, Exception>, Exception>
			contextBatchUnsafeConsumer;
	protected com.liferay.portal.kernel.model.Company contextCompany;
	protected HttpServletRequest contextHttpServletRequest;
	protected HttpServletResponse contextHttpServletResponse;
	protected Object contextScopeChecker;
	protected UriInfo contextUriInfo;
	protected com.liferay.portal.kernel.model.User contextUser;
	protected ExpressionConvert<Filter> expressionConvert;
	protected FilterParserProvider filterParserProvider;
	protected GroupLocalService groupLocalService;
	protected ResourceActionLocalService resourceActionLocalService;
	protected ResourcePermissionLocalService resourcePermissionLocalService;
	protected RoleLocalService roleLocalService;
	protected VulcanBatchEngineImportTaskResource
		vulcanBatchEngineImportTaskResource;

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(
			BaseFGLicenseApplicationDetailsResourceImpl.class);

}