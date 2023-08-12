<%@include file="/ffpb_registration/init.jsp" %>

<%String acceptedExtensions = "image/*,application/pdf"; %>

<div class='form-group'>
<h3 class="subtitle"> <liferay-ui:message key="upload"></liferay-ui:message> </h3>

<clay:row>

    <clay:col md="6" sm="6">
        <label for=photograph><liferay-ui:message key="photograph"></liferay-ui:message><span class="txt-red">*</span></label>
        <aui:input type="file" name="photograph"  accept='<%= acceptedExtensions %>' label=""  onchange="handleFiles(this)" cssClass="validate">
<!--  		<aui:validator name="required" errorMessage="this-field-is-required" />  -->
<!--         <aui:validator name="custom" errorMessage="file-size-error-label"> -->
<!-- 				function(val,node,junction){ -->
<!--                     console.log('uploadSize...',uploadSize) -->
<!-- 					if(uploadSize==true){ -->
<!-- 						return true; -->
<!-- 					}else{ -->
<!-- 						return false; -->
<!-- 					} -->
<!-- 				} -->
<!-- 			</aui:validator> -->
        </aui:input>
    </clay:col>

    <clay:col md="6" sm="6">
        <label for="signature"><liferay-ui:message key="signature"></liferay-ui:message><span class="txt-red">*</span></label>
        <aui:input type="file" name="signature"  accept='<%= acceptedExtensions %>' label=""  onchange="handleFiles(this)" cssClass="validate">
<!--             <aui:validator name="required" errorMessage="this-field-is-required" />	  -->
<!--         <aui:validator name="custom" errorMessage="file-size-error-label"> -->
<!-- 				function(val,node,junction){ -->
<!-- 					if(uploadSize==true){ -->
<!-- 						return true; -->
<!-- 					}else{ -->
<!-- 						return false; -->
<!-- 					} -->
<!-- 				} -->
<!-- 			</aui:validator> -->
        </aui:input>
        
    </clay:col>
    
    <clay:col md="6" sm="6">
        <label for="additionalDoc"><liferay-ui:message key="additional-doc"></liferay-ui:message></label>
        <aui:input type="file" name="additionalDoc"  accept='<%= acceptedExtensions %>' multiple="true"   label=""onchange="handleFiles(this)">
            <aui:validator name="custom" errorMessage="file-size-error-label">
				function(val,node,junction){
					if(uploadSize==true){
						return true;
					}else{
						return false;
					}
				}
			</aui:validator>   
    </aui:input>
    </clay:col>


</clay:row>

</div>	
<aui:button-row>
        <aui:button  value='back' onClick="showNextOrPreviousStep('basic_info');"></aui:button> 
        
       <aui:button  value='next' onClick="preview();"></aui:button>
</aui:button-row>

<aui:script>
  var uploadSize = true
  function handleFiles(e){

    var size=0;
    var htmlData = $(".multipleDocs").html();

    var multiple = $("#"+e.id).attr('multiple');
    console.log(multiple);
    if(multiple == "multiple"){
        htmlData = "";
    }

    for(var j = 0; j < e.files.length; j++){

        var file= e.files[j];
		var fileExt = file.name.split('.').pop();
		console.log("File Extension - "+fileExt);
		var id = e.id + "Img";
		var idLink = e.id + "Link"
        console.log("File Name - "+file.name+" File Size - "+file.size+" e.id"+e.id);
        if(file.size>2000000){
            uploadSize=false;
        }else{
            uploadSize=true;
            if(multiple == "multiple"){

                $("#"+id+j).on('change', function(){
                    URL.revokeObjectURL($("#"+id).attr("src"));
                });

                if(fileExt == "pdf"){
                    htmlData = htmlData + "<a href='"+URL.createObjectURL(file)+"' target='_blank' ><img id='<portlet:namespace/>"+id+j+"' src='<%=request.getContextPath()%>/images/pdf.png' style='width:100px;height:100px;'></img></a>";
                }else if(fileExt == "docx"){
                    htmlData = htmlData + "<a href='"+URL.createObjectURL(file)+"' target='_blank' download='"+file.name+"' ><img id='<portlet:namespace/>"+id+j+"' src='<%=request.getContextPath()%>/images/docx.png' style='width:100px;height:100px;'></img></a>";
                }else{
                    htmlData = htmlData + "<a href='"+URL.createObjectURL(file)+"' target='_blank' ><img id='<portlet:namespace/>"+id+j+"' src='"+URL.createObjectURL(file)+"' style='width:100px;height:100px;'></img></a>";
                }

            }else{

                if(fileExt == "docx"){
                    $("#"+idLink).attr("href", URL.createObjectURL(file)).attr("download", URL.createObjectURL(file));
                }else{
                    $("#"+idLink).attr("href", URL.createObjectURL(file));
                }

                if(fileExt == "pdf"){
                    $("#"+id).attr("src", '<%=request.getContextPath()+"/images/pdf.png"%>');
                }else if(fileExt == "docx"){
                    $("#"+id).attr("src", '<%=request.getContextPath()+"/images/docx.png"%>');
                }else{
                    $("#"+id).attr("src", URL.createObjectURL(file));
                }
                
                
                $("#"+id).on('change', function(){
                    
                    URL.revokeObjectURL($("#"+idLink).attr("href"));
                    URL.revokeObjectURL($("#"+id).attr("src"));
                });

            }
        }
        size+=file.size;
    }  
    $(".multipleDocs").html(htmlData);
    
  }


    function preview(){

    validateFields('upload','preview');

    var inputs = document.querySelectorAll(".preview_text");
   Array.prototype.forEach.call(inputs,(e)=>{
    const id = e.getAttribute('id');
    $('#'+id+'_preview').text(e.value);

   })

   var gender =  document.querySelector("input[name='<portlet:namespace/>gender']:checked").value;
   
   var previewGender = document.getElementById("<portlet:namespace/>gender_preview");

		if(gender == "0"){
			previewGender.textContent = '<liferay-ui:message key="male"></liferay-ui:message>';  
		}else if(gender == "1"){
			previewGender.textContent = '<liferay-ui:message key="female"></liferay-ui:message>';
		}else{
			previewGender.textContent = '<liferay-ui:message key="third-gender"></liferay-ui:message>';
		}

     var maritalStatus =  document.querySelector("input[name='<portlet:namespace/>maritalStatus']:checked").value;

     var maritalStatusGender = document.getElementById("<portlet:namespace/>maritalStatus_preview");

		if(maritalStatus == "0"){
			maritalStatusGender.textContent = '<liferay-ui:message key="unmarried"></liferay-ui:message>';
		}else if(maritalStatus == "1"){
			maritalStatusGender.textContent = '<liferay-ui:message key="married"></liferay-ui:message>';
		}else if(maritalStatus == "2"){
			maritalStatusGender.textContent = '<liferay-ui:message key="divorced"></liferay-ui:message>';
		}else if(maritalStatus == "3"){
			maritalStatusGender.textContent = '<liferay-ui:message key="widow"></liferay-ui:message>';
		}else {
			maritalStatusGender.textContent = '<liferay-ui:message key="widower"></liferay-ui:message>';
		}


    var selects = document.querySelectorAll("#<portlet:namespace/>fm select");
    Array.prototype.forEach.call(selects,(e)=>{
        const id = e.getAttribute('id');
        $('#'+id+'_preview').text($("#"+id).find('option:selected').text());
    })
    
    
    
    }
</aui:script>