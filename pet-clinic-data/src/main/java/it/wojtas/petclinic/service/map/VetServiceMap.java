package it.wojtas.petclinic.service.map;

import it.wojtas.petclinic.model.Vet;
import it.wojtas.petclinic.service.CrudService;
import it.wojtas.petclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet owner) {
        return super.save(owner);
    }

    @Override
    public void delete(Vet t) {
        super.delete(t);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll() ;
    }
}
