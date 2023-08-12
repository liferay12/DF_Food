<%@ include file="../init.jsp"%>

<%
	FFPBeneficiary ffpBeneficiary = (FFPBeneficiary) request.getAttribute("ffpBeneficiary");
	Format dateFormat = FastDateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy");
	
%>


<br />
<h3 class="subtitle">
	<liferay-ui:message key="personal-details"></liferay-ui:message>
</h3>
<clay:row>
	<clay:col md="6" sm="6">
		<liferay-ui:message key="name"></liferay-ui:message> : <span
			id='<portlet:namespace/>name_preview'><%=ffpBeneficiary != null ? ffpBeneficiary.getName() : StringPool.BLANK%></span>
	</clay:col>
	<clay:col md="6" sm="6">
		<liferay-ui:message key="father-name"></liferay-ui:message> : <span
			id='<portlet:namespace/>fatherName_preview'><%=ffpBeneficiary != null ? ffpBeneficiary.getFatherName() : StringPool.BLANK%></span>
	</clay:col>
	<clay:col md="6" sm="6">
		<liferay-ui:message key="national-id"></liferay-ui:message> : <span
			id='<portlet:namespace/>nationalId_preview'><%=ffpBeneficiary != null ? ffpBeneficiary.getNationalId() : StringPool.BLANK%></span>
	</clay:col>
	<clay:col md="6" sm="6">
		<liferay-ui:message key="mother-name"></liferay-ui:message> : <span
			id='<portlet:namespace/>motherName_preview'><%=ffpBeneficiary != null ? ffpBeneficiary.getMotherName() : StringPool.BLANK%></span>
	</clay:col>
	<clay:col md="6" sm="6">
		<liferay-ui:message key="mobile-number"></liferay-ui:message> : <span
			id='<portlet:namespace/>mobileNumber_preview'><%=ffpBeneficiary != null ? ffpBeneficiary.getMobileNumber() : StringPool.BLANK%></span>
	</clay:col>
	<clay:col md="6" sm="6">
		<liferay-ui:message key="date-of-birth"></liferay-ui:message> : <span
			id='<portlet:namespace/>dateOfBirth_preview'><%=ffpBeneficiary != null ? dateFormat.format(ffpBeneficiary.getDateOfBirth())
							: StringPool.BLANK%></span>
	</clay:col>
	<clay:col md="6" sm="6">
		<liferay-ui:message key="gender"></liferay-ui:message> : <span
			id='<portlet:namespace/>gender_preview'><%=ffpBeneficiary != null ? ffpBeneficiary.getGender() : StringPool.BLANK%></span>
	</clay:col>

</clay:row>


<h3 class="subtitle">
	<liferay-ui:message key="family-details"></liferay-ui:message>
</h3>
<clay:row>
	<clay:col md="6" sm="6">
		<liferay-ui:message key="marital-status"></liferay-ui:message> : <span
			id='<portlet:namespace/>maritalStatus_preview'><%=ffpBeneficiary != null ? ffpBeneficiary.getMaritalStatus() : StringPool.BLANK%></span>
	</clay:col>
	<clay:col md="6" sm="6">
		<liferay-ui:message key="spouse-date-of-birth"></liferay-ui:message> : <span
			id='<portlet:namespace/>spouseDateOfBirth_preview'><%=ffpBeneficiary != null ? dateFormat.format(ffpBeneficiary.getSpouseDateOfBirth())
							: StringPool.BLANK%></span>
	</clay:col>
	<clay:col md="6" sm="6">
		<liferay-ui:message key="spouse-name"></liferay-ui:message> : <span
			id='<portlet:namespace/>spouseName_preview'><%=ffpBeneficiary != null ? ffpBeneficiary.getSpouseName() : StringPool.BLANK%></span>
	</clay:col>
	<clay:col md="6" sm="6">
		<liferay-ui:message key="family-earning-members"></liferay-ui:message> : <span
			id='<portlet:namespace/>familyEarningMembers_preview'><%=ffpBeneficiary != null ? ffpBeneficiary.getFamilyEarningMembers() : StringPool.BLANK%></span>
	</clay:col>
	<clay:col md="6" sm="6">
		<liferay-ui:message key="spouse-national-id"></liferay-ui:message> : <span
			id='<portlet:namespace/>spouseNationalId_preview'><%=ffpBeneficiary != null ? ffpBeneficiary.getSpouseNationalId() : StringPool.BLANK%></span>
	</clay:col>
	<clay:col md="6" sm="6">
		<liferay-ui:message key="family-average-monthly-income"></liferay-ui:message> : <span
			id='<portlet:namespace/>familyAverageMonthlyIncome_preview'><%=ffpBeneficiary != null ? ffpBeneficiary.getFamilyAverageMonthlyIncome()
							: StringPool.BLANK%></span>
	</clay:col>
</clay:row>



<clay:row>
	<clay:col md="6" sm="6">
		<h3 class="subtitle">
			<liferay-ui:message key="permanent-address"></liferay-ui:message>
		</h3>
	</clay:col>
	<clay:col md="6" sm="6">
		<h3 class="subtitle">
			<liferay-ui:message key="present-address"></liferay-ui:message>
		</h3>
	</clay:col>

	<clay:col md="6" sm="6">
		<clay:col md="6" sm="6">
			<liferay-ui:message key="permanent-region"></liferay-ui:message> : <span
				id='<portlet:namespace/>permanentRegion_preview'></span>
		</clay:col>
		<clay:col md="6" sm="6">
			<liferay-ui:message key="permanent-zilla"></liferay-ui:message> : <span
				id='<portlet:namespace/>permanentZilla_preview'></span>
		</clay:col>
		<clay:col md="6" sm="6">
			<liferay-ui:message key="permanent-upazilla"></liferay-ui:message> : <span
				id='<portlet:namespace/>permanentUpazilla_preview'></span>
		</clay:col>
		<clay:col md="6" sm="6">
			<liferay-ui:message key="permanent-union"></liferay-ui:message> : <span
				id='<portlet:namespace/>permanentUnion_preview'></span>
		</clay:col>
		<clay:col md="6" sm="6">
			<liferay-ui:message key="permanent-village"></liferay-ui:message> : <span
				id='<portlet:namespace/>permanentVillage_preview'></span>
		</clay:col>
		<clay:col md="6" sm="6">
			<liferay-ui:message key="permanent-ward"></liferay-ui:message> : <span
				id='<portlet:namespace/>permanentWard_preview'></span>
		</clay:col>
		<clay:col md="6" sm="6">
			<liferay-ui:message key="permanent-zip-code"></liferay-ui:message> : <span
				id='<portlet:namespace/>permanentZipCode_preview'></span>
		</clay:col>
		<clay:col md="6" sm="6">
			<liferay-ui:message key="permanent-post-office"></liferay-ui:message> : <span
				id='<portlet:namespace/>permanentPostOffice_preview'></span>
		</clay:col>
		<clay:col md="6" sm="6">
			<liferay-ui:message key="permanent-house-address"></liferay-ui:message> : <span
				id='<portlet:namespace/>permanentHouseAddress_preview'></span>
		</clay:col>
	</clay:col>

	<clay:col md="6" sm="6">
		<clay:col md="6" sm="6">
			<liferay-ui:message key="present-region"></liferay-ui:message> : <span
				id='<portlet:namespace/>presentRegion_preview'></span>
		</clay:col>
		<clay:col md="6" sm="6">
			<liferay-ui:message key="present-zilla"></liferay-ui:message> : <span
				id='<portlet:namespace/>presentZilla_preview'></span>
		</clay:col>
		<clay:col md="6" sm="6">
			<liferay-ui:message key="present-upazilla"></liferay-ui:message> : <span
				id='<portlet:namespace/>presentUpazilla_preview'></span>
		</clay:col>
		<clay:col md="6" sm="6">
			<liferay-ui:message key="present-union"></liferay-ui:message> : <span
				id='<portlet:namespace/>presentUnion_preview'></span>
		</clay:col>
		<clay:col md="6" sm="6">
			<liferay-ui:message key="permanent-village"></liferay-ui:message> : <span
				id='<portlet:namespace/>presentVillage_preview'></span>
		</clay:col>
		<clay:col md="6" sm="6">
			<liferay-ui:message key="present-ward"></liferay-ui:message> : <span
				id='<portlet:namespace/>presentWard_preview'></span>
		</clay:col>
		<clay:col md="6" sm="6">
			<liferay-ui:message key="present-zip-code"></liferay-ui:message> : <span
				id='<portlet:namespace/>presentZipCode_preview'></span>
		</clay:col>
		<clay:col md="6" sm="6">
			<liferay-ui:message key="present-post-office"></liferay-ui:message> : <span
				id='<portlet:namespace/>presentPostOffice_preview'></span>
		</clay:col>
		<clay:col md="6" sm="6">
			<liferay-ui:message key="present-house-address"></liferay-ui:message> : <span
				id='<portlet:namespace/>presentHouseAddress_preview'></span>
		</clay:col>
	</clay:col>
</clay:row>


<h3 class="subtitle">
	<liferay-ui:message key="documents"></liferay-ui:message>
</h3>
<clay:row>
	<clay:col md="6" sm="6">
		<liferay-ui:message key="photograph"></liferay-ui:message>
		<a id="<portlet:namespace/>photographLink" href="" target="_blank">
			<img id="<portlet:namespace/>photographImg"
			style='width: 200px; height: 200px;'></img>
		</a>
	</clay:col>
	<clay:col md="6" sm="6">
		<liferay-ui:message key="signature"></liferay-ui:message>
		<a id="<portlet:namespace/>signatureLink" href="" target="_blank">
			<img id="<portlet:namespace/>signatureImg"
			style='width: 200px; height: 200px;'></img>
		</a>
	</clay:col>
	<clay:col class='col-12'>
		<liferay-ui:message key="additional-doc"></liferay-ui:message>
		<div class="multipleDocs"></div>
	</clay:col>
</clay:row>
