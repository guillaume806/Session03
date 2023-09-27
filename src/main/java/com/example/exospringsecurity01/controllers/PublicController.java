package com.example.exospringsecurity01.controllers;

import com.example.exospringsecurity01.exceptions.ResourceNotFound;
import com.example.exospringsecurity01.models.DogDTO;
import com.example.exospringsecurity01.services.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class PublicController {


    private final DogService dogService;

    @GetMapping("dogs")
    public String listDogs(Model model, @RequestParam(value = "name", defaultValue = "") String filterByName) {
        List<DogDTO> dogs = dogService.getDogs();


        if (!filterByName.isEmpty() && !filterByName.isBlank()) {
            dogs = dogs.stream().filter(d -> d.getName().startsWith(filterByName)).toList();
        }

        model.addAttribute("dogs", dogs);

        return "dogs/list";
    }

    @GetMapping
    public String homePage() {
        return "home";
    }


    @GetMapping("/{dogId}")
    public String getDogDetails(@PathVariable("dogId") UUID id, Model model) {
        Optional<DogDTO> foundDog = Optional.ofNullable(dogService.getDogById(id));

        if (foundDog.isPresent()) {
            model.addAttribute("dog", foundDog.get());
            model.addAttribute("mode", "details");

            return "private/dogsform";
        }

        throw new ResourceNotFound();
    }
}
