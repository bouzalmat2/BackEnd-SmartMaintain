package com.smartmaintain.equipementservice.services;

import com.smartmaintain.equipementservice.entities.Equipe;
import com.smartmaintain.equipementservice.repositories.EquipeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class EquipeService {
    private final EquipeRepository repository;

    public EquipeService(EquipeRepository repository) { this.repository = repository; }

    public List<Equipe> getAll() { return repository.findAll(); }
    public Equipe save(Equipe e) { return repository.save(e); }
    public void delete(UUID id) { repository.deleteById(id); }
}
