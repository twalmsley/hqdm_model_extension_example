package com.elemendar.hqdm.ext;

import com.elemendar.hqdm.model.Ext;
import com.elemendar.hqdm.model.UkLimitedCompanyImpl;

import uk.gov.gchq.magmacore.hqdm.extensions.ExtensionService;
import uk.gov.gchq.magmacore.hqdm.model.Thing;
import uk.gov.gchq.magmacore.hqdm.rdf.iri.IRI;
import uk.gov.gchq.magmacore.hqdm.rdf.iri.RDFS;

public class HqdmExtensionService implements ExtensionService {

	@Override
	public Thing createEntity(final String typeName, final IRI iri) {

        // Check the type name and return an appropriate instance.
        //
		if (Ext.UK_LIMITED_COMPANY_TYPE_NAME.equals(typeName)) {
            final var result = new UkLimitedCompanyImpl(iri);
            result.addValue(RDFS.RDF_TYPE, Ext.UK_LIMITED_COMPANY_IRI);
            return result;
        }

        // Or null if it's not a class from this extension package.
        return null;
	}

}
