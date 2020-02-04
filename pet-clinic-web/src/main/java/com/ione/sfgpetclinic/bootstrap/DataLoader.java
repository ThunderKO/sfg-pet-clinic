package com.ione.sfgpetclinic.bootstrap;

import com.ione.sfgpetclinic.model.Owner;
import com.ione.sfgpetclinic.model.PetType;
import com.ione.sfgpetclinic.model.Vet;
import com.ione.sfgpetclinic.services.OwnerService;
import com.ione.sfgpetclinic.services.PetTypeService;
import com.ione.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Gucci");
        owner2.setLastName("Gang");

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
