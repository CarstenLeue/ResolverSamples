package com.ibm.portal.samples.resolver.client;

import javax.naming.Context;
import javax.naming.NamingException;

import com.ibm.portal.model.LanguageListHome;
import com.ibm.portal.portlet.service.PortletServiceHome;
import com.ibm.portal.portlet.service.PortletServiceUnavailableException;
import com.ibm.portal.portlet.service.model.PortletLocalizedContextHome;
import com.ibm.portal.samples.resolver.client.ResolverPortlet.Dependencies;

public class ResolverDependencies implements Dependencies {

	private final LanguageListHome languageListHome;

	private final PortletLocalizedContextHome portletLocalizedContextHome;

	public ResolverDependencies(final Context aContext) throws NamingException, PortletServiceUnavailableException {
		languageListHome = (LanguageListHome) aContext.lookup(LanguageListHome.JNDI_NAME);
		// lookup the portlet service
		final PortletServiceHome psh = (PortletServiceHome) aContext.lookup(PortletLocalizedContextHome.JNDI_NAME);
		portletLocalizedContextHome = (PortletLocalizedContextHome) psh
				.getPortletService(PortletLocalizedContextHome.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.portal.samples.resolver.client.Bean.Dependencies#
	 * getLanguageListHome()
	 */
	@Override
	public LanguageListHome getLanguageListHome() {
		// the language list
		return languageListHome;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.portal.samples.resolver.client.Bean.Dependencies#
	 * getLocalizedContextHome()
	 */
	@Override
	public PortletLocalizedContextHome getLocalizedContextHome() {
		// localization APIs
		return portletLocalizedContextHome;
	}

}
