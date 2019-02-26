package it.wojtas.petclinic.service.map;

import it.wojtas.petclinic.model.Pet;
import it.wojtas.petclinic.service.CrudService;
import it.wojtas.petclinic.service.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet);
    }

    @Override
    public void delete(Pet t) {
        super.delete(t);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll() ;
    }
}
