package com.ibm.portal.samples.resolver.client;

/**
 * Some constants used by the viewer portlet
 * 
 * @author Dr. Carsten Leue
 */
public interface Constants {

	/**
	 * Request attribute used to identify the bean. Used in clear text in the
	 * JSP.
	 */
	String KEY_BEAN = "bean";

	/**
	 * Key of the language input field, implementation detail.
	 */
	String KEY_LANGUAGE = "l";

	/**
	 * Key of the info input field, implementation detail.
	 */
	String KEY_INFO = "i";

	/**
	 * Key of the submit button, implementation detail.
	 */
	String KEY_SUBMIT = "s";

	/**
	 * Name of the public render parameter that encodes a POC URI Must match the
	 * <code>supported-public-render-parameter</code> element in the
	 * <code>portlet.xml</code>
	 */
	String KEY_URI = "uri";
}
