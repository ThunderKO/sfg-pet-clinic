package com.ione.sfgpetclinic.bootstrap;

import com.ione.sfgpetclinic.model.*;
import com.ione.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Louis");
        owner1.setLastName("Vuitton");
        owner1.setAddress("HK Island");
        owner1.setCity("Hong Kong");
        owner1.setTelephone("9250 1254");

        Pet louisPet = new Pet();
        louisPet.setPetType(savedDogPetType);
        louisPet.setOwner(owner1);
        louisPet.setBirthDate(LocalDate.now());
        louisPet.setName("Golden");
        owner1.getPets().add(louisPet);

        ownerService.save(owner1);

        Visit dogVisit = new Visit();
        dogVisit.setPet(louisPet);
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescriptions("Cold doggo");
        visitService.save(dogVisit);

        Owner owner2 = new Owner();
        owner2.setFirstName("Gucci");
        owner2.setLastName("Gang");
        owner2.setAddress("New Territories");
        owner2.setCity("Hong Kong");
        owner2.setTelephone("5219 0295");

        Pet gucciPet = new Pet();
        gucciPet.setPetType(savedCatPetType);
        gucciPet.setOwner(owner2);
        gucciPet.setBirthDate(LocalDate.now());
        gucciPet.setName("Darken");
        owner2.getPets().add(gucciPet);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(gucciPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescriptions("Sneezy Kitty");
        visitService.save(catVisit);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Calvin");
        vet1.setLastName("Klevin");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Andy");
        vet2.setLastName("Sammuel");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
