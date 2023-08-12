package bd.gov.dgfood.headless.common.delivery.internal.graphql.servlet.v1_0;

import bd.gov.dgfood.headless.common.delivery.internal.graphql.mutation.v1_0.Mutation;
import bd.gov.dgfood.headless.common.delivery.internal.graphql.query.v1_0.Query;
import bd.gov.dgfood.headless.common.delivery.resource.v1_0.CaptchaAnswerResource;
import bd.gov.dgfood.headless.common.delivery.resource.v1_0.OTPGenerationResource;
import bd.gov.dgfood.headless.common.delivery.resource.v1_0.OTPVerificationResource;
import bd.gov.dgfood.headless.common.delivery.resource.v1_0.UserNotificationResource;
import bd.gov.dgfood.headless.common.delivery.resource.v1_0.UserResponseResource;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author krishna
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setUserNotificationResourceComponentServiceObjects(
			_userNotificationResourceComponentServiceObjects);
		Mutation.setUserResponseResourceComponentServiceObjects(
			_userResponseResourceComponentServiceObjects);

		Query.setCaptchaAnswerResourceComponentServiceObjects(
			_captchaAnswerResourceComponentServiceObjects);
		Query.setOTPGenerationResourceComponentServiceObjects(
			_otpGenerationResourceComponentServiceObjects);
		Query.setOTPVerificationResourceComponentServiceObjects(
			_otpVerificationResourceComponentServiceObjects);
		Query.setUserNotificationResourceComponentServiceObjects(
			_userNotificationResourceComponentServiceObjects);
		Query.setUserResponseResourceComponentServiceObjects(
			_userResponseResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/dgfood-headless-common-delivery-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<UserNotificationResource>
		_userNotificationResourceComponentServiceObjects;
	private ComponentServiceObjects<UserResponseResource>
		_userResponseResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<CaptchaAnswerResource>
		_captchaAnswerResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<OTPGenerationResource>
		_otpGenerationResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<OTPVerificationResource>
		_otpVerificationResourceComponentServiceObjects;

}