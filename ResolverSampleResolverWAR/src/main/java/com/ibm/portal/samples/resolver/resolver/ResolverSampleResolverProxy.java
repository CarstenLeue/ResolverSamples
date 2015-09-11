package com.ibm.portal.samples.resolver.resolver;

import org.eclipse.core.runtime.IExecutableExtensionFactory;

import com.ibm.portal.resolver.cor.helper.DefaultContentOperationsRegistryFactory;

/**
 * This class is registered with the <code>plugin.xml</code>. We use this proxy
 * because it automatically constructs and fills in the dependencies interface
 * for the {@link ResolverSampleResolver}. Since the proxy implements
 * {@link IExecutableExtensionFactory} the eclipse instantiation process will
 * actually return the resulting class as the real implementation.
 * 
 * @author cleue
 */
public class ResolverSampleResolverProxy extends DefaultContentOperationsRegistryFactory
		implements IExecutableExtensionFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.portal.resolver.cor.helper.
	 * DefaultContentOperationsRegistryFactory #getTargetClass()
	 */
	@Override
	protected Class<ResolverSampleResolver> getTargetClass() {
		// construct this class
		return ResolverSampleResolver.class;
	}
}
