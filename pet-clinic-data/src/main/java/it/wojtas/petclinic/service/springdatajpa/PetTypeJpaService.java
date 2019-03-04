package it.wojtas.petclinic.service.springdatajpa;

import com.google.common.collect.Sets;
import it.wojtas.petclinic.model.PetType;
import it.wojtas.petclinic.repositories.PetTypeRepository;
import it.wojtas.petclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElseGet(null);
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }

    @Override
    public Set<PetType> findAll() {
        return Sets.newHashSet(petTypeRepository.findAll());
    }
}
