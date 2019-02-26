package it.wojtas.petclinic.service.map;

import it.wojtas.petclinic.model.PetType;
import it.wojtas.petclinic.service.PetTypeService;

import java.util.Set;

public class PetTypeServiceMap extends AbstractMapService implements PetTypeService {

    @Override
    public PetType findById(Long id) {
        return null;
    }

    @Override
    public PetType save(PetType PetType) {
        return null;
    }

    @Override
    public void delete(PetType petType) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Set<PetType> findAll() {
        return null;
    }
}
