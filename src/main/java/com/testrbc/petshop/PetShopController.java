package com.testrbc.petshop;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetShopController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

//    @RequestMapping("/pet/{petId}")
//    public String getPetById(@PathVariable String petId) {
//        return "getPetById";
//    }
}
