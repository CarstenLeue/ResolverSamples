package com.ibm.portal.samples.resolver.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ibm.icu.util.ULocale;
import com.ibm.portal.resolver.uri.BaseURI;

public class ResolverSampleURI extends BaseURI {

	/** class name for the logger */
	private static final String LOG_CLASS = ResolverSampleURI.class.getName();

	/** logging level */
	private static final Level LOG_LEVEL = Level.FINER;

	/** class logger */
	private static final Logger LOGGER = Logger.getLogger(LOG_CLASS);

	private static final String SCHEME = "RESOLVER.SAMPLE.SCHEME";

	private static final String SEPARATOR = "@";

	public static final URI createInstance(final Locale aLocale,
			final String aInfo) throws URISyntaxException {
		return new URI(SCHEME,
				localeToLanguageTag(aLocale) + SEPARATOR + aInfo, null);
	}

	private static final Locale languageTagToLocale(final String aTag) {
		return ULocale.forLanguageTag(aTag).toLocale();
	}

	private static final String localeToLanguageTag(final Locale aLocale) {
		return ULocale.forLocale(aLocale).toLanguageTag();
	}

	private final String info;

	private final Locale locale;

	private final URI originalURI;

	public ResolverSampleURI(final URI aURI) {
		// logging support
		final String LOG_METHOD = "ResolverSampleURI(aURI)";
		final boolean bIsLogging = LOGGER.isLoggable(LOG_LEVEL);
		if (bIsLogging) {
			LOGGER.entering(LOG_CLASS, LOG_METHOD, aURI);
		}
		// keep the uri
		originalURI = aURI;
		// parse
		final String ssp = aURI.getSchemeSpecificPart();
		final int idx = ssp.indexOf(SEPARATOR);
		// language tag and info
		final String tag = ssp.substring(0, idx);
		info = ssp.substring(idx + 1);
		// decode the locale
		locale = languageTagToLocale(tag);
		// exit trace
		if (bIsLogging) {
			LOGGER.exiting(LOG_CLASS, LOG_METHOD, this);
		}
	}

	public String getInfo() {
		return info;
	}

	public Locale getLocale() {
		return locale;
	}

	public URI getURI() {
		return originalURI;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// some debugging
		return "[" + locale + ", " + info + "]";
	}
}
