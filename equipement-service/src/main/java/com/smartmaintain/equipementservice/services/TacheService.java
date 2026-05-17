package com.smartmaintain.equipementservice.services;

import com.smartmaintain.equipementservice.entities.Equipe;
import com.smartmaintain.equipementservice.entities.Tache;
import com.smartmaintain.equipementservice.repositories.EquipeRepository;
import com.smartmaintain.equipementservice.repositories.TacheRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TacheService {
    private final TacheRepository tacheRepository;
    private final  EquipeRepository equipeRepository;
    // Constructor injection...
    public TacheService(TacheRepository tacheRepository ,EquipeRepository equipeRepository) {
        this.tacheRepository = tacheRepository;
        this.equipeRepository = equipeRepository;
    }

    public List<Tache> getTachesByTaxonomie(Long taxonomieId) {
        return tacheRepository.findByTaxonomieId(taxonomieId);
    }

    public void assignTaskToTeam(UUID tacheId, UUID equipeId) {
        Tache tache = tacheRepository.findById(tacheId).orElseThrow();
        Equipe equipe = equipeRepository.findById(equipeId).orElseThrow();
        tache.setEquipe(equipe);
        tacheRepository.save(tache);
    }
}
