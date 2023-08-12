$(document).ready(function() {

	//Update the input values in Preview/summary page
	$("#"+namespace+'new-sales-proposal').find(".preview").on("change",function(){
		previewInputData(this);
	});
});

//To get the Address Dropdown Values
function populateAddressOption(currentDropdownId, nextDropdownId,currAddressType) {


	if(currentDropdownId.indexOf(currAddressType) != -1){
		nextDropdownId = currAddressType + nextDropdownId;	
	}
	
	console.log("next Id - "+nextDropdownId);
	
	var classNames = $('#'+namespace+nextDropdownId).attr("class").split(" ");
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
						$('#'+namespace+nextDropdownId).append("<option value='" + key.id + "'>" + key.name + "</option>");
					});
				}
			});
		
	}
}