package com.example.exospringsecurity01.bootstrap;

import com.example.exospringsecurity01.models.DogDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {


//        private final Map<UUID, DogDTO> dogs;


//    public DogService() {
//            dogs = new HashMap<>();
//
//            DogDTO dogA = DogDTO.builder()
//                    .id(UUID.randomUUID())
//                    .age(5)
//                    .name("Bernie")
//                    .breed("Labrador")
//                    .build();
//
//            DogDTO dogB = DogDTO.builder()
//                    .id(UUID.randomUUID())
//                    .age(3)
//                    .name("Rex")
//                    .breed("Doberman")
//                    .build();
//
//            DogDTO dogC = DogDTO.builder()
//                    .id(UUID.randomUUID())
//                    .age(12)
//                    .name("Caramel")
//                    .breed("Beagle")
//                    .build();
//
//            dogs.put(dogA.getId(), dogA);
//            dogs.put(dogB.getId(), dogB);
//            dogs.put(dogC.getId(), dogC);
//        }

    }
}