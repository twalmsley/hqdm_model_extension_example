package com.example.hqdm.ext;

import com.example.hqdm.model.Constants;
import com.example.hqdm.model.UkLimitedCompanyImpl;
import com.example.hqdm.model.UkSoftwareDevelopmenCompanyImpl;

import uk.gov.gchq.magmacore.hqdm.extensions.ExtensionService;
import uk.gov.gchq.magmacore.hqdm.model.Thing;
import uk.gov.gchq.magmacore.hqdm.rdf.iri.IRI;
import uk.gov.gchq.magmacore.hqdm.rdf.iri.RDFS;

/**
 * An example HQDM ExtensionService for adding some extension classes to MagmaCore.
 */
public class HqdmExtensionService implements ExtensionService {

    /**
     * {@inheritDoc}
     */
	@Override
	public Thing createEntity(final String typeName, final IRI iri) {

        // Check the type name and return an appropriate instance.
        //
		if (Constants.UK_LIMITED_COMPANY_TYPE_NAME.equals(typeName)) {
            final var result = new UkLimitedCompanyImpl(iri);
            result.addValue(RDFS.RDF_TYPE, Constants.UK_LIMITED_COMPANY_IRI);
            return result;
        } else if (Constants.UK_SOFTWARE_DEVELOPMENT_COMPANY_TYPE_NAME.equals(typeName)) {
            final var result = new UkSoftwareDevelopmenCompanyImpl(iri);
            result.addValue(RDFS.RDF_TYPE, Constants.UK_SOFTWARE_DEVELOPMENT_COMPANY_IRI);
            return result;
        }

        // Or null if it's not a class from this extension package.
        return null;
	}

}
