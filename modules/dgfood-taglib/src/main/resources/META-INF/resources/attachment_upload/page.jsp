<%@ include file="/attachment_upload/init.jsp" %>


<%
String label = GetterUtil.getString(request.getAttribute("dgfood-ui:attachment-upload:label"));
boolean required = GetterUtil.getBoolean(request.getAttribute("dgfood-ui:attachment-upload:required"));
boolean multiple = GetterUtil.getBoolean(request.getAttribute("dgfood-ui:attachment-upload:multiple"));
long maxSize = GetterUtil.getLong(request.getAttribute("dgfood-ui:attachment-upload:maxSize"),0);
String accept = GetterUtil.getString(request.getAttribute("dgfood-ui:attachment-upload:accept"));
String name = GetterUtil.getString(request.getAttribute("dgfood-ui:attachment-upload:name"));
String id = GetterUtil.getString(request.getAttribute("dgfood-ui:attachment-upload:id"));
String previewContainerId = GetterUtil.getString(request.getAttribute("dgfood-ui:attachment-upload:previewContainerId"));
String contextPath = GetterUtil.getString(request.getAttribute("dgfood-ui:attachment-upload:contextPath"));
String classes = GetterUtil.getString(request.getAttribute("dgfood-ui:attachment-upload:classes"));

if(Validator.isNull(id) || id.isEmpty()){
	id = name;
}
if(Validator.isNull(label) || label.isEmpty()){
	label = name;
}

%>



<label for="<%=name %>"><liferay-ui:message key="<%=label %>"></liferay-ui:message>  <c:if test="<%=required %>"> <span class="txt-red">*</span> </c:if> </label>
<aui:input type="file" name="<%=name %>"  id="<%=id %>" accept='<%= accept + ";capture=camera" %>' multiple="<%= multiple%>" label="" required="<%=required %>" cssClass="<%=classes%>">
	<aui:validator name="acceptFiles">
                 '<%= accept %>'
    </aui:validator>
    
    <aui:validator name="custom" errorMessage="file-size-can-not-be-empty">
                 function(val,node,ruleValue){
                 
                  for(var j = 0; j < node._node.files.length; j++){
                         const file = node._node.files[j];
                         if(file.size <= 0){
                            return false;
                         }
                    }
                 console.log('SIZE is not zero '); 
                      return true;
                 }
    </aui:validator>
    
	<aui:validator name="custom" errorMessage="<%= LanguageUtil.format(request, "please-enter-a-file-with-a-valid-file-size-no-larger-than-x", FileConstants.getSizeLabel(maxSize)) %>">
                function(val,node,ruleValue){
                     const box = document.getElementById('<%=previewContainerId %>');

                     for(var j = 0; j < node._node.files.length; j++){
                         const file = node._node.files[j];
                            if(file.size > Number('<%=maxSize %>')){                       
                               return false;
                            }                                                        
                           
                         }    
                         console.log('ENDDDDDDDDDD','<%=previewContainerId %>');  
               if(box){
                   previewImage(node._node.files,box);        
               }
                return true;
            }
            </aui:validator>
</aui:input>


<aui:script>

function previewImage(files,previewContainer){
          console.log('file',files)
  previewContainer.innerHTML = '';
  for(var j = 0; j < files.length; j++){
    const file = files[j];
  
    const anchor = document.createElement('a');
          //anchor.setAttribute('target', "_blank");
    const img = document.createElement('img');
          img.setAttribute("alt", file.name);
          img.style.width = '150px';
          img.style.height = '150px';

    var fileExt = file.name.split('.').pop();
    var type = file.type;
    
         anchor.setAttribute('href', URL.createObjectURL(file));
         anchor.setAttribute("download", file.name);   

         if(fileExt == "pdf"){
                    img.setAttribute("src", '<%=contextPath+"/images/pdf.png"%>');
           }else if(fileExt == "docx" || fileExt == "doc" || fileExt === 'txt'){
                    img.setAttribute("src", '<%=contextPath+"/images/doc.png"%>');
          }else{
                    img.setAttribute("src", URL.createObjectURL(file));
           }
           
      anchor.appendChild(img);
      previewContainer.appendChild(anchor);
    }           
}

</aui:script>

