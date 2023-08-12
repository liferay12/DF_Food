package bd.gov.dgfood.credit.other.priority.customer.internal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer;
import bd.gov.dgfood.credit.other.priority.customer.service.SalesCustomerLocalService;

@Component(immediate = true, property = "indexer.class.name=bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer", service = ModelIndexerWriterContributor.class)
public class SalesCustomerModelIndexerWriterContributor implements ModelIndexerWriterContributor<SalesCustomer> {

	@Override
	public void customize(BatchIndexingActionable batchIndexingActionable,
			ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

		batchIndexingActionable.setPerformActionMethod((SalesCustomer customer) -> {
			Document document = modelIndexerWriterDocumentHelper.getDocument(customer);

			batchIndexingActionable.addDocuments(document);
		});
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return dynamicQueryBatchIndexingActionableFactory
				.getBatchIndexingActionable(salesCustomerLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(SalesCustomer customer) {
		return customer.getCompanyId();
	}

	@Reference
	protected DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;

	@Reference
	protected SalesCustomerLocalService salesCustomerLocalService;
	

}
