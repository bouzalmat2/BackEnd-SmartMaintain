package com.smartmaintain.identityservice.services;

import com.smartmaintain.identityservice.entities.*;
import com.smartmaintain.identityservice.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public Client saveClient(Client client) {

        return utilisateurRepository.save(client);
    }


    public Admin saveAdmin(Admin admin) {

        String encodedPassword = passwordEncoder.encode(admin.getMotDePasse());
        admin.setMotDePasse(encodedPassword);
        return utilisateurRepository.save(admin);
    }

    public Utilisateur findUserByEmail(String email) {
        return utilisateurRepository.findByEmail(email).orElse(null);
    }

    public Manager saveManager(Manager manager) {
        return utilisateurRepository.save(manager);
    }

    public Ingenieur saveIngenieur(Ingenieur ingenieur) {
        return utilisateurRepository.save(ingenieur);
    }

    public Operateur saveOperateur(Operateur operateur) {
        return utilisateurRepository.save(operateur);
    }
}