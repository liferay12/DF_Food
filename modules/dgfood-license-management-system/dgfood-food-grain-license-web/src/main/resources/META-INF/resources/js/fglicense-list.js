var namespace=$("#portletNamespace").val();
var selectedLanguage = themeDisplay.getLanguageId().split("_")[0];
var today = new Date();
$(document).ready(function() {

	$("#"+namespace+"fromDate").datepicker({
		format : 'dd-mm-yyyy',
		pickTime : false,
		endDate : today,
		locale : selectedLanguage,
		language : selectedLanguage,
		autoclose:true
	});

	$("#"+namespace+"toDate").datepicker({
		format : 'dd-mm-yyyy',
		pickTime : false,
		endDate : today,
		locale : selectedLanguage,
		language : selectedLanguage,
		autoclose:true,
	});

	const loadLocationDropdown = (masterUrl, filterOptions, inputFieldId) => {

		if(filterOptions!=undefined && Object.keys(filterOptions).length>0)
		{
			masterUrl=masterUrl+"?filter="+escape(filterOptions);
		}

		const updateFieldOptions = (optionsList,inputFieldId) => {
			console.debug(optionsList)
			console.debug(inputFieldId)

			if(optionsList==undefined || optionsList.items==undefined)
			{
				return;
			}

			let options = optionsList.items;

			const inputField = document.getElementById(inputFieldId);

			const dropdownOptions = [];
			options.forEach((option) => {
				dropdownOptions.push(
						"<option value='" + option.code + "'>" + option.name + "</option>"
				);   

			})

			inputField.innerHTML = inputField.innerHTML+dropdownOptions.join('');
		}

		Liferay.Util.fetch(masterUrl).then((response) => response.json()).then((response) => updateFieldOptions(response,inputFieldId));
	}

	var filterOptions=[];
	if($("#"+namespace+"userZillaCode").val()!=undefined && $("#"+namespace+"userZillaCode").val()!="")
	{
		filterOptions.push("parentLocationCode eq '"+$("#"+namespace+"userZillaCode").val()+"'");
	}
	filterOptions.push("active eq true");
	loadLocationDropdown($("#"+namespace+"upazilaRestURL").val(),filterOptions.join(" and "),namespace+"upazila");

});
