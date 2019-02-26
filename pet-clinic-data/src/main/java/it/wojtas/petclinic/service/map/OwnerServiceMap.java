package it.wojtas.petclinic.service.map;

import it.wojtas.petclinic.model.Owner;
import it.wojtas.petclinic.model.Pet;
import it.wojtas.petclinic.service.OwnerService;
import it.wojtas.petclinic.service.PetService;
import it.wojtas.petclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner == null)
            return null;

        if (owner.getPets() != null) {
            owner.getPets().forEach(pet -> {
                if (pet.getPetType() != null) {
                    if (pet.getPetType().getId() == null) {
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }
                } else {
                    throw new RuntimeException("Pet type is required");
                }
                if (pet.getId() == null) {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
        }
        return super.save(owner);
    }

    @Override
    public void delete(Owner t) {
        super.delete(t);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findByLastName(String lastName) {
        return super.map.values().stream().filter(owner -> owner.getLastName().equals(lastName)).findFirst().get();

    }
}
