<%@include file="/ffpb_registration/init.jsp" %>

	<div class='form-group'>
	    <h3 class="subtitle"><liferay-ui:message key="nid-details" /></h3>

			<clay:row>

				<clay:col md="6" sm="6">
					<label for="nationalId"><liferay-ui:message
							key="national-id"></liferay-ui:message><span class="txt-red">*</span></label>
					<aui:input name="nationalId" label="" value="1234567899" cssClass="validate preview_text">
					<aui:validator name="required" errorMessage="this-field-is-required"></aui:validator>
				<aui:validator name="maxLength"
					errorMessage="maxlength-seventeen-error-label">17</aui:validator>
				<aui:validator name="minLength"
					errorMessage="minlength-ten-error-label">10</aui:validator>
				<aui:validator name="number" />
			</aui:input>
				</clay:col>

		<clay:col md="6" sm="6">

		<label for="emailAddress"><liferay-ui:message
				key="emailAddress-label"></liferay-ui:message></label>
		<aui:input name="emailAddress" cssClass="form-control validate"
			id="emailAddress" label="" type="text"
			placeholder="emailAddress-label" value="" maxLength="30">
			<aui:validator name="maxLength"
				errorMessage="maxlength-thirty-error-label">30</aui:validator>
		</aui:input>
		</clay:col>



		<clay:col md="6" sm="6">
					<label for="dateOfBirth"><liferay-ui:message
							key="date-of-birth"></liferay-ui:message><span class="txt-red">*</span></label>
					<aui:input type="text" name="dateOfBirth" label="" value="12/12/1919" cssClass="validate preview_text">
					<aui:validator name="required" errorMessage="this-field-is-required"></aui:validator>
				<aui:validator name="custom" errorMessage="age-error-label">
					    function(val, fieldNode, ruleValue) {
					    	
					    	//var parts = val.split("-");
					    	var today = new Date();
					    	var result = false;
					    	var birthDate = new Date(val);
							console.log("birthDate ..",birthDate);
							var age = today.getFullYear() - birthDate.getFullYear();
							var m = today.getMonth() - birthDate.getMonth();
							
							if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) 
							{
								age--;
							}
							if (age >= 18) {
								console.log("Age is Greater than 18");
								result = true;
							} 
							else 
							{
								console.log("Age is Less than 18");
								result = false;
							}				
							return result;					
					    }
				</aui:validator>
			</aui:input>
				</clay:col>

				<clay:col md="6" sm="6">
					<label for="mobileNumber"><liferay-ui:message
							key="mobile-number"></liferay-ui:message><span class="txt-red">*</span></label>
					<aui:input name="mobileNumber" label="" value="1234567899" cssClass="validate preview_text">
					<aui:validator name="required" errorMessage="this-field-is-required"></aui:validator>
				<aui:validator name="maxLength"
					errorMessage="maxlength-ten-error-label">10</aui:validator>
				<aui:validator name="minLength"
					errorMessage="minlength-ten-error-label">10</aui:validator>
				<aui:validator name="number" />
			</aui:input>
				</clay:col>
			
				<!-- <clay:col md="6" sm="6"></clay:col>

				<clay:col md="6" sm="6">
					<liferay-captcha:captcha />
				</clay:col> -->
			</clay:row>
	</div>			
<aui:button type="button" value="retrive" onClick='<%= liferayPortletResponse.getNamespace() + "validateNID();" %>'></aui:button>


<div id="<portlet:namespace />loader"></div>

<aui:script>

	function <portlet:namespace />validateNID() {
		var nationalId = document.getElementById('<portlet:namespace />nationalId');
		var formData = new FormData();
		formData.append('<portlet:namespace />nationalId', nationalId.value);

		const loader = document.getElementById('<portlet:namespace />loader');
		loader.innerHTML = '<span class="loading-animation">';

		Liferay.Util.fetch(
			'<liferay-portlet:resourceURL copyCurrentRenderParameters="<%= false %>" id="/verify/nid" />',
			{
				body: formData,
				method: 'POST',
			}
		).then((response) => {
			loader.innerHTML = '';
			if(!response.ok){
				throw new Error();				
			}
			return response.text();
		}).then((response) => {
			validateFields('nid_details','basic_info');
		}).catch((error) => {
			loader.innerHTML = '';
			Liferay.Util.openToast({
				autoClose: 1500,
				container: document.querySelector('#<portlet:namespace />errorMsg'),
				message: '<liferay-ui:message key="duplicate-nid-error" />',
				title: '<liferay-ui:message key="error" />:',
				type: 'danger',
			});
		
			console.error(error);
		});
                 
		
	}

</aui:script>
		
