package com.smartmaintain.equipementservice.services;

import com.smartmaintain.equipementservice.entities.Maintenance;
import com.smartmaintain.equipementservice.repositories.MaintenanceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@Transactional
public class MaintenanceService {
    private final MaintenanceRepository repository;

    public MaintenanceService(MaintenanceRepository repository) { this.repository = repository; }

    public List<Maintenance> getAll() { return repository.findAll(); }
    public Maintenance getById(UUID id) { return repository.findById(id).orElseThrow(); }
    public Maintenance save(Maintenance m) { return repository.save(m); }

    public Maintenance changeStatus(UUID id, String status) {
        Maintenance m = getById(id);
        m.setStatus(status);
        return repository.save(m);
    }
}
