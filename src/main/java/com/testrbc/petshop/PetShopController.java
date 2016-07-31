package com.testrbc.petshop;

import com.stormpath.sdk.application.Application;
import com.testrbc.petshop.security.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PetShopController {
    @Autowired
    AdminService adminService;

    @Autowired
    Application app;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("appName", app.getName());
        model.addAttribute("appDescription", app.getDescription());
        return "home";
    }
}
