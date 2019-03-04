package it.wojtas.petclinic.repositories;

import it.wojtas.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisityRepository extends CrudRepository<Visit, Long> {
}
