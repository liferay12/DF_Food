
setTimeout(function() {
	var namespace=$("#portletNamespace").val();
	$("#"+namespace+"nationalId").val(new Date().getTime().toString()).change();
	$("#"+namespace+"dateOfBirth").val("07-02-1999").change();
	$("#"+namespace+"mobileNumber").val("01712345678").change();
	$("#"+namespace+"emailAddress").val("fims.dgfood@yopmail.com").change();
	$("#"+namespace+"password").val("Dgfoods@123");
	$("#"+namespace+"confirmPassword").val("Dgfoods@123");

	$("#"+namespace+"applicantName").val("Ashish V").change();
	$("#"+namespace+"fatherName").val("Mr VSR").change();
	$("#"+namespace+"motherName").val("Mrs VSR").change();
	$("[name="+namespace+"gender][value=2]").prop("checked",true).change();
	$("[name="+namespace+"maritalStatus][value=2]").prop("checked",true).change();
	$("#"+namespace+"krishokCardNumber").val("KC"+new Date().getTime().toString()).change();
	
	$("#"+namespace+"permanentRegion").val("38633").change();

	setTimeout(function(){
		$("#"+namespace+"permanentZilla").val("38645").change();
	}, 500);
	setTimeout(function(){
		$("#"+namespace+"permanentUpazilla").val("38651").change();
	}, 1000);
	setTimeout(function(){
		$("#"+namespace+"permanentUnion").val("38658").change();
	}, 1500);
	setTimeout(function(){
		$("#"+namespace+"permanentWard").val("38473").change();
	}, 2000);

	$("#"+namespace+"permanentVillage").val("Rayagada").change();
	$("#"+namespace+"permanentZipCode").val("75017").change();
	$("#"+namespace+"permanentPostOffice").val("Chandili").change();
	$("#"+namespace+"permanentAddress").val("JKPM Colony, Near Water tank").change();

	$("#"+namespace+"presentRegion").val("38633").change();

	setTimeout(function(){
		$("#"+namespace+"presentZilla").val("38645").change();
	}, 500);
	setTimeout(function(){
		$("#"+namespace+"presentUpazilla").val("38651").change();
	}, 1000);
	setTimeout(function(){
		$("#"+namespace+"presentUnion").val("38658").change();
	}, 1500);
	setTimeout(function(){
		$("#"+namespace+"presentWard").val("38473").change();
	}, 2000);

	$("#"+namespace+"presentVillage").val("Rayagada").change();
	$("#"+namespace+"presentZipCode").val("75017").change();
	$("#"+namespace+"presentPostOffice").val("Chandili").change();
	$("#"+namespace+"presentAddress").val("JKPM Colony, Near Water tank").change();

	$("#"+namespace+"cultivableLandSeason1Name").val("amon").change();
	$("#"+namespace+"cultivableLandSeason1Area").val("25").change();
	$("#"+namespace+"cultivableLandSeason1Unit").val("bigha").change();
	$("#"+namespace+"cultivableLandSeason2Name").val("boro").change();
	$("#"+namespace+"cultivableLandSeason2Area").val("27").change();
	$("#"+namespace+"cultivableLandSeason2Unit").val("bigha").change();
	$("#"+namespace+"cultivableLandSeason3Name").val("wheat").change();
	$("#"+namespace+"cultivableLandSeason3Area").val("22").change();
	$("#"+namespace+"cultivableLandSeason3Unit").val("hectare").change();

},1000);