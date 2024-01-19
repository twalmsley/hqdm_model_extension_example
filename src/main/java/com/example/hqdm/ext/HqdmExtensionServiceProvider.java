package com.example.hqdm.ext;

import java.util.Map;

import com.example.hqdm.model.Constants;
import com.example.hqdm.model.UkLimitedCompany;
import com.example.hqdm.model.UkSoftwareDevelopmenCompany;

import uk.gov.gchq.magmacore.hqdm.extensions.ExtensionService;
import uk.gov.gchq.magmacore.hqdm.extensions.ExtensionServiceProvider;
import uk.gov.gchq.magmacore.hqdm.model.Thing;
import uk.gov.gchq.magmacore.hqdm.rdf.iri.IRI;

/**
 * An example ExtensionServiceProvider for adding some extension classes to MagmaCore.
 */
public class HqdmExtensionServiceProvider implements ExtensionServiceProvider {

    /**
     * {@inheritDoc}
     */
	@Override
	public ExtensionService createService(final Map<IRI, Class<? extends Thing>> map) {

        // Register our extension IRIs and the corresponding interfaces.
        //
        map.put(Constants.UK_LIMITED_COMPANY_IRI, UkLimitedCompany.class);
        map.put(Constants.UK_SOFTWARE_DEVELOPMENT_COMPANY_IRI, UkSoftwareDevelopmenCompany.class);

        // Create ane return the extension service.
		return new HqdmExtensionService();
	}

}
