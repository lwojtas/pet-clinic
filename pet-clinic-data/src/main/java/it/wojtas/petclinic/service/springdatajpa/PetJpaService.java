package it.wojtas.petclinic.service.springdatajpa;

import com.google.common.collect.Sets;
import it.wojtas.petclinic.model.Pet;
import it.wojtas.petclinic.repositories.PetRepository;
import it.wojtas.petclinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetJpaService implements PetService {

    private final PetRepository petRepository;

    public PetJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElseGet(null);
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public Set<Pet> findAll() {
        return Sets.newHashSet(petRepository.findAll());
    }
}
