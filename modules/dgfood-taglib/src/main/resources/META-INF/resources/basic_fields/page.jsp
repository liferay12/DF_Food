<%@page import="bd.gov.dgfood.common.util.constants.ParameterLabelConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.ParameterConstants"%>
<%@page import="bd.gov.dgfood.taglib.servlet.taglib.BasicInformation"%>
<%@page import="bd.gov.dgfood.common.util.constants.MaritalStatusConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.GenderConstants"%>
<%@page import="bd.gov.dgfood.common.util.constants.CategoryConstants"%>
<%@page import="bd.gov.dgfood.common.util.CategoryUtil"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.asset.kernel.model.AssetCategory"%>
<%@include file="/basic_fields/init.jsp" %>

<%
try{
	
boolean showAlertMessage = (Boolean)request.getAttribute("dgfood-ui:page-access-status-verifier:showAlertMessage");
String addressLabel = StringPool.BLANK;
String addressType = (String)request.getAttribute("dgfood-ui:addressType");
boolean nameFields = (Boolean)request.getAttribute("dgfood-ui:nameFields");
boolean genderField = (Boolean)request.getAttribute("dgfood-ui:genderField");
boolean maritalStatusField = (Boolean)request.getAttribute("dgfood-ui:maritalStatusField");
boolean addressField = (Boolean)request.getAttribute("dgfood-ui:addressField");

boolean isDisabled=false;
if(Validator.isNotNull(request.getAttribute("dgfood-ui:isDisabled")))
{
	isDisabled = (Boolean)request.getAttribute("dgfood-ui:isDisabled");
}

BasicInformation basicInformation=new BasicInformation();
if(Validator.isNotNull(request.getAttribute("dgfood-ui:basicInformation")))
{
	basicInformation = (BasicInformation)request.getAttribute("dgfood-ui:basicInformation");
}
boolean isAddressValueAvailable=false;
if(Validator.isNotNull(basicInformation.getAddress()))
{
	isAddressValueAvailable=true;
}

List<AssetCategory> divisionList = new ArrayList<AssetCategory>();
divisionList = CategoryUtil.fetchCategoriesbyVocabularyNameAndParentId(themeDisplay, CategoryConstants.LOCATION, CategoryConstants.ZERO);
if(divisionList != null && !divisionList.isEmpty()) {
	System.out.println("Division attribute is not null...");
	for(AssetCategory assetCategory:divisionList){
		System.out.println(assetCategory.getCategoryId());
	}
}else {
	System.out.println("Division attribute is null...");
}
	if(nameFields || genderField || maritalStatusField){
%>
<h3><liferay-ui:message key="label-basic-information" /></h3>
<div class="row">
<% 
	if(nameFields){
%>
	<div class="col-6">
		<aui:input name="<%=ParameterConstants.APPLICANT_NAME%>" 
			label="<%=ParameterLabelConstants.LABEL_APPLICANT_NAME%>"
			placeholder="<%=ParameterLabelConstants.LABEL_APPLICANT_NAME%>" 
			value="<%=basicInformation.getApplicantName() %>" 
			cssClass="form-control validate preview" disabled="<%=isDisabled %>"
			type="text" minLength="1" maxLength="30">
			<aui:validator name="required" errorMessage="error-label-applicant-name" />
			<aui:validator name="maxLength" errorMessage="error-label-max-length-thirty">30</aui:validator>
			<aui:validator name="minLength" errorMessage="error-label-min-length-one">1</aui:validator>
			<aui:validator name="custom" errorMessage="error-label-invalid-character">
							function(val, fieldNode, ruleValue) {
								var regex = new RegExp("^[a-zA-Z\\s]*$");
								return regex.test(val);
							}
			</aui:validator>
		</aui:input>
	</div>

	<div class="col-6">
		<aui:input name="<%=ParameterConstants.FATHER_NAME%>"
			label="<%=ParameterLabelConstants.LABEL_FATHER_NAME%>"
			placeholder="<%=ParameterLabelConstants.LABEL_FATHER_NAME%>"
			value="<%=basicInformation.getFatherName() %>" 
			cssClass="form-control validate preview" disabled="<%=isDisabled %>" 
			type="text" maxLength="30" minLength="1">
			<aui:validator name="required" errorMessage="error-label-father-name" />
			<aui:validator name="maxLength"
				errorMessage="error-label-max-length-thirty">30</aui:validator>
			<aui:validator name="minLength"
				errorMessage="error-label-min-length-one" >1</aui:validator>
			<aui:validator name="custom" errorMessage="error-label-invalid-character" >
						function(val, fieldNode, ruleValue) {
							var regex = new RegExp("^[a-zA-Z\\s]*$");
							return regex.test(val);
						}
			</aui:validator>
		</aui:input>
	</div>

	<div class="col-6">
		<aui:input name="<%=ParameterConstants.MOTHER_NAME%>"
			label="<%=ParameterLabelConstants.LABEL_MOTHER_NAME%>" 
			placeholder="<%=ParameterLabelConstants.LABEL_MOTHER_NAME%>"
			value="<%=basicInformation.getMothername() %>" 
			type="text" maxLength="30" minLength="1"
			cssClass="form-control validate preview" disabled="<%=isDisabled %>" >
			<aui:validator name="required" errorMessage="error-label-mother-name" />
			<aui:validator name="maxLength"
				errorMessage="error-label-max-length-thirty">30</aui:validator>
			<aui:validator name="minLength"
				errorMessage="error-label-min-length-one">1</aui:validator>
			<aui:validator name="custom" errorMessage="error-label-invalid-character">
						function(val, fieldNode, ruleValue) {
							var regex = new RegExp("^[a-zA-Z\\s]*$");
							return regex.test(val);
						}
			</aui:validator>
		</aui:input>
	</div>
	<%
		}if(genderField){
	%>
	<div class="col-6">
		<aui:input name="<%=ParameterConstants.GENDER%>"  cssClass="validate preview" disabled="<%=isDisabled %>" type="radio" 
			label="<%=GenderConstants.LABEL_MALE%>" value="<%=String.valueOf(GenderConstants.GENDER_MALE) %>"
			checked="<%=(basicInformation.getGender() == GenderConstants.GENDER_MALE) ? true:false %>"></aui:input>
		<aui:input name="<%=ParameterConstants.GENDER%>"  cssClass="validate preview" disabled="<%=isDisabled %>" type="radio" 
			label="<%=GenderConstants.LABEL_FEMALE%>" value="<%=String.valueOf(GenderConstants.GENDER_FEMALE) %>"
			checked="<%=(basicInformation.getGender()==GenderConstants.GENDER_FEMALE) ? true:false %>"></aui:input>
		<aui:input name="<%=ParameterConstants.GENDER%>"  cssClass="validate preview" disabled="<%=isDisabled %>" type="radio" 
			label="<%=GenderConstants.LABEL_OTHER%>" value="<%=String.valueOf(GenderConstants.GENDER_OTHER) %>"
			checked="<%=(basicInformation.getGender()==GenderConstants.GENDER_OTHER) ? true:false %>"></aui:input>
	</div>
	<%
		}if(maritalStatusField){
	%>
	<div class="col-6">
		<aui:input name="<%=ParameterConstants.MARITAL_STATUS%>"  cssClass="validate preview" disabled="<%=isDisabled %>" type="radio"
			label="<%=MaritalStatusConstants.LABEL_UNMARRIED%>" 
			value="<%=MaritalStatusConstants.MARITAL_STATUS_UNMARRIED %>"
			checked="<%=(basicInformation.getMaritalStatus()==MaritalStatusConstants.MARITAL_STATUS_UNMARRIED)?true:false %>"></aui:input>
		<aui:input name="<%=ParameterConstants.MARITAL_STATUS%>"  cssClass="validate preview" disabled="<%=isDisabled %>" type="radio"
			label="<%=MaritalStatusConstants.LABEL_MARRIED%>" 
			value="<%=MaritalStatusConstants.MARITAL_STATUS_MARRIED %>"
			checked="<%=(basicInformation.getMaritalStatus()==MaritalStatusConstants.MARITAL_STATUS_MARRIED)?true:false %>"></aui:input>
		<aui:input name="<%=ParameterConstants.MARITAL_STATUS%>"  cssClass="validate preview" disabled="<%=isDisabled %>" type="radio"
			label="<%=MaritalStatusConstants.LABEL_DIVORCED%>" 
			value="<%=MaritalStatusConstants.MARITAL_STATUS_DIVORCED %>"
			checked="<%=(basicInformation.getMaritalStatus()==MaritalStatusConstants.MARITAL_STATUS_DIVORCED)?true:false %>"></aui:input>
		<aui:input name="<%=ParameterConstants.MARITAL_STATUS%>" cssClass="validate preview" disabled="<%=isDisabled %>" type="radio"
			label="<%=MaritalStatusConstants.LABEL_WIDOW%>" 
			value="<%=MaritalStatusConstants.MARITAL_STATUS_WIDOW %>"
			checked="<%=(basicInformation.getMaritalStatus()==MaritalStatusConstants.MARITAL_STATUS_WIDOW)?true:false %>"></aui:input>
		<aui:input name="<%=ParameterConstants.MARITAL_STATUS%>"  cssClass="validate preview" disabled="<%=isDisabled %>" type="radio"
			label="<%=MaritalStatusConstants.LABEL_WIDOWER%>" 
			value="<%=MaritalStatusConstants.MARITAL_STATUS_WIDOWER %>"
			checked="<%=(basicInformation.getMaritalStatus()==MaritalStatusConstants.MARITAL_STATUS_WIDOWER)?true:false %>"></aui:input>
	</div>
	<%
		}
	%>
</div>

<div class="row">
	<aui:input name="<%=ParameterConstants.PROFILE_PHOTOGRAPH%>" type="hidden" value="" />
	<div>
		<label>NID Picture</label>
		<img id="<%=ParameterConstants.NID_PROFILE_PHOTOGRAPH + "Preview"%>" style='width: 100px; height: 100px;'></img>
	</div>
	
</div>

<%
	}if(addressField){
		if(Validator.isNull(addressType) || addressType.isEmpty()){
			addressType = StringPool.BLANK;
		}else{
			
			addressType = addressType.trim().toLowerCase();
		}
		
		if(Validator.isNull(addressLabel) || addressLabel.isEmpty()){
			addressLabel = StringPool.BLANK;
		}else{
			addressLabel = addressLabel.trim().toLowerCase();
		}
%>
<h3>
<liferay-ui:message key="label-address-information" />
</h3>
<div class="row">
	<div class="col-6">
		<aui:select name='<%=addressType+"Region"%>' label="<%=ParameterLabelConstants.LABEL_REGION%>"
			onChange='<%="populateAddressOption(this.id,'Zilla','"+ addressType+"');" %>' 
			cssClass='<%=addressType+"level-0" + " validate preview"%>'  disabled="<%=isDisabled %>">
			<aui:validator name="required" errorMessage="error-label-region-or-division" />
			<aui:option selected="true">
				<liferay-ui:message key="label-select" />
			</aui:option>
			<%
				for (AssetCategory divisionCategory : divisionList) {
				if(isAddressValueAvailable && basicInformation.getAddress().getRegion()==divisionCategory.getCategoryId()){
			%>
					<aui:option value="<%=divisionCategory.getCategoryId()%>"
						label="<%=divisionCategory.getTitle(themeDisplay.getLocale())%>" selected="<%=true %>"></aui:option>
				<%
					}else{
					
				%>
					<aui:option value="<%=divisionCategory.getCategoryId()%>"
						label="<%=divisionCategory.getTitle(themeDisplay.getLocale())%>"></aui:option>
			<%
				}}
			%>
		</aui:select>
	</div>

	<div class="col-6">
		<aui:select name='<%=addressType+"Zilla"%>' label="<%=ParameterLabelConstants.LABEL_ZILLA%>"
			onChange='<%="populateAddressOption(this.id,'Upazila','"+ addressType+"');" %>' 
			cssClass='<%=addressType+"level-1" + " validate preview"%>'  disabled="<%=isDisabled %>">
			<aui:validator name="required" errorMessage="error-label-district-or-zilla" />
			<aui:option selected="true">
				<liferay-ui:message key="label-select" />
			</aui:option>
			<%if(isAddressValueAvailable){ %>
				<aui:option value="<%=basicInformation.getAddress().getDistrict()%>" selected="<%=true %>"
						label="<%=basicInformation.getAddressCategories().get(basicInformation.getAddress().getDistrict()).getTitle(themeDisplay.getLocale())%>"></aui:option>
			<%
				}
			%>
		</aui:select>
	</div>

	<div class="col-6">
		<aui:select name='<%=addressType+"Upazila"%>' label="<%=ParameterLabelConstants.LABEL_UPAZILA%>"
			onChange='<%="populateAddressOption(this.id,'CityMetropolis','"+ addressType+"');" %>' 
			cssClass='<%=addressType+"level-2" + " validate preview"%>'  disabled="<%=isDisabled %>">
			<aui:validator name="required" errorMessage="error-label-upazila" />
			<aui:option selected="true">
				<liferay-ui:message key="label-select" />
			</aui:option>
			<%if(isAddressValueAvailable){ %>
				<aui:option value="<%=basicInformation.getAddress().getUpazilla()%>" selected="<%=true %>"
						label="<%=basicInformation.getAddressCategories().get(basicInformation.getAddress().getUpazilla()).getTitle(themeDisplay.getLocale())%>"></aui:option>
			<%
				}
			%>
		</aui:select>
	</div>
	<div class="col-6">
		<aui:select name='<%=addressType+"CityMetropolis"%>' label="<%=ParameterLabelConstants.LABEL_CITY_METROPOLIS%>"
			onChange='<%="populateAddressOption(this.id,'CityCorporationOrMuncipalty','"+ addressType+"');" %>' 
			cssClass='<%=addressType+"level-3" + " validate preview"%>'  disabled="<%=isDisabled %>">
			<aui:validator name="required" errorMessage="error-label-city-metropolis" />
			<aui:option selected="true">
				<liferay-ui:message key="label-select" />
			</aui:option>
			<%if(isAddressValueAvailable){ %>
				<aui:option value="<%=basicInformation.getAddress().getUpazilla()%>" selected="<%=true %>"
						label="<%=basicInformation.getAddressCategories().get(basicInformation.getAddress().getUpazilla()).getTitle(themeDisplay.getLocale())%>"></aui:option>
			<%
				}
			%>
		</aui:select>
	</div>
	
	<div class="col-6">
		<aui:select name='<%=addressType+"CityCorporationOrMuncipalty"%>' label="<%=ParameterLabelConstants.LABEL_CITY_CORPORATION_OR_MUNICIPALITY%>"
			onChange='<%="populateAddressOption(this.id,'Union','"+ addressType+"');" %>' 
			cssClass='<%=addressType+"level-4" + " validate preview"%>'  disabled="<%=isDisabled %>">
			<aui:validator name="required" errorMessage="error-label-city-corporation-or-muncipalty" />
			<aui:option selected="true">
				<liferay-ui:message key="label-select" />
			</aui:option>
			<%if(isAddressValueAvailable){ %>
				<aui:option value="<%=basicInformation.getAddress().getUpazilla()%>" selected="<%=true %>"
						label="<%=basicInformation.getAddressCategories().get(basicInformation.getAddress().getUpazilla()).getTitle(themeDisplay.getLocale())%>"></aui:option>
			<%
				}
			%>
		</aui:select>
	</div>

	<div class="col-6">
		<aui:select name='<%=addressType+"Union"%>' label="<%=ParameterLabelConstants.LABEL_UNION%>"
			cssClass='<%=addressType+"level-5" + " validate preview"%>'  disabled="<%=isDisabled %>">
			<aui:validator name="required" errorMessage="error-label-union" />
			<aui:option selected="true">
				<liferay-ui:message key="label-select" />
			</aui:option>
		</aui:select>
	</div>

	<div class="col-6">
		<aui:input name='<%=addressType+"Village"%>' label="<%=ParameterLabelConstants.LABEL_VILLAGE%>" 
			placeholder="<%=ParameterLabelConstants.LABEL_VILLAGE%>"
			value="<%=(isAddressValueAvailable)?basicInformation.getAddress().getVillageOrRoad():StringPool.BLANK %>"
			type="text" cssClass="form-control validate preview" disabled="<%=isDisabled %>"
			maxLength="30" minLength="1">
			<aui:validator name="required" errorMessage="error-label-village-or-mohalla" />
			<aui:validator name="maxLength" errorMessage="error-label-max-length-thirty">30</aui:validator>
			<aui:validator name="minLength" errorMessage="error-label-min-length-one">1</aui:validator>
			<aui:validator name="custom" errorMessage="error-label-invalid-character">
				function(val, fieldNode, ruleValue) {
					var regex = new RegExp("^[a-zA-Z\\s]*$");
					return regex.test(val);
				}
			</aui:validator>
		</aui:input>
	</div>

	<div class="col-6">
		<aui:input name='<%=addressType+"Ward"%>' label="<%=ParameterLabelConstants.LABEL_WARD%>"
			placeholder="<%=ParameterLabelConstants.LABEL_WARD%>"
			value="<%=(isAddressValueAvailable)?basicInformation.getAddress().getPostOffice():StringPool.BLANK %>"
			cssClass="form-control validate preview" disabled="<%=isDisabled %>" 
			type="text" maxLength="10" minLength="5">
			<aui:validator name="required" errorMessage="error-ward" />
			<aui:validator name="maxLength" errorMessage="error-label-max-length-ten">10</aui:validator>
			<aui:validator name="minLength" errorMessage="error-label-min-length-five">5</aui:validator>
			<aui:validator name="custom" errorMessage="error-label-invalid-character">
						function(val, fieldNode, ruleValue) {
							var regex = new RegExp("^[a-zA-Z0-9\\s]*$");
							return regex.test(val);
						}
			</aui:validator>
		</aui:input>
	</div>

	<div class="col-6">
		<aui:input name='<%=addressType+"ZipCode"%>' label="<%=ParameterLabelConstants.LABEL_ZIP_CODE%>"
			placeholder="<%=ParameterLabelConstants.LABEL_ZIP_CODE%>"
			value="<%=(isAddressValueAvailable)?basicInformation.getAddress().getZipCode():StringPool.BLANK %>"
			cssClass="form-control validate preview" disabled="<%=isDisabled %>" 
			type="text" maxLength="6" minLength="4">
			<aui:validator name="required" errorMessage="error-label-zip-code-or-post-code" />
			<aui:validator name="maxLength" errorMessage="error-label-max-length-six">6</aui:validator>
			<aui:validator name="minLength" errorMessage="error-label-min-length-four">4</aui:validator>
			<aui:validator name="number" />
		</aui:input>
	</div>
	
	<div class="col-6">
		<aui:input name='<%=addressType+"PostOffice"%>' label="<%=ParameterLabelConstants.LABEL_POST_OFFICE%>"
			placeholder="<%=ParameterLabelConstants.LABEL_POST_OFFICE%>"
			value="<%=(isAddressValueAvailable)?basicInformation.getAddress().getPostOffice():StringPool.BLANK %>"
			cssClass="form-control validate preview" disabled="<%=isDisabled %>" 
			type="text" maxLength="10" minLength="5">
			<aui:validator name="required" errorMessage="error-label-post-office" />
			<aui:validator name="maxLength" errorMessage="error-label-max-length-ten">10</aui:validator>
			<aui:validator name="minLength" errorMessage="error-label-min-length-five">5</aui:validator>
			<aui:validator name="custom" errorMessage="error-label-invalid-character">
						function(val, fieldNode, ruleValue) {
							var regex = new RegExp("^[a-zA-Z0-9\\s]*$");
							return regex.test(val);
						}
			</aui:validator>
		</aui:input>
	</div>
	
	<div class="col-6">
		<aui:input name='<%=addressType+"MouzaOrMoholla"%>' label="<%=ParameterLabelConstants.LABEL_MOUZA_OR_MOHOLLA%>" 
			placeholder="<%=ParameterLabelConstants.LABEL_VILLAGE%>"
			value="<%=(isAddressValueAvailable)?basicInformation.getAddress().getVillageOrRoad():StringPool.BLANK %>"
			type="text" cssClass="form-control validate preview" disabled="<%=isDisabled %>"
			maxLength="30" minLength="1">
			<aui:validator name="required" errorMessage="error-label-village-or-mohalla" />
			<aui:validator name="maxLength" errorMessage="error-label-max-length-thirty">30</aui:validator>
			<aui:validator name="minLength" errorMessage="error-label-min-length-one">1</aui:validator>
			<aui:validator name="custom" errorMessage="error-label-invalid-character">
				function(val, fieldNode, ruleValue) {
					var regex = new RegExp("^[a-zA-Z\\s]*$");
					return regex.test(val);
				}
			</aui:validator>
		</aui:input>
	</div>

	<div class="col-12">
		<aui:input name='<%=addressType+"HouseAddress"%>' label="<%=ParameterLabelConstants.LABEL_HOUSE_ADDRESS%>"
			placeholder="<%=ParameterLabelConstants.LABEL_HOUSE_ADDRESS%>"
			value="<%=(isAddressValueAvailable)?basicInformation.getAddress().getAddress():StringPool.BLANK %>"
			cssClass="form-control validate preview" disabled="<%=isDisabled %>"
			type="text" maxLength="50" minLength="10">
			<aui:validator name="required" errorMessage="error-label-address" />
			<aui:validator name="maxLength" errorMessage="error-label-max-length-fifty">50</aui:validator>
			<aui:validator name="minLength" errorMessage="error-label-min-length-ten">10</aui:validator>
			<aui:validator name="custom" errorMessage="error-label-invalid-character">
						function(val, fieldNode, ruleValue) {
							var regex = new RegExp("^[a-zA-Z0-9\\s,]*$");
							return regex.test(val);
						}
			</aui:validator>
		</aui:input>
	</div>
</div>
<%
	}
%>
<script>

//============================Address Population Code========================//
function populateAddressOption(currentDropdownId, nextDropdownId,currAddressType) {


if(currentDropdownId.indexOf(currAddressType) != -1){
	nextDropdownId = currAddressType + nextDropdownId;	
}

console.log("next Id - "+nextDropdownId);

var classNames = $('#<portlet:namespace/>'+nextDropdownId).attr("class").split(" ");
for(var num = 0; num < classNames.length; num++){
	var clsName = classNames[num];
	if(clsName.includes("level")){
		var addressType = clsName.split("-")[0];
		var level = clsName.split("-")[1];
		var maxlevel = 5;
		emptyDropdown(addressType,level, maxlevel);
	}
}
var address=[];
var currentDropdownValue = $("#"+currentDropdownId).val();
var langid = themeDisplay.getLanguageId();
if(currentDropdownValue !="" || currentDropdownValue != null){

		Liferay.Util.fetch(
			themeDisplay.getPortalURL()+'/o/tld/get-all-categories?categoryId='+currentDropdownValue+'&languageId='+langid)
		.then((response) => {
		console.log('response',response)
		      return response.json()
		}).then((dataObj) => {
		console.log('dataObj',dataObj)
		      if(dataObj != null){
				address = dataObj["options"];
				$(address).each(function(val, key) {
					$('#<portlet:namespace/>'+nextDropdownId).append("<option value='" + key.id + "'>" + key.name + "</option>");
				});
			}
		});
	}
}
//============================Empty Address Fields Code========================//
function emptyDropdown(addressType, level, maxlevel) {
	
	for(var num = level; num <= maxlevel; num++){
		$('.'+addressType+'-'+num)
		.find('option')
		.remove()
		.end()
		.append("<option selected='true' value=''>"+ "label-select" +"</option>");
	}
}
</script>
<%
}catch(Exception e){
e.printStackTrace();
}
%>