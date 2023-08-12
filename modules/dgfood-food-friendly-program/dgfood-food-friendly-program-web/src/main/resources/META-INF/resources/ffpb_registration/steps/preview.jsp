<%@include file="/ffpb_registration/init.jsp"%>


<liferay-util:include page="/ffpb_profile/ffpb_profile.jsp"
	servletContext="<%=application%>" />


<clay:col>

	<aui:input name="acknowledge" label="" type="checkbox">
		<aui:validator name="required" errorMessage="this-field-is-required" /> 
	</aui:input>
	<label for="acknowledge"><liferay-ui:message key="acknowledge"></liferay-ui:message></label>
</clay:col>

<clay:col>

	<aui:input name="nonOfMyFamilyMembersRegistered" label=""
		type="checkbox">
		<aui:validator name="required" errorMessage="this-field-is-required" /> 
	</aui:input>
	<label for="nonOfMyFamilyMembersRegistered"><liferay-ui:message
			key="none-of-my-mamily-members-registred-earlier"></liferay-ui:message></label>
</clay:col>



<aui:button-row>
	<aui:button value='back' onClick="showNextOrPreviousStep('upload');"></aui:button>
	<aui:button value='back' type='submit'></aui:button>
	<!-- <aui:button onClick='<%= liferayPortletResponse.getNamespace() + "onClick();" %>' primary="<%= true %>" value="submit" /> -->
</aui:button-row>


<portlet:renderURL var="finalPageURL">
        <portlet:param name="mvcRenderCommandName" 
        value="/uc_uno/view" />
</portlet:renderURL>


<aui:script>
	function <portlet:namespace />onClick() {
		var form = Liferay.Form.get('<portlet:namespace />fm');
		var formValidator = form.formValidator;

		formValidator.validate();
		if (!formValidator.hasErrors()) {
			<portlet:namespace />submit();
		}else{
			Liferay.Util.openToast({
				message: '<liferay-ui:message key="error-exist-in-form" />',
				title: '<liferay-ui:message key="error" />:',
				type: 'danger',
			});
		}
	}

	function <portlet:namespace />submit() {

		var form = document.<portlet:namespace />fm;

		Liferay.Util.fetch(
			'<liferay-portlet:resourceURL copyCurrentRenderParameters="<%= false %>" id="/uc/edit_ffpb" />',
			{
				body: new FormData(form),
				method: 'POST',
			}
		).then((response) => {
			
			if (!response.ok) {
				return response.json();
			}
            console.log(' response ... ',response)
			console.log(' response ... ',response.json())
			//var modalSignInURL = Liferay.Util.addParams(
			//	'windowState=exclusive',
			//	signInURL
			//);
			Liferay.Util.navigate('<%= finalPageURL.toString()%>')
		}).then((response) => {

			const exception = response.exception;

		 if (!exception) {
				throw new Error();
		  }else{

			var errorKey = '<%=UnicodeLanguageUtil.get(resourceBundle, "your-request-failed-to-complete")%>';
            console.log("exception....",exception)
			if(exception.indexOf('BeneficiaryNameException$MustNotBeNull') > -1 ){

				errorKey = '<%=UnicodeLanguageUtil.get(resourceBundle, "name-cannot-be-blank")%>';

			}else if(exception.indexOf('BeneficiaryDateOfBirthException$MustNotBeNull') > -1 ){

				errorKey = '<%=UnicodeLanguageUtil.get(resourceBundle, "date-of-birth-cannot-be-blank")%>';

			}else if(exception.indexOf('BeneficiaryMobileNumberException$MustNotBeNull') > -1 ){

				errorKey = '<%=UnicodeLanguageUtil.get(resourceBundle, "mobile-number-cannot-be-blank")%>';

			}else if(exception.indexOf('BeneficiaryNationalIdException$MustNotBeNull') > -1 ){

				errorKey = '<%=UnicodeLanguageUtil.get(resourceBundle, "national-id-cannot-be-blank")%>';

			}else if(exception.indexOf('BeneficiaryNationalIdException$MustNotBeDuplicate') > -1 ){

				errorKey = '<%=UnicodeLanguageUtil.get(resourceBundle, "national-id-you-requested-is-already-registered")%>';

			}else if(exception.indexOf('BeneficiarySpouseException$SpouseNameMustNotBeNull') > -1 ){

				errorKey = '<%=UnicodeLanguageUtil.get(resourceBundle, "spouse-name-cannot-be-blank")%>';

			}else if(exception.indexOf('BeneficiarySpouseException$SpouseDateOfBirthMustNotBeNull') > -1 ){

				errorKey = '<%=UnicodeLanguageUtil.get(resourceBundle, "spouse-date-of-birth-cannot-be-blank")%>';

			}else if(exception.indexOf('BeneficiarySpouseException$SpouseFatherNameMustNotBeNull') > -1 ){

				errorKey = '<%=UnicodeLanguageUtil.get(resourceBundle, "spouse-father-name-cannot-be-blank")%>';

			}else if(exception.indexOf('BeneficiarySpouseException$SpouseNationalIdMustNotBeDuplicate') > -1 ){

				errorKey = '<%=UnicodeLanguageUtil.get(resourceBundle, "spouse-national-id-you-requested-is-already-registered")%>';

			}else if(exception.indexOf('BeneficiarySpouseException$SpouseNationalIdMustNotBeNull') > -1 ){

				errorKey = '<%=UnicodeLanguageUtil.get(resourceBundle, "spouse-national-id-cannot-be-blank")%>';
			}
			console.log("exception....",exception.indexOf('BeneficiarySpouseException$SpouseNationalIdMustNotBeDuplicate'))
			
			
			Liferay.Util.openToast({
				autoClose: 10000,
				container: document.querySelector('#<portlet:namespace />errorMsg'),
				message: errorKey,
				title: '<liferay-ui:message key="error" />:',
				type: 'danger',
			});
			window.scrollTo(0, 0);
		  }

                 
		}).catch((error) => {
			Liferay.Util.openToast({
				message: '<liferay-ui:message key="an-unexpected-error-occurred" />',
				title: '<liferay-ui:message key="error" />:',
				type: 'danger',
			});
		
			console.error(error);
		});
	}

</aui:script>







