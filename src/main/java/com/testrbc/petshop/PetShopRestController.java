package com.testrbc.petshop;

import com.testrbc.petshop.security.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetShopRestController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/admin")
    String admin() {
        adminService.ensureAdmin();
        return "admin";
    }

    @RequestMapping("/pet/{petId}")
    public String getPetById(@PathVariable String petId) {
        return "getPetById";
    }
}
