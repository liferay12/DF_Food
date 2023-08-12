package bd.gov.dgfood.credit.other.priority.customer.internal.search.spi.model.query.contributor;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.search.spi.model.query.contributor.ModelPreFilterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchSettings;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = "indexer.class.name=bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer", service = ModelPreFilterContributor.class)
public class SalesCustomerModelPreFilterContributor implements ModelPreFilterContributor {

	@Override
	public void contribute(BooleanFilter booleanFilter, ModelSearchSettings modelSearchSettings,
			SearchContext searchContext) {

		_log.debug(" CustomerModelPreFilterContributor ........" + searchContext.getAttribute("userType"));

		int status = GetterUtil.getInteger(searchContext.getAttribute(Field.STATUS), WorkflowConstants.STATUS_ANY);

		String organizationName = GetterUtil.getString(searchContext.getAttribute("organizationName"));

		String userType = GetterUtil.getString(searchContext.getAttribute("userType"));

		if (Validator.isNotNull(userType)) {
			booleanFilter.addRequiredTerm("userType", userType);
		}

		if (Validator.isNotNull(organizationName)) {
			booleanFilter.addRequiredTerm("organizationName", organizationName);
		}

		if (status != WorkflowConstants.STATUS_ANY) {
			booleanFilter.addRequiredTerm(Field.STATUS, status);
		}

		// _filterByLocationIds(booleanFilter, searchContext);
		_filterByDate(booleanFilter, searchContext);

	}

	// private void _filterByLocationIds(BooleanFilter booleanFilter, SearchContext
	// searchContext) {
	//
	// long[] locationIds = (long[]) searchContext.getAttribute("locationIds");
	//
	// _log.info(" _filterByLocationIds ........" + Arrays.toString(locationIds));
	//
	// TermsFilter termsFilter = new TermsFilter("locationIds");
	//
	// termsFilter.addValues(ArrayUtil.toStringArray(locationIds));
	//
	// booleanFilter.add(termsFilter, BooleanClauseOccur.MUST);
	//
	// }

	private void _filterByDate(BooleanFilter booleanFilter, SearchContext searchContext) {

		long endDate = GetterUtil.getLong(searchContext.getAttribute("toDate"));
		long startDate = GetterUtil.getLong(searchContext.getAttribute("fromDate"));

		if ((endDate > 0) && (startDate > 0)) {

			BooleanFilter minFilter = new BooleanFilter();
			minFilter.addRangeTerm(Field.CREATE_DATE, startDate, endDate);
			booleanFilter.add(minFilter, BooleanClauseOccur.MUST);
		}

	}

	private static final Log _log = LogFactoryUtil.getLog(SalesCustomerModelPreFilterContributor.class);
}
