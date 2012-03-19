/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.providermanagement;

import java.io.Serializable;
import java.util.Set;

import org.openmrs.BaseOpenmrsMetadata;
import org.openmrs.Relationship;

/**
 * Used to store the possible provider roles.  A Provide can only have a single role (though a single person
 * could be associated with more than one Provider object).
 *
 * A provider role specifies what Provider/Patient relationships a provider with that role can support,
 * as well as the provider roles that another provider role can provider oversight for.
 *
 * For example, a "Community Health Worker" role might support an "Accompagnateur" relationship,
 * and "Head Surgeon" role might be able to oversee a person with Provider Role of "Surgeon".
 */
public class ProviderRole extends BaseOpenmrsMetadata implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;

    // the provider/patient relationships this role can support
    private Set<Relationship> relationshipTypes;

    // the provider roles this provider role can supervisor
    private Set<ProviderRole> superviseeProviderRoles;
    
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
	}

    public Set<Relationship> getRelationshipTypes() {
        return relationshipTypes;
    }

    public void setRelationshipTypes(Set<Relationship> relationshipTypes) {
        this.relationshipTypes = relationshipTypes;
    }

    public Set<ProviderRole> getSuperviseeProviderRoles() {
        return superviseeProviderRoles;
    }

    public void setSuperviseeProviderRoles(Set<ProviderRole> superviseeProviderRoles) {
        this.superviseeProviderRoles = superviseeProviderRoles;
    }

}