package com.example.exospringsecurity01.controllers;

import com.example.exospringsecurity01.exceptions.ResourceNotFound;
import com.example.exospringsecurity01.models.DogDTO;
import com.example.exospringsecurity01.services.DogService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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





    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpServletRequest request) {
        if (username != null && username.equals("admin") && password != null && password.equals("admin")) {
            HttpSession session = request.getSession();
            session.setAttribute("user", "johnny");

            return "redirect:/private";
        }

        return "redirect:/login";
    }
}
