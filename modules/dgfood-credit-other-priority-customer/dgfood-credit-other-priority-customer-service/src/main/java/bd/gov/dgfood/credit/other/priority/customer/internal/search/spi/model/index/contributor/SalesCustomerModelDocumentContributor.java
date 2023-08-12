package bd.gov.dgfood.credit.other.priority.customer.internal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.common.services.model.Address;
import bd.gov.dgfood.common.services.service.AddressLocalServiceUtil;
import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer;

@Component(immediate = true, property = "indexer.class.name=bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer", service = ModelDocumentContributor.class)
public class SalesCustomerModelDocumentContributor implements ModelDocumentContributor<SalesCustomer> {

	@Override
	public void contribute(Document document, SalesCustomer baseModel) {

		document.addText(Field.NAME, baseModel.getContactPersonName());
		document.addKeyword(Field.COMPANY_ID, baseModel.getCompanyId());
		document.addDate(Field.CREATE_DATE, baseModel.getCreateDate());
		document.addKeyword("organizationName", baseModel.getOrganizationName());
		document.addKeyword("organizationType", baseModel.getOrganizationType());
		document.addKeyword(Field.STATUS, baseModel.getStatus());
		document.addKeyword("userType", baseModel.getUserType());

		Set<Long> addressIds = _populateAddresses(document, baseModel.getSalesCustomerId());

		_log.info(" addressIds ..." + baseModel.getUserType());

		if (!addressIds.isEmpty()) {
			document.addKeyword("locationIds", ArrayUtil.toLongArray(addressIds));
		}

	}

	private Set<Long> _populateAddresses(Document document, long customerId) {

		Set<Long> addressIds = new HashSet<>();

		try {

			List<Address> address = AddressLocalServiceUtil.getAddressListByClassNameAndClassPK(customerId,
					SalesCustomer.class.getName());

			address.stream().forEach(e -> {
				addressIds.add(e.getRegion());
				addressIds.add(e.getDistrict());
				addressIds.add(e.getUpazilla());
				addressIds.add(e.getCityCorporationOrMunicipality());
				addressIds.add(e.getUnionOrWard());
				addressIds.add(e.getZipCode());

			});

			addressIds.remove(0L);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return addressIds;

	}

	private static final Log _log = LogFactoryUtil.getLog(SalesCustomerModelDocumentContributor.class);
}
