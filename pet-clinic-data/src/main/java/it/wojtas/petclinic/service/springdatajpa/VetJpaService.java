package it.wojtas.petclinic.service.springdatajpa;

import com.google.common.collect.Sets;
import it.wojtas.petclinic.model.Vet;
import it.wojtas.petclinic.repositories.VetRepository;
import it.wojtas.petclinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }


    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElseGet(null);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return Sets.newHashSet(vetRepository.findAll());
    }
}
