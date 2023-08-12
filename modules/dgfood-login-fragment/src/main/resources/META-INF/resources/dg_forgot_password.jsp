<%@ include file="/init.jsp"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<c:choose>
	<c:when test="<%=!themeDisplay.isSignedIn()%>">

		<%
		User user2 = (User)request.getAttribute(WebKeys.FORGOT_PASSWORD_REMINDER_USER);
		
		String passwordSuccess = (String)request.getAttribute("password-changed-successfully");
		if(com.liferay.portal.kernel.util.Validator.isNotNull(passwordSuccess)){
		%>
		Your password has been updated successfully!
		Please login to access your account
		<%
		user2=null;
		
		}
		%>
		<portlet:actionURL name="/dg/login/forgot_password"
			var="forgotPasswordActionURL" />

		<liferay-ui:error key="nid-dob-does-not-match"
			message='<%= "nid-and-dob-does-not-match-in-our-database" %>' />
		<liferay-ui:error exception="<%= NoSuchUserException.class %>"
			message='<%= "the-user-is-not-registered-in-our-database" %>' />
		<liferay-ui:error exception="<%= UserActiveException.class %>"
			message="your-account-is-not-active" />
		<liferay-ui:error
			exception="<%= UserEmailAddressException.MustNotBeNull.class %>"
			message="please-enter-an-email-address" />
		<liferay-ui:error
			exception="<%= UserEmailAddressException.MustValidate.class %>"
			message="please-enter-a-valid-email-address" />
		<liferay-ui:error
			exception="<%= UserLockoutException.LDAPLockout.class %>"
			message="this-account-is-locked" />
		<liferay-ui:error exception="<%= UserPasswordException.MustNotBeEqualToCurrent.class %>"
			message="new-password-cannot-be-the-same-as-your-old-password-please-enter-a-different-password" />
		<liferay-ui:error
			exception="<%= UserLockoutException.PasswordPolicyLockout.class %>">

			<%
			UserLockoutException.PasswordPolicyLockout ule = (UserLockoutException.PasswordPolicyLockout)errorException;
			%>

			<c:choose>
				<c:when test="<%= ule.passwordPolicy.isRequireUnlock() %>">
					<liferay-ui:message key="this-account-is-locked" />
				</c:when>
				<c:otherwise>

					<%
					Format dateFormat = FastDateFormatFactoryUtil.getDateTime(FastDateFormatConstants.SHORT, FastDateFormatConstants.LONG, locale, TimeZone.getTimeZone(ule.user.getTimeZoneId()));
					%>

					<liferay-ui:message
						arguments="<%= dateFormat.format(ule.user.getUnlockDate()) %>"
						key="this-account-is-locked-until-x"
						translateArguments="<%= false %>" />
				</c:otherwise>
			</c:choose>
		</liferay-ui:error>


		<aui:form action="<%=forgotPasswordActionURL %>" method="post"
			name="fm">
			<c:choose>
				<c:when test="<%= user2 == null %>">
					<div class="forgot-password">
						<h2>Forgot Password?</h2>
					</div>
					<div class="forgot-password">

						<aui:input name="step" type="hidden" value="1" />

						<aui:input label="nationalId" name="nationalId" size="30"
							type="text" value="1234578901234" maxLength="17" minLength="13">
							<aui:validator name="required"
								errorMessage="error-label-nationalId" />
							<aui:validator name="custom"
								errorMessage="error-label-length-nationalId">
								    function(val, fieldNode, ruleValue) {
								    	var valLength = val.length;
								    	var result = false;
										
										if(valLength == 13 || valLength == 17){
											result = true;
										}else{
											console.log("National Id must be 13 or 17 digit long.");
											result = false;
										}				
										return result;					
								    }
							</aui:validator>
							<aui:validator name="maxLength"
								errorMessage="error-label-max-length-seventeen">17</aui:validator>
							<aui:validator name="minLength"
								errorMessage="error-label-min-length-thirteen">13</aui:validator>
							<aui:validator name="number" />
						</aui:input>

						<aui:input label="date-of-birth" name="dateOfBirth" type="text"
							value="01-01-1970">
							<aui:validator name="required" />
						</aui:input>

						<aui:input label="mobile-number" name="mobileNumber" size="11"
							type="text" value="98920989201" maxLength="15" minLength="12">
							<aui:validator name="required" />
							<aui:validator name="maxLength"
								errorMessage="error-label-max-length-ten">15</aui:validator>
							<aui:validator name="minLength"
								errorMessage="error-label-min-length-ten">11</aui:validator>
							<aui:validator name="number" />
						</aui:input>
					</div>
				</c:when>
				<c:when test="<%= user2 != null %>">
					<div class="create-new-password">
						<h2>Create New Password</h2>
					</div>
					<div class="create-new-password">

						<aui:input name="step" type="hidden" value="2" />

						<aui:input label="password" name="password" type="password">
							<aui:validator name="required" />
						</aui:input>

						<aui:input label="confirm-password" name="confirmPassword"
							type="password">
							<aui:validator name="required" />
							<aui:validator name="equalTo">'#<portlet:namespace />password'</aui:validator>
						</aui:input>
					</div>
				</c:when>
			</c:choose>
			<aui:button-row>
				<aui:button type="submit" name="submit" value="submit" />
			</aui:button-row>
		</aui:form>
	</c:when>
</c:choose>