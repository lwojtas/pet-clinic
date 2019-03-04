package it.wojtas.petclinic.service.springdatajpa;

import com.google.common.collect.Sets;
import it.wojtas.petclinic.model.Speciality;
import it.wojtas.petclinic.repositories.SpecialityRepository;
import it.wojtas.petclinic.service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSpecialityJpaService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public VetSpecialityJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).orElseGet(null);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        specialityRepository.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }

    @Override
    public Set<Speciality> findAll() {
        return Sets.newHashSet(specialityRepository.findAll());
    }
}
