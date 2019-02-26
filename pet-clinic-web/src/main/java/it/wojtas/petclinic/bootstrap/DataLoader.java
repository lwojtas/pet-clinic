package it.wojtas.petclinic.bootstrap;

import it.wojtas.petclinic.model.*;
import it.wojtas.petclinic.service.OwnerService;
import it.wojtas.petclinic.service.PetTypeService;
import it.wojtas.petclinic.service.SpecialityService;
import it.wojtas.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Controller
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().size() == 0)
            loadData();
    }

    private void loadData() {

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCat = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality dentist = new Speciality();
        dentist.setDescription("dentist");

        specialityService.save(surgery);
        specialityService.save(radiology);
        specialityService.save(dentist);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("Tomaszkowice");
        owner1.setCity("Wieliczka");
        owner1.setPhone("246452526");

        Pet pet1 = new Pet();
        pet1.setPetType(savedDog);
        pet1.setBirthday(LocalDate.of(2018, 8, 1));
        pet1.setOwner(owner1);
        pet1.setName("Rex");

        owner1.getPets().add(pet1);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("Przebieczany");
        owner2.setCity("Wieliczka");
        owner2.setPhone("73465943");

        Pet pet2 = new Pet();
        pet2.setPetType(savedCat);
        pet2.setBirthday(LocalDate.of(2015, 10, 4));
        pet2.setOwner(owner2);
        pet2.setName("Guiness");

        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(surgery);
        vet1.getSpecialities().add(dentist);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(radiology);

        vetService.save(vet2);

    }
}
