package com.example.exospringsecurity01.controllers;

import com.example.exospringsecurity01.exceptions.ResourceNotFound;
import com.example.exospringsecurity01.models.DogDTO;
import com.example.exospringsecurity01.services.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/private")
@RequiredArgsConstructor

public class PrivateController {


    private final DogService dogService;
    @GetMapping
    public String getHomeSecrets() {
        return "private/home";
    }

    @GetMapping("contacts")
    public String getContacts() {
        return "private/contacts";
    }

    @GetMapping("infos")
    public String getWebInfos() {
        return "private/infos";
    }




    @GetMapping("/add")
    public String getDogForm(Model model, @RequestParam(value = "exemple", defaultValue = "default") String blabla) {


        model.addAttribute("dog", DogDTO.builder().build());
        model.addAttribute("mode", "add");

        return "private/dogsform";
    }

    @PostMapping("/add")
    public String addDogHandler(DogDTO newDog) {
        dogService.addDog(newDog);

        return "redirect:/dogs";
    }

    @PostMapping("/delete/{dogId}")
    public String deleteDogById(@PathVariable("dogId") UUID id) {


        return "redirect:/dogs";
    }
}
