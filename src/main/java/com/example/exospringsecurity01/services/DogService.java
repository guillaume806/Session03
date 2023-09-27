package com.example.exospringsecurity01.services;

import com.example.exospringsecurity01.models.DogDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Primary
public class DogService {




    public List<DogDTO> getDogs() {

        Map<Object, Object> dogs;
        return dogs.values().stream().toList();
    }

    public DogDTO getDogById(UUID id) {
        return dogs.values().stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    public void addDog(DogDTO newDog) {
    }
}