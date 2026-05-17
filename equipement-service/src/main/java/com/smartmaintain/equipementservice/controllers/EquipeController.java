package com.smartmaintain.equipementservice.controllers;

import com.smartmaintain.equipementservice.entities.Equipe;
import com.smartmaintain.equipementservice.services.EquipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/equipes")
public class EquipeController {
    private final EquipeService service;

    public EquipeController(EquipeService service) { this.service = service; }

    @GetMapping
    public List<Equipe> getAll() { return service.getAll(); }

    @PostMapping
    public Equipe create(@RequestBody Equipe e) { return service.save(e); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) { service.delete(id); }
}
