package it.wojtas.petclinic.service.springdatajpa;

import com.google.common.collect.Sets;
import it.wojtas.petclinic.model.Visit;
import it.wojtas.petclinic.repositories.VisityRepository;
import it.wojtas.petclinic.service.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitJpaService implements VisitService {

    private final VisityRepository visityRepository;

    public VisitJpaService(VisityRepository visityRepository) {
        this.visityRepository = visityRepository;
    }

    @Override
    public Visit findById(Long id) {
        return visityRepository.findById(id).orElseGet(null);
    }

    @Override
    public Visit save(Visit visit) {
        return visityRepository.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visityRepository.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        visityRepository.deleteById(id);
    }

    @Override
    public Set<Visit> findAll() {
        return Sets.newHashSet(visityRepository.findAll());
    }
}
