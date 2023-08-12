package bd.gov.dgfood.common.util.constants;

import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * The purpose of this interface to list down all the contstants that will be
 * used with respect to status.
 *
 * Accessibility : Throughout application
 *
 *
 * @author Ashish Singh
 * 
 */
public interface StatusConstants {

	/**
	 * Will be used throughout application if Status for an entity is APPROVED
	 */
	public static final int STATUS_APPROVED = WorkflowConstants.STATUS_APPROVED;
	public static final String LABEL_APPROVED = WorkflowConstants.LABEL_APPROVED;

	/**
	 * Will be used throughout application if Status for an entity is PENDING
	 */
	public static final int STATUS_PENDING = WorkflowConstants.STATUS_PENDING;
	public static final String LABEL_PENDING = WorkflowConstants.LABEL_PENDING;

	/**
	 * Will be used throughout application if entity i in DRAFT state
	 */
	public static final int STATUS_DRAFT = WorkflowConstants.STATUS_DRAFT;
	public static final String LABEL_DRAFT = WorkflowConstants.LABEL_DRAFT;

	/**
	 * Will be used throughout application
	 */
	public static final int STATUS_ANY = WorkflowConstants.STATUS_ANY;
	public static final String LABEL_ANY = WorkflowConstants.LABEL_ANY;

	/**
	 * Will be used throughout application if Status for an entity is DECLINED
	 */
	public static final int STATUS_DECLINED = WorkflowConstants.STATUS_DENIED;
	public static final String LABEL_DECLINED = WorkflowConstants.LABEL_DENIED;

	/**
	 * Will be used throughout application if Status for an entity is INACTIVE
	 */
	public static final int STATUS_INACTIVE = WorkflowConstants.STATUS_INACTIVE;
	public static final String LABEL_INACTIVE = WorkflowConstants.LABEL_INACTIVE;

	/**
	 * Will be used throughout application if Status for an entity is REJECTED
	 */
	public static final int STATUS_REJECTED = 9;
	public static final String LABEL_REJECTED = "rejected";

	/**
	 * Will be used throughout application if Status for an entity is ACTIVE
	 */
	public static final int STATUS_ACTIVE = 10;
	public static final String LABEL_ACTIVE = "active";

	/**
	 * Will be used throughout application if Status for an entity is PICKUP
	 */
	public static final int STATUS_PICKUP = 11;
	public static final String LABEL_PICKUP = "pickup";

	/**
	 * Will be used throughout application if Status for an entity is DELIVERED
	 */
	public static final int STATUS_DELIVERED = 12;
	public static final String LABEL_DELIVERED = "delivered";

	/**
	 * Will be used throughout application if Status for an entity is DELIVERY
	 * PENDING
	 */
	public static final int STATUS_DELIVERY_PENDING = 13;
	public static final String LABEL_DELIVERY_PENDING = "delivery-pending";

	/**
	 * Will be used throughout application if Status for an entity is BILLED
	 */
	public static final int STATUS_BILLED = 14;
	public static final String LABEL_BILLED = "billed";

	/**
	 * Will be used throughout application if Status for an entity is PAID
	 */
	public static final int STATUS_PAID = 15;
	public static final String LABEL_PAID = "paid";

	/**
	 * Will be used throughout application if Status for an entity is WQSC GENERATRD
	 */
	public static final int STATUS_WQSC_GENERATED = 16;
	public static final String LABEL_WQSC_GENERATED = "wqsc-generated";

	/**
	 * Will be used throughout application if Status for an entity is PO GENERATED
	 */
	public static final int STATUS_PO_GENERATED = 17;
	public static final String LABEL_PO_GENERATED = "po-generated";
	
	/**
	 * Will be used throughout application if Status for an entity is RESOLVED
	 */
	public static final int STATUS_RESOLVED = 18;
	public static final String LABEL_RESOLVED = "resolved";
	
	/**
	 * Will be used throughout application if Status for an entity is FIRST_LEVEL_APPROVED
	 */
	public static final int STATUS_FIRST_LEVEL_APPROVED = 19;
	public static final String LABEL_FIRST_LEVEL_APPROVED = "first-level-approved";
	
	/**
	 * Will be used throughout application if Status for an entity is CHALLAN_UPLOADED
	 */
	public static final int STATUS_CHALLAN_UPLOADED = 20;
	public static final String LABEL_CHALLAN_UPLOADED = "challan-uploaded";
	
	/**
	 * Will be used throughout application if Status for an entity is LICENSE_ISSUED
	 */
	public static final int STATUS_LICENSE_ISSUED = 21;
	public static final String LABEL_LICENSE_ISSUED = "license-issued";
	
	/**
	 * Will be used throughout application if Status for an entity is PAYMENT_NOT_VERIFIED
	 */
	public static final int STATUS_PAYMENT_NOT_VERIFIED = 22;
	public static final String LABEL_PAYMENT_NOT_VERIFIED = "payment-not-verified";

	public static final double DEFAULT_VERSION = 1.0;
	

	public static Map<Integer, String> getStatusText() {
		Map<Integer, String> statusText = new HashMap<Integer, String>();
		statusText.put(STATUS_APPROVED, LABEL_APPROVED);
		statusText.put(STATUS_PENDING, LABEL_PENDING);
		statusText.put(STATUS_DECLINED, LABEL_DECLINED);
		statusText.put(STATUS_INACTIVE, LABEL_INACTIVE);
		statusText.put(STATUS_DRAFT, LABEL_DRAFT);
		statusText.put(STATUS_ANY, LABEL_ANY);
		statusText.put(STATUS_REJECTED, LABEL_REJECTED);
		statusText.put(STATUS_ACTIVE, LABEL_ACTIVE);
		statusText.put(STATUS_PICKUP, LABEL_PICKUP);
		statusText.put(STATUS_DELIVERED, LABEL_DELIVERED);
		statusText.put(STATUS_DELIVERY_PENDING, LABEL_DELIVERY_PENDING);
		statusText.put(STATUS_BILLED, LABEL_BILLED);
		statusText.put(STATUS_PAID, LABEL_PAID);
		statusText.put(STATUS_WQSC_GENERATED, LABEL_WQSC_GENERATED);
		statusText.put(STATUS_PO_GENERATED, LABEL_PO_GENERATED);
		statusText.put(STATUS_RESOLVED, LABEL_RESOLVED);
		statusText.put(STATUS_FIRST_LEVEL_APPROVED, LABEL_FIRST_LEVEL_APPROVED);
		statusText.put(STATUS_CHALLAN_UPLOADED, LABEL_CHALLAN_UPLOADED);
		statusText.put(STATUS_LICENSE_ISSUED, LABEL_LICENSE_ISSUED);
		statusText.put(STATUS_PAYMENT_NOT_VERIFIED, LABEL_PAYMENT_NOT_VERIFIED);
		return statusText;
	}

	public static String getStatusStyle(int status) {

		if (status == StatusConstants.STATUS_APPROVED) {
			return "success";
		} else if (status == StatusConstants.STATUS_REJECTED) {
			return "danger";
		} else if (status == StatusConstants.STATUS_DECLINED) {
			return "danger";
		} else if (status == StatusConstants.STATUS_DRAFT) {
			return "secondary";
		} else if (status == StatusConstants.STATUS_INACTIVE) {
			return "secondary";
		}else if (status == StatusConstants.STATUS_RESOLVED) {
			return "success";
		}
//		else if (status == StatusConstants.STATUS_INCOMPLETE) {
//			return "warning";
//		} 
		else if (status == StatusConstants.STATUS_PENDING) {
			return "info";
		}

		return "secondary";
	}

	public static int getLabelStatus(String label) {

		if (label.equals(LABEL_ANY)) {
			return STATUS_ANY;
		}else if (label.equals(LABEL_APPROVED)) {
			return STATUS_APPROVED;
		}else if (label.equals(LABEL_DECLINED)) {
			return STATUS_DECLINED;
		}else if (label.equals(LABEL_DRAFT)) {
			return STATUS_DRAFT;
		}else if (label.equals(LABEL_INACTIVE)) {
			return STATUS_INACTIVE;
		}else if (label.equals(LABEL_PENDING)) {
			return STATUS_PENDING;
		}else if (label.equals(LABEL_REJECTED)) {
			return STATUS_REJECTED;
		}else if (label.equals(LABEL_RESOLVED)) {
			return STATUS_RESOLVED;
		}else if (label.equals(LABEL_FIRST_LEVEL_APPROVED)) {
			return STATUS_FIRST_LEVEL_APPROVED;
		}else if (label.equals(LABEL_CHALLAN_UPLOADED)) {
			return STATUS_CHALLAN_UPLOADED;
		}else if (label.equals(LABEL_LICENSE_ISSUED)) {
			return STATUS_LICENSE_ISSUED;
		}else if (label.equals(LABEL_PAYMENT_NOT_VERIFIED)) {
			return STATUS_PAYMENT_NOT_VERIFIED;
		}
		return STATUS_ANY;
	}

	public static String getStatusCssClass(int status) {

		if (status == STATUS_ANY) {
			return LABEL_ANY;
		}else if (status == STATUS_APPROVED) {
			return LABEL_APPROVED;
		}else if (status == STATUS_DECLINED) {
			return LABEL_DECLINED;
		}else if (status == STATUS_DRAFT) {
			return LABEL_DRAFT;
		}else if (status == STATUS_INACTIVE) {
			return LABEL_INACTIVE;
		}else if (status == STATUS_PENDING) {
			return LABEL_PENDING;
		}else if (status == STATUS_REJECTED) {
			return LABEL_REJECTED;
		}else if (status == STATUS_RESOLVED) {
			return LABEL_RESOLVED;
		}else if (status == STATUS_FIRST_LEVEL_APPROVED) {
			return LABEL_FIRST_LEVEL_APPROVED;
		}else if (status == STATUS_CHALLAN_UPLOADED) {
			return LABEL_CHALLAN_UPLOADED;
		}else if (status == STATUS_LICENSE_ISSUED) {
			return LABEL_LICENSE_ISSUED;
		}else if (status == STATUS_PAYMENT_NOT_VERIFIED) {
			return LABEL_PAYMENT_NOT_VERIFIED;
		}
		return LABEL_ANY;
	}

	public static String getStatusLabel(int status) {

		if(status == STATUS_ANY) {
			return LABEL_ANY;
		}else if (status == STATUS_APPROVED) {
			return LABEL_APPROVED;
		}else if (status == STATUS_DECLINED) {
			return LABEL_DECLINED;
		}else if (status == STATUS_DRAFT) {
			return LABEL_DRAFT;
		}else if (status == STATUS_INACTIVE) {
			return LABEL_INACTIVE;
		}else if (status == STATUS_PENDING) {
			return LABEL_PENDING;
		}else if (status == STATUS_REJECTED) {
			return LABEL_REJECTED;
		}else if (status == STATUS_RESOLVED) {
			return LABEL_RESOLVED;
		}else if (status == STATUS_FIRST_LEVEL_APPROVED) {
			return LABEL_FIRST_LEVEL_APPROVED;
		}else if (status == STATUS_CHALLAN_UPLOADED) {
			return LABEL_CHALLAN_UPLOADED;
		}else if (status == STATUS_LICENSE_ISSUED) {
			return LABEL_LICENSE_ISSUED;
		}else if (status == STATUS_PAYMENT_NOT_VERIFIED) {
			return LABEL_PAYMENT_NOT_VERIFIED;
		}

		return LABEL_ANY;
	}

}
