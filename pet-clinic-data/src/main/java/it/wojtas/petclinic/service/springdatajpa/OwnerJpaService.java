package it.wojtas.petclinic.service.springdatajpa;

import com.google.common.collect.Sets;
import it.wojtas.petclinic.model.Owner;
import it.wojtas.petclinic.repositories.OwnerRepository;
import it.wojtas.petclinic.repositories.PetRepository;
import it.wojtas.petclinic.repositories.PetTypeRepository;
import it.wojtas.petclinic.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElseGet(null);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return Sets.newHashSet(ownerRepository.findAll());
    }
}
