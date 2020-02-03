package com.ione.sfgpetclinic.bootstrap;

import com.ione.sfgpetclinic.model.Owner;
import com.ione.sfgpetclinic.model.Vet;
import com.ione.sfgpetclinic.services.OwnerService;
import com.ione.sfgpetclinic.services.VetService;
import com.ione.sfgpetclinic.services.map.OwnerMapServiceImpl;
import com.ione.sfgpetclinic.services.map.VetMapServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerMapServiceImpl();
        vetService = new VetMapServiceImpl();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Louis");
        owner1.setLastName("Vutton");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Gucci");
        owner1.setLastName("Gang");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Calvin");
        vet1.setLastName("Klevin");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Andy");
        vet1.setLastName("Sammuel");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
