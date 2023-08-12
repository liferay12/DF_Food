package bd.gov.dgfood.common.util;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.URLCodec;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.multipart.BinaryFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.services.model.Attachment;
import bd.gov.dgfood.common.services.model.AttachmentVersion;
import bd.gov.dgfood.common.services.service.AttachmentLocalServiceUtil;
import bd.gov.dgfood.common.services.service.AttachmentVersionLocalServiceUtil;
import bd.gov.dgfood.common.util.constants.DocumentLibraryConstants;

/**
 * The purpose of this class is to mention common DL upload activities
 *
 * Accessibility : Throughout application
 *
 *
 * @author Ashish Singh
 * 
 */
@Component(immediate = true, service = {})
public class DLUploadUtil {

	/**
	 * This method is used for create the Document File. This method will be
	 * executed when the user uploads file.
	 * 
	 * @param ServiceContext : holds Object of ServiceContext and provides scope
	 *                       group id in long value
	 * @param ActionRequest  : holds the Object of ActionRequest and provides upload
	 *                       file details
	 * @param parentFolderId : holds the long value for parent Folder ID of the
	 *                       child folder and the child folder use to keep
	 *                       particular type of files and this folder kept in
	 *                       Documents and Media
	 * @param folderId       : holds the long value for Folder ID of the folder to
	 *                       keep particular type of files
	 * @param folderName     : holds the string value for Folder Name of the folder
	 *                       to keep particular type of files
	 * @param fieldName      : holds the request string query name in string value
	 *                       which is use to get value of uploaded file name from
	 *                       ActionRequest by particular request string query name
	 * @param maxFileSize    : holds the maximum size value of particular file type
	 *                       in long value
	 * @return long : holds the long value for fileEntryId of created File which is
	 *         uploaded by end user
	 */
	public static long fileUpload(ServiceContext serviceContext, ActionRequest actionRequest, long folderId,
			String folderName, String fieldName, long maxFileSize) {

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String fileName = uploadPortletRequest.getFileName(fieldName);
		InputStream is = null;
		try {
			if (Validator.isNotNull(fileName)) {
				File file = uploadPortletRequest.getFile(fieldName);
				String mimeType = uploadPortletRequest.getContentType(fieldName);

				_log.info("Title : " + fileName + " and File length in bytes : " + file.length());

				if (file.length() <= maxFileSize) {
					try {
						is = new FileInputStream(file);

						// get list of files in the folder
						List<FileEntry> fileEntrys = null;
						if (!folderName.equalsIgnoreCase(folderName)) {
							fileEntrys = DLAppServiceUtil.getFileEntries(serviceContext.getScopeGroupId(), folderId);
						}

						/* Checking if new uploaded file already exist in folder */
						FileEntry fileEntry = isFileExist(serviceContext, folderId, fileName);

						// file does not exist in folder start upload and remove other files
						if (Validator.isNull(fileEntry)) {
							_log.info("file does not exist...uploading started");

							fileEntry = DLAppLocalServiceUtil.addFileEntry(null, serviceContext.getUserId(),
									serviceContext.getScopeGroupId(), folderId, fileName, mimeType, fileName, fileName,
									null, "File updated programatically", is, file.length(), null, null,
									serviceContext);

							_log.info("file uploaded..." + fileName);

							// Delete all old files from the folder
							if (Validator.isNotNull(fileEntrys)) {
								for (FileEntry fileDetails : fileEntrys) {
									_log.info("Deleting old files from folder.... " + fileDetails.getTitle());
									DLAppLocalServiceUtil.deleteFileEntry(fileDetails.getFileEntryId());
								}
							}
						} else {
							_log.info("File already available in folder with same name so updating...");
							fileEntry = DLAppLocalServiceUtil.addFileEntry(null, serviceContext.getUserId(),
									serviceContext.getScopeGroupId(), folderId, fileName, mimeType, fileName, fileName,
									null, "File updated programatically", is, file.length(), null, null,
									serviceContext);
							_log.info("file updated..." + fileName);
						}

						// TODO: This needs to be changed later
						Role guestRole = RoleLocalServiceUtil.getRole(fileEntry.getCompanyId(), RoleConstants.GUEST);
						ResourcePermissionLocalServiceUtil.setResourcePermissions(fileEntry.getCompanyId(),
								DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
								String.valueOf(fileEntry.getFileEntryId()), guestRole.getRoleId(),
								new String[] { "VIEW" });

						return fileEntry.getFileEntryId();

					} catch (Exception e) {
						_log.error(e);
						e.printStackTrace();
						if (is != null) {
							try {
								is.close();
							} catch (IOException e1) {
								_log.error(e1);
							}
						}
						SessionErrors.add(actionRequest, "fileUploadError");
					}
				} else {
					_log.info("unable to upload file, size is greater than ..." + maxFileSize);
					SessionErrors.add(actionRequest, "fileSizeError" + fieldName);
					return 0;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	/**
	 * This method is used to get the Folder details.
	 * 
	 * @param ServiceContext : holds Object of ServiceContext and provides scope
	 *                       group id in long value
	 * @param parentFolderId : holds the long value for parent Folder ID of the
	 *                       child folder
	 * @param folderName     : holds the string value for Folder Name of the folder
	 * @return Folder : holds the details of particular folder as it's name matched
	 *         with folderName value
	 */
	public static Folder getFolder(ServiceContext serviceContext, long parentFolderId, String folderName) {
		Folder folder = null;
		try {
			folder = DLAppLocalServiceUtil.getFolder(serviceContext.getScopeGroupId(), parentFolderId, folderName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return folder;
	}

	/**
	 * This method is used to create a Folder
	 * 
	 * @param ServiceContext : holds Object of ServiceContext and provides scope
	 *                       group id in long value
	 * @param parentFolderId : holds the long value for parent Folder ID of the
	 *                       child folder
	 * @param folderName     : holds the string value for Folder Name of the folder
	 * @return Folder : holds the details of particular created folder with the
	 *         folderName value
	 */
	public static Folder createFolder(ServiceContext serviceContext, long parentFolderId, String folderName) {
		Folder folder = isFolderExist(serviceContext, parentFolderId, folderName);
		if (Validator.isNull(folder)) {
			_log.info("folder does not exist, creating new one with name" + folderName);
			_log.info(" parentFolderId ...." + parentFolderId);

			long repositoryId = serviceContext.getScopeGroupId();
			_log.info(" repositoryId....." + repositoryId);
			try {
				folder = DLAppLocalServiceUtil.addFolder(serviceContext.getUserId(), repositoryId, parentFolderId,
						folderName, folderName, serviceContext);

				_log.info("creating new one with name" + folder.getFolderId());
				Role guestRole = RoleLocalServiceUtil.getRole(folder.getCompanyId(), RoleConstants.GUEST);

				ResourcePermissionLocalServiceUtil.setResourcePermissions(folder.getCompanyId(),
						DLFolder.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
						String.valueOf(folder.getFolderId()), guestRole.getRoleId(), new String[] { "VIEW" });

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return folder;
	}

	/**
	 * This method is used to check the existence of a Folder
	 * 
	 * @param ServiceContext : holds Object of ServiceContext and provides scope
	 *                       group id in long value
	 * @param parentFolderId : holds the long value for parent Folder ID of the
	 *                       child folder
	 * @param folderName     : holds the string value for Folder Name of the folder
	 * @return boolean : holds the status in boolean value whether particular folder
	 *         is exist or not ,and particular folder name is matched with
	 *         folderName value
	 */
	public static Folder isFolderExist(ServiceContext serviceContext, long parentFolderId, String folderName) {
		Folder folder = null;
		try {
			folder = DLAppLocalServiceUtil.getFolder(serviceContext.getScopeGroupId(), parentFolderId, folderName);
			_log.info("folder exists..");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
		return folder;
	}

	/**
	 * This method is used to check the existence of a File
	 * 
	 * @param ServiceContext : holds Object of ServiceContext and provides scope
	 *                       group id in long value
	 * @param parentFolderId : holds the long value for parent Folder ID of the
	 *                       child folder
	 * @param title          : holds the string value for File Name
	 * @return boolean : holds the status in boolean value whether particular file
	 *         is exist or not ,and particular file name is matched with title value
	 */
	public static FileEntry isFileExist(ServiceContext serviceContext, long parentFolderId, String title) {
		FileEntry fileEntry = null;
		try {
			fileEntry = DLAppLocalServiceUtil.getFileEntry(serviceContext.getScopeGroupId(), parentFolderId, title);
			_log.info("File Exists in folder");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
		return fileEntry;
	}

	public static byte[] getUploadedDocument(PortletRequest portletRequest, String inputFieldName) {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(portletRequest);
		File uplodedFile = uploadPortletRequest.getFile(inputFieldName);

		try {
			byte[] fileBytes = FileUtil.getBytes(uplodedFile);
			return fileBytes;
		} catch (IOException e) {
			_log.error("Unable to fetch the uploaded document");
			if (_log.isDebugEnabled()) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public static String getFileURL(ThemeDisplay themeDisplay, long fileEntryId) {
		try {
			DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntry(fileEntryId);
			return themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
			+ themeDisplay.getScopeGroupId() + "/" + dlFileEntry.getFolderId() + "/" + dlFileEntry.getTitle();
		} catch (Exception e) {
			_log.error("Unable to geneerate URL : " + e.getMessage());
		}
		return StringPool.BLANK;
	}

	/**
	 * @param name
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws PortalException
	 */
	public static BinaryFile getBinaryFile(String name, PortletRequest request) throws IOException, PortalException {

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);

		_log.debug(" uploadPortletRequest " + uploadPortletRequest);

		if (_log.isDebugEnabled()) {
			_log.debug(" ContentType " + uploadPortletRequest.getContentType(name));
			_log.debug(" getFileName " + uploadPortletRequest.getFileName(name));
			_log.debug(" getSize " + uploadPortletRequest.getSize(name));
			_log.debug(" getInputStream " + uploadPortletRequest.getFileAsStream(name));
		}

		if (Validator.isNotNull(uploadPortletRequest.getFileName(name))) {
			return new BinaryFile(uploadPortletRequest.getContentType(name), uploadPortletRequest.getFileName(name),
					uploadPortletRequest.getFileAsStream(name), uploadPortletRequest.getSize(name));
		}

		return null;

	}

	/**
	 * @param name
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws PortalException
	 */
	public static List<BinaryFile> getBinaryFileList(String name, PortletRequest request)
			throws IOException, PortalException {

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);

		FileItem[] fileItems = uploadPortletRequest.getMultipartParameterMap().get(name);
		List<BinaryFile> binaryFiles = new ArrayList<>();

		if (Validator.isNotNull(fileItems) && fileItems.length > 0) {

			_log.debug(" fileItems " + fileItems.length);
			for (FileItem fileItem : fileItems) {

				if (_log.isDebugEnabled()) {
					_log.debug(" fileName " + fileItem.getFileName());
					_log.debug(" getFileNameExtension " + fileItem.getInputStream());
					_log.debug(" mimeType " + fileItem.getContentType());
					_log.debug(" size " + fileItem.getSize());
				}

				if (Validator.isNotNull(fileItem.getFileName()) || !fileItem.getFileName().isEmpty()
						|| !fileItem.getContentType().equals("application/octet-stream")) {
					binaryFiles.add(new BinaryFile(fileItem.getContentType(), fileItem.getFileName(),
							fileItem.getInputStream(), fileItem.getSize()));
				}

			}
		}
		_log.debug(" binaryFiles " + binaryFiles);
		return binaryFiles;

	}

	public static FileEntry addAttachmentInFileEntry(long folderId, BinaryFile binaryFile, String title,
			String description, String category, ServiceContext serviceContext) {

		if (Validator.isNull(binaryFile)) {
			return null;
		}

		long parentFolderId = createFolder(serviceContext, folderId, category).getFolderId();

		if (title == null || title.isEmpty()) {
			title = binaryFile.getFileName();
		}

		try {
			return DLAppLocalServiceUtil.addFileEntry(null, serviceContext.getUserId(),
					serviceContext.getScopeGroupId(), parentFolderId, binaryFile.getFileName(),
					binaryFile.getContentType(), title, title, description, "File updated programatically",
					binaryFile.getInputStream(), binaryFile.getSize(), null, null, serviceContext);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Map<String, Serializable> addPreviewAndMetadata(FileEntry fileEntry) {
		String previewURL = getPreviewURL(fileEntry, null, null, false, false);

		Map<String, Serializable> metadata = new HashMap<String, Serializable>();
		metadata.put(DocumentLibraryConstants.PREVIEW_URL, previewURL);
		metadata.put(DocumentLibraryConstants.EXTENSION, fileEntry.getExtension());
		return metadata;
	}

	public static Attachment addAttachment(long folderId, BinaryFile binaryFile, String title, String description,
			String category, ServiceContext serviceContext) throws PortalException {

		FileEntry fileEntry = addAttachmentInFileEntry(folderId, binaryFile, title, description, category, serviceContext);
		if (Validator.isNotNull(fileEntry)) {
			return AttachmentLocalServiceUtil.addAttachment(fileEntry.getFileEntryId(), fileEntry.getTitle(), category,
					addPreviewAndMetadata(fileEntry));
		}
		return null;
	}

	public static List<Attachment> addAttachments(long folderId, List<BinaryFile> binaryFiles, String description,
			String category, String className, long classPK, ServiceContext serviceContext) throws PortalException {

		long parentFolderId = createFolder(serviceContext, folderId, category).getFolderId();

		List<Attachment> attachments = new ArrayList<Attachment>();
		List<FileEntry> fileEntries = new ArrayList<FileEntry>();

		for (BinaryFile binaryFile : binaryFiles) {
			String fileName = DLUtil.getUniqueFileName(serviceContext.getScopeGroupId(), parentFolderId,
					binaryFile.getFileName(), true);
			FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(null, serviceContext.getUserId(),
					serviceContext.getScopeGroupId(), parentFolderId, binaryFile.getFileName(),
					binaryFile.getContentType(), fileName, fileName, description, "File updated programatically",
					binaryFile.getInputStream(), binaryFile.getSize(), null, null, serviceContext);

			fileEntries.add(fileEntry);
		}

		for (FileEntry e : fileEntries) {
			String previewURL = getPreviewURL(e, null, null, false, false);

			Map<String, Serializable> metadata = new HashMap<String, Serializable>();
			metadata.put(DocumentLibraryConstants.PREVIEW_URL, previewURL);
			metadata.put(DocumentLibraryConstants.EXTENSION, e.getExtension());

			Attachment attachment = AttachmentLocalServiceUtil.addAttachment(e.getFileEntryId(), e.getTitle(), category,
					metadata);
			attachments.add(attachment);
		}

		return attachments;

	}

	public static List<AttachmentVersion> addAttachmentsVersion(long folderId, List<BinaryFile> binaryFiles,
			String description, String category, String className, long classPK, ServiceContext serviceContext)
					throws PortalException {

		long parentFolderId = createFolder(serviceContext, folderId, category).getFolderId();

		List<AttachmentVersion> attachments = new ArrayList<AttachmentVersion>();
		List<FileEntry> fileEntries = new ArrayList<FileEntry>();

		for (BinaryFile binaryFile : binaryFiles) {
			String fileName = DLUtil.getUniqueFileName(serviceContext.getScopeGroupId(), parentFolderId,
					binaryFile.getFileName(), true);
			FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(null, serviceContext.getUserId(),
					serviceContext.getScopeGroupId(), parentFolderId, binaryFile.getFileName(),
					binaryFile.getContentType(), fileName, fileName, description, "File updated programatically",
					binaryFile.getInputStream(), binaryFile.getSize(), null, null, serviceContext);
			fileEntries.add(fileEntry);
		}

		for (FileEntry e : fileEntries) {
			String previewURL = getPreviewURL(e, null, null, false, false);

			Map<String, Serializable> metadata = new HashMap<String, Serializable>();

			metadata.put(DocumentLibraryConstants.PREVIEW_URL, previewURL);
			metadata.put(DocumentLibraryConstants.EXTENSION, e.getExtension());

			AttachmentVersion attachmentVersion = AttachmentVersionLocalServiceUtil
					.addAttachmentVersion(e.getFileEntryId(), e.getTitle(), category, metadata, className, classPK);
			attachments.add(attachmentVersion);
		}

		return attachments;

	}

	public static Attachment updateAttachment(long attachmentId, long folderId, BinaryFile binaryFile, String title,
			String description, String category, ServiceContext serviceContext) throws PortalException {

		long parentFolderId = createFolder(serviceContext, folderId, category).getFolderId();

		if (title == null || title.isEmpty()) {
			title = binaryFile.getFileName();
		}

		String fileName = DLUtil.getUniqueFileName(serviceContext.getScopeGroupId(), parentFolderId,
				binaryFile.getFileName(), true);
		FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(null, serviceContext.getUserId(),
				serviceContext.getScopeGroupId(), parentFolderId, binaryFile.getFileName(), binaryFile.getContentType(),
				fileName, fileName, description, "File updated programatically", binaryFile.getInputStream(),
				binaryFile.getSize(), null, null, serviceContext);

		Role guestRole = RoleLocalServiceUtil.getRole(fileEntry.getCompanyId(), RoleConstants.GUEST);
		ResourcePermissionLocalServiceUtil.setResourcePermissions(fileEntry.getCompanyId(), DLFileEntry.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(fileEntry.getFileEntryId()), guestRole.getRoleId(),
				new String[] { "VIEW" });

		String previewURL = getPreviewURL(fileEntry, null, null, false, false);

		Map<String, Serializable> metadata = new HashMap<String, Serializable>();

		metadata.put(DocumentLibraryConstants.PREVIEW_URL, previewURL);
		metadata.put(DocumentLibraryConstants.EXTENSION, fileEntry.getExtension());

		return AttachmentLocalServiceUtil.updateAttachment(attachmentId, fileEntry.getFileEntryId(), title, metadata);

	}

	public static FileEntry getFileEntry(long fileEntryId) {
		FileEntry fileEntry = null;
		try {
			fileEntry = DLAppLocalServiceUtil.getFileEntry(fileEntryId);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return fileEntry;
	}

	public static String getPreviewURL(FileEntry fileEntry, ThemeDisplay themeDisplay, String queryString,
			boolean appendVersion, boolean absoluteURL) {

		StringBundler sb = new StringBundler(15);

		//		if ((themeDisplay != null) && absoluteURL) {
		//			sb.append(themeDisplay.getPortalURL());
		//		}
		//
		//		sb.append(_portal.getPathContext());
		sb.append("/documents/");
		sb.append(fileEntry.getRepositoryId());
		sb.append(StringPool.SLASH);
		sb.append(fileEntry.getFolderId());
		sb.append(StringPool.SLASH);

		String fileName = fileEntry.getFileName();

		sb.append(URLCodec.encodeURL(HtmlUtil.unescape(fileName)));

		sb.append(StringPool.SLASH);
		sb.append(URLCodec.encodeURL(fileEntry.getUuid()));

		if (appendVersion) {
			sb.append("?version=");
			sb.append(fileEntry.getVersion());
			sb.append("&t=");
		} else {
			sb.append("?t=");
		}

		Date modifiedDate = fileEntry.getModifiedDate();

		sb.append(modifiedDate.getTime());

		// sb.append(queryString);

		String previewURL = sb.toString();

		//		if ((themeDisplay != null) && themeDisplay.isAddSessionIdToURL()) {
		//			return _portal.getURLWithSessionId(previewURL, themeDisplay.getSessionId());
		//		}

		return previewURL;

	}

	public static AttachmentVersion copyAttachmentToVersion(Attachment attachment, String className, long classPK,
			ServiceContext serviceContext) throws PortalException {

		if (Validator.isNotNull(attachment)) {

			return AttachmentVersionLocalServiceUtil.addAttachmentVersion(attachment.getFileEntryId(),
					attachment.getTitle(), attachment.getCategory(), attachment.getMetadata(), className, classPK);
		}

		return null;
	}

	public static Attachment copyAttachmentToMaster(AttachmentVersion attachment, String className, long classPK,
			ServiceContext serviceContext) throws PortalException {

		if (Validator.isNotNull(attachment)) {

			return AttachmentLocalServiceUtil.addAttachment(attachment.getFileEntryId(), attachment.getTitle(),
					attachment.getCategory(), attachment.getMetadata());
		}

		return null;
	}

	/**
	 * This method is used to get the Folder ID of relevant module Folder.
	 * It creates new folder for every new entry.
	 * 
	 * @param ServiceContext
	 * @param tradeLicenseNo
	 * @return long
	 */
	public static long getFoodGrainLicenseUserFolder(String tradeLicenseNo, ServiceContext serviceContext) {

		Folder root = DLUploadUtil.createFolder(serviceContext, 0,
				DocumentLibraryConstants.LMS_ROOT_FOLDER_NAME);
		Folder registration = DLUploadUtil.createFolder(serviceContext, root.getFolderId(),
				DocumentLibraryConstants.FOOD_GRAIN_LICENSE_REGISTRATION_FOLDER_NAME);
		Folder userFolder = DLUploadUtil.createFolder(serviceContext, registration.getFolderId(),
				DocumentLibraryConstants.FOOD_GRAIN_LICENSE_REGISTRATION_USER_FOLDER_PREFIX 
				+ tradeLicenseNo);

		return userFolder.getFolderId();
	}

	/**
	 * @param endodedProfileString
	 * @return
	 * @throws IOException
	 * @throws PortalException
	 */
	public static BinaryFile getNIDProfileBinaryFile(String endodedProfileString) throws IOException, PortalException {

		InputStream profileStream = null;
		byte[] decodedProfileByte = null;
		String mimeType = StringPool.BLANK;
		String nidProfile = StringPool.BLANK;
		String extension = StringPool.BLANK;
		
		if(Validator.isNotNull(endodedProfileString)) {
			try {

				mimeType = endodedProfileString.split(";")[0].split(":")[1];
				extension = mimeType.split("/")[1];
				nidProfile = endodedProfileString.split(",")[1];
				_log.debug(mimeType);
				_log.debug(nidProfile);
				
				decodedProfileByte = Base64.getDecoder().decode(new String(nidProfile).getBytes("UTF-8"));
				_log.info(new String(decodedProfileByte));

				profileStream = new ByteArrayInputStream(decodedProfileByte);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (Validator.isNotNull(decodedProfileByte) && Validator.isNotNull(profileStream)) {
			return new BinaryFile(mimeType, DocumentLibraryConstants.PROFILE_PHOTOGRAPH_NAME + "." + extension, 
					profileStream, Long.valueOf(decodedProfileByte.length));
		}
		return null;
	}

	private static Log _log = LogFactoryUtil.getLog(DLUploadUtil.class);
}
