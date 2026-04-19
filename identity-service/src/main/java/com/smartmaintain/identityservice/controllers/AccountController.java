package com.smartmaintain.identityservice.controllers;

import com.smartmaintain.identityservice.entities.*;
import com.smartmaintain.identityservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/admin")
    public Admin createAdmin(@RequestBody Admin admin) {
        return accountService.saveAdmin(admin);
    }

    @PostMapping("/client")
    public Client createClient(@RequestBody Client client) {
        return accountService.saveClient(client);
    }

    @PostMapping("/manager")
    public Manager createManager(@RequestBody Manager manager) {
        return accountService.saveManager(manager);
    }

    @PostMapping("/ingenieur")
    public Ingenieur createIngenieur(@RequestBody Ingenieur ingenieur) {
        return accountService.saveIngenieur(ingenieur);
    }

    @PostMapping("/operateur")
    public Operateur createOperateur(@RequestBody Operateur operateur) {
        return accountService.saveOperateur(operateur);
    }
}