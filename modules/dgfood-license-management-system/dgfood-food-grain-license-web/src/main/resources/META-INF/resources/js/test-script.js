setTimeout(function() {
	var namespace=$("#portletNamespace").val();
	$("#"+namespace+"nationalId").val(new Date().getTime().toString().substring(0,10)).change();
	$("#"+namespace+"dateOfBirth").val("07-02-1999").change();
	$("#"+namespace+"mobileNumber").val("01712345678").change();
	$("#"+namespace+"emailAddress").val("ashishv@gmail.com").change();
	$("#"+namespace+"password").val("Dgfoods@123");
	$("#"+namespace+"confirmPassword").val("Dgfoods@123");

	$("[name="+namespace+"maritalStatus][value=2]").prop("checked",true).change();

	$("#"+namespace+"presentRegion").val("45089").change();
	setTimeout(function(){
		$("#"+namespace+"presentZilla").val("45114").change();
	}, 500);
	setTimeout(function(){
		$("#"+namespace+"presentUpazila").val("45138").change();
	}, 1000);
	setTimeout(function(){
		$("#"+namespace+"presentCityMetropolis").val("45162").change();
	}, 1500);
	setTimeout(function(){
		$("#"+namespace+"presentCityCorporationOrMuncipalty").val("45903").change();
	}, 2000);
	setTimeout(function(){
		$("#"+namespace+"presentUnion").val("45907").change();
	}, 2500);

	$("#"+namespace+"presentVillage").val("Pune").change();
	$("#"+namespace+"presentWard").val("Ward2").change();
	$("#"+namespace+"presentZipCode").val("44490").change();
	$("#"+namespace+"presentPostOffice").val("Dubai").change();
	$("#"+namespace+"presentMouzaOrMoholla").val("NewMouza").change();
	$("#"+namespace+"presentHouseAddress").val("JKPM Colony Near Water tank").change();

	$("#"+namespace+"tradeLicenseNumber").val(new Date().getTime().toString().substring(0,10)).change();
	$("#"+namespace+"tradeLicenseValidity").val("07-02-2023").change();
	$("#"+namespace+"tradeLicenseIssuerCode").val("23243").change();
	$("#"+namespace+"tradeLicenseIssurCity").val("Mumbai").change();
	
	$("#"+namespace+"businessName").val("Hello World Dealer Business").change();
	$("#"+namespace+"businessType").val("Dealer").change();
	
	$("#"+namespace+"businessRegion").val("45089").change();
	setTimeout(function(){
		$("#"+namespace+"businessZilla").val("45114").change();
	}, 500);
	setTimeout(function(){
		$("#"+namespace+"businessUpazila").val("45138").change();
	}, 1000);
	setTimeout(function(){
		$("#"+namespace+"businessCityMetropolis").val("45162").change();
	}, 1500);
	setTimeout(function(){
		$("#"+namespace+"businessCityCorporationOrMuncipalty").val("45903").change();
	}, 2000);
	setTimeout(function(){
		$("#"+namespace+"businessUnion").val("45907").change();
	}, 2500);

	$("#"+namespace+"businessVillage").val("Mumbai").change();
	$("#"+namespace+"businessWard").val("Ward5").change();
	$("#"+namespace+"businessZipCode").val("44770").change();
	$("#"+namespace+"businessPostOffice").val("Alibag").change();
	$("#"+namespace+"businessMouzaOrMoholla").val("OldMouza").change();
	$("#"+namespace+"businessHouseAddress").val("Infront of DMART").change();

},1000);