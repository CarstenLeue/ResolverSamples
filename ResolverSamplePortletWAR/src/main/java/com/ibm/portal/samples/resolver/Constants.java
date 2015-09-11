package com.ibm.portal.samples.resolver;

/**
 * Some constants used by the portlet and the portlet resolver
 * 
 * @author Dr. Carsten Leue
 */
public interface Constants {

	/**
	 * Private render parameter, only known to the portlet and the resolver
	 */
	String KEY_PRIVATE_PARAM = "privateKey";

	/**
	 * Default value for the {@link #KEY_PRIVATE_PARAM} parameter
	 */
	String PRIVATE_PARAM_DEFAULT = "privateDefault";

	/**
	 * Private render parameter, only known to the portlet and the resolver
	 */
	String KEY_PRIVATE_URI = "privateUri";

}
