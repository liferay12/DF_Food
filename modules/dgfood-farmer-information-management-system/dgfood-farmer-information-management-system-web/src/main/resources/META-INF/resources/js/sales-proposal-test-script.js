
setTimeout(function() {
	var namespace=$("#portletNamespace").val();

	
	$("#"+namespace+"sellFoodgrainsRegion").val("38633").change();

	setTimeout(function(){
		$("#"+namespace+"sellFoodgrainsZilla").val("38645").change();
	}, 500);
	setTimeout(function(){
		$("#"+namespace+"sellFoodgrainsUpazilla").val("38651").change();
	}, 1000);
	setTimeout(function(){
		$("#"+namespace+"sellFoodgrainsUnion").val("38658").change();
	}, 1500);
	

	$("#"+namespace+"accountNumber").val("125420236525").change();
	$("#"+namespace+"bankName").val("Bangladesh Commerce Bank Limited.").change();
	$("#"+namespace+"branchName").val("Dhamrai").change();
	$("#"+namespace+"routingCode").val("030261156").change();

	$("#"+namespace+"pastProdDataSeason1Name").val("boro").change();
	$("#"+namespace+"pastProdDataSeason1Year").val("2020").change();
	$("#"+namespace+"pastProdDataSeason1FoodgrainQuantity").val("24.32").change();

	$("#"+namespace+"pastProdDataSeason2Name").val("amon").change();
	$("#"+namespace+"pastProdDataSeason2Year").val("2020").change();
	$("#"+namespace+"pastProdDataSeason2FoodgrainQuantity").val("14.52").change();

	$("#"+namespace+"pastProdDataSeason3Name").val("boro").change();
	$("#"+namespace+"pastProdDataSeason3Year").val("2021").change();
	$("#"+namespace+"pastProdDataSeason3FoodgrainQuantity").val("27.77").change();

	$("#"+namespace+"succeedingProdDataSeason1Name").val("wheat").change();
	$("#"+namespace+"succeedingProdDataSeason1Year").val("2022").change();
	$("#"+namespace+"succeedingProdDataSeason1FoodgrainQuantity").val("21.58").change();

	$("#"+namespace+"succeedingProdDataSeason2Name").val("amon").change();
	$("#"+namespace+"succeedingProdDataSeason2Year").val("2022").change();
	$("#"+namespace+"succeedingProdDataSeason2FoodgrainQuantity").val("32.30").change();

	$("#"+namespace+"succeedingProdDataSeason3Name").val("boro").change();
	$("#"+namespace+"succeedingProdDataSeason3Year").val("2023").change();
	$("#"+namespace+"succeedingProdDataSeason3FoodgrainQuantity").val("15.36").change();	

	$("#"+namespace+"foodgrainProcuredSeason1Name").val("boro").change();
	$("#"+namespace+"foodgrainProcuredSeason1Year").val("2021").change();

	$("#"+namespace+"foodgrainProcuredSeason2Name").val("wheat").change();
	$("#"+namespace+"foodgrainProcuredSeason2Year").val("2021").change();

	$("#"+namespace+"foodgrainProcuredSeason3Name").val("amon").change();
	$("#"+namespace+"foodgrainProcuredSeason3Year").val("2020").change();

	$("#"+namespace+"foodgrainProcuredSeason4Name").val("wheat").change();
	$("#"+namespace+"foodgrainProcuredSeason4Year").val("2020").change();


},1000);