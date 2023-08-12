package bd.gov.dgfood.headless.user.authentication.internal.resource.v1_0;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import bd.gov.dgfood.headless.user.authentication.dto.v1_0.UserAuthenticationRequestData;
import bd.gov.dgfood.headless.user.authentication.dto.v1_0.UserAuthenticationResponseData;
import bd.gov.dgfood.headless.user.authentication.resource.v1_0.UserAuthenticationRequestResource;

/**
 * @author AshishV
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/user-authentication-request.properties",
	scope = ServiceScope.PROTOTYPE,
	service = UserAuthenticationRequestResource.class
)
public class UserAuthenticationRequestResourceImpl extends BaseUserAuthenticationRequestResourceImpl 
{

	@Override
	public UserAuthenticationResponseData authenticateUser(UserAuthenticationRequestData userAuthenticationRequestData) throws Exception 
	{
		String validationResult=validateRequest(userAuthenticationRequestData);
		UserAuthenticationResponseData userAuthenticationResponseData=super.authenticateUser(userAuthenticationRequestData);
		
		if(Validator.isNotNull(validationResult))
		{
			log.debug(validationResult);
			userAuthenticationResponseData.setErrorMessage(validationResult);
			userAuthenticationResponseData.setErrorCode("400");
			return userAuthenticationResponseData;
		}
		
		try
		{
			long userId=userLocalService.authenticateForBasic(CompanyThreadLocal.getCompanyId(), userAuthenticationRequestData.getAuthType(), 
					userAuthenticationRequestData.getUserName(), userAuthenticationRequestData.getPassword());
			User user=userLocalService.fetchUser(userId);
			
			if(userId==0 && Validator.isNull(user))
			{
				userAuthenticationResponseData.setErrorCode(String.valueOf(400));
				userAuthenticationResponseData.setErrorMessage("Invalid user Id or password. User authentication failed for the user: "+userAuthenticationRequestData.getUserName());
				return userAuthenticationResponseData;
			}
			
			userAuthenticationResponseData.setAuthenticationResult("Success");
			userAuthenticationResponseData.setEmailAddress(user.getEmailAddress());
			userAuthenticationResponseData.setScreenName(user.getScreenName());
			userAuthenticationResponseData.setFullName(user.getFirstName());
		}
		catch (Exception e) 
		{
			userAuthenticationResponseData.setErrorCode(String.valueOf(400));
			userAuthenticationResponseData.setErrorMessage("User Authentication failed "+e.getMessage());
			
			log.debug("User Authentication failed "+e.getMessage());
			if(log.isDebugEnabled())
			{
				e.printStackTrace();
			}
		}
		
		
		return userAuthenticationResponseData;
	}
	
	private String validateRequest(UserAuthenticationRequestData userAuthenticationRequestData)
	{
		if(Validator.isNull(userAuthenticationRequestData))
		{
			return "Invalid request";
		}
		else if(Validator.isNull(userAuthenticationRequestData.getUserName()))
		{
			return "User Name is required: User Name can't be blank";
		}
		else if(Validator.isNull(userAuthenticationRequestData.getPassword()))
		{
			return "Password is required: Password can't be blank";
		}
		else if(Validator.isNull(userAuthenticationRequestData.getAuthType()))
		{
			return "Auth type is required: Auth type can't be blank";
		}
		
		return null;
	}
	
	@Reference
	private UserLocalService userLocalService;
	
	private Log log = LogFactoryUtil.getLog(this.getClass());
}