package bd.gov.dgfood.credit.other.priority.customer.internal.search;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer;

@Component(immediate = true)
public class SalesCustomerSearchRegistrar {

	@Activate
	protected void activate(BundleContext bundleContext) {
		_serviceRegistration = modelSearchRegistrarHelper.register(SalesCustomer.class, bundleContext,
				modelSearchDefinition -> {
					modelSearchDefinition.setDefaultSelectedFieldNames(Field.COMPANY_ID, Field.ENTRY_CLASS_NAME,
							Field.ENTRY_CLASS_PK, Field.UID);

					modelSearchDefinition.setModelIndexWriteContributor(modelIndexWriterContributor);
				});
	}

	@Deactivate
	protected void deactivate() {

		_serviceRegistration.unregister();
	}

	@Reference(target = "(indexer.class.name=bd.gov.dgfood.credit.other.priority.customer.model.SalesCustomer)")
	protected ModelIndexerWriterContributor<SalesCustomer> modelIndexWriterContributor;

	@Reference
	protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

	private ServiceRegistration<?> _serviceRegistration;

}
