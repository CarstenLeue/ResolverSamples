package com.ibm.portal.samples.resolver;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Simplistic portlet that just prints its render parameters
 *
 * @author Dr. Carsten Leue
 */
public class ResolverPortlet extends GenericPortlet {

	/** class name for the logger */
	private static final String LOG_CLASS = ResolverPortlet.class.getName();

	/** logging level */
	private static final Level LOG_LEVEL = Level.FINER;

	/** class logger */
	private static final Logger LOGGER = Logger.getLogger(LOG_CLASS);

	/**
	 * prefix for the JSP path
	 */
	private static final String PRIVATE_PATH_PREFIX = "/WEB-INF/"
			+ ResolverPortlet.class.getPackage().getName().replace('.', '/') + "/";

	/**
	 * suffix for the JSP path
	 */
	private static final String PATH_SUFFIX = ".jsp";

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.portlet.GenericPortlet#doView(javax.portlet.RenderRequest,
	 * javax.portlet.RenderResponse)
	 */
	@Override
	protected void doView(final RenderRequest request, final RenderResponse response)
			throws PortletException, IOException {
		// logging support
		final String LOG_METHOD = "doView(request, response)";
		final boolean bIsLogging = LOGGER.isLoggable(LOG_LEVEL);
		if (bIsLogging) {
			LOGGER.entering(LOG_CLASS, LOG_METHOD);
		}
		// init the response
		response.setContentType(request.getResponseContentType());
		// compute the JSP name
		final String jspPath = PRIVATE_PATH_PREFIX + request.getPortletMode() + PATH_SUFFIX;
		// log this
		if (bIsLogging) {
			LOGGER.logp(LOG_LEVEL, LOG_CLASS, LOG_METHOD, "Including [{0}] ...", jspPath);
		}
		// dispatch
		getPortletContext().getRequestDispatcher(jspPath).include(request, response);
		// exit trace
		if (bIsLogging) {
			LOGGER.exiting(LOG_CLASS, LOG_METHOD);
		}
	}
}
