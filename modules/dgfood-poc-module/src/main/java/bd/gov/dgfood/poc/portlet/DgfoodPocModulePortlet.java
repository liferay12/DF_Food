package bd.gov.dgfood.poc.portlet;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.poc.constants.DgfoodPocModulePortletKeys;

/**
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.dgfood",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DgfoodPocModule",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DgfoodPocModulePortletKeys.DGFOODPOCMODULE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DgfoodPocModulePortlet extends MVCPortlet {
	
	String ROOT_FOLDER_NAME = "WebCam Pic";
	
	String ROOT_FOLDER_DESCRIPTION = "This folder holds the web cam pictures";
	
	public void uploadImage(ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
		Folder folder = createFolder(actionRequest, themeDisplay, serviceContext);
		fileUpload(themeDisplay, actionRequest, serviceContext, folder);
	}
	
	public Folder createFolder(ActionRequest actionRequest,ThemeDisplay themeDisplay, ServiceContext serviceContext)
	{
        boolean folderExist = isFolderExist(themeDisplay);
        Folder folder = null;
		if (!folderExist) {
			long repositoryId = themeDisplay.getScopeGroupId();		
			try {
				folder = DLAppServiceUtil.addFolder(repositoryId,0, ROOT_FOLDER_NAME,ROOT_FOLDER_DESCRIPTION, serviceContext);
				System.out.println("Folder created");
			} catch (PortalException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}			
		}else {
			folder = getFolder(themeDisplay);
		}
		return folder;
	}
	
	public boolean isFolderExist(ThemeDisplay themeDisplay){
		boolean folderExist = false;
		try {
			DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, ROOT_FOLDER_NAME);
			folderExist = true;
			System.out.println("Folder is already Exist");
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		return folderExist;
}

	public Folder getFolder(ThemeDisplay themeDisplay){
	Folder folder = null;
		try {
			folder =DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, ROOT_FOLDER_NAME);
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		return folder;
	}
	
	public void fileUpload(ThemeDisplay themeDisplay,ActionRequest actionRequest, ServiceContext serviceContext, Folder folder){
		
		deleteAllDocumentsfromFolder(themeDisplay);
		
		String picture = ParamUtil.getString(actionRequest, "picture");
		System.out.println("picture : "+picture);
		
		String base64Image = picture.split(",")[1];
		byte[] imageBytes = Base64.decode(base64Image);
		try {
		/*DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), folder.getFolderId(), 
				"Webcam.jpg", "image/jpeg", "Webcam "+System.currentTimeMillis()+".jpg", null, "", imageBytes, serviceContext);
		System.out.println("File uploaded successfully..");*/
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteAllDocumentsfromFolder(ThemeDisplay themeDisplay) {
		Folder folder =getFolder(themeDisplay);
		try {
		List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), folder.getFolderId());
		 for (FileEntry file : fileEntries) {
			DLAppLocalServiceUtil.deleteFileEntry(file.getFileEntryId());
		}
		System.out.println("File deleted successfully.."); 
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}