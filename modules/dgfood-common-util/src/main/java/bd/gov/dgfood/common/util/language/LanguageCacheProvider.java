package bd.gov.dgfood.common.util.language;

import com.liferay.portal.kernel.cache.MultiVMPool;
import com.liferay.portal.kernel.cache.PortalCache;

import java.io.Serializable;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class LanguageCacheProvider {
	private static final String CUSTOM_LANGUAGE_CACHE = "languageProperties";
	

	private static PortalCache<Serializable, Serializable> portalCache;
	
	@Reference(unbind = "-")
	protected void setMultiVMPool(MultiVMPool multiVMPool) {
		portalCache = (PortalCache<Serializable, Serializable>) multiVMPool.getPortalCache(CUSTOM_LANGUAGE_CACHE);
	}
	
	public static PortalCache<Serializable, Serializable> getPortalCache(){
		return portalCache;
	}
}