package bd.gov.dgfood.common.util.constants;

import java.util.Arrays;
import java.util.List;

/**
 * The purpose of this class is to mention file related constants
 *
 * Accessibility : Throughout application
 *
 *
 * @author Ashish Singh
 * 
 */
public class FileConstants {
	public static final long SIX_MB = 6000000;
	public static final long TWO_MB = 2000000;
	public static final List<String> JPG_JPEG_PNG = Arrays.asList(".png", ".jpg", ".jpeg");
	public static final List<String> PDF_DOC_DOCX = Arrays.asList(".pdf", ".doc", ".docx");
	public static String getSizeLabel(long size) {
		if (TWO_MB == size) {
			return "2 MB";
		} else if (SIX_MB == size) {
			return "6 MB";
		}
		return size + " MB";
	}
	
	public static final String FILE_PROFILE_PHOTOGRAPH="profilePhotograph";
	public static final String FILE_KRISHI_CARD="krishiCard";
	public static final String FILE_WQSC="wqsc";
}
