package com.example.hqdm.ext;

import java.util.Map;

import com.example.hqdm.model.Constants;
import com.example.hqdm.model.UkLimitedCompany;

import uk.gov.gchq.magmacore.hqdm.extensions.ExtensionService;
import uk.gov.gchq.magmacore.hqdm.extensions.ExtensionServiceProvider;
import uk.gov.gchq.magmacore.hqdm.model.Thing;
import uk.gov.gchq.magmacore.hqdm.rdf.iri.IRI;

public class HqdmExtensionServiceProvider implements ExtensionServiceProvider {

	@Override
	public ExtensionService createService(final Map<IRI, Class<? extends Thing>> map) {

        // Register our extension IRIs and classes.
        map.put(Constants.UK_LIMITED_COMPANY_IRI, UkLimitedCompany.class);

        // Create ane return the extension service.
		return new HqdmExtensionService();
	}

}
