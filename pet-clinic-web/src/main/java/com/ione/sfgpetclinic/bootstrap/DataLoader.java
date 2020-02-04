package com.ione.sfgpetclinic.bootstrap;

import com.ione.sfgpetclinic.model.Owner;
import com.ione.sfgpetclinic.model.Pet;
import com.ione.sfgpetclinic.model.PetType;
import com.ione.sfgpetclinic.model.Vet;
import com.ione.sfgpetclinic.services.OwnerService;
import com.ione.sfgpetclinic.services.PetTypeService;
import com.ione.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

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

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Calvin");
        vet1.setLastName("Klevin");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Andy");
        vet2.setLastName("Sammuel");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
