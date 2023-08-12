<%@include file="/ffpb_registration/init.jsp" %>
	
<div class='form-group'>
	<h3 class="subtitle"><liferay-ui:message key="basic-info" /></h3>
	<clay:row>

		<clay:col md="6" sm="6" cssClass="auto-fill-values">
			<label for="name"><liferay-ui:message key="name"></liferay-ui:message><span class="txt-red">*</span></label>
			<aui:input readonly="true" name="name" label="" value="test" cssClass="validate preview_text">
			
				<aui:validator name="required" errorMessage="this-field-is-required"></aui:validator>
			<aui:validator name="maxLength"
				errorMessage="name-maxlength-error-label">30</aui:validator>
			<aui:validator name="minLength"
				errorMessage="name-minlength-error-label">1</aui:validator>
			<aui:validator name="custom" errorMessage="name-character-error">
							function(val, fieldNode, ruleValue) {
								var regex = new RegExp("^[a-zA-Z\\s]*$");
								return regex.test(val);
							}
				</aui:validator>
			</aui:input>
		</clay:col>

		<clay:col md="6" sm="6" cssClass="auto-fill-values">
			<label for="fatherName"><liferay-ui:message key="father-name"></liferay-ui:message></label>
			<aui:input readonly="true" name="fatherName" label="" value="father" cssClass='preview_text'>
			<aui:validator name="maxLength"
				errorMessage="maxlength-thirty-error-label">30</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-one-error-label">1</aui:validator>
			<aui:validator name="custom" errorMessage="name-character-error">
							function(val, fieldNode, ruleValue) {
								var regex = new RegExp("^[a-zA-Z\\s]*$");
								return regex.test(val);
							}
				</aui:validator>
			</aui:input>
		</clay:col>
		
		<clay:col md="6" sm="6" cssClass="auto-fill-values">
			<label for="motherName"><liferay-ui:message key="mother-name"></liferay-ui:message></label>
			<aui:input readonly="true" name="motherName" label="" value="mother" cssClass='preview_text'>
				<aui:validator name="maxLength"
				errorMessage="maxlength-thirty-error-label">30</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-one-error-label">1</aui:validator>
			<aui:validator name="custom" errorMessage="name-character-error">
							function(val, fieldNode, ruleValue) {
								var regex = new RegExp("^[a-zA-Z\\s]*$");
								return regex.test(val);
							}
				</aui:validator>
			</aui:input>
		</clay:col>

		<clay:col md="6" sm="6"></clay:col>
		<clay:col md="6" sm="6">
				<label for="gender"><liferay-ui:message key="gender"></liferay-ui:message><span class="txt-red">*</span></label>
				<aui:input name="gender" type="radio" label="" value="0" checked="true"></aui:input><liferay-ui:message key="male"></liferay-ui:message>
				<aui:input name="gender" type="radio" label="" value="1"></aui:input><liferay-ui:message key="female"></liferay-ui:message>
				<aui:input name="gender" type="radio" label="" value="2"></aui:input><liferay-ui:message key="third-gender"></liferay-ui:message>
		</clay:col>
	</clay:row>
</div>
<div class='form-group'>
<h3 class="subtitle"> <liferay-ui:message key="permanent-address"></liferay-ui:message> </h3>
<clay:row>	

	<clay:col md="6" sm="6" cssClass="auto-fill-values">
		<label for="permanentRegion"><liferay-ui:message key="permanent-region"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select cssClass="validate permanent_address"   onChange="populateAddressOption(event, 'permanentZilla')" label="" name="permanentRegion" value="0" readonly="true" data-address="Region"> 
			<aui:validator name="required" errorMessage="region-error-label" />	
			<aui:option selected="true" value='40617'>
				<liferay-ui:message key='Region1' />
			</aui:option>
		</aui:select>
	</clay:col>

	<clay:col md="6" sm="6" cssClass="auto-fill-values">
		<label for="permanentZilla"><liferay-ui:message key="permanent-zilla"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select cssClass="validate permanent_address"   onChange="populateAddressOption(event,'permanentUpazilla')" name="permanentZilla" label=""  showEmptyOption="false" value="1" readonly="true" data-address="Zilla">
			<aui:validator name="required" errorMessage="zilla-error-label" />	
			<aui:option selected="true" value='40619'>
				<liferay-ui:message key='Zilla1' />
			</aui:option>
<%-- 		<aui:validator errorMessage='<%= LanguageUtil.get(request, "this-field-is-required") %>' name="custom">
						function(val, fieldNode) {
							if (fieldNode.length === 1) {
								return true;
							}

							if (Number(val) !== 0) {
								return true;
							}

							return false;
						}
					</aui:validator> --%>
		</aui:select>
	</clay:col>

	<clay:col md="6" sm="6" cssClass="auto-fill-values">
			<label for="permanentUpazilla"><liferay-ui:message key="permanent-upazilla"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select cssClass="validate permanent_address"   onChange="populateAddressOption(event, 'permanentUnion')" name="permanentUpazilla" label="" value="1" readonly="true" data-address="Upazilla">
		<aui:validator name="required" errorMessage="upazilla-error-label" />	
		<aui:option selected="true" value='40621'>
			<liferay-ui:message key='Upzilla1' />
		</aui:option>
		</aui:select>
	</clay:col>

	<clay:col md="6" sm="6" cssClass="auto-fill-values">
			<label for="permanentUnion"><liferay-ui:message key="permanent-union"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select cssClass="validate permanent_address"   onChange="populateAddressOption(event,'permanentWard');"  name="permanentUnion" label=""  value="1" readonly="true" data-address="Union">
		<aui:validator name="required" errorMessage="union-error-label" />
		<aui:option selected="true" value='40624'>
			<liferay-ui:message key='Union1' />
		</aui:option>
		</aui:select>
	</clay:col>

	<clay:col md="6" sm="6" cssClass="auto-fill-values">
			<label for="permanentVillage"><liferay-ui:message key="permanent-village"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input cssClass="validate permanent_address preview_text" name="permanentVillage" label="" required="true" value="permanent village" readonly="true" data-address="Village">
				<aui:validator name="required" errorMessage="village-error-label" />
			<aui:validator name="maxLength"
				errorMessage="maxlength-thirty-error-label">30</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-one-error-label">1</aui:validator>
			<aui:validator name="custom" errorMessage="name-character-error">
						function(val, fieldNode, ruleValue) {
							var regex = new RegExp("^[a-zA-Z\\s]*$");
							return regex.test(val);
						}
			</aui:validator>
		</aui:input>
	</clay:col>

	<clay:col md="6" sm="6" cssClass="auto-fill-values">
			<label for="permanentWard"><liferay-ui:message key="permanent-ward"></liferay-ui:message><span class="txt-red">*</span></label>
			<aui:select  cssClass="validate permanent_address" id="permanentWard" name="permanentWard" label="" readonly="true" data-address="Ward"> 
				<aui:validator name="required" errorMessage="ward-error-label" />
				<aui:option selected="true" value='0'>
					<liferay-ui:message key='Ward1' />
				</aui:option>
			</aui:select>
	</clay:col>

	<clay:col md="6" sm="6" cssClass="auto-fill-values">
			<label for="permanentZipCode"><liferay-ui:message key="permanent-zip-code"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input cssClass="validate permanent_address preview_text" name="permanentZipCode" label=""  value="1234" readonly="true" data-address="ZipCode">
			<aui:validator name="required" errorMessage="zip-error-label" />
			<aui:validator name="maxLength"
				errorMessage="zip-maxlength-error-label">5</aui:validator>
			<aui:validator name="minLength"
				errorMessage="zip-minlength-error-label">4</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</clay:col>

	<clay:col md="6" sm="6" cssClass="auto-fill-values">
			<label for="permanentPostOffice"><liferay-ui:message key="permanent-post-office"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select cssClass="validate permanent_address"   name="permanentPostOffice" label=""  value="1" readonly="true" data-address="PostOffice">
			<aui:validator name="required" errorMessage="post-office-error-label" />
			<aui:option  value="0" label="option1"></aui:option>
			<aui:option value="1" label="option2"></aui:option>
			<aui:option value="2" label="option3"></aui:option>
		</aui:select>
	</clay:col>

	<clay:col md="12" sm="6" cssClass="auto-fill-values">	   
		<label for="permanentHouseAddress"><liferay-ui:message key="permanent-house-address"></liferay-ui:message></label>
		<aui:input cssClass="validate permanent_address preview_text" name="permanentHouseAddress" label="" value="permanent address" readonly="true" data-address="HouseAddress">
			<aui:validator name="required"
				errorMessage="house-address-error-label" />
			<aui:validator name="maxLength"
				errorMessage="houseAddress-maxlength-error-label">50</aui:validator>
			<aui:validator name="minLength"
				errorMessage="houseAddress-minlength-error-label">10</aui:validator>
		</aui:input>
		
	</clay:col>

</clay:row>
</div>
<div class='form-group'>
<h3 class="subtitle"> <liferay-ui:message key="present-address"></liferay-ui:message></h3>

<clay:row>	
	
	<clay:col md="6" sm="6">
			
		<aui:input name="sameAsPermanentAddress" type="checkbox" label="" /> <label for="sameAsPermanentAddress"> <liferay-ui:message key="same-as-permanent-address"></liferay-ui:message></label>
	</clay:col>

	<clay:col md="6" sm="6">
			
		
	</clay:col>

	<clay:col md="6" sm="6">
			<label for="presentRegion"><liferay-ui:message key="present-region"></liferay-ui:message><span class="txt-red">*</span></label>
		   <aui:select cssClass="validate present_address"  onChange="populateAddressOption(event, 'presentZilla');"  name="presentRegion" label="" value="1">
			<aui:validator name="required" errorMessage="region-error-label" />
			<aui:option selected="true" >
				<liferay-ui:message key='select-label' />
			</aui:option>
		</aui:select>
	</clay:col>

	<clay:col md="6" sm="6">
			<label for="presentZilla"><liferay-ui:message key="present-zilla"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select cssClass="validate present_address"  onChange="populateAddressOption(event, 'presentUpazilla');" name="presentZilla" label="" value="1">
			<aui:validator name="required" errorMessage="zilla-error-label" />
			<aui:option selected="true" >
				<liferay-ui:message key='select-label' />
			</aui:option>
		</aui:select>
	</clay:col>

	<clay:col md="6" sm="6">
			<label for="presentUpazilla"><liferay-ui:message key="present-upazilla"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select cssClass="validate present_address"   onChange="populateAddressOption(event, 'presentUnion');" name="presentUpazilla" label=""  value="1">
			<aui:validator name="required" errorMessage="upazilla-error-label" />
			<aui:option selected="true" >
				<liferay-ui:message key='select-label' />
			</aui:option>
		</aui:select>
	</clay:col>

	<clay:col md="6" sm="6">
			<label for="presentUnion"><liferay-ui:message key="present-union"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select cssClass="validate present_address"    name="presentUnion" label=""  value="1">
			<aui:validator name="required" errorMessage="union-error-label" />
			<aui:option selected="true" >
				<liferay-ui:message key='select-label' />
			</aui:option>
		</aui:select>
	</clay:col>

	<clay:col md="6" sm="6">
			<label for="presentVillage"><liferay-ui:message key="present-village"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input name="presentVillage" label="" required="true" value="village" cssClass="validate preview_text">
			<aui:validator name="required" errorMessage="village-error-label" />
			<aui:validator name="maxLength"
				errorMessage="maxlength-thirty-error-label">30</aui:validator>
			<aui:validator name="minLength"
				errorMessage="minlength-one-error-label">1</aui:validator>
			<aui:validator name="custom" errorMessage="name-character-error">
						function(val, fieldNode, ruleValue) {
							var regex = new RegExp("^[a-zA-Z\\s]*$");
							return regex.test(val);
						}
			</aui:validator>
		</aui:input>
	</clay:col>

	<clay:col md="6" sm="6">
			<label for="presentWard"><liferay-ui:message key="present-ward"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select cssClass="validate present_address" name="presentWard" label=""  value="ward" >
			<aui:validator name="required" errorMessage="ward-error-label" />
			<aui:option value='0' >
				<liferay-ui:message key='Ward1' />
			</aui:option>
			<aui:option  value='1'>
				<liferay-ui:message key='Ward2' />
			</aui:option>
		</aui:select>
	</clay:col>

	<clay:col md="6" sm="6">
			<label for="presentZipCode"><liferay-ui:message key="present-zip-code"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input name="presentZipCode" label="" required="true" value="1234" cssClass="validate preview_text">
			<aui:validator name="required" errorMessage="zip-error-label" />
			<aui:validator name="maxLength"
				errorMessage="zip-maxlength-error-label">5</aui:validator>
			<aui:validator name="minLength"
				errorMessage="zip-minlength-error-label">4</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</clay:col>

	<clay:col md="6" sm="6">
			<label for="presentPostOffice"><liferay-ui:message key="present-post-office"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:select cssClass="validate"   name="presentPostOffice" label="" required="true" value="1">
			<aui:validator name="required" errorMessage="post-office-error-label" />
			<aui:option value='0' >
				<liferay-ui:message key='Post1' />
			</aui:option>
			<aui:option  value='1'>
				<liferay-ui:message key='Post2' />
			</aui:option>
		</aui:select>
	</clay:col>

	<clay:col md="12" sm="6">
	    <label for="presentHouseAddress"><liferay-ui:message key="present-house-address"></liferay-ui:message></label>
		<aui:input name="presentHouseAddress" label="" required="true" value="present address " cssClass="validate preview_text">
			<aui:validator name="required"
				errorMessage="house-address-error-label" />
			<aui:validator name="maxLength"
				errorMessage="houseAddress-maxlength-error-label">50</aui:validator>
			<aui:validator name="minLength"
				errorMessage="houseAddress-minlength-error-label">10</aui:validator>
		</aui:input>
	</clay:col>

</clay:row>
</div>
<div class='form-group'>
<h3 class="subtitle"> <liferay-ui:message key="family-details"></liferay-ui:message> </h3>
<clay:row>	
	

	<clay:col md="6" sm="6">
			
		<label for="maritalStatus"><liferay-ui:message key="marital-status"></liferay-ui:message><span class="txt-red">*</span></label>
				<aui:input name="maritalStatus" type="radio" label="" value="0" required="true"></aui:input> <liferay-ui:message key="unmarried"></liferay-ui:message>
				<aui:input name="maritalStatus" type="radio" label="" value="1" required="true" checked="true"></aui:input> <liferay-ui:message key="married"></liferay-ui:message>
				<aui:input name="maritalStatus" type="radio" label="" value="2" required="true"></aui:input> <liferay-ui:message key="divorced"></liferay-ui:message>
				<aui:input name="maritalStatus" type="radio" label="" value="3" required="true"></aui:input> <liferay-ui:message key="widow"></liferay-ui:message>
				<aui:input name="maritalStatus" type="radio" label="" value="4" required="true"></aui:input> <liferay-ui:message key="widower"></liferay-ui:message>
	</clay:col>

	<clay:col md="6" sm="6">
			
		
	</clay:col>

	<clay:col md="6" sm="6">
			<label for="spouseName"><liferay-ui:message key="spouse-name"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input cssClass="validate preview_text" name="spouseName" label=""  value="spouse">
			<aui:validator name="required" errorMessage="spouse-name-error-label" />	
		<aui:validator name="maxLength"
			errorMessage="spouse-name-maxlength-error-label">30</aui:validator>
		<aui:validator name="minLength"
			errorMessage="spouse-name-minlength-error-label">1</aui:validator>
		<aui:validator name="custom" errorMessage="name-character-error">
						function(val, fieldNode, ruleValue) {
							var regex = new RegExp("^[a-zA-Z\\s]*$");
							return regex.test(val);
						}
			</aui:validator>
		</aui:input>
	</clay:col>

	<clay:col md="6" sm="6">
			<label for="spouseFatherName"><liferay-ui:message key="spouse-father-name"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input cssClass="validate preview_text" name="spouseFatherName" label=""  value="spouseFather">
			<aui:validator name="required" errorMessage="spouse-father-name-error-label" />	
		<aui:validator name="maxLength"
			errorMessage="spouse-father-name-maxlength-error-label">30</aui:validator>
		<aui:validator name="minLength"
			errorMessage="spouse-father-name-minlength-error-label">1</aui:validator>
		<aui:validator name="custom" errorMessage="name-character-error">
						function(val, fieldNode, ruleValue) {
							var regex = new RegExp("^[a-zA-Z\\s]*$");
							return regex.test(val);
						}
			</aui:validator>
		</aui:input>
	</clay:col>

	<clay:col md="6" sm="6">
			<label for="spouseNationalId"><liferay-ui:message key="spouse-national-id"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input cssClass="validate preview_text" name="spouseNationalId" label="" value="1234567899">
			<aui:validator name="required" errorMessage="spouse-nationalid-error-label" />	
			<aui:validator name="maxLength"
			errorMessage="maxlength-seventeen-error-label">17</aui:validator>
		<aui:validator name="minLength"
			errorMessage="minlength-ten-error-label">10</aui:validator>
		<aui:validator name="number" />
		</aui:input>
	</clay:col>

	<clay:col md="6" sm="6">
			<label for="spouseDateOfBirth"><liferay-ui:message key="spouse-date-of-birth"></liferay-ui:message><span class="txt-red">*</span></label>
		<aui:input cssClass="validate preview_text" name="spouseDateOfBirth" label="" value="12/12/1999">
			<aui:validator name="required" errorMessage="spouse-date-of-birth-error-label" />	
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
			<label for="familyEarningMembers"><liferay-ui:message key="family-earning-members"></liferay-ui:message></label>
		<aui:input name="familyEarningMembers" label=""  value="2" cssClass='preview_text'>
			<aui:validator name="number" />
		</aui:input>
	</clay:col>

	<clay:col md="6" sm="6">
			<label for="familyAverageMonthlyIncome"><liferay-ui:message key="family-average-monthly-income"></liferay-ui:message></label>
		<aui:select name="familyAverageMonthlyIncome" label="" value="1">
		    <aui:option  label="option1"></aui:option>
			<aui:option value="1" label="option2"></aui:option>
			<aui:option value="2" label="option3"></aui:option>
		</aui:select>
	</clay:col>

</clay:row>
</div>
<aui:button-row>
       <aui:button  value='back' onClick="showNextOrPreviousStep('nid_details');"></aui:button>
       <aui:button  value='next' onClick="validateFields('basic_info','upload');"></aui:button>

</aui:button-row>

<aui:script>


Liferay.Service(
	'/assetcategory/get-vocabulary-categories',
	{
	  parentCategoryId: 0,
	  vocabularyId: 40636,
	  start: -1,
	   end: -1,
	   orderByComparator: null 
	},
	(list) => {
			//const permanentRegion = document.getElementById('<portlet:namespace/>permanentRegion');
			const presentRegion = document.getElementById('<portlet:namespace/>presentRegion');

			if(Array.isArray(list)){
				const selectOptions = buildOptions(list);

				//permanentRegion.setAttribute('data-componentType', 'dynamic_select');
				presentRegion.setAttribute('data-componentType', 'dynamic_select');

				//permanentRegion.innerHTML = selectOptions.join('');
				presentRegion.innerHTML = selectOptions.join('');
				
			}
			

	});

function buildOptions(list){
	const selectOptions = [];

		selectOptions.push('<option value=""><liferay-ui:message key='select-label' /></option>');

		list.forEach(function (item) {	

		selectOptions.push(
                "<option value='" + item.categoryId + "'>" + item.titleCurrentValue + "</option>"
            ); 
   })
   return selectOptions;
}

function populateAddressOption(event, nextDropdownId){

const parentId = Number(event.currentTarget.value);
const select = document.getElementById('<portlet:namespace/>'+nextDropdownId);

if(parentId > 0 ){

	Liferay.Service(
		'/assetcategory/get-child-categories',
	{
	  parentCategoryId: parentId,
	},
	(list) => {
		  if(Array.isArray(list)){
		     const selectOptions = buildOptions(list);
			 select.setAttribute('data-componentType', 'dynamic_select');
		     select.innerHTML = selectOptions.join('');
		  }
		});
	}else{
		select.innerHTML = ['<option  value=""><liferay-ui:message key="select" />'].join('');
	}

}

var sameAsPermanentAddress = document.getElementById('<portlet:namespace/>sameAsPermanentAddress');

if(sameAsPermanentAddress){
	sameAsPermanentAddress.addEventListener('click',function(event){

		var checked = sameAsPermanentAddress.checked;
		const permanentAddressList = $('.permanent_address');
		permanentAddressList.each(function( index ) {

			const optionsHTML = $(this).html();
            const dataAttr = $(this).attr('data-address');
			const presentElement = $("#<portlet:namespace/>present"+dataAttr);
			presentElement.html(optionsHTML);
			presentElement.val($(this).val())
			
		  })
	
	})
	
}


</aui:script>
