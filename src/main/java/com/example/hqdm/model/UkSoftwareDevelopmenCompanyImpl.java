package com.example.hqdm.model;

import uk.gov.gchq.magmacore.hqdm.pojo.HqdmObject;
import uk.gov.gchq.magmacore.hqdm.rdf.iri.IRI;

/**
 * An HQDM Extension class to add a new entity type to MagmaCore.
 */
public class UkSoftwareDevelopmenCompanyImpl extends HqdmObject implements UkLimitedCompany {

	public UkSoftwareDevelopmenCompanyImpl(IRI id) {
		super(id);
	}

}

