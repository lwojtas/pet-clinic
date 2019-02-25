package it.wojtas.petclinic.service;

import it.wojtas.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
